package com.iroshnk.demo.util;

import com.iroshnk.demo.service.RandomNameService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class DemoBeanUtil implements ApplicationContextAware {
    private static ApplicationContext appCxt;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appCxt = applicationContext;
    }

    public static RandomNameService getRandomNameService() throws BeansException {
        return (RandomNameService) appCxt.getAutowireCapableBeanFactory().getBean("randomNameSvc");
    }
}
