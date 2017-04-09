package hk.edu.polyu.comp3222.vfs.server;

import hk.edu.polyu.comp3222.vfs.Util.ConsoleIO;

import hk.edu.polyu.comp3222.vfs.client.ClientController;
import hk.edu.polyu.comp3222.vfs.controller.SerializationController;
import hk.edu.polyu.comp3222.vfs.core.handler.*;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;

import java.net.*;
import java.io.*;
import java.util.LinkedList;

/**
 * Created by Isaac on 1/24/17.
 */
public class ServerController {


    private ServerSocket serversocket;
    private Socket client;
    private int bytesRead;
    //Connect c = new Connect();
    private String userName;
    private String passwd;
    //private BufferedReader input;
    //private PrintWriter output;
    private final int PORT_NO = 5000;
    private final int DISK_SIZE = 5000;


    /**
     * start the connection from server side
     * @throws IOException IO excpetion
     */
    public void start() throws IOException{
        System.out.println("Connection Starting on port:" + "0.0.0.0:5000");

        //make connection to client on port specified
        serversocket = new ServerSocket(PORT_NO);
        System.out.println("Waiting for connection from client");

        //accept connection from client
        client = serversocket.accept();
        ConsoleIO.printLine("connection established.");

        try (
                BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
        )
        {
            //ConsoleIO.printLine("make sure I am here");
            logInfo(input, output);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * authenticate the username and password
     * @throws Exception exception
     */
    public void logInfo(BufferedReader input, PrintWriter output) throws Exception {

        //retrive the vfs file from username first
        String username = input.readLine();
        ConsoleIO.printLine("SERVER SIDE: " + username);
        VisualDisk tempDisk = SerializationController.getInstance().deserialize(username);
        if (tempDisk != null) {
            output.println("User exists, please input password:");
            output.flush();
            this.userName = username;
            this.passwd = tempDisk.getPassword();

            //confirm the password
            String password;
            while(true) {
                if ((password = input.readLine()) != null) {
                    ConsoleIO.printLine("SERVER SIDE: " + password);
                    if (password.equals(passwd)) {
                        output.println("Welcome, " + username);
                        OutputInstance(client, tempDisk);
                    } else {
                        output.println("Login Failed");
                    }
                    break;
                }
            }
        }else{
            output.println("User not existed, you may create a new one:");
            output.flush();
            String newPasswd;
            while(true) {
                if ((newPasswd = input.readLine()) != null) {

                    ConsoleIO.printLine("SERVER SIDE: new password: " + newPasswd);
                    int newDiskSize = Integer.parseInt(input.readLine());
                    VisualDisk newDisk = new VisualDisk(username, newPasswd, newDiskSize);
                    OutputInstance(client, newDisk);
                    break;
                }
            }
        }
        output.flush();
        //output.close();
    }

    /**
     * send the visual disk to client
     * @param socket socket for connection
     * @param testSystem working visual disk from login
     * @throws Exception exception
     */
    public void OutputInstance(Socket socket, VisualDisk testSystem) throws Exception{
         /*-----------------------Get the visual disk-----------------------------*/
        System.out.println("Socket Extablished...");
        ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());

        System.out.println("make sure I sent the object"+testSystem.getName());
        outToClient.writeObject(testSystem);

        while(true){
            LinkedList<ResponseHandler> cmdStack = (LinkedList<ResponseHandler>) inFromClient.readObject();
            if(cmdStack != null){
                for(ResponseHandler e : cmdStack){
                    testSystem.setCurrentDir((VFSDirectory) e.handlerOnServer());
                }
                //ClientController.boot(testSystem);
                SerializationController.getInstance().serialize(testSystem);
                //sth
                ConsoleIO.printLine("sync finished");
                break;
            }
        }
        inFromClient.close();
        outToClient.close();
    }

    /**
     * server side main function
     * @param args default arguments
     */
    public static void main(String[] args){
        ServerController server = new ServerController();
        try {
            server.start();
        }catch (IOException e){
            e.printStackTrace();
        }



    }

}
