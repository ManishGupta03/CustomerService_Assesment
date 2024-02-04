package com.example.sunbase.Controller;

import com.example.sunbase.Service.CustomerService;
import com.example.sunbase.Entity.Customer;
import com.example.sunbase.Service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping("/{customerId}")
    public Customer updateCustomer(@PathVariable Long customerId, @RequestBody Customer updatedCustomer) {
        return customerService.updateCustomer(customerId, updatedCustomer);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/page")
    public Page<Customer> getAllCustomersWithPagination(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "10") int size) {
        return customerService.getAllCustomersWithPagination(page, size);
    }

    @GetMapping("/{customerId}")
    public Optional<Customer> getCustomerById(@PathVariable Long customerId) {
        return customerService.getCustomerById(customerId);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
    }


}