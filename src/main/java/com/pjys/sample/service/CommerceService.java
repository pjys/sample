package com.pjys.sample.service;

import com.pjys.sample.model.OrderDTO;
import com.pjys.sample.model.PersonDTO;
import com.pjys.sample.model.ProductDTO;

import java.util.List;

public interface CommerceService {
    void insertPerson(PersonDTO personDTO);

    void deletePerson(PersonDTO personDTO);

    List<String> allSelectPerson() throws Exception;

    void insertProduct(ProductDTO productDTO);

    void deleteProduct(ProductDTO productDTO);

    List<String> allSelectProduct() throws Exception;

    void insertOrder(OrderDTO orderDTO) throws Exception;

    List<OrderDTO> allSelectOrder() throws Exception;

    void deleteOrder(OrderDTO orderDTO);
}
