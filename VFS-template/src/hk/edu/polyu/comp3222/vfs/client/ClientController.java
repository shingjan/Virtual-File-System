package hk.edu.polyu.comp3222.vfs.client;
import hk.edu.polyu.comp3222.vfs.Util.ConsoleIO;

import hk.edu.polyu.comp3222.vfs.core.handler.*;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Created by Isaac on 1/24/17.
 */
public class ClientController {

    private Socket socket;
    private BufferedReader read;
    private PrintWriter output;
    private static LinkedList<ResponseHandler> commandStack = new LinkedList<>();
    private final int PORT = 5000;
    private static boolean online = true;

    /**
     * create the map for retriveing responsehandler while avoid multi-(if else)s
     */
    private static final Map<String, ResponseHandler> themap = new HashMap<>();
    static{
        //command handlers
        themap.put("cd", new DirectResponseHandler());
        themap.put("ls", new ListResponseHandler());
        themap.put("mv", new MoveResponseHandler());
        themap.put("cp", new CopyResponseHandler());
        themap.put("mkdir", new MkdirHandler());
        themap.put("touch", new CreateHandler());
        themap.put("cat", new CatHandler());
        themap.put("import", new ImportResponseHandler());
        themap.put("export", new ExportResponseHandler());
        themap.put("search", new SearchResponseHandler());
        themap.put("remove", new RemoveHandler());
        themap.put("rename", new RenameHandler());
        themap.put("query", new QueryHandler());
        themap.put("help", new HelpHandler());
        themap.put("quit", new QuitResponseHandler());
    }


    /**
     * user need to output command to server for synchronization
     * @return the client socket
     * @throws IOException IO exception
     */
    public Socket startClient() throws IOException{
        //Create socket connection
        Socket clientSocket = new Socket("0.0.0.0",PORT);

        //create printwriter for sending login to server
        output = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        read = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        //prompt for user name and send to server
        String inputUsername = ConsoleIO.readLine("Please input your username: ");
        output.println(inputUsername);
        output.flush();

        //read response from server
        String authenticateResponse = read.readLine();
        ConsoleIO.printLine(authenticateResponse);
        while(true) {
            if (authenticateResponse.equals("User not existed, you may create a new one:")) {
                String newpasswd = ConsoleIO.readLine("please input new password for " + inputUsername + " ");
                output.println(newpasswd);
                String newDiskSize = ConsoleIO.readLine("please input size for this new disk: ");
                output.println(newDiskSize);
                output.flush();
                break;
            } else if (authenticateResponse.equals("User exists, please input password:")) {
                //prompt for password
                String inputPasswd = ConsoleIO.readLine("Please input your password: ");
                output.println(inputPasswd);
                output.flush();
                break;
            }
        }
        //output.close();
        return clientSocket;
    }

    /**
     * receive the instance from server
     * @param clientSocket client socket needed for socket connection
     * @return return received socket from server
     * @throws IOException IO exception
     * @throws ClassNotFoundException Class not found exception
     */
    public VisualDisk receiveInstance(Socket clientSocket) throws IOException, ClassNotFoundException{
        ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
        ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
        //PrintWriter finalOutput = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        VisualDisk currentDisk = (VisualDisk) inFromServer.readObject();
        String serverCmd = boot(currentDisk);
        if(serverCmd.equals("save")) {
            Serializable cmdStack = commandStack;
            outToServer.writeObject(commandStack);
            ConsoleIO.printLine("File system saved!");
        }else if(serverCmd.equals("delete")){
            outToServer.writeObject(null);
            ConsoleIO.printLine("File system deleted!");
        }

        inFromServer.close();
        outToServer.close();
        return null;
    }

    /**
     * boot method for client visual disk
     * @param disk the visual disk to be booted
     * @return modified visual disk or null
     */
    public static String boot(VisualDisk disk){
        String[] cmd_segments;
        ConsoleIO.printLine(disk.getName());
        while (true){
            ConsoleIO.printLine("Current Working Directory is:");
            ConsoleIO.printLine(disk.getCurrentDir().getPath());
            cmd_segments = ConsoleIO.readLine("-->").split(" ");
            ResponseHandler cmd = themap.get(cmd_segments[0]);

            //save command for server
            if(cmd_segments[0].equals("save") && online){
                return "save";
            }else if(cmd_segments[0].equals("delete") && online){
                return "delete";
            }else if(cmd_segments[0].equals("online")) {
                online = true;
                continue;
            }else if(cmd_segments[0].equals("offline")) {
                online = false;
                continue;
            }else if((cmd_segments[0].equals("save") | cmd_segments[0].equals("delete")) && !online){
                ConsoleIO.printLine("save & delete are not applicable in offline mode");
                continue;
            }

            /*-------------------command line implementation--------------------------*/
            if(cmd != null){

                disk.setCurrentDir((VFSDirectory) cmd.handlerResponse(cmd_segments, disk,disk.getROOT_FS(), disk.getCurrentDir()));
                commandStack.add(cmd);
                if(disk.getCurrentDir() == null){
                    return "save";
                }
            }else{
                ConsoleIO.printLine("wrong command, try again");
            }

        }
        //return null;
    }

    /**
     * set socket method
     * @param socket socket to be set
     */
    public void setSocket(Socket socket){
        this.socket = socket;
    }

    /**
     * get socket method
     * @return return required socket
     */
    public Socket getSocket(){
        return this.socket;
    }

    /**
     * main method for client
     * @param args default arguments
     */
    public static void main(String[] args) {


        final int DISK_SIZE = 13356;
        ClientController client = new ClientController();


        try{
            client.setSocket(client.startClient());
            //System.out.println("make sure i get in here/");
            client.receiveInstance(client.getSocket());

        }catch (UnknownFormatConversionException | IOException | ClassNotFoundException e){
            e.printStackTrace();
        }


    }


}
