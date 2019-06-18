package com.iroshnk.demo.config;

import com.iroshnk.demo.util.DemoBeanUtil;
import com.iroshnk.demo.websocket.RandomNameServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ServletRegistrationBean socketServlet(){
        return new ServletRegistrationBean(new RandomNameServlet(), "/push");
    }

    @Bean
    public DemoBeanUtil randomNameBeanUtil(){
        return new DemoBeanUtil();
    }
}
