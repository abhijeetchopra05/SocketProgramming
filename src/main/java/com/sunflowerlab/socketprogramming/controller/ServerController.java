package com.sunflowerlab.socketprogramming.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {


    @RequestMapping("/start-server")
    public void startServer(){
        System.out.println("START SERVER");
    }
    @RequestMapping("/stop-server")
    public void stopServer(){
        System.out.println("STOP SERVER");
    }


}
