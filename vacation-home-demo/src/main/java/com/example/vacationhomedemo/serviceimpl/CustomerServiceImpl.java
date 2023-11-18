package com.example.vacationhomedemo.serviceimpl;

import com.example.vacationhomedemo.model.Customer;
import com.example.vacationhomedemo.repository.CustomerRepository;
import com.example.vacationhomedemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl (CustomerRepository theCustomerRepository) { customerRepository = theCustomerRepository; }

    @Override
    public List<Customer> findAll() { return customerRepository.findAllByOrderByLastNameAsc(); }

    @Override
    public Customer findById(int theId) {
        Optional<Customer> result = customerRepository.findById(theId);

        Customer theCustomer = null;

        if (result.isPresent()) {
            theCustomer = result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theCustomer;
    }

    @Override
    public Customer save(Customer theCustomer) {return customerRepository.save(theCustomer); }

    @Override
    public void deleteById(int theId) { customerRepository.deleteById(theId); }


}
