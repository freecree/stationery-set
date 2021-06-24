package application;

import com.vaadin.flow.spring.annotation.EnableVaadin;
import config.HibernateConfig;
import config.SpringConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.vaadin.artur.helpers.LaunchUtil;

@EnableVaadin("application/views")
@SpringBootApplication
@Import(SpringConfig.class)
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        LaunchUtil.launchBrowserInDevelopmentMode(SpringApplication.run(Application.class, args));
    }

}
