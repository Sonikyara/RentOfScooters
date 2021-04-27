package work.appConfiguration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@EnableJpaRepositories("")
//@EnableTransactionManagement
@Configuration
@EnableWebMvc
@ComponentScan("work")
@PropertySource("classpath:application.properties")

public class ControllerConfig { //extends WebMvcConfigurerAdapter

    public ControllerConfig() {    }
}
