package com.github.pires.obd.reader.trips;

import android.util.Log;

import com.github.pires.obd.reader.openxc.OpenXCLocationMessage;
import com.github.pires.obd.reader.openxc.OpenXCMessage;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TripAggragator {

    private Map<String, Long> counters;

    private AggregatedTrip trip;

    public TripAggragator(AggregatedTrip trip) {
        this.trip = trip;
        counters = new HashMap<>();
    }

    public void update(OpenXCMessage message) {

        try {

            trip.setVin(message.getVin());
            trip.setTripId(message.getTripId());
            if (message.getName().equals("location")) {
                OpenXCLocationMessage lMessage = (OpenXCLocationMessage) message;
                trip.setLatitude(lMessage.getLatitude());
                trip.setLongitude(lMessage.getLongitude());
            }

            if (message.getName().equals("vehicle_speed")) {
                long counter = getCounter("vehicle_speed");
                trip.setVehicleSpeedMean(
                        getMean(trip.getVehicleSpeedMean(), (double) message.getValue(), counter));
                counters.put("vehicle_speed", counter + 1);
            }

            if (message.getName().equals("engine_speed")) {
                long counter = getCounter("engine_speed");
                trip.setEngineSpeedMean(
                        getMean(trip.getEngineSpeedMean(), new Double(String.valueOf(message.getValue())), counter));
                counters.put("engine_speed", counter + 1);
            }

            if (message.getName().equals("oil_temp")) {
                long counter = getCounter("oil_temp");
                trip.setOilTempMean(
                        getMean(trip.getOilTempMean(), new Double(String.valueOf(message.getValue())), counter));
                counters.put("oil_temp", counter + 1);
            }

            if (message.getName().equals("odometer")) {
                trip.setOdometer((double) message.getValue());
            }

            if (message.getName().equals("fuel_level")) {
                trip.setFuelLevel((int) message.getValue());
            }
        } catch (Exception e) {
            Log.e("TRIP", e.getMessage());
        }

    }

    private long getCounter(String name) {
        return counters.containsKey(name) ? counters.get(name) : 0l;
    }

    private double getMean(double prevAvg, double newVal, long counter) {
        return (prevAvg * counter + newVal) / (counter + 1);
    }

    public AggregatedTrip getTrip() {
        return trip;
    }

    public AggregatedTrip endTrip() {
        trip.setTimestamp(new Date());
        return trip;
    }

}
