package eu.senla.statkevich.scooters.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

public class ProfileDetectorEPP implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        if (environment.getActiveProfiles().length!=0){
            System.out.println("Профайл изменен c - "+environment.getActiveProfiles()[0]+" на mess1");
            environment.setActiveProfiles("mess1");
        }
    }
}
