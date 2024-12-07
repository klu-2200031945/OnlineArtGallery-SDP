package com.example.JFSD_SDP.repository;

import com.example.JFSD_SDP.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
	 Seller findByEmailAndPassword(String email, String password);
}
