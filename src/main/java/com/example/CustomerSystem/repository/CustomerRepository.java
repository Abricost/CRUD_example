package com.example.CustomerSystem.repository;

import com.example.CustomerSystem.model.Customer;

import java.sql.SQLException;

/**
 * Repository interface with CRUD function
 * @version 1.0
 */
public interface CustomerRepository {
    Long createCustomer(Customer customer) throws SQLException;

    Customer getCustomerById(long id);

    void editCustomer(Customer customer);

    void deleteCustomer(long id);
}
