package com.jackfordtech.waterwatcher.controller;

import com.jackfordtech.waterwatcher.dao.SoilReading;
import com.jackfordtech.waterwatcher.service.SoilReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class WaterWatcherController {
    @Autowired
    SoilReadingService soilReadingService;
    @PostMapping("/moisturereadings")
    public void saveSoilReading(@RequestParam("moisture") Double moisture){
        SoilReading soilReading = new SoilReading();
        soilReading.setTimestamp(System.currentTimeMillis());
        soilReading.setSoilMoisture(moisture);

        soilReadingService.save(soilReading);

    }

    @GetMapping("/moisturereadings")
    public List<SoilReading> getSoilReadings(@RequestParam(name="date", required = false) LocalDate date,
                                             @RequestParam(name="starttime", required = false) LocalDateTime startDateTime,
                                             @RequestParam(name="endtime", required = false) LocalDateTime endDateTime,
                                             @RequestParam(name="minmoisture", required = false) Double minmoisture,
                                             @RequestParam(name="maxmoisture", required = false) Double maxmoisture){
        if (date != null){
            return soilReadingService.findByDate(date);
        } else if(startDateTime != null && endDateTime != null){
            return soilReadingService.findBetweenDateTimes(startDateTime, endDateTime);
        } else if (startDateTime != null){
            return soilReadingService.findAfterDateTime(startDateTime);
        } else if (endDateTime != null){
            return soilReadingService.findBeforeDateTime(endDateTime);
        } else if (minmoisture != null && maxmoisture != null) {
            return soilReadingService.findBetweenMoistures(minmoisture, maxmoisture);
        } else if (minmoisture != null){
            return soilReadingService.findByMinSoilMoisture(minmoisture);
        } else if (maxmoisture != null){
            return soilReadingService.findByMaxSoilMoisture(maxmoisture);
        } else {
            return soilReadingService.getAllReadings();
        }
    }
}