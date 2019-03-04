package com.sunflowerlab.socketprogramming.service;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ClientServices {

    Map<Integer,Socket> map = new HashMap<>();

    int i = 0;

    Client client = new Client();

    public int createClient(String host, int port) {

        Socket socket = client.getSocket(host,port);

        map.put(i,socket);

        int mapId = i;

        i++;

        return mapId;
    }

    public String echoMessage(int mapId,String data) {

        Socket socket = map.get(mapId);

        String message = client.echoMessage(socket, data);

        return message;
    }

}
