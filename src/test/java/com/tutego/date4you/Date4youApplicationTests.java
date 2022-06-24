package com.tutego.date4you;

import com.tutego.date4you.service.PhotoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;


@SpringBootTest
@TestPropertySource(properties = "spring.shell.interactive.enabled=false")
class Date4youApplicationTests {

    @Autowired
    PhotoService photoService;

    @Test
    void contextLoads() {
    }

}
