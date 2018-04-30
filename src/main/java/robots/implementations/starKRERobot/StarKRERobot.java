package robots.implementations.starKRERobot;

import org.springframework.beans.factory.InitializingBean;
import robots.abstractRobot.Robot;
import robots.abstractRobot.annotations.FriendlyRobot;
import robots.abstractRobot.annotations.RobotVersion;
import robots.abstractRobot.core.Core;
import robots.abstractRobot.head.Head;

import java.util.logging.Logger;

@FriendlyRobot
public final class StarKRERobot implements Robot, InitializingBean {

    private static final Logger log = Logger.getLogger(StarKRERobot.class.getName());

    @RobotVersion(min = 10)
    private int version;

    private Head head;

    private Core core;

    @Override
    public final void calc() {
        log.info("I'm calculating...");
    }

    @Override
    public final void afterPropertiesSet() {
        log.info("I'm ready to the battle!!!");
    }

    private void init(){
        log.info("Hello, I'm StarKRE with version: " + this.version);
    }

    private void destroy() {
        log.info("No!!! I'l be BACK!!!!!");
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