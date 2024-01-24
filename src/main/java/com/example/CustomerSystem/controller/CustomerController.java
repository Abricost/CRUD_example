package com.example.CustomerSystem.controller;

import com.example.CustomerSystem.model.Customer;
import com.example.CustomerSystem.repository.CustomerRepositoryImpl;
import com.example.CustomerSystem.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * Controller contains processing of 4 endpoints
 * @version 1.0
 */

@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    /**
     * Method processes POST request to create a customer
     * <p>
     * Example URL: http://localhost:8080
     * <p>
     * Json body:
     * {
     *     "name": "Tom",
     *     "phone": "123456789",
     *     "address": "Toms address"
     * }
     * @param customer
     * @return id
     * @throws SQLException
     */
    @PostMapping
    public Long createCustomer(@RequestBody Customer customer) throws SQLException {
        return customerService.createCustomer(customer);
    }

    /**
     * Method processes GET request to get a customer
     * <p>
     * Example URL: http://localhost:8080?id=1
     * @param id
     * @return customer
     */
    @GetMapping
    public Customer getCustomerById(@RequestParam long id) {
        return customerService.getCustomerById(id);
    }

    /**
     * Method processes PUT request to edit a customer
     * <p>
     * Example URL: http://localhost:8080
     * <p>
     * Json body:
     * {
     *     "id": 1,
     *     "name": "NewTom",
     *     "phone": "123456789",
     *     "address": "NewToms address"
     * }
     * @param customer
     */
    @PutMapping
    public void editCustomer(@RequestBody Customer customer) {
        customerService.editCustomer(customer);
    }

    /**
     * Method processes DELETE request to delete a customer
     * <p>
     * Example URL: localhost:8080?id=1
     * @param id
     */
    @DeleteMapping
    public void deleteCustomer(@RequestParam long id) {
        customerService.deleteCustomer(id);
    }
}
