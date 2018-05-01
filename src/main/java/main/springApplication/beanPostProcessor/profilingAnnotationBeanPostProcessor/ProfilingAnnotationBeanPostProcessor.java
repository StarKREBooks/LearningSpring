package main.springApplication.beanPostProcessor.profilingAnnotationBeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public final class ProfilingAnnotationBeanPostProcessor implements BeanPostProcessor {

    private static final Logger log = Logger.getLogger(ProfilingAnnotationBeanPostProcessor.class.getName());

    private final Map<String, Class> beanNameVsBeanClazzMap = new HashMap<>();

    @Override
    public final Object postProcessBeforeInitialization(final Object bean, final String beanName)
            throws BeansException {
        final Class beanClazz = bean.getClass();
        if (beanClazz.isAnnotationPresent(Profiling.class)) {
            this.beanNameVsBeanClazzMap.put(beanName, beanClazz);
        }
        return bean;
    }

    @Override
    public final Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException {
        final Class beanClazz = this.beanNameVsBeanClazzMap.get(beanName);
        if (beanClazz != null) {
            final ClassLoader clazzLoader = beanClazz.getClassLoader();
            final Class[] interfaces = beanClazz.getInterfaces();
            final InvocationHandler invocationHandler = (proxy, method, args) -> {
                log.info("\nSTART PROFILING..................................................");
                final long before = System.nanoTime();
                final Object returnValue = method.invoke(bean, args);
                final long after = System.nanoTime();
                log.info("\n TIME: " + (after - before));
                log.info("\nEND PROFILING....................................................");
                return returnValue;
            };
            return Proxy.newProxyInstance(clazzLoader, interfaces, invocationHandler);
        }
        return bean;
    }
}