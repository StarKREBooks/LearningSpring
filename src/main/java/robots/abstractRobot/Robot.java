package robots.abstractRobot;

import robots.abstractRobot.core.Core;
import robots.abstractRobot.head.Head;

public interface Robot {

    Head getHead();

    Core getCore();

    void calc();

    void thirdInit();
}
