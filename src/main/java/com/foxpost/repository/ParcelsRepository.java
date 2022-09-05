package com.foxpost.repository;

import com.foxpost.entity.Clients;
import com.foxpost.entity.Parcels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParcelsRepository extends JpaRepository<Parcels, Integer> {
    Parcels findBySenderId(Clients senderId);
    Parcels findByReceiverId(Clients receiverId);

   Optional <Parcels> findByParcelNo(String parcelNumber);
    

}
