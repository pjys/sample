package com.pjys.sample.repository;

import com.pjys.sample.model.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductDTO, String> {
    List<ProductDTO> findByProductId(String productId);
}
