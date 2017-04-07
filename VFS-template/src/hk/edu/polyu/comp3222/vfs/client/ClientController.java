package hk.edu.polyu.comp3222.vfs.client;
import hk.edu.polyu.comp3222.vfs.Util.ConsoleIO;
import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.controller.SerializationController;
import hk.edu.polyu.comp3222.vfs.core.handler.ResponseHandler;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Isaac on 1/24/17.
 */
public class ClientController {

    public IOService ioService = new ConsoleIO();
    private Socket socket;
    private BufferedReader read;
    private PrintWriter output;
    private VisualDisk currentDisk;
    public final Map<String, ResponseHandler> themap = new HashMap<>();


    //user need to output command to server for synchronization
    public void outputCommand(VisualDisk currentDisk){
            currentDisk.getCmdArray();
    }

    public Socket startClient() throws IOException{
        //Create socket connection
        Socket clientSocket = new Socket("0.0.0.0",5000);

        //create printwriter for sending login to server
        output = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        //prompt for user name
        String inputUsername = ioService.readLine("Please input your username: ");


        //send user name to server
        output.println(inputUsername);

        //prompt for password
        String inputPasswd = ioService.readLine("Please input your password: ");

        //send password to server
        output.println(inputPasswd);
        output.flush();

        //create Buffered reader for reading response from server
        read = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        //read response from server
        String response = read.readLine();
        System.out.println("This is the response: " + response);

        return clientSocket;
    }

    public VisualDisk receiveInstance(Socket clientSocket) throws IOException, ClassNotFoundException{
        ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
        ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());

        return (VisualDisk) inFromServer.readObject();
    }

    public void boot(VisualDisk disk){
        String[] cmd_segments;
        ioService = new ConsoleIO();
        ioService.printLine(disk.getName());
        while (true){
            ioService.printLine("Current Working Directory is:");
            ioService.printLine(disk.currentDir.getPath());
            cmd_segments = ioService.readLine("-->").split(" ");
            ResponseHandler cmd = themap.get(cmd_segments[0]);
            if(cmd_segments[0].equals("save")){
                //SerializationController.getInstance().serialize(this);
                ioService.printLine("File system saved!");
                break;
            }

            /*-------------------command line implementation--------------------------*/
            if(cmd != null){
                disk.currentDir = (VFSDirectory) cmd.handlerResponse(cmd_segments, disk.ROOT_FS, disk.currentDir, ioService);
                if(disk.currentDir == null){
                    System.exit(0);
                }
            }else{
                ioService.printLine("wrong command, try again");
            }

        }
    }

    public static void main(String[] args) {


        ClientController client = new ClientController();
        try {
            client.socket = client.startClient();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try{
            System.out.println("make sure i get in here/");
            client.currentDisk = client.receiveInstance(client.socket);
            System.out.println(client.currentDisk.getName());
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        client.boot(client.currentDisk);
    }


}
