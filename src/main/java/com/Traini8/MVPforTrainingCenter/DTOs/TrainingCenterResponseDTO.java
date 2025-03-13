package com.Traini8.MVPforTrainingCenter.DTOs;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.Traini8.MVPforTrainingCenter.Entity.Address;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TrainingCenterResponseDTO {

    private String centerName;
    private String centerCode;
    private Address address;
    private Integer studentCapacity;
    private List<String> coursesOffered;
    private String contactEmail;
    private String contactPhone;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Kolkata")
    private String createdOn; // Store formatted date as a String

    // Convert Epoch time to formatted date before returning
     public void setCreatedOn(Long epochTime) {
        if (epochTime != null) {
            LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(epochTime), ZoneId.of("Asia/Kolkata"));
            this.createdOn = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
    }
}
