package com.sunflowerlab.socketprogramming.service;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket;

    Socket socket;

    public Server(int port) {
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("Server started");

        } catch (Exception e) {

        }

        while(true) {
            try{

                socket = serverSocket.accept();
                System.out.println("Client Connected with ip address : " + socket.getInetAddress() + " and port : " + socket.getPort());


                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                String message = dataInputStream.readUTF();
                System.out.println("Client Message : " + message);

                DataOutputStream os = new DataOutputStream(socket.getOutputStream());
                os.writeUTF(message);
                System.out.println("Message sent to the client is "+message);


            } catch(Exception e) {
                e.printStackTrace();
                System.exit(0);
            }


        }
    }

    public static void main(String str[]) {

        Server server = new Server(4444);

    }

}