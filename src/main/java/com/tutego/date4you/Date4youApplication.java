package com.tutego.date4you;


import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;



import java.lang.invoke.MethodHandles;
import java.util.Arrays;

@SpringBootApplication
@EnableJpaAuditing
public class Date4youApplication {

    public static void main(String[] args) {

        Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
        ApplicationContext ctx = SpringApplication.run(Date4youApplication.class, args);
        Arrays.stream(ctx.getBeanDefinitionNames()).sorted().forEach(log::info);
    }

}
