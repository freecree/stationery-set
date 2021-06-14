package config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"controllers", "services", "models", "repository"})
@EnableAutoConfiguration
@Import(HibernateConfig.class)
public class SpringConfig {

}
