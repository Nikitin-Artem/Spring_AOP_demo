package com.example.aop2.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficService {
    // using for simulate @Around advice
    public String getTraffic(){

        // simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Expect heavy traffic";
    }

    // using for simulate @Around advice in AroundHandleException
    public String getTraffic(boolean tripWipe) {

        if(tripWipe){
            throw new RuntimeException("Major accident! Highway is closed");
        }

        return getTraffic();
    }
}
