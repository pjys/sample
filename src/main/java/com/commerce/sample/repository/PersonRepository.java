package com.commerce.sample.repository;

import com.commerce.sample.model.PersonDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<PersonDTO, String> {
    List<PersonDTO> findByPersonId(String personId);
}
