package com.jackfordtech.waterwatcher.soilreading.service;

import com.jackfordtech.waterwatcher.soilreading.dao.SoilReading;
import com.jackfordtech.waterwatcher.soilreading.dao.SoilReadingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;

@Service
public class SoilReadingServiceImpl implements SoilReadingService {
    @Autowired
    SoilReadingDao soilReadingDao;

    public List<SoilReading> getAllReadings() {
        return soilReadingDao.getAllReadings();
    }

    public List<SoilReading> findByDate(LocalDate date) {
        ZoneId utcZoneId = ZoneId.of("UTC");
        long startOfDay = date.atStartOfDay(utcZoneId).toInstant().toEpochMilli();
        long endOfDay = date.atTime(23, 59, 59, 999_999_999).atZone(utcZoneId).toInstant().toEpochMilli();

        return soilReadingDao.findBetweenTimestamps(startOfDay, endOfDay);
    }

    public List<SoilReading> findBetweenDateTimes(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        ZoneId utcZoneId = ZoneId.of("UTC");
        long startTimestamp = startDateTime.atZone(utcZoneId).toInstant().toEpochMilli();
        long endTimestamp = endDateTime.atZone(utcZoneId).toInstant().toEpochMilli();

        return soilReadingDao.findBetweenTimestamps(startTimestamp, endTimestamp);
    }

    public List<SoilReading> findBeforeDateTime(LocalDateTime endTime) {
        long endTimestamp = endTime.atZone(ZoneId.of("UTC")).toInstant().toEpochMilli();
        return soilReadingDao.findBeforeTimestamp(endTimestamp);
    }

    public List<SoilReading> findAfterDateTime(LocalDateTime startTime) {
        long startTimestamp = startTime.atZone(ZoneId.of("UTC")).toInstant().toEpochMilli();
        return soilReadingDao.findAfterTimestamp(startTimestamp);
    }

    public List<SoilReading> findBetweenMoistures(double minSoilMoisture, double maxSoilMoisture) {
        return soilReadingDao.findBetweenMoistures(minSoilMoisture, maxSoilMoisture);
    }

    public List<SoilReading> findByMinSoilMoisture(double minSoilMoisture) {
        return soilReadingDao.findByMinSoilMoisture(minSoilMoisture);
    }

    public List<SoilReading> findByMaxSoilMoisture(double maxSoilMoisture) {
        return soilReadingDao.findByMaxSoilMoisture(maxSoilMoisture);
    }

    public void save(SoilReading soilReading) {
        soilReadingDao.save(soilReading);
    }

}