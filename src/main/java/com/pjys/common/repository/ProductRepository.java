package com.pjys.common.repository;

import com.pjys.common.model.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductDTO, String> {
    List<ProductDTO> findByProductId(String productId);
}
