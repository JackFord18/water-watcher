package com.jackfordtech.waterwatcher.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SoilReading {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private double soilMoisture;
    private long timestamp;

    public int getId() {
        return id;
    }

    public double getSoilMoisture() {
        return soilMoisture;
    }
    public void setSoilMoisture(double soilMoisture) {
        this.soilMoisture = soilMoisture;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}