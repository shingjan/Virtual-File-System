package hk.edu.polyu.comp3222.vfs.server;
import java.net.*;
import java.util.*;
import java.io.*;
/**
 * Created by Isaac on 1/24/17.
 */
public class ServerController {
    public static void main(String[] args){
        new ServerController();
    }

    public ServerController(){
        try {
            ServerSocket sSocket = new ServerSocket(5000);
            System.out.println("Server started at: " + new Date());

            //Wait for a client to connect
            Socket socket = sSocket.accept();

            //Create the streams
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //Tell the client that he/she has connected
            output.println("You have connected at: " + new Date());

            //Loop that runs server functions
            while(true) {
                //This will wait until a line of text has been sent
                String chatInput = input.readLine();
                System.out.println(chatInput);
            }
        } catch(IOException exception) {
            System.out.println("Error: " + exception);
        }
    }
}
