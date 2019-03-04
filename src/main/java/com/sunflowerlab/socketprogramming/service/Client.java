package com.sunflowerlab.socketprogramming.service;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client
{

    public Socket getSocket(String host, int port) {
        Socket socket = null;
        try{
            socket = new Socket(host, port);
        } catch (Exception e) {

        }
        return socket;

    }

    public String echoMessage(Socket socket, String message) {
        try{
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());

            os.writeUTF(message);
            System.out.println("Message sent to the server : "+message);

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            message = dataInputStream.readUTF();
            System.out.println("Message received from the server : " +message);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return message;
    }

}