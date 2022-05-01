package com.pjys.common.repository;

import com.pjys.common.model.PersonDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<PersonDTO, String> {
    List<PersonDTO> findByPersonId(String personId);
}
