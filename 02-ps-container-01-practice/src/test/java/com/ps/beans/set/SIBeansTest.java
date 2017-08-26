package com.ps.beans.set;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by iuliana.cosmina on 3/26/16.
 */
public class SIBeansTest {
    private Logger logger = LoggerFactory.getLogger(SIBeansTest.class);

    @Test
    public void testConfig() {
        // ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/set/sample-config-01.xml");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/set/sample-config-02.xml");

        logger.info(" --- All beans in context --- ");
        for(String beanName :  ctx.getBeanDefinitionNames()) {
            logger.info("Bean " + beanName + " of type " + ctx.getBean(beanName).getClass().getSimpleName());
        }

        //TODO 4. Retrieve beans of types ComplexBean and make sure their dependencies were correctly set.
        ComplexBeanImpl complexBean0 = ctx.getBean("complexBean0", ComplexBeanImpl.class);
        assertNotNull(complexBean0.getSimpleBean());
        assertFalse(complexBean0.isComplex());

        ComplexBeanImpl complexBean1 = ctx.getBean("complexBean1", ComplexBeanImpl.class);
        assertNotNull(complexBean1.getSimpleBean());
        assertTrue(complexBean1.isComplex());

        ComplexBean2Impl complexBean2 = ctx.getBean("complexBean2", ComplexBean2Impl.class);
        assertNotNull(complexBean2.getSimpleBean());
        assertTrue(complexBean2.isComplex());

    }
}
