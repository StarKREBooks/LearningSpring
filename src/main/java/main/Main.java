package main;

import main.springApplication.RobotApplication;
import robots.abstractRobot.Robot;

import java.util.logging.Logger;

public final class Main {

    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(final String[] args) {
        final RobotApplication robotApplication = new RobotApplication();
        final Robot robot = (Robot) robotApplication.getClassPathXmlApplicationContext().getBean("workerRobot");
        robot.calc();
        final Robot robot2 = (Robot) robotApplication.getClassPathXmlApplicationContext().getBean("starKRERobot");
        robot2.calc();
    }
}