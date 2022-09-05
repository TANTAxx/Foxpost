package com.foxpost.repository;

import com.foxpost.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Clients,Integer> {
    Optional<Clients> findBySenderId(Clients senderId);
}
