package com.bej.userauthenticationservice.service;


import com.bej.userauthenticationservice.domain.Customer;
import com.bej.userauthenticationservice.exception.UserAlreadyExistsException;
import com.bej.userauthenticationservice.exception.InvalidCredentialsException;

public interface CustomerService {

    Customer saveCustomer(Customer user) throws UserAlreadyExistsException;
    //user name and pwd is in db ot not, if not save
    Customer findCustomerByCustomerIdAndPassword(int customerId, String password) throws InvalidCredentialsException;



}
