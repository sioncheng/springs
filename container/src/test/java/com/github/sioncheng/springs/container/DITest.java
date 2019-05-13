package com.github.sioncheng.springs.container;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DITest {

    @Test
    public void test() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(new String[]{"di.xml"});

        Assert.assertNotNull(beanFactory);

        Object c= beanFactory.getBean("customer");

        Assert.assertNotNull(c);
        Assert.assertTrue(c instanceof Customer);

        Customer customer = (Customer)c;

        Assert.assertEquals("james", customer.getName());
        Assert.assertEquals("shanghai", customer.getAddress().getCityName());

        Object c2 = beanFactory.getBean("customer2");

        Assert.assertNotNull(c2);
        Assert.assertTrue(c2 instanceof Customer);

        Customer customer2 = (Customer)c2;

        Assert.assertEquals("jane", customer2.getName());
        Assert.assertEquals("shanghai", customer2.getAddress().getCityName());
    }
}
