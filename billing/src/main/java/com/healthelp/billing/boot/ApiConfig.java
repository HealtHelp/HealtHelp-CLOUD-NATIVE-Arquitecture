package com.healthelp.billing.boot;

import com.healthelp.billing.controller.BillingController;
import com.healthelp.billing.controller.impl.BillingControllerImpl;
import com.healthelp.billing.dao.BillingDao;
import com.healthelp.billing.service.BillingService;
import com.healthelp.billing.service.impl.BillingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Bean
    public BillingService billingService(final BillingDao billingDao){
        return new BillingServiceImpl(billingDao);
    }

    @Bean
    public BillingController billingController(final  BillingService billingService){
        return new BillingControllerImpl(billingService);
    }
}
