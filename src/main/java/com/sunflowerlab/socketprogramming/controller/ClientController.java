package com.sunflowerlab.socketprogramming.controller;


import com.sunflowerlab.socketprogramming.service.ClientServices;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    ClientServices clientServices = new ClientServices();

    @RequestMapping("/start-client/{host}/{port}")
    public int startClient(@PathVariable String host, @PathVariable int port){

        return clientServices.createClient(host,port);
    }

    @RequestMapping("/send-message/{mapId}/{data}")
    public String sendMessage(@PathVariable int mapId, @PathVariable String data) {
        return clientServices.echoMessage(mapId,data);
    }

    @RequestMapping("/stop-client")
    public void stopClient(){
        System.out.println("STOP CLIENT");
    }
}
