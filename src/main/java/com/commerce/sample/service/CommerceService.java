package com.commerce.sample.service;

import com.commerce.sample.model.OrderDTO;
import com.commerce.sample.model.PersonDTO;
import com.commerce.sample.model.ProductDTO;

import java.util.List;
import java.util.Map;

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
