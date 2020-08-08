package com.naveen.librarybook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan (basePackageClasses = {LibraryBookApp.class})
@EnableFeignClients
public class LibraryBookApp {
    public static void main(String[] args) {
        SpringApplication.run(LibraryBookApp.class, args);
    }
}
