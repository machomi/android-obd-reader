package com.github.pires.obd.reader.cloud;

import android.os.AsyncTask;

import com.amazonaws.mobileconnectors.iot.AWSIotMqttManager;
import com.amazonaws.mobileconnectors.iot.AWSIotMqttQos;
import com.github.pires.obd.reader.openxc.OpenXCMessage;
import com.google.gson.Gson;

public class AwsUploadOpenXCMessageTask extends AsyncTask<OpenXCMessage, Void, Void> {

    private static final String TELEMETRY_TOPIC = "connectedcar/telemetry/";

    private AWSIotMqttManager mqttManager;

    private Gson gson;

    public AwsUploadOpenXCMessageTask(AWSIotMqttManager mqttManager, Gson gson) {
        this.mqttManager = mqttManager;
        this.gson = gson;
    }

    @Override
    protected Void doInBackground(OpenXCMessage... openXCMessages) {

        for (OpenXCMessage message : openXCMessages) {
//            Log.d("AWS", "Sending message " + gson.toJson(message) + " to topic " + TELEMETRY_TOPIC + message.getVin());
            mqttManager.publishString(gson.toJson(message), TELEMETRY_TOPIC + message.getVin(), AWSIotMqttQos.QOS0);
        }
        return null;
    }
}
