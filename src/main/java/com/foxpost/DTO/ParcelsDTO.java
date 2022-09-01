package com.foxpost.DTO;

import lombok.Data;

@Data
public class ParcelsDTO {

    private int senderId;
    private int receiverId;
    private String parcelNo;
}
