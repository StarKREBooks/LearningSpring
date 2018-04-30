package robots.implementations.robot724;

import org.springframework.beans.factory.InitializingBean;
import robots.abstractRobot.Robot;
import robots.abstractRobot.core.Core;
import robots.abstractRobot.head.Head;

public final class Robot724 implements Robot, InitializingBean {

    private Core core;

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

    }

    public final void setCore(final Core core) {
        this.core = core;
    }

    @Override
    public final void afterPropertiesSet() {

    }
}