package com.bej.userauthenticationservice.service;


import com.bej.userauthenticationservice.domain.Customer;
import com.bej.userauthenticationservice.exception.CustomerAlreadyExistsException;
import com.bej.userauthenticationservice.exception.InvalidCredentialsException;

public interface CustomerService {

    Customer saveCustomer(Customer user) throws CustomerAlreadyExistsException;
    //user name and pwd is in db ot not, if not save
    Customer findCustomerByCustomerIdAndPassword(String customerId, String password) throws InvalidCredentialsException;



}
