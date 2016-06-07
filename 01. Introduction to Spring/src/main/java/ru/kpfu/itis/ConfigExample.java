package ru.kpfu.itis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigExample {


    @Bean
    public Guitar guitar() {
        return new Guitar();
    }

    @Bean
    public TestService testService1() {return new TestService("1");}

    @Bean
    public TestService testService2() {return new TestService("2");}
}
