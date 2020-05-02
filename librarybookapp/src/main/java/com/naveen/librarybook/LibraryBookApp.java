package com.naveen.librarybook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan (basePackageClasses = {LibraryBookApp.class})
public class LibraryBookApp {
    public static void main(String[] args) {
        SpringApplication.run(LibraryBookApp.class, args);
    }
}
