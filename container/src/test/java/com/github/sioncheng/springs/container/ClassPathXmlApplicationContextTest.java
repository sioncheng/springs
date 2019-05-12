package com.github.sioncheng.springs.container;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassPathXmlApplicationContextTest {
    @Test
    public void testInit() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(new String[]{"beans.xml", "beans2.xml"});

        Assert.assertNotNull(beanFactory);
    }
}
