package com.sec.practice.oauth.config;

import com.sec.practice.oauth.persistence.repository.RepositoryUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses=RepositoryUser.class)
@PropertySource(value = "classpath:message.properties")
public class ConfigApp implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${key.jwt}")
    private String KEY_JWT;

    @Value("${minute.exp}")
    private Long EXP_JWT;
    @Override
    public void run(String... args) throws Exception {
        StringBuilder builder = new StringBuilder("\nKEY: ");
        builder.append(KEY_JWT);
        builder.append("\nEXP: ");
        builder.append(EXP_JWT);
        logger.info(builder.toString());
    }
}
