package eu.senla.statkevich.scooters.controller;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
// написать аспект, который в лог запишет
// какой метод контроллера вызван,
// какие параметры пришли,
// что вернул метод,
// сколько по времени работал …
@Component
@Aspect
public class ControllerInfoAspect {

    final static Logger logger=Logger.getLogger(ControllerInfoAspect.class);

    private String methodsInfo="";
    private LocalDateTime timeStartMethod;
    //private Long timeStartMethodM;
    private LocalDateTime timeEndMethod;

    @Pointcut("execution(* eu.senla.statkevich.scooters.controller.controllers.*.*(..))")
    public void controllerMethodsPointСut() {
    }

    @Before("controllerMethodsPointСut()")
    public void before(JoinPoint jp) {
        methodsInfo="\n Aspects info \n Method Signature: "  + jp.getSignature();
        if (jp.getArgs().length>0){
            Arrays.stream(jp.getArgs()).forEach(o->methodsInfo=methodsInfo.concat("\n"+"arg-"+o.getClass()+"---"+ o));
        }
        timeStartMethod=LocalDateTime.now();
        //timeStartMethodM=System.currentTimeMillis();
    }

    @AfterReturning(pointcut = "controllerMethodsPointСut()", returning = "someValue")
    public void afterReturning(Object someValue) {
        if (someValue!=null){
            methodsInfo=methodsInfo.concat("\n"+"returned value: " + someValue);
        }
    }

    @After("controllerMethodsPointСut()")
    public void after() {
        timeEndMethod=LocalDateTime.now();
        methodsInfo=methodsInfo.concat("\n"+"Start time: "+timeStartMethod+"\n"+
                        "End time: "+timeEndMethod+"\n"+
                        "All time in millis: "+ Duration.between(timeStartMethod,timeEndMethod).toMillis()+"\n"
//                +"All time in millis system: "+ (System.currentTimeMillis()-timeStartMethodM)+"\n"
        );
        logger.info("after---"+"\n"+
                methodsInfo);
    }

//    @Around("controllerMethodsPointСut()")
//    public void doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
//        Object retVal = pjp.proceed();
//        String.join("\n",methodsInfo,"Value around: " + retVal);
//        logger.info("around---"+"\n"+
//                methodsInfo);
//    }

}
