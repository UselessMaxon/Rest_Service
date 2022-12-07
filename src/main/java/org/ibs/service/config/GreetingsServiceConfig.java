package org.ibs.service.config;


import lombok.extern.slf4j.Slf4j;
import org.ibs.service.bussines.GreetingService;
import org.ibs.service.bussines.GreetingServiceImpl;
import org.ibs.service.bussines.GreetingServiceImpl2;
import org.ibs.service.domain.entity.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Slf4j
public class GreetingsServiceConfig {

    @Bean
    @Profile("!test")
    GreetingService getGSImpl() {
        return  new GreetingServiceImpl(log);
    }

    @Bean
    @Profile("test")
    GreetingService getGSImpl2() {
        return  new GreetingServiceImpl2(log);
    }


    @Bean
    Employee makeDefEmppl() {
        return new Employee(null, "Maks", null, null, null, null, null, null);
    }
}
