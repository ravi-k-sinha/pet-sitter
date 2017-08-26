package com.ps.beans.ctr;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by iuliana.cosmina on 3/26/16.
 */
public class CIBeansTest {
    private Logger logger = LoggerFactory.getLogger(CIBeansTest.class);

    @Test
    public void testConfig() {
        // ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/ctr/sample-config-01.xml");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/ctr/sample-config-02.xml");

        logger.info(" --- All beans in context --- ");
        for(String beanName :  ctx.getBeanDefinitionNames()) {
            logger.info("Bean " + beanName + " of type " + ctx.getBean(beanName).getClass().getSimpleName());
        }

        //TODO 3. Retrieve beans of types ComplexBean and make sure their dependencies were correctly set.
        ComplexBeanImpl complexBean0 = (ComplexBeanImpl)ctx.getBean("complexBean0");
        assertNotNull(complexBean0.getSimpleBean());
        assertFalse("complex must be false", complexBean0.isComplex());
        logger.info("complexBean0 is OK");

        ComplexBeanImpl complexBean1 = (ComplexBeanImpl)ctx.getBean("complexBean1");
        assertNotNull(complexBean1.getSimpleBean());
        assertTrue("complex must be true", complexBean1.isComplex());
        logger.info("complexBean1 is OK");

        ComplexBean2Impl complexBean2 = (ComplexBean2Impl)ctx.getBean("complexBean2");
        assertNotNull(complexBean2.getSimpleBean1());
        assertNotNull(complexBean2.getSimpleBean2());
        logger.info("complexBean2 is OK");
    }
}
