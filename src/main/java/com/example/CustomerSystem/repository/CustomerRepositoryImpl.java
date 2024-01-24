package com.example.CustomerSystem.repository;

import com.example.CustomerSystem.model.Customer;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Class that implements CRUD functions with custom request
 * @version 1.0
 */
@Repository
@AllArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository{

    /**
     * @see DbConfig
     */
    private final NamedParameterJdbcTemplate template;

    /**
     * Method create new customer
     * @param customer
     * @return id
     */
    @Override
    public Long createCustomer(Customer customer) {
        String sql = "INSERT INTO customer(name, phone, address) VALUES(:name, :phone, :address) RETURNING ID";
        Map<String, Object> map = new HashMap<>();
        map.put("name", customer.getName());
        map.put("phone", customer.getPhone());
        map.put("address", customer.getAddress());
        return template.queryForObject(sql, map, Long.class);
    }

    /**
     * Method get customer by id
     * @param id
     * @return customer
     */
    @Override
    public Customer getCustomerById(long id) {
        String sql = "SELECT id, name, phone, address, created FROM customer WHERE id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        return template.queryForObject(sql, parameterSource, new CustomerRowMapper());
    }

    /**
     * Method edit customer
     * @param customer
     */
    @Override
    public void editCustomer(Customer customer) {
        String sql = "UPDATE customer SET name = :name, address = :address, phone = :phone WHERE id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", customer.getId())
                .addValue("name", customer.getName())
                .addValue("phone", customer.getPhone())
                .addValue("address", customer.getAddress());
        template.update(sql, parameterSource);
    }

    /**
     * Method delete customer by id
     * @param id
     */
    @Override
    public void deleteCustomer(long id) {
        String sql = "DELETE FROM customer WHERE id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        template.update(sql, parameterSource);
    }
}
