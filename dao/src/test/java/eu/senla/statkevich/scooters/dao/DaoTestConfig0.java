package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.entity.EntityConfig;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootConfiguration
@PropertySource("classpath:appTest.properties")
@ComponentScan(basePackages = {"eu.senla.statkevich.runner",
        "eu.senla.statkevich.dao",
        "eu.senla.statkevich.entity"})
@Import(EntityConfig.class)
@EnableTransactionManagement
public class DaoTestConfig0 {

}
