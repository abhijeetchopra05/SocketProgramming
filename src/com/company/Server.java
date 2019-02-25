package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String str[]) {

        ServerSocket serverSocket = null;
        Socket socket = null;
        while(true) {
            try{
                serverSocket = new ServerSocket(4444);
                socket = serverSocket.accept();
                System.out.println("Server started");
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                String message = dataInputStream.readUTF();
                System.out.println("Client Maessage : " + message);

                DataOutputStream os = new DataOutputStream(socket.getOutputStream());

                os.writeUTF(message);
                System.out.println("Message sent to the client is "+message);


            } catch(Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
            finally
            {
                try
                {

                    socket.close();

                }
                catch(Exception e){}
            }

        }

    }

}