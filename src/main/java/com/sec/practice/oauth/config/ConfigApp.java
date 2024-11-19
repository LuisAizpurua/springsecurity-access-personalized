package com.sec.practice.oauth.config;

import com.sec.practice.oauth.persistence.repository.RepositoryUser;
import com.sec.practice.oauth.persistence.util.fileproperty.JwtProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses=RepositoryUser.class)
@PropertySource(value = "classpath:message.properties")
@EnableConfigurationProperties(JwtProperty.class)
public class ConfigApp {

     /*
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${key.jwt}")
    private String KEY_JWT;

    @Value("${minute.exp}")
    private Long EXP_JWT;

    @Bean
    CommandLineRunner commandLineRunner(){
    return args-> {
        StringBuilder builder = new StringBuilder("\nKEY: ");
        builder.append(KEY_JWT);
        builder.append("\nEXP: ");
        builder.append(EXP_JWT);
        logger.info(builder.toString());
        };
    }
     */
}