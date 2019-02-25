package com.company;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client
{

    private static Socket socket;

    public static void main(String args[])
    {
        try
        {
            String host = "localhost";
            int port = 4444;
            socket = new Socket(host, port);

            //Send the message to the server
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());

            String sendMessage = "ABC";
            os.writeUTF(sendMessage);
            System.out.println("Message sent to the server : "+sendMessage);



            //Get the return message from the server
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String message = dataInputStream.readUTF();
            System.out.println("Message received from the server : " +message);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            //Closing the socket
            try
            {
                socket.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}