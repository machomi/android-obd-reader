package com.github.pires.obd.reader.trips;

/*
vehicle_speed_mean: 0.0,
            engine_speed_mean: 0.0,
            torque_at_transmission_mean: 0.0,
            oil_temp_mean: 0.0,
            accelerator_pedal_position_mean: 0.0,
            brake_mean: 0.0,
            high_speed_duration: 0,
            high_acceleration_event: 0,
            high_braking_event: 0,
            idle_duration: 0,
            start_time: moment()
 */

import java.util.Date;

public class AggregatedTrip {

    // TODO: add proper names with _
    private String tripId;

    private String vin;

    private Double vehicleSpeedMean = 0.0;

    private Double engineSpeedMean = 0.0;

    private Double oilTempMean = 0.0;

    private Double acceleratorPedalPositionMean = 0.0;

    private Double brakeMean = 0.0;

    private Integer highSpeedDuration = 0;

    private Integer highAccelerationDuration = 0;

    private Integer highBreakingEvent = 0;

    private Long idleDuration = 0l;

    private Date startTime;

    private Date timestamp;

    private Double odometer = 0.0;

    private Integer fuelLevel = 0;

    private String name = "aggregated_telemetrics";

    private Double latitude;

    private Double longitude;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AggregatedTrip(String tripId, String vin) {
        this.tripId = tripId;
        this.vin = vin;
    }

    public AggregatedTrip() {

    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Double getVehicleSpeedMean() {
        return vehicleSpeedMean;
    }

    public void setVehicleSpeedMean(Double vehicleSpeedMean) {
        this.vehicleSpeedMean = vehicleSpeedMean;
    }

    public Double getEngineSpeedMean() {
        return engineSpeedMean;
    }

    public void setEngineSpeedMean(Double engineSpeedMean) {
        this.engineSpeedMean = engineSpeedMean;
    }

    public Double getAcceleratorPedalPositionMean() {
        return acceleratorPedalPositionMean;
    }

    public void setAcceleratorPedalPositionMean(Double acceleratorPedalPositionMean) {
        this.acceleratorPedalPositionMean = acceleratorPedalPositionMean;
    }

    public Double getBrakeMean() {
        return brakeMean;
    }

    public void setBrakeMean(Double brakeMean) {
        this.brakeMean = brakeMean;
    }

    public Integer getHighSpeedDuration() {
        return highSpeedDuration;
    }

    public void setHighSpeedDuration(Integer highSpeedDuration) {
        this.highSpeedDuration = highSpeedDuration;
    }

    public Integer getHighAccelerationDuration() {
        return highAccelerationDuration;
    }

    public void setHighAccelerationDuration(Integer highAccelerationDuration) {
        this.highAccelerationDuration = highAccelerationDuration;
    }

    public Integer getHighBreakingEvent() {
        return highBreakingEvent;
    }

    public void setHighBreakingEvent(Integer highBreakingEvent) {
        this.highBreakingEvent = highBreakingEvent;
    }

    public Long getIdleDuration() {
        return idleDuration;
    }

    public void setIdleDuration(Long idleDuration) {
        this.idleDuration = idleDuration;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Double getOdometer() {
        return odometer;
    }

    public void setOdometer(Double odometer) {
        this.odometer = odometer;
    }

    public Integer getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(Integer fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public Double getOilTempMean() {
        return oilTempMean;
    }

    public void setOilTempMean(Double oilTempMean) {
        this.oilTempMean = oilTempMean;
    }
}
