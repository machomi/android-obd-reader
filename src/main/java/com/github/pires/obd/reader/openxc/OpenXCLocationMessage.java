package com.github.pires.obd.reader.openxc;

import java.util.Date;

public class OpenXCLocationMessage extends OpenXCMessage {

    private Double latitude;

    private Double longitude;

    public OpenXCLocationMessage(String tripId, String vin, Double latitude, Double longitude) {
        this.timestamp = new Date();
        this.name = "location";
        this.vin = vin;
        this.tripId = tripId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
