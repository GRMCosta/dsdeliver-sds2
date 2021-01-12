package com.devsuperior.dsdeliver.repositories;

import com.devsuperior.dsdeliver.entities.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  List<Product> findAllByOrderByNameAsc();

}