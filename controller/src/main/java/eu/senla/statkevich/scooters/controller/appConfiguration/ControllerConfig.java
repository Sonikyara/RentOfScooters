package eu.senla.statkevich.scooters.controller.appConfiguration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@EnableTransactionManagement
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "eu.senla.statkevich.scooters.controller")
@PropertySource("classpath:application.properties")

public class ControllerConfig { //extends WebMvcConfigurerAdapter

    public ControllerConfig() {    }
}
