package com.example.decathloncalculator.config;

import com.example.decathloncalculator.events.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    private final ConfigurableApplicationContext context;

    @Autowired
    public AppConfig(ConfigurableApplicationContext context) {
        this.context = context;
    }

    @Bean
    public List<Event> events() {
        return new ArrayList<>(Arrays.asList(
                context.getBean(HundredMeters.class),
                context.getBean(LongJump.class),
                context.getBean(ShotPut.class),
                context.getBean(HighJump.class),
                context.getBean(FourHundredMeters.class),
                context.getBean(HundredAndTenMeters.class),
                context.getBean(DiscusThrow.class),
                context.getBean(PoleVault.class),
                context.getBean(JavelinThrow.class),
                context.getBean(ThousandFiveHundredMeters.class))
        );
    }
}
