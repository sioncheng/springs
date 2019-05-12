package com.github.sioncheng.springs.container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContainerApp {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("beans.xml");

        System.out.println(beanFactory.containsBean("a"));
    }
}
