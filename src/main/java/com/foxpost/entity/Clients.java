package com.foxpost.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // ID
    private String clientName; //Ügyfélnév
    private String address; // Ügyfél címe
    private String zipcode; // Ügyfél irányítószáma
    private String city;  // Város
    private String phone; // telefonszáma
    private String email; // email címe

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ugyfelek{");
        sb.append("id=").append(id);
        sb.append(", clientName='").append(clientName).append('\'');
        sb.append(", addres='").append(address).append('\'');
        sb.append(", zipcode='").append(zipcode).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Clients(int id) {
        this.id = id;
    }

    public Clients(String clientName, String address, String zipcode, String city, String phone, String email) {
        super();
        this.clientName = clientName;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.phone = phone;
        this.email = email;
    }

}
