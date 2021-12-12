package by.itacademy.javaenterprise.borisevich;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopDeveloperRunner {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AopConfig.class);
        Developer developer = context.getBean(Developer.class);
        developer.initProfile();
        developer.doSomeCode(8,1,100);

        developer.throwSomeMysticException();
    }
}
