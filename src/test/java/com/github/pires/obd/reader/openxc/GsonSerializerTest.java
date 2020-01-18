package com.github.pires.obd.reader.openxc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class GsonSerializerTest {

    private static final String DOUBLE_EXPECTED = "{\"timestamp\":\"2019-10-23 16:41:52.426\",\"trip_id\":\"c5a09cff-449c-45c8-8289-14b296b87d6a\",\"vin\":\"PGY0UZC3RKE8CE4XF\",\"name\":\"odometer\",\"value\":0.1117}";

    private static final String INTEGER_EXPECTED = "{\"timestamp\":\"2019-10-23 16:41:52.426\",\"trip_id\":\"c5a09cff-449c-45c8-8289-14b296b87d6a\",\"vin\":\"PGY0UZC3RKE8CE4XF\",\"name\":\"steering_wheel_angle\",\"value\":87}";

    private static final String STRING_EXPECTED = "{\"timestamp\":\"2019-10-23 16:41:52.426\",\"trip_id\":\"c5a09cff-449c-45c8-8289-14b296b87d6a\",\"vin\":\"PGY0UZC3RKE8CE4XF\",\"name\":\"ignition_status\",\"value\":\"run\"}";

    private static final String BOOLEAN_EXPECTED = "{\"timestamp\":\"2019-10-23 16:41:52.426\",\"trip_id\":\"c5a09cff-449c-45c8-8289-14b296b87d6a\",\"vin\":\"PGY0UZC3RKE8CE4XF\",\"name\":\"brake_pedal_status\",\"value\":false}";

    @Test
    public void serializeDoubleTest() throws ParseException {

        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2019-10-23 16:41:52.426");

        OpenXCMessage<Double> message = new OpenXCMessage<>(date, "c5a09cff-449c-45c8-8289-14b296b87d6a", "PGY0UZC3RKE8CE4XF", "odometer", 0.1117);

        String json = GsonSerializer.build().toJson(message);

        assertEquals(DOUBLE_EXPECTED, json);
    }

    @Test
    public void serializeIntegerTest() throws ParseException {

        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2019-10-23 16:41:52.426");

        OpenXCMessage<Integer> message = new OpenXCMessage<>(date, "c5a09cff-449c-45c8-8289-14b296b87d6a", "PGY0UZC3RKE8CE4XF", "steering_wheel_angle", 87);

        String json = GsonSerializer.build().toJson(message);

        assertEquals(INTEGER_EXPECTED, json);
    }

    @Test
    public void serializeStringTest() throws ParseException {

        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2019-10-23 16:41:52.426");

        OpenXCMessage<String> message = new OpenXCMessage<>(date, "c5a09cff-449c-45c8-8289-14b296b87d6a", "PGY0UZC3RKE8CE4XF", "ignition_status", "run");

        String json = GsonSerializer.build().toJson(message);

        assertEquals(STRING_EXPECTED, json);
    }

    @Test
    public void serializeBooleanTest() throws ParseException {

        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2019-10-23 16:41:52.426");

        OpenXCMessage<Boolean> message = new OpenXCMessage<>(date, "c5a09cff-449c-45c8-8289-14b296b87d6a", "PGY0UZC3RKE8CE4XF", "brake_pedal_status", false);

        String json = GsonSerializer.build().toJson(message);

        assertEquals(BOOLEAN_EXPECTED, json);
    }

}