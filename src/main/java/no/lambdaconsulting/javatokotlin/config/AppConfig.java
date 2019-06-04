package no.lambdaconsulting.javatokotlin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
class AppConfig {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
        .addScript("db/sql/create-db.sql")
        .addScript("db/sql/insert-data.sql")
        .build();
    }

    @Bean
    JdbcTemplate jdbcTempate() {
        return new JdbcTemplate(dataSource());
    }
}