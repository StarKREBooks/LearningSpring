package main.springApplication.beanPostProcessor.classInstallerBeanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public final class ClassInstallerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public final void postProcessBeanFactory(final ConfigurableListableBeanFactory beanFactory) throws BeansException {
        final String[] names = beanFactory.getBeanDefinitionNames();
    }
}