package com.healthelp.billing.dao;

import com.healthelp.billing.model.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BillingDao extends JpaRepository<Billing,Integer> {

    List<Billing> findAllByPatientId(Integer patientId);
}
