package com.foxpost.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TrackingDTO {
    private short eventId;
    private int parcelId;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDate eventDate;

    public TrackingDTO(short eventId, int parcelId, LocalDate eventDate) {
        this.eventId = eventId;
        this.eventDate = eventDate;
        this.parcelId = parcelId;
    }
}
