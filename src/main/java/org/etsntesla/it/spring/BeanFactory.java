package org.etsntesla.it.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = "org.etsntesla.it.spring")
@PropertySource("classpath:application.properties")
public class BeanFactory {

    @Autowired
    Environment env;

    @Bean
    public DatabaseConfiguration factoryDBConfig(){
        DatabaseConfiguration config = new DatabaseConfiguration();
        config.setUrl(env.getProperty("database.url"));
        config.setUser(env.getProperty("database.user"));
        config.setPass(env.getProperty("database.pass"));
        return config;
    }
}
