package com.github.pires.obd.reader.openxc.map;

import com.github.pires.obd.commands.ObdCommand;

public class OpenXCIntegerBuilder extends OpenXCBuilder<Integer> {

    public OpenXCIntegerBuilder(String name) {
        super(name);
    }

    @Override
    protected Integer getValue(ObdCommand command) {
        return Integer.valueOf(command.getFormattedResult().replaceAll("\\D+",""));
    }
}
