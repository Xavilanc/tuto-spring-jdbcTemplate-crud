package tutojava.com.tuto.shared.database;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class DataSourceConfig extends DriverManagerDataSource {

    // Recuperer toutes les propriétés qui commencent par "spring.datasource"
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        return new DriverManagerDataSource();
    }

    @Bean("jdbc-template-1") // For @Qualifier (utilisation de plusieurs DB)
    public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(dataSource());
    }
} 
