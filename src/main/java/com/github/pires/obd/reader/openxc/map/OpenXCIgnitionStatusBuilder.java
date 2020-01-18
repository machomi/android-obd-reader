package com.github.pires.obd.reader.openxc.map;

import com.github.pires.obd.commands.ObdCommand;
import com.github.pires.obd.commands.control.IgnitionMonitorCommand;

public class OpenXCIgnitionStatusBuilder extends OpenXCBuilder<String> {

    public OpenXCIgnitionStatusBuilder() {
        super("ignition_status");
    }

    @Override
    protected String getValue(ObdCommand command) {
        if (command instanceof IgnitionMonitorCommand) {
            return ((IgnitionMonitorCommand)command).isIgnitionOn() ? "run" : "off";
        }
        return null;
    }
}
