package robots.implementations.robot724.core;

import robots.abstractRobot.core.Core;

import java.util.logging.Logger;

public final class Core724 implements Core {

    private static final Logger log = Logger.getLogger(Core724.class.getName());

    public final void install(){
        log.info("CORE-724 has installed!!!");
    }

    public final void activate(){
        log.info("CORE-724 has activated!!!");
    }
}