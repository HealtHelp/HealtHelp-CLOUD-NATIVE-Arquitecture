package com.healthelp.sessions.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Builder
@Data
@Document("session")
public class Sessions {
    @Id
    private String id;
    private Date date;
    private Integer patientId;
    private String diagnosis;
    private String exploration;
    private String treatment;
    private String reason;
    private String background;
    private String complementary;

    public Sessions(){}

    public Sessions( Date date, int patientId, String diagnosis, String exploration, String treatment, String reason, String background, String complementary) {
        this.date = date;
        this.patientId = patientId;
        this.diagnosis = diagnosis;
        this.exploration = exploration;
        this.treatment = treatment;
        this.reason = reason;
        this.background = background;
        this.complementary = complementary;
    }

    public Sessions(String id, Date date, int patientId, String diagnosis, String exploration, String treatment, String reason, String background, String complementary) {
        this.id = id;
        this.date = date;
        this.patientId = patientId;
        this.diagnosis = diagnosis;
        this.exploration = exploration;
        this.treatment = treatment;
        this.reason = reason;
        this.background = background;
        this.complementary = complementary;
    }

}
