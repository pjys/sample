package com.pjys.history.repository;

import com.pjys.history.model.HistoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistroyRepository extends JpaRepository<HistoryDTO, String> {
}
