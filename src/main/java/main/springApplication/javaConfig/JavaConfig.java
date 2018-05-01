package main.springApplication.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import robots.abstractRobot.Robot;
import robots.implementations.robot127.Robot127;

@Configuration
public class JavaConfig {

    @Bean(value = {"workerRobot"})
    public Robot workerRobot(){
        return new Robot127();
    }
}