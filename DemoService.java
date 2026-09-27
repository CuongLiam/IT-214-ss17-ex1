package com.example.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DemoService {

    // Cache kết quả của method này với tên cache là "restaurants", key là restaurantId
    @Cacheable(value = "restaurants", key = "#restaurantId")
    public Restaurant getRestaurantMenu(Long restaurantId) {
        System.out.println("Fetching data from database for restaurantId: " + restaurantId);
        // Giả lập gọi database
        return new Restaurant(restaurantId, "Nhà hàng " + restaurantId, Arrays.asList("Phở", "Bún chả", "Nem rán"));
    }

    // DTO class
    public static class Restaurant {
        private Long id;
        private String name;
        private List<String> menu;

        public Restaurant() {} // Jackson cần constructor rỗng

        public Restaurant(Long id, String name, List<String> menu) {
            this.id = id;
            this.name = name;
            this.menu = menu;
        }

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public List<String> getMenu() { return menu; }
        public void setMenu(List<String> menu) { this.menu = menu; }
    }
}
