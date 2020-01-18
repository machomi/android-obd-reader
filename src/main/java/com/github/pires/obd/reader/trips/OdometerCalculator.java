package com.github.pires.obd.reader.trips;

import com.github.pires.obd.reader.openxc.OpenXCMessage;

import java.util.Date;

public class OdometerCalculator {

    private long start;

    private double value;

    public void start() {
        start = System.currentTimeMillis();
        value = 0.0;
    }

    public OpenXCMessage<Double> calculate(OpenXCMessage<Double> speed, String tripId, String vin) {
        long current = System.currentTimeMillis();
        long delta = current - start / 1000;
        value += speed.getValue() * delta / 3600;
        OpenXCMessage<Double> message = new OpenXCMessage<>();
        message.setName("odometer");
        message.setValue(value);
        message.setTimestamp(new Date());
        message.setVin(vin);
        message.setTripId(tripId);
        return message;
    }
}
