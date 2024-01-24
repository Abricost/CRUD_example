package com.example.CustomerSystem.service;

import com.example.CustomerSystem.model.Customer;
import com.example.CustomerSystem.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Service layer
 * @version 1.0
 */
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Override
    public Long createCustomer(Customer customer) throws SQLException {
        return customerRepository.createCustomer(customer);
    }

    @Override
    public Customer getCustomerById(long id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public void editCustomer(Customer customer) {
        customerRepository.editCustomer(customer);
    }

    @Override
    public void deleteCustomer(long id) {
        customerRepository.deleteCustomer(id);
    }
}
