package main;

import main.springApplication.RobotApplication;
import robots.abstractRobot.Robot;

import java.util.logging.Logger;

public final class Main {

    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(final String[] args) {
        final RobotApplication robotApplication = new RobotApplication();
        log.info("\n\n");
        final Robot robot = (Robot) robotApplication.getGroovyApplicationContext().getBean("starKRERobot");
        robot.calc();
    }
}