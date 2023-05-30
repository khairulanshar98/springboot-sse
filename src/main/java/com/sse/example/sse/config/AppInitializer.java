package com.sse.example.sse.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppInitializer implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("AppInitializer");
    }
}
