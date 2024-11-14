package com.sec.practice.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources(
      @PropertySource(value = "classpath: message.properties")
)
public class ConfigApp {

}
