package main.springApplication.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import robots.abstractRobot.annotations.FriendlyRobot;

import java.util.logging.Logger;

public final class FriendlyRobotAnnotationBeanPostProcessor implements BeanPostProcessor {

    private static final Logger log = Logger.getLogger(FriendlyRobotAnnotationBeanPostProcessor.class.getName());

    @Override
    public final Object postProcessBeforeInitialization(final Object bean, final String beanName)
            throws BeansException {
        final FriendlyRobot friendlyRobotAnnotation = bean.getClass().getAnnotation(FriendlyRobot.class);
        if (friendlyRobotAnnotation != null){
            final String message = "\n\n\n" + beanName + " IS A FRIENDLY ROBOT";
            log.info(message.toUpperCase());
        }
        log.info("\n\n\nFriendlyRobotAnnotationBeanPostProcessor: BEFORE INIT: " + beanName);
        return bean;
    }

    @Override
    public final Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException {
        log.info("FriendlyRobotAnnotationBeanPostProcessor: AFTER INIT: " + beanName);
        return bean;
    }
}