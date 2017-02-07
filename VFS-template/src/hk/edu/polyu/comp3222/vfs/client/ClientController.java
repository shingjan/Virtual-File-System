package hk.edu.polyu.comp3222.vfs.client;
import java.util.Scanner;
import java.io.*;
import java.net.*;
/**
 * Created by Isaac on 1/24/17.
 */
public class ClientController {

    public static void main(String[] args)
    {

    }

    public ClientController(){
        Scanner scanner = new Scanner(System.in);
        try {
            Socket socket = new Socket("localhost",5000);
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //This will wait for the server to send the string to the client saying a connection
            //has been made.
            String inputString = input.readLine();
            System.out.println(inputString);
            //Again, here is the code that will run the client, this will continue looking for
            //input from the user then it will send that info to the server.
            while(true) {
                //Here we look for input from the user
                String userInput = scanner.nextLine();
                //Now we write it to the server
                output.println(userInput);
            }
        } catch (IOException exception) {
            System.out.println("Error: " + exception);
        }
    }

}
