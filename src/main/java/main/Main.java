package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

public final class Main {

    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(final String[] args) {
        final ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("applicationContext/RobotContext.xml");
        final Robot robot = context.getBean(Robot.class);
        robot.make();
    }
}