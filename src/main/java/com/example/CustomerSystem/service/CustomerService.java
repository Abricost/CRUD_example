package com.example.CustomerSystem.service;

import com.example.CustomerSystem.model.Customer;

import java.sql.SQLException;

public interface CustomerService {
    Long createCustomer(Customer customer) throws SQLException;

    Customer getCustomerById(long id);

    void editCustomer(Customer customer);

    void deleteCustomer(long id);
}
