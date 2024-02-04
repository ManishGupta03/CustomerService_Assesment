package com.example.sunbase.Service;

import com.example.sunbase.Repository.CustomerRepository;
import com.example.sunbase.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long customerId, Customer updatedCustomer) {
        if (customerRepository.existsById(customerId)) {
            updatedCustomer.setId(customerId);
            return customerRepository.save(updatedCustomer);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Page<Customer> getAllCustomersWithPagination(int page, int size) {
        return customerRepository.findAll(PageRequest.of(page, size));
    }

    public Optional<Customer> getCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    public void loadUserByUsername(String username) {
        return;
    }
}