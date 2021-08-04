package eu.senla.statkevich.scooters.runner;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {
        "eu.senla.statkevich.scooters.controller",
        "eu.senla.statkevich.scooters.dao",
        "eu.senla.statkevich.scooters.service",
        "eu.senla.statkevich.scooters.dao"
        ,"eu.senla.statkevich.scooters.entity"})
//exclude = {SecurityAutoConfiguration.class},
@EntityScan("eu.senla.statkevich.scooters.entity")
public class BootApp {
    //тут можно и бины,как в конфиге

    static Logger log = Logger.getLogger(BootApp.class);

    public static void main(String[] args) {
        SpringApplication.run(BootApp.class, args);

        log.info("Started");
    }
}
