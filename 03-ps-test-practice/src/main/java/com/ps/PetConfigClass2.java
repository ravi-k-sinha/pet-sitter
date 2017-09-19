package com.ps;

import com.ps.services.PetService;
import com.ps.services.impl.SimplePetService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by iuliana.cosmina on 4/17/16.
 */
public class PetConfigClass2 {

    @Bean
    public PetService simplePetService() {
        return new SimplePetService();
    }
}
