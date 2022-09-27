package com.example.demo;

import java.net.InetAddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class DemoApplication {

    @RequestMapping("/")
    String home() {
        InetAddress[] peers = InetAddress.getAllByName("java-springboot-headless.jvm-test.svc.cluster.local")
        StringBuilder s = new StringBuilder("Hello World!\n\nMy peers are:\n")

        for(int i = 0; i < peers.length; i++) {
            s.append("    " + peers[i].getHostAddress() + "\n");
        }

        s.append("\n\n");

        return s.toString();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}