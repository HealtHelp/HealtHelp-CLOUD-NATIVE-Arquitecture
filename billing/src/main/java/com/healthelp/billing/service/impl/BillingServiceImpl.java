package com.healthelp.billing.service.impl;

import com.healthelp.billing.controller.impl.ExceptionHandlerControllerImpl;
import com.healthelp.billing.dao.BillingDao;
import com.healthelp.billing.model.dto.BillingDTO;
import com.healthelp.billing.model.entity.Billing;
import com.healthelp.billing.model.exceptions.HandleNotFoundByPatientId;
import com.healthelp.billing.model.map.BillingMapper;
import com.healthelp.billing.service.BillingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Slf4j
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
    public List<BillingDTO> getBillingsByPatientId(Integer patientId){
        List<Billing> billingDTOList;
        try{
            billingDTOList = billingDao.findAllByPatientId(patientId);
            Objects.equals(billingDTOList.get(0).getPatientId(), patientId);
        }catch (Exception ex){
            throw new HandleNotFoundByPatientId(ex);
        }
        return BillingMapper.mapBillingListToBillingDTOList(billingDTOList);
    }
}
