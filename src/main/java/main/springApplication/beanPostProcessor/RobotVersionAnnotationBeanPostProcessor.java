package main.springApplication.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;
import robots.abstractRobot.annotations.RobotVersion;

import java.lang.reflect.Field;
import java.util.logging.Logger;

public final class RobotVersionAnnotationBeanPostProcessor implements BeanPostProcessor {

    private static final Logger log = Logger.getLogger(FriendlyRobotAnnotationBeanPostProcessor.class.getName());

    @Override
    public final Object postProcessBeforeInitialization(final Object bean, final String beanName)
            throws BeansException {
        log.info("\n\n\nRobotVersionAnnotationBeanPostProcessor: BEFORE INIT: " + beanName);
        final Class clazz = bean.getClass();
        final Field[] fields = clazz.getDeclaredFields();
        for (final Field field : fields) {
            final RobotVersion robotVersionAnnotation = field.getAnnotation(RobotVersion.class);
            if (robotVersionAnnotation != null){
                ReflectionUtils.makeAccessible(field);
                final int minVersion = robotVersionAnnotation.min();
                final int currentVersion = (int) ReflectionUtils.getField(field, bean);
                log.info("MIN VERSION: " + minVersion);
                log.info("CURRENT VERSION: " + currentVersion);
                if (minVersion > currentVersion){
                    ReflectionUtils.setField(field, bean, minVersion);
                }
            }
        }
        return bean;
    }

    @Override
    public final Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException {
        log.info("RobotVersionAnnotationBeanPostProcessor: AFTER INIT: " + beanName);
        return bean;
    }
}
