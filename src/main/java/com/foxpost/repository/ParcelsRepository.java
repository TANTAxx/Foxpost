package com.foxpost.repository;

import com.foxpost.entity.Clients;
import com.foxpost.entity.Parcels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParcelsRepository extends JpaRepository<Parcels, Integer> {
    List<Parcels> findAllBySenderId(Clients senderId);

    List<Parcels> findAllByReceiverId(Clients receiverId);


}
