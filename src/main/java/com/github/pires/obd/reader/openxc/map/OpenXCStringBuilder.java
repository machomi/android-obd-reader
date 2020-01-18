package com.github.pires.obd.reader.openxc.map;

import com.github.pires.obd.commands.ObdCommand;

public class OpenXCStringBuilder extends OpenXCBuilder<String> {

    public OpenXCStringBuilder(String name) {
        super(name);
    }

    @Override
    protected String getValue(ObdCommand command) {
        return command.getFormattedResult();
    }
}
