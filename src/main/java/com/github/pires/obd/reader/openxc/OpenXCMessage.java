package com.github.pires.obd.reader.openxc;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class OpenXCMessage<T> {

    protected Date timestamp;

    @SerializedName("trip_id")
    protected String tripId;

    protected String vin;

    protected String name;

    protected T value;

    public OpenXCMessage(Date timestamp, String tripId, String vin, String name, T value) {
        this.timestamp = timestamp;
        this.tripId = tripId;
        this.vin = vin;
        this.name = name;
        this.value = value;
    }

    public OpenXCMessage() {
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
