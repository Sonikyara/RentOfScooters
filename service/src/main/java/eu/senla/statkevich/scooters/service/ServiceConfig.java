package eu.senla.statkevich.scooters.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
//@EnableTransactionManagement//(proxyTargetClass = true)
public class ServiceConfig {

    public ServiceConfig() {    }
}
