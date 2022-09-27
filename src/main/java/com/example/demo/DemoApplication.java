package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class DemoApplication {

    @RequestMapping("/")
    String home() {
        InetAddress[] peers = null;
        try {
            peers = InetAddress.getAllByName("java-springboot-headless.jvm-test.svc.cluster.local");
        } catch (UnknownHostException e) {
            System.out.println("Host not found.  Skipping peer section.");
        }
        
        StringBuilder s = new StringBuilder("Hello World!\n\n");
        
        if (peers != null) {
            s.append("Including myself, I have " + peers.length + " peers.\n");
            s.append("My peers are:\n");


            for(int i = 0; i < peers.length; i++) {
                s.append("    " + peers[i].getHostAddress() + "\n");
            }

            s.append("\n\n");
        }

        return s.toString();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}