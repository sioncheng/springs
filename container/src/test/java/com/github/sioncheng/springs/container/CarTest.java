package com.github.sioncheng.springs.container;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarTest {

    @Test
    public void test() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(new String[]{"beans.xml", "beans2.xml"});

        Assert.assertNotNull(beanFactory);

        Object o = beanFactory.getBean("car");

        Assert.assertNotNull(o);

        Car car = (Car)o;
        Assert.assertEquals("defaultCar", car.getName());

        Object of = beanFactory.getBean("carF");

        Assert.assertNotNull(of);

        Assert.assertTrue(of instanceof Car);

        Assert.assertEquals("factoryCar", ((Car)of).getName());
    }
}
