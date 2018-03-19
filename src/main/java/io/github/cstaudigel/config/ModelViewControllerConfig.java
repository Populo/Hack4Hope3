package io.github.cstaudigel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * The file ModelViewControllerConfig.java was created by Chris on 2:34 PM at 3/17/2018
 */

@Configuration
public class ModelViewControllerConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");
        //registry.addViewController("/CreateUser").setViewName("createuserform");
    }
}
