package com.ps.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by iuliana.cosmina on 4/17/16.
 */
@Configuration
@ComponentScan(basePackages = {"com.ps.repos.impl", "com.ps.services" ,"com.ps.aspects"})
//TODO 20. Enable automatic @Aspect detection
public class AppConfig {
}
