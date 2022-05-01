package com.pjys.sample.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "ORDERTABLE")
public class OrderDTO {
    @Id
    private String orderId;
    private String personId;
    private String productId;
    private LocalDate orderDate;
    private String personName;
    private String productName;
}
