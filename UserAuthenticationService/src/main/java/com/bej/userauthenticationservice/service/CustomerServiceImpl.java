package com.bej.userauthenticationservice.service;


import com.bej.userauthenticationservice.domain.Customer;
import com.bej.userauthenticationservice.exception.UserAlreadyExistsException;
import com.bej.userauthenticationservice.repository.CustomerRepository;
import com.bej.userauthenticationservice.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

private CustomerRepository userRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public Customer saveCustomer(Customer user) throws UserAlreadyExistsException {
        if(userRepository.findById(user.getCustomerId()).isPresent())
        {
            throw new UserAlreadyExistsException();
        }
        System.out.println(user);
        return userRepository.save(user);
    }

    @Override
    public Customer findCustomerByCustomerIdAndPassword(int customerId, String password) throws InvalidCredentialsException {
        System.out.println("email"+customerId);
        System.out.println("password"+password);
        Customer loggedInUser = userRepository.findCustomerByCustomerIdAndPassword(customerId,password);
        System.out.println(loggedInUser);
        if(loggedInUser == null)
        {
            throw new InvalidCredentialsException();
        }

        return loggedInUser;
    }
}
