package com.example.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/restaurant/{id}")
    public DemoService.Restaurant getRestaurant(@PathVariable Long id) {
        long startTime = System.currentTimeMillis();
        DemoService.Restaurant restaurant = demoService.getRestaurantMenu(id);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
        return restaurant;
    }
}
