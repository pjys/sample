package com.pjys.sample.service.impl;

import com.pjys.sample.model.OrderDTO;
import com.pjys.sample.model.PersonDTO;
import com.pjys.sample.model.ProductDTO;
import com.pjys.sample.repository.OrderRepository;
import com.pjys.sample.repository.PersonRepository;
import com.pjys.sample.repository.ProductRepository;
import com.pjys.sample.service.CommerceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommerceServiceImpl implements CommerceService {

    private final PersonRepository personRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Override
    public void insertPerson (PersonDTO personDTO) {
        personRepository.save(personDTO);
    }

    @Override
    public void deletePerson (PersonDTO personDTO) {
        personRepository.deleteById(personDTO.getPersonId());
    }

    @Override
    public List<String> allSelectPerson () throws Exception {
        List<String> personNameList = new ArrayList<>();
        List<PersonDTO> personDTOList =  personRepository.findAll();
        if (personDTOList.isEmpty()) {
            throw new Exception("데이터 없음");
        }else {
            for (PersonDTO personDTO : personDTOList) {
                personNameList.add(personDTO.getPersonName());
            }
            return personNameList;
        }
    }

    @Override
    public void insertProduct (ProductDTO productDTO) {
        productRepository.save(productDTO);
    }

    @Override
    public void deleteProduct (ProductDTO productDTO) {
        personRepository.deleteById(productDTO.getProductId());
    }

    @Override
    public List<String> allSelectProduct () throws Exception {
        List<String> productNameList = new ArrayList<>();
        List<ProductDTO> productDTOList =  productRepository.findAll();
        if (productDTOList.isEmpty()) {
            throw new Exception("데이터 없음");
        }else {
            for (ProductDTO productDTO : productDTOList) {
                productNameList.add(productDTO.getProductName());
            }
            return productNameList;
        }
    }

    @Override
    public void insertOrder (OrderDTO orderDTO) throws Exception {
        List<PersonDTO> existPerson = personRepository.findByPersonId(orderDTO.getPersonId());
        if(existPerson.isEmpty()){
            throw new Exception("Person이 존재하지 않음");
        }
        List<ProductDTO> existProduct = productRepository.findByProductId(orderDTO.getProductId());
        if(existProduct.isEmpty()){
            throw new Exception("Product가 존재하지 않음");
        }
        orderRepository.save(OrderDTO.builder()
                .orderId(orderDTO.getOrderId())
                .personId(orderDTO.getPersonId())
                .productId(orderDTO.getProductId())
                .personName(existPerson.get(0).getPersonName())
                .productName(existProduct.get(0).getProductName())
                .orderDate(LocalDate.now())
                .build());
    }

    @Override
    public List<OrderDTO> allSelectOrder () throws Exception {
        List<OrderDTO> orderList = new ArrayList<>();
        List<OrderDTO> orderDTOList =  orderRepository.findAll();
        if (orderDTOList.isEmpty()) {
            throw new Exception("데이터 없음");
        }else {
            for (OrderDTO orderDTO : orderDTOList) {
                orderList.add(new OrderDTO().builder()
                        .personName(orderDTO.getPersonName())
                        .productName(orderDTO.getProductName())
                        .build());
            }
            return orderList;
        }
    }

    @Override
    public void deleteOrder (OrderDTO orderDTO) {

        personRepository.deleteById(orderDTO.getOrderId());
    }
}
