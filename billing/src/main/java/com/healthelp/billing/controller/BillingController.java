package com.healthelp.billing.controller;

import com.healthelp.billing.model.dto.BillingDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public interface BillingController {
    @GetMapping(path = "/billings")
    ResponseEntity<List<BillingDTO>> getBillings();
    @GetMapping(path = "/billings/{patientId}")
    ResponseEntity<List<BillingDTO>> getBillingsByPatientId(@PathVariable("patientId") Integer patientId);
}
