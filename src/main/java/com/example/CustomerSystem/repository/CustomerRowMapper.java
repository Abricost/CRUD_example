package com.example.CustomerSystem.repository;

import com.example.CustomerSystem.model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Mapper class for customer
 */
public class CustomerRowMapper implements RowMapper<Customer> {
    /**
     *
     * @param rs
     * @param rowNum
     * @return customer
     * @throws SQLException
     */
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getLong("id"));
        customer.setName(rs.getString("name"));
        customer.setPhone(rs.getString("phone"));
        customer.setAddress(rs.getString("address"));
        customer.setCreated(rs.getTimestamp("created").toLocalDateTime());
        return customer;
    }
}
