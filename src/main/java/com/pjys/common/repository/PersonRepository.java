package com.pjys.sample.repository;

import com.pjys.sample.model.PersonDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<PersonDTO, String> {
    List<PersonDTO> findByPersonId(String personId);
}
