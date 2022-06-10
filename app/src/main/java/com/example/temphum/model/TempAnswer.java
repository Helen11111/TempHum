package com.example.temphum.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TempAnswer {
    @SerializedName("temperature")
    @Expose
    private float temp;
    @SerializedName("humidity")
    @Expose
    private float hum;

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public void setHum(float hum) {
        this.hum = hum;
    }

    public float getTemp() {
        return temp;
    }

    public float getHum() {
        return hum;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
