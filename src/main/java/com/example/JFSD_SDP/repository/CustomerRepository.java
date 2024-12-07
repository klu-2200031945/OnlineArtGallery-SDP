package com.example.JFSD_SDP.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.JFSD_SDP.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	 Customer findByEmailAndPassword(String email, String password);

}
