package com.jackfordtech.waterwatcher.soilreading.service;

import com.jackfordtech.waterwatcher.soilreading.dao.SoilReading;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface SoilReadingService {
    List<SoilReading> getAllReadings();

    List<SoilReading> findByDate(LocalDate date);

    List<SoilReading> findBetweenDateTimes(LocalDateTime startTime, LocalDateTime endTime);

    List<SoilReading> findBeforeDateTime(LocalDateTime endTime);

    List<SoilReading> findAfterDateTime(LocalDateTime startTime);

    List<SoilReading> findByMinSoilMoisture(double minSoilMoisture);

    List<SoilReading> findByMaxSoilMoisture(double maxSoilMoisture);

    List<SoilReading> findBetweenMoistures(double minSoilMoisture, double maxSoilMoisture);

    void save(SoilReading soilReading);
}
