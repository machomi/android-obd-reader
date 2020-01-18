package com.github.pires.obd.reader.openxc.map;

import com.github.pires.obd.commands.ObdCommand;

public class OpenXCDoubleBuilder extends OpenXCBuilder<Double> {

    public OpenXCDoubleBuilder(String name) {
        super(name);
    }

    @Override
    protected Double getValue(ObdCommand command) {
        return Double.valueOf(command.getFormattedResult().replaceAll("[^0-9.]+",""));
    }
}
