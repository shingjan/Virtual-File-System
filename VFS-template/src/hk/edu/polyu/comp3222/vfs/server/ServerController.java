package hk.edu.polyu.comp3222.vfs.server;

import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;

import java.net.*;
import java.io.*;
/**
 * Created by Isaac on 1/24/17.
 */
public class ServerController {

    private int currentTot;
    private ServerSocket serversocket;
    private Socket client;
    private int bytesRead;
    //Connect c = new Connect();
    private String userName = "test";
    private String passwd = "test";
    private BufferedReader input;
    private PrintWriter output;
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

        try {
            logInfo();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    /**
     * authenticate the username and password
     * @throws Exception exception
     */
    public void logInfo() throws Exception{
        //open buffered reader for reading data from client
        input = new BufferedReader(new InputStreamReader(client.getInputStream()));

        String username = input.readLine();
        System.out.println("SERVER SIDE: " + username);
        String password = input.readLine();
        System.out.println("SERVER SIDE: " + password);

        //SerializationController.getInstance().deserialize(username+".vfs");
        //open printwriter for writing data to client
        output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));

        if(username.equals(userName) &&password.equals(passwd)){
            output.println("Welcome, " + username);
        }else{
            output.println("Login Failed");
        }
        output.flush();


        OutputInstance(client);

        output.close();


    }

    /**
     * send the visual disk to client
     * @param socket socket for connection
     * @throws Exception exception
     */
    public void OutputInstance(Socket socket) throws Exception{
         /*-----------------------Get the visual disk-----------------------------*/
        System.out.println("Socket Extablished...");
        ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());

        VisualDisk testSystem = new VisualDisk("test","test",DISK_SIZE);
        System.out.println("make sure I sent the object"+testSystem.getName());
        outToClient.writeObject(testSystem);
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
