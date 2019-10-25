package com.healthelp.billing.controller.impl;

import com.healthelp.billing.controller.BillingController;
import com.healthelp.billing.model.dto.BillingDTO;
import com.healthelp.billing.service.BillingService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@Slf4j
public class BillingControllerImpl implements BillingController {

    private BillingService billingService;

    public BillingControllerImpl(BillingService billingService) {
        this.billingService = billingService;
    }

    @Override
    public ResponseEntity<List<BillingDTO>> getBillings(){
        log.info(" -- GET /patients");
        return new ResponseEntity<>(billingService.getBillings(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<BillingDTO>> getBillingsByPatientId(Integer patientId) {
        log.info(" -- GET /patients/{}",patientId);
        return new ResponseEntity<>(billingService.getBillingsByPatientId(patientId),HttpStatus.OK);
    }


}
