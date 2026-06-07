package com.example.order.entity;

import lombok.Data;

@Data
public class Order {
    private Long id;
    private Long userId;
    private String product;
    private Double price;
}
