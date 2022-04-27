package com.example.service;

import com.example.mapper.CustomerMapper;
import com.example.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    public List<Customer> selectAll() throws Exception{
        return customerMapper.selectAll();
    }

}
