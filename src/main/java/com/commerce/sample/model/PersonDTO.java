package com.commerce.sample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "PERSON")
public class PersonDTO {
    @Id
    private String personId;
    private String personName;
    private String personBirth;
    private Character personGender;
}
