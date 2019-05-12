package com.github.sioncheng.springs.container;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.List;

public class DemoCustomInit implements InitializingBean, ApplicationContextAware {

    private String message;
    private String name;
    private boolean afterPropertiesSetted;
    private ApplicationContext applicationContext;
    private List<String> initOrder = new ArrayList<String>();

    public void init() {
        this.message = "m-init";
        this.name = "m-name";
        this.addInitOrder("self");
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public boolean isAfterPropertiesSetted() {
        return afterPropertiesSetted;
    }

    public void afterPropertiesSet() throws Exception {
        this.afterPropertiesSetted = true;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public String[] getInitOrder() {
        return  initOrder.toArray(new String[]{});
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void addInitOrder(String o) {
        this.initOrder.add(o);
    }
}
