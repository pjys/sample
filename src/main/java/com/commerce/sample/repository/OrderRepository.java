package com.commerce.sample.repository;

import com.commerce.sample.model.OrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderDTO, String> {
}
