package main.springApplication;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public final class RobotApplication {

    private ClassPathXmlApplicationContext classPathXmlApplicationContext;

    private GenericGroovyApplicationContext groovyApplicationContext;

    public RobotApplication(){
        final String xmlConfigLocation = "applicationContext/RobotContext.xml";
        final String groovyConfigLocation = "applicationContext/RobotContext.groovy";
        //Раскоментируйте, если хотите запустить XMLContext:
         this.classPathXmlApplicationContext = new ClassPathXmlApplicationContext(xmlConfigLocation);
//        this.groovyApplicationContext = new GenericGroovyApplicationContext(groovyConfigLocation);
    }

    public final ClassPathXmlApplicationContext getClassPathXmlApplicationContext(){
        return this.classPathXmlApplicationContext;
    }

    public final GenericGroovyApplicationContext getGroovyApplicationContext() {
        return this.groovyApplicationContext;
    }
}