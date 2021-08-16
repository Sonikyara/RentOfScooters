package eu.senla.statkevich.scooters.runner;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Condition;

@SpringBootApplication(scanBasePackages = {
        "eu.senla.statkevich.scooters.controller",
        "eu.senla.statkevich.scooters.dao",
        "eu.senla.statkevich.scooters.service",
        "eu.senla.statkevich.scooters.dao",
        "com.my.starter"
        ,"eu.senla.statkevich.scooters.entity"})
//exclude = {SecurityAutoConfiguration.class},
@EntityScan("eu.senla.statkevich.scooters.entity")
@EnableJpaRepositories("eu.senla.statkevich.scooters.dao")
@EnableAspectJAutoProxy
public class BootApp {
    //тут можно и бины,как в конфиге

    static Logger log = Logger.getLogger(BootApp.class);

    public static void main(String[] args) {
        ApplicationContext context=
        SpringApplication.run(BootApp.class, args);

        log.info("Started");
        log.info((context.getEnvironment().getActiveProfiles().length>0)?
                ("Active profile is - "+context.getEnvironment().getActiveProfiles()[0]):
                ("Active with profile - "+context.getEnvironment().getDefaultProfiles()[0]));

    }
}
