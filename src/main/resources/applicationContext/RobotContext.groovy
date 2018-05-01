package applicationContext

import main.springApplication.beanPostProcessor.friendlyRobotAnnotationBeanPostProcessor.FriendlyRobotAnnotationBeanPostProcessor
import main.springApplication.beanPostProcessor.profilingAnnotationBeanPostProcessor.ProfilingAnnotationBeanPostProcessor
import main.springApplication.beanPostProcessor.robotVersionAnnotationBeanPostProcessor.RobotVersionAnnotationBeanPostProcessor
import main.springApplication.contextListener.FinalInitializationContextListener.FinalInitializationAnnotationContextListener
import robots.implementations.starKRERobot.StarKRERobot

beans{

    //Define StarKRE robot:
    starKRERobot(StarKRERobot){bean ->
        version = 5
        bean.initMethod = 'secondInit'
        bean.destroyMethod = 'destroy'
    }

    xmlns(['annotation-config':'http://www.springframework.org/schema/context'])

    //BeanPostProcessors:
    friendlyRobotAnnotationBeanPostProcessor(FriendlyRobotAnnotationBeanPostProcessor)
    robotVersionAnnotationBeanPostProcessor(RobotVersionAnnotationBeanPostProcessor)
    profilingAnnotationBeanPostProcessor(ProfilingAnnotationBeanPostProcessor)
    finalInitializationAnnotationContextListener(FinalInitializationAnnotationContextListener)
}