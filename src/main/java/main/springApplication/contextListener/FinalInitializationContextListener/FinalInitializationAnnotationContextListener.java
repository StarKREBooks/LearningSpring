package main.springApplication.contextListener.FinalInitializationContextListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.lang.reflect.Method;

public class FinalInitializationAnnotationContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ConfigurableListableBeanFactory configurableListableBeanFactory;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        final ApplicationContext context = event.getApplicationContext();
        final String[] beanDefinitionNames =  context.getBeanDefinitionNames();
        for (final String name : beanDefinitionNames){
            final BeanDefinition beanDefinition = this.configurableListableBeanFactory.getBeanDefinition(name);
            final String originalClazzName = beanDefinition.getBeanClassName();
            try {
                final Class<?> originalClazz =  Class.forName(originalClazzName);
                final Method[] methods = originalClazz.getMethods();
                for (final Method method : methods){
                    if (method.isAnnotationPresent(FinalInitialization.class)){
                        final Object bean = context.getBean(name);
                        final Class<?> proxyClazz = bean.getClass();
                        System.out.println("Original: " + method.getName());
                        for (final Method eachMethod : proxyClazz.getMethods()){
                            System.out.println("Proxy: " + eachMethod.getName());
                        }
                        final Method proxyMethod = proxyClazz.getMethod(method.getName(), method.getParameterTypes());
                        proxyMethod.invoke(bean);
                    }
                }
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
    }
}
