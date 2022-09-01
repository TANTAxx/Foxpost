package com.foxpost.repository;

import com.foxpost.entity.Parcels;
import com.foxpost.entity.Trackings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackingsRepository extends JpaRepository<Trackings, Integer> {

//    List<Trackings> findByAllByParcelId(Parcels parcels);

    List<Trackings> findAllByParcelId(Parcels parcelId);
}
