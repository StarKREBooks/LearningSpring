package robots.implementations.starKRERobot;

import main.springApplication.beanPostProcessor.profilingAnnotationBeanPostProcessor.Profiling;
import main.springApplication.contextListener.FinalInitializationContextListener.FinalInitialization;
import robots.abstractRobot.Robot;
import main.springApplication.beanPostProcessor.friendlyRobotAnnotationBeanPostProcessor.FriendlyRobot;
import main.springApplication.beanPostProcessor.robotVersionAnnotationBeanPostProcessor.RobotVersion;
import robots.abstractRobot.core.Core;
import robots.abstractRobot.head.Head;

import java.util.logging.Logger;

@Profiling
@FriendlyRobot
public final class StarKRERobot implements Robot {

    private static final Logger log = Logger.getLogger(StarKRERobot.class.getName());

    @RobotVersion(min = 10)
    private int version;

    private Head head;

    private Core core;


    @Override
    public final void calc() {
        log.info("I'm calculating...");
    }

    private void secondInit(){
        log.info("Hello, I'm StarKRE with version: " + this.version);
    }

    private void destroy() {
        log.info("No!!! I'l be BACK!!!!!");
    }

    @Override
    @FinalInitialization
    public final void thirdInit(){
        log.info("I'M READY!!!");
    }

    public final int getVersion() {
        return this.version;
    }

    public final void setVersion(int version) {
        this.version = version;
    }

    @Override
    public final Head getHead() {
        return this.head;
    }

    @Override
    public final Core getCore() {
        return this.core;
    }
}