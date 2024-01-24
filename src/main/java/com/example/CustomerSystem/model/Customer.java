package com.example.CustomerSystem.model;

import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Customer description
 * @version 1.0
 */

@Data
public class Customer {
    private long id;
    private String name;
    private String phone;
    private String address;
    private LocalDateTime created;
}
