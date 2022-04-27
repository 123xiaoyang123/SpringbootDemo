package com.example.mapper;

import com.example.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {

    List<Customer> selectAll() throws Exception;

}
