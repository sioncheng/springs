package com.github.sioncheng.springs.container;


import org.springframework.stereotype.Component;

@Component("shanghai")
public class ShanghaiAddress extends Address {

    public ShanghaiAddress() {
        this.setCityName("shanghai");
        this.setPinCode(3401238903L);
    }
}
