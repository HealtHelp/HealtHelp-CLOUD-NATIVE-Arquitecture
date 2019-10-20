package com.healthelp.billing.service;

import com.healthelp.billing.model.dto.BillingDTO;
import java.util.List;



public interface BillingService {
    List<BillingDTO> getBillings();
    List<BillingDTO> getBillingsByPatientId(Integer patientId);
}
