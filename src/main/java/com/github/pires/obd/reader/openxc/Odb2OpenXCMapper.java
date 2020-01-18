package com.github.pires.obd.reader.openxc;

import com.github.pires.obd.commands.ObdCommand;
import com.github.pires.obd.enums.AvailableCommandNames;
import com.github.pires.obd.reader.openxc.map.OpenXCBuilder;
import com.github.pires.obd.reader.openxc.map.OpenXCDoubleBuilder;
import com.github.pires.obd.reader.openxc.map.OpenXCIgnitionStatusBuilder;
import com.github.pires.obd.reader.openxc.map.OpenXCIntegerBuilder;

import java.util.HashMap;
import java.util.Map;

public class Odb2OpenXCMapper {

    private static Map<String, OpenXCBuilder> map = new HashMap<String, OpenXCBuilder>(){{
        put(AvailableCommandNames.SPEED.getValue(), new OpenXCDoubleBuilder("vehicle_speed"));
        put(AvailableCommandNames.ENGINE_RPM.getValue(), new OpenXCIntegerBuilder("engine_speed"));
        put(AvailableCommandNames.IGNITION_MONITOR.getValue(), new OpenXCIgnitionStatusBuilder());
        put(AvailableCommandNames.FUEL_LEVEL.getValue(), new OpenXCIntegerBuilder("fuel_level"));
        put(AvailableCommandNames.ENGINE_OIL_TEMP.getValue(), new OpenXCIntegerBuilder("oil_temp"));
        // odometer
        // fuel_consumed_since_restart
        // brake
        // transmission_gear_position
        // brake_pedal_status
        // parking_brake_status
        // steering_wheel_angle
        // gear_lever_position
        // torque_at_transmission
        // acceleration
        // accelerator_pedal_position
    }};

    public static OpenXCMessage map(ObdCommand command, String tripId, String vin) {
        OpenXCBuilder builder = map.get(command.getName());
        if (builder != null) {
            return builder.build(command, tripId, vin);
        }
        return null;
    }
}
