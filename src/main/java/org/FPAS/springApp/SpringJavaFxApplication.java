package org.FPAS.springApp;

import org.FPAS.springApp.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.FPAS")

public class SpringJavaFxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJavaFxApplication.class, "");
    }

    @Autowired
    ClientRepository userRepository;


}
