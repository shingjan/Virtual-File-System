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

    //in the constructor of ClientController
    //we need to open the right vfs from server and
    public ClientController(){

        /*-----------------------Connect to Server-------------------------------*/
        try {
            Socket socket = new Socket("0.0.0.0",5000);
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            String inputUsername = ioService.readLine("Please input your username: ");
            String inputPasswd = ioService.readLine("Please input your password: ");

            //Now we write it to the server
            output.println(inputUsername);
            output.println(inputPasswd);


            /*-----------------------Get the visual disk-----------------------------*/
            //ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
            //ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

        } catch (IOException exception) {
            System.out.println("Error: " + exception);
        }


    }

    //user need to output command to server for synchronization
    public void outputCommand(VisualDisk currentDisk){
            currentDisk.getCmdArray();
    }


    public static void main(String[] args) {

        //VisualDisk testSystem = VisualDisk.loadFS("test","test",13356);
        //testSystem.boot();

        new ClientController();


    }

}
