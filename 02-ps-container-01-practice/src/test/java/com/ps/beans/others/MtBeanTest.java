package com.ps.beans.others;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Closeable;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by iuliana.cosmina on 3/26/16.
 */
public class MtBeanTest {

    private Logger logger = LoggerFactory.getLogger(MtBeanTest.class);

    @Test
    public void testConfig() throws IOException {
        //TODO 6. Modify this class to use the new set of configuration files, created by resolving TODO 5.
        //TODO 7. Try to use wildcards as well.
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/others/sample-config-01.xml");

        MultipleTypesBean mtBean = (MultipleTypesBean) ctx.getBean("mtBean");
        assertNotNull(mtBean);

        //expected no of beans in the context
        int beanCount1 = ctx.getBeanDefinitionNames().length;
        ((Closeable)ctx).close();

        ctx = new ClassPathXmlApplicationContext(
                "classpath:spring/others/sample-config-01-cfg-01-mtype.xml",
                "classpath:spring/others/sample-config-01-cfg-02-converter.xml",
                "classpath:spring/others/sample-config-01-cfg-03-beans.xml",
                "classpath:spring/others/sample-config-01-cfg-04-factory.xml"
        );
        int beanCount2 = ctx.getBeanDefinitionCount();
        ((Closeable)ctx).close();

        ctx = new ClassPathXmlApplicationContext(
                "classpath:spring/others/*-cfg-*.xml"
        );
        int beanCount3 = ctx.getBeanDefinitionCount();

        assertTrue("Counts through various methods must be same", beanCount1 == beanCount2);

        assertTrue("Counts through various methods must be same", beanCount1 == beanCount3);

    }
}
