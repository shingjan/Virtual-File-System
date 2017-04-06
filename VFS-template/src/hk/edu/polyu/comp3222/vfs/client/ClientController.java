package hk.edu.polyu.comp3222.vfs.client;
import hk.edu.polyu.comp3222.vfs.core.Util.ConsoleIO;
import hk.edu.polyu.comp3222.vfs.core.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;

import java.util.Scanner;
import java.io.*;
import java.net.*;
/**
 * Created by Isaac on 1/24/17.
 */
public class ClientController {

    public IOService ioService = new ConsoleIO();
    private Socket socket;
    private BufferedReader read;
    private PrintWriter output;


    //user need to output command to server for synchronization
    public void outputCommand(VisualDisk currentDisk){
            currentDisk.getCmdArray();
    }

    public void startClient() throws UnknownHostException, IOException{
        //Create socket connection
        socket = new Socket("0.0.0.0",5000);

        //create printwriter for sending login to server
        output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

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
        read = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //read response from server
        String response = read.readLine();
        System.out.println("This is the response: " + response);
    }

    public static void main(String[] args) {

        //VisualDisk testSystem = VisualDisk.loadFS("test","test",13356);
        //testSystem.boot();

        ClientController client = new ClientController();
        try {
            client.startClient();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
