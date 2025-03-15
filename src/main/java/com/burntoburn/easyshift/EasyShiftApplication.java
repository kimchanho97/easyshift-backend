package com.burntoburn.easyshift;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties
@EnableJpaAuditing
public class EasyShiftApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyShiftApplication.class, args);
    }
}
