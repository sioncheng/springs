package com.github.sioncheng.springs.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class BookDaoTest {

    @Test
    public void test() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(new String[]{"dao.xml"});

        Assert.assertNotNull(beanFactory);

        Object d = beanFactory.getBean("dataSource");
        Assert.assertNotNull(d);
        Assert.assertTrue(d instanceof DataSource);

        Object c= beanFactory.getBean("bookDao");

        Assert.assertNotNull(c);
        Assert.assertTrue(c instanceof BookDaoImpl);

        BookDaoImpl bookDao = (BookDaoImpl)c;
        int rows = bookDao.addBook(new Book());

        Assert.assertEquals(1, rows);
    }
}
