package com.example.aop2;

import com.example.aop2.config.DemoConfig;
import com.example.aop2.service.TrafficService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Around_demo {
    public static void main(String[] args) {

        // read Spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficService trafficService = context.getBean("trafficService", TrafficService.class);

        System.out.println("\nMain Program: Around_demo");
        System.out.println("Calling getTraffic");

        String data = trafficService.getTraffic();
        System.out.println("\nMy traffic is: " + data);
        System.out.println("Finished");

        context.close();
    }
}
