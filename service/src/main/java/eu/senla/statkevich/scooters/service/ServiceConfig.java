package eu.senla.statkevich.scooters.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "eu.senla.statkevich.scooters.service")
//@ComponentScan
//@EnableTransactionManagement//(proxyTargetClass = true)
public class ServiceConfig {

    public ServiceConfig() {    }

}
