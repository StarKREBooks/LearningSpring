package main.springApplication.beanPostProcessor.deprecatedRobotAnnotationBeanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import robots.implementations.robot127.Robot127;
import robots.implementations.robot724.Robot724;

import java.util.logging.Logger;

public final class DeprecatedRobotAnnotationBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private static final Logger log = Logger.getLogger(DeprecatedRobotAnnotationBeanFactoryPostProcessor.class
            .getName());

    @Override
    public final void postProcessBeanFactory(final ConfigurableListableBeanFactory beanFactory) throws BeansException {
        final String[] names = beanFactory.getBeanDefinitionNames();
        for (final String name : names){
            final BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            final String beanClazzName = beanDefinition.getBeanClassName();
            try {
                if (beanClazzName != null){
                    final Class<?> beanClazz = Class.forName(beanClazzName);
                    final DeprecatedRobot deprecatedRobotAnnotation = beanClazz.getAnnotation(DeprecatedRobot.class);
                    if (deprecatedRobotAnnotation != null){
                        beanDefinition.setBeanClassName(deprecatedRobotAnnotation.newImplementation().getName());
                    }
                } else {
                    System.out.println("!!!!-----" + name);
                    beanDefinition.setBeanClassName(Robot724.class.getName());
                }
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
    }
}