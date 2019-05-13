package com.github.sioncheng.springs.container;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsTest {

    @Test
    public void test() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(new String[]{"annotations.xml"});

        Assert.assertNotNull(beanFactory);

        Object c= beanFactory.getBean("customer");

        Assert.assertNotNull(c);
        Assert.assertTrue(c instanceof Customer);

        Customer customer = (Customer)c;

        Assert.assertNotNull(customer.getAddress());
        Assert.assertTrue(customer.getAddress() instanceof ShanghaiAddress);
        Assert.assertEquals("shanghai", customer.getAddress().getCityName());

        Object bo = beanFactory.getBean("beijing");

        Assert.assertNotNull(bo);
        Assert.assertTrue(bo instanceof BeijingAddress);

    }
}
