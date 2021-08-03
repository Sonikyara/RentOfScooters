package eu.senla.statkevich.scooters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class BootApp extends SpringBootServletInitializer {
//тут можно и бины,как в конфиге
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(eu.senla.statkevich.scooters.BootApp.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(BootApp.class, args);
    }

}
