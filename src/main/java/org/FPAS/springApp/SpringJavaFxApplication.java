package org.FPAS.springApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.FPAS", "org.FPAS.javaFXApp"})
public class SpringJavaFxApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringJavaFxApplication.class, args);
    }
}
