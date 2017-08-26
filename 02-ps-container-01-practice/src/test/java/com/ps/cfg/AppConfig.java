package com.ps.cfg;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ps.quiz", "com.ps.another.quiz"})
public class AppConfig {
}
