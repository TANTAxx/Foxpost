package com.foxpost.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trackings")
public class Tracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   @ManyToOne
    private Parcel parcelId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventDate;
    @OneToOne
    @JoinColumn(referencedColumnName = "ID")
    private Event eventId;
//    private Set<Events> eventId = new HashSet<>();

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Trackings{");
        sb.append("id=").append(id);
        sb.append(", parcelId=").append(parcelId);
        sb.append(", eventDate=").append(eventDate);
        sb.append(", eventId=").append(eventId);
        sb.append('}');
        return sb.toString();
    }

    public Tracking(Parcel parcelId){
        this.parcelId = parcelId;
    }
    public Tracking(Event eventId, Parcel parcelId, LocalDate eventDate) {
        this.eventId = eventId;
        this.parcelId = parcelId;
        this.eventDate = eventDate;
    }

// 1 csomagszámot beirni adja azz összes csomaghoz tartozó Trackinget vissza
}
