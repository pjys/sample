package com.pjys.sample.repository;

import com.pjys.sample.model.OrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderDTO, String> {
}
