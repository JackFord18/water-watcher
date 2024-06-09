package com.jackfordtech.waterwatcher.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface SoilReadingRepository extends CrudRepository<SoilReading, Integer> {
    @Override
    @NonNull
    List<SoilReading> findAll();

    @NonNull
    List<SoilReading> findByTimestampLessThanEqual(long endTimestamp);

    @NonNull
    List<SoilReading> findByTimestampGreaterThanEqual(long startTimestamp);

    @NonNull
    List<SoilReading> findByTimestampBetween(long startTimestamp, long endTimestamp);

    @NonNull
    List<SoilReading> findBySoilMoistureGreaterThanEqual(double minSoilMoisture);

    @NonNull
    List<SoilReading> findBySoilMoistureLessThanEqual(double maxSoilMoisture);

    @NonNull
    List<SoilReading> findBySoilMoistureBetween(double minSoilMoisture, double maxSoilMoisture);
}