package com.foxpost.repository;

import com.foxpost.entity.Client;
import com.foxpost.entity.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParcelsRepository extends JpaRepository<Parcel, Integer> {

   List<Parcel>  findAllByReceiverId(Client receiverId);
   List<Parcel>  findAllBySenderId(Client senderId);

   Optional <Parcel> findByParcelNo(String parcelNumber);
    

}
