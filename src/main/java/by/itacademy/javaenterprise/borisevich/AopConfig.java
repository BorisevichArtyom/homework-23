package by.itacademy.javaenterprise.borisevich;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("by.itacademy.javaenterprise.borisevich")
@EnableAspectJAutoProxy
public class AopConfig {

    @Bean
    public Developer getDeveloper() {
        return new Developer("Borisevich", "Java developer", 2);
    }


}
