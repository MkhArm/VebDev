package org.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BrowserOpener implements ApplicationRunner {

    @Autowired
    private Environment environment;

    @Override
    public void run(ApplicationArguments args) {
//        String homePageUrl = "http://localhost:8080/home";
//        try {
//            String os = System.getProperty("os.name").toLowerCase();
//            ProcessBuilder processBuilder;
//            processBuilder = new ProcessBuilder("cmd", "/c", "start", homePageUrl);
//            processBuilder.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}



