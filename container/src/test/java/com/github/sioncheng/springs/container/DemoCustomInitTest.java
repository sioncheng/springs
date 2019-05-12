package com.github.sioncheng.springs.container;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoCustomInitTest {

    @Test
    public void testInit()  {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(new String[]{"beans.xml", "beans2.xml"});

        Assert.assertNotNull(beanFactory);

        Object o = beanFactory.getBean("demoCustomInit");

        Assert.assertNotNull(o);

        DemoCustomInit demoCustomInit = (DemoCustomInit)o;

        Assert.assertEquals("m-init", demoCustomInit.getMessage());
        Assert.assertEquals("m-name", demoCustomInit.getName());
        Assert.assertEquals(true, demoCustomInit.isAfterPropertiesSetted());
        Assert.assertNotNull(demoCustomInit.getApplicationContext());
        Assert.assertEquals(beanFactory, demoCustomInit.getApplicationContext());
        String[] initOrder = demoCustomInit.getInitOrder();
        Assert.assertNotNull(initOrder);
        Assert.assertEquals(2, demoCustomInit.getInitOrder().length);
        Assert.assertEquals("demoBeanPostProcessor", initOrder[0]);
        Assert.assertEquals("self", initOrder[1]);
    }
}
