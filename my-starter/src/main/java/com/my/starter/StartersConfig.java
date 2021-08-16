package com.my.starter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartersConfig {

    @Bean
    public StartersAppListener startersAppListener(){
        return new StartersAppListener();
    }

}
