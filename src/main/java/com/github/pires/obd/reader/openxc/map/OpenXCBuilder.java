package com.github.pires.obd.reader.openxc.map;

import com.github.pires.obd.commands.ObdCommand;
import com.github.pires.obd.reader.openxc.OpenXCMessage;

import java.util.Date;

public abstract class OpenXCBuilder<T> {

    protected String name;

    public OpenXCBuilder(String name) {
        this.name = name;
    }

    protected abstract T getValue(ObdCommand command);

    public OpenXCMessage<T> build(ObdCommand command, String tripId, String vin) {
        OpenXCMessage<T> message = new OpenXCMessage<>();
        message.setName(name);
        message.setTripId(tripId);
        message.setVin(vin);
        message.setTimestamp(new Date());
        message.setValue(getValue(command));
        return message;
    }
}
