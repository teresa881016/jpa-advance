package com.sparta.jpaadvance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, orphanRemoval = true) // orphanRemoval는 CascadeType.REMOVE 기능을 가지고 있다.
    private List<Food> foodList = new ArrayList<>();

    public void addFoodList(Food food) {
        this.foodList.add(food);
        food.setUser(this);//외래키 설정

    }

//    @OneToMany(mappedBy = "user") // 고객 한명 to 음식을 여러번 주문할 수 있다.
//    private List<Order> orderList = new ArrayList<>();
}