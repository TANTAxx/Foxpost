package com.foxpost.repository;

import com.foxpost.entity.Parcel;
import com.foxpost.entity.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackingsRepository extends JpaRepository<Tracking, Integer> {

    List<Tracking> findAllByParcelId(Parcel parcel);
}
