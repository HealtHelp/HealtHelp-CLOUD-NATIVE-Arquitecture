package com.healthelp.billing.model.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "billing")
public class Billing implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name="patient_id")
    private Integer patientId;
    @Column(name="session_id")
    private Integer sessionId;
    private Integer amount;
}
