package com.healthelp.billing.model.map;

import com.healthelp.billing.model.dto.BillingDTO;
import com.healthelp.billing.model.dto.HttpErrorDTO;
import com.healthelp.billing.model.entity.Billing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

public class BillingMapper {

    public static List<BillingDTO> mapBillingListToBillingDTOList(List<Billing> billings){
      return billings.stream().map(BillingMapper::mapBillingToBillingDTO).collect(Collectors.toList());
    }

    public static BillingDTO mapBillingToBillingDTO(Billing item) {
        return BillingDTO.builder()
                .id(item.getId())
                .date(item.getDate())
                .amount(item.getAmount())
                .sessionId(item.getSessionId())
                .patientId(item.getPatientId()).build();
    }

    public static ResponseEntity<HttpErrorDTO> buildHttpErrorDTO(Integer code, String statusText, String url, String message) {
        return new ResponseEntity<>(HttpErrorDTO.builder()
                .code(code)
                .statusText(statusText)
                .url(url)
                .message(message)
                .build(), HttpStatus.NOT_FOUND);
    }
}
