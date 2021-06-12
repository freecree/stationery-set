package config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "repository")
@EntityScan(basePackages = "models")
@Import({HibernateConfigH2.class, HibernateConfigMySQL.class})
public class HibernateConfig {
    //    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Properties hibernateProperties) {
//        LocalContainerEntityManagerFactoryBean em
//                = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource);
//        em.setPackagesToScan("models");
//
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        em.setJpaProperties(hibernateProperties);
//
//        return em;
//    }

}
