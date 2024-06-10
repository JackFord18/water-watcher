package com.jackfordtech.waterwatcher.soilreading.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SoilReadingDao {
    @Autowired
    private SoilReadingRepository soilReadingRepository;

    public Optional<SoilReading> getReading(int readingId) {
        return soilReadingRepository.findById(readingId);
    }
    public List<SoilReading> getAllReadings() {
        return soilReadingRepository.findAll();
    }

    public List<SoilReading> findBetweenTimestamps(long startTimestamp, long endTimestamp) {
        return soilReadingRepository.findByTimestampBetween(startTimestamp, endTimestamp);
    }

    public List<SoilReading> findBeforeTimestamp(long endTimestamp) {
        return soilReadingRepository.findByTimestampLessThanEqual(endTimestamp);
    }

    public List<SoilReading> findAfterTimestamp(long startTimestamp) {
        return soilReadingRepository.findByTimestampGreaterThanEqual(startTimestamp);
    }

    public List<SoilReading> findByMinSoilMoisture(double minSoilMoisture) {
        return soilReadingRepository.findBySoilMoistureGreaterThanEqual(minSoilMoisture);
    }

    public List<SoilReading> findByMaxSoilMoisture(double maxSoilMoisture) {
        return soilReadingRepository.findBySoilMoistureLessThanEqual(maxSoilMoisture);
    }

    public List<SoilReading> findBetweenMoistures(double minSoilMoisture, double maxSoilMoisture) {
        return soilReadingRepository.findBySoilMoistureBetween(minSoilMoisture, maxSoilMoisture);
    }

    public void save(SoilReading soilReading) {
        soilReadingRepository.save(soilReading);
    }
}