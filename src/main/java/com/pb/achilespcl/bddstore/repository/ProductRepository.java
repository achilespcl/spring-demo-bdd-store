package com.pb.achilespcl.bddstore.repository;

import com.pb.achilespcl.bddstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
