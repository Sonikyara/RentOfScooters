package eu.senla.statkevich.scooters.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

//пример профайлера, пок ане подключен

//@Component
public class MyProfileManager {

    @Autowired
    private Environment environment;

    @Value("${my.mess}")
    private String myMess;

    @Value("${spring.profiles.active}")
    private String activeProfile;

    public void getActiveProfiles() {
        for (String profileName : environment.getActiveProfiles()) {
            System.out.println("Currently active profile - " + profileName);
        }
    }
}
