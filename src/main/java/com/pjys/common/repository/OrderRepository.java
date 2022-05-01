package com.pjys.common.repository;

import com.pjys.common.model.OrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderDTO, String> {
}
