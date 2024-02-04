package com.example.sunbase.Repository;

import com.example.sunbase.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByName(String username);
    // Add custom query methods if needed, e.g., findByEmail, findByNameContaining, etc.
}
