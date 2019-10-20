package com.healthelp.billing.service.impl;

import com.healthelp.billing.dao.BillingDao;
import com.healthelp.billing.model.dto.BillingDTO;
import com.healthelp.billing.model.map.BillingMapper;
import com.healthelp.billing.service.BillingService;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.UUID;

public class BillingServiceImpl implements BillingService , Converter<UUID,String> {

    private BillingDao billingDao;

    public BillingServiceImpl(BillingDao billingDao) {
        this.billingDao = billingDao;
    }

    @Override
    public String convert(UUID source) {
        return String.valueOf(source);
    }

    @Override
    public List<BillingDTO> getBillings() {
        return BillingMapper.mapBillingListToBillingDTOList(billingDao.findAll());
    }

    @Override
    public List<BillingDTO> getBillingsByPatientId(Integer patientId) {
        return BillingMapper.mapBillingListToBillingDTOList(billingDao.findAllByPatientId(patientId));
    }


}
