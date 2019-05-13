package com.github.sioncheng.springs.container;

public class Address {

    private String cityName;
    private long pinCode;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public long getPinCode() {
        return pinCode;
    }

    public void setPinCode(long pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return String.format("%s    %d", cityName, pinCode);
    }
}
