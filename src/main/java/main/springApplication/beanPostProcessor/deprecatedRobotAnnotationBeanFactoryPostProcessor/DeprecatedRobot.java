package main.springApplication.beanPostProcessor.deprecatedRobotAnnotationBeanFactoryPostProcessor;

import robots.abstractRobot.Robot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DeprecatedRobot {
    Class<? extends Robot> newImplementation();
}
