package com.healthelp.sessions.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
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
}
