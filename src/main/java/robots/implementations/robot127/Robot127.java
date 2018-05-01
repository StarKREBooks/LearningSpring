package robots.implementations.robot127;

import main.springApplication.beanPostProcessor.deprecatedRobotAnnotationBeanFactoryPostProcessor.DeprecatedRobot;
import robots.abstractRobot.Robot;
import robots.abstractRobot.core.Core;
import robots.abstractRobot.head.Head;
import robots.implementations.robot724.Robot724;

@DeprecatedRobot(newImplementation = Robot724.class)
public final class Robot127 implements Robot {

    @Override
    public Head getHead() {
        return null;
    }

    @Override
    public Core getCore() {
        return null;
    }

    @Override
    public void calc() {
        System.out.println("Robot127 is calculating...");
    }

    @Override
    public void thirdInit() {

    }
}