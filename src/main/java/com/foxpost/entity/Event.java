package com.foxpost.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id; // id


// mentés nem megy akkor ha a GenerateValue bent van !
    //megoldva / táblakat sql-be létre kellet hozni (if not exists)
    // + app.proper-be felkellet venni, hogy a sql táblákat minden újra inditásnál törölje
    // + auto_increment ( a not null helyet!)

    private String eventName; // esemény neve

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Events{");
        sb.append("id=").append(id);
        sb.append(", eventName='").append(eventName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Event(String eventName) {
        super();
        this.eventName = eventName;
    }
}
