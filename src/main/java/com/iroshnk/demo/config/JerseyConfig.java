package com.iroshnk.demo.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig{
    public JerseyConfig() {
        packages("com.iroshnk.demo.resources");
    }
}
