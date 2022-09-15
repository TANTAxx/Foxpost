package com.foxpost.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // ID
    private String clientName; //Ügyfélnév
    private String address; // Ügyfél címe
    private String zipcode; // Ügyfél irányítószáma
    private String city;  // Város
    private String phone; // telefonszáma
    @Email
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

    public Client(int id) {
        this.id = id;
    }

    public Client(String clientName, String address, String zipcode, String city, String phone, String email) {
        super();
        this.clientName = clientName;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.phone = phone;
        this.email = email;
    }

}
