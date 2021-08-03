package eu.senla.statkevich.scooters.controller.сonfiguration;

import eu.senla.statkevich.dao.JPAConfig;
import eu.senla.statkevich.scooters.controller.security.SecurityConfig;
import org.apache.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import eu.senla.statkevich.scooters.service.ServiceConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class SpringWebAppInitializer implements WebApplicationInitializer {

    private static final Logger logger = Logger.getLogger(SpringWebAppInitializer.class);

    @Override
    public void onStartup(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();

        appContext.register(ControllerConfig.class);
        appContext.register(ServiceConfig.class);
        appContext.register(JPAConfig.class);
        appContext.register(SecurityConfig.class);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher",
                new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");

        logger.info("Application started");
    }
}
