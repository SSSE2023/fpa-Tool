package org.FPAS.springApp;

import org.FPAS.springApp.model.Client;
import org.FPAS.springApp.model.ClientRepository;
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

    public void printAll(){
        userRepository.save(Client.builder()
                .username("John_Kurt")
                .password("l5qorn4#")
                .email("kurtijohn@outlook.com")
                .build());
        Iterable<Client> userss= userRepository.findAll();

        for (Client u: userss) {
            System.out.println(u);
        }
    }
}
