package main.springApplication.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import robots.implementations.robot127.Robot127;

@Configuration
public class JavaConfiguration {

    @Bean(value = {"workerRobot"})
    public robots.implementations.robot127.Robot127 workerRobot(){
        return new robots.implementations.robot127.Robot127();
    }
}