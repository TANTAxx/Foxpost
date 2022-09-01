package com.foxpost.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

//
@Entity
@NoArgsConstructor
@Data
public class Parcels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // ID

    @OneToMany
    @JoinColumn(referencedColumnName = "id")
    private List<Trackings> track;
    @OneToOne
    @JoinColumn(referencedColumnName = "ID")
    private Clients senderId; // Ügyfél idegen kulcs feladó

    @OneToOne
    @JoinColumn(referencedColumnName = "ID")
    private Clients receiverId; // Ügyfél idegen kulcs címzett

    private String parcelNo; // Csomagszám

    public Parcels(Clients senderId, Clients receiverId, String parcelNo) {
        this.parcelNo = parcelNo;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Parcels{");
        sb.append("id=").append(id);
        sb.append(", senderId=").append(senderId);
        sb.append(", receiverId=").append(receiverId);
        sb.append(", parcelNo='").append(parcelNo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
