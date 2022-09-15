package com.foxpost.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

//
@Entity
@NoArgsConstructor
@Data
@Table(name = "parcels")
public class Parcel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // ID

    @OneToMany
    @JoinColumn(referencedColumnName = "id")
    @Transient
    @JsonIgnore
    private List<Tracking> track;
    @OneToOne
    @JoinColumn(referencedColumnName = "ID")
    private Client senderId;

    @OneToOne
    @JoinColumn(referencedColumnName = "ID")
    private Client receiverId;

    private String parcelNo;

    public Parcel(Client senderId, Client receiverId, String parcelNo) {
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
