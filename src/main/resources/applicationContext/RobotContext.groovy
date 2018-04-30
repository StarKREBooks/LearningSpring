package applicationContext

import main.springApplication.beanPostProcessor.FriendlyRobotAnnotationBeanPostProcessor
import main.springApplication.beanPostProcessor.RobotVersionAnnotationBeanPostProcessor
import robots.implementations.starKRERobot.StarKRERobot

beans{

    //Define StarKRE robot:
    starKRERobot(StarKRERobot){bean ->
        version = 5
        bean.initMethod = 'init'
        bean.destroyMethod = 'destroy'
    }

    //BeanPostProcessors:
    friendlyRobotAnnotationBeanPostProcessor(FriendlyRobotAnnotationBeanPostProcessor)
    robotVersionAnnotationBeanPostProcessor(RobotVersionAnnotationBeanPostProcessor)
}