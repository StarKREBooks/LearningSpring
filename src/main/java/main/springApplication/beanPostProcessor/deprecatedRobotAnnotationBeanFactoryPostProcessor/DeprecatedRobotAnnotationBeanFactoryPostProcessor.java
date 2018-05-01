package main.springApplication.beanPostProcessor.deprecatedRobotAnnotationBeanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

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
                }
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
    }
}