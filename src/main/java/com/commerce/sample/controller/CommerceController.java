package com.commerce.sample.controller;

import com.commerce.sample.model.OrderDTO;
import com.commerce.sample.model.PersonDTO;
import com.commerce.sample.model.ProductDTO;
import com.commerce.sample.service.CommerceService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CommerceController {

    @Autowired
    CommerceService commerceService;

    @ApiOperation(value = "인원 추가")
    @PostMapping("/insert/person")
    public ResponseEntity<String> insertPerson(@RequestBody PersonDTO personDTO) throws Exception {
        if (ObjectUtils.isEmpty(personDTO)) {
            throw new Exception("파라미터 오류123");
        }else{
            commerceService.insertPerson(personDTO);
            return ResponseEntity.ok("인원 추가 완료");
        }

    }

    @ApiOperation(value = "인원 삭제")
    @PostMapping("/delete/person")
    public ResponseEntity<String> deletePerson(@RequestBody PersonDTO personDTO) throws Exception {
        if (ObjectUtils.isEmpty(personDTO)) {
            throw new Exception("파라미터 오류");
        }else{
            commerceService.deletePerson(personDTO);
            return ResponseEntity.ok("인원 삭제 완료");
        }

    }

    @ApiOperation(value = "인원 조회")
    @GetMapping("/all/select/person")
    public ResponseEntity<List<String>> allSelectPerson () throws Exception {
        return ResponseEntity.ok(commerceService.allSelectPerson());
    }

    @ApiOperation(value = "상품 추가")
    @PostMapping("/insert/product")
    public ResponseEntity<String> insertProduct(ProductDTO productDTO) throws Exception {
        if (ObjectUtils.isEmpty(productDTO)) {
            throw new Exception("파라미터 오류");
        }else{
            commerceService.insertProduct(productDTO);
            return ResponseEntity.ok("제품 추가 완료");
        }
    }

    @ApiOperation(value = "상품 삭제")
    @PostMapping("/delete/product")
    public ResponseEntity<String> deleteProduct(@RequestBody ProductDTO productDTO) throws Exception {
        if (ObjectUtils.isEmpty(productDTO)) {
            throw new Exception("파라미터 오류");
        }else{
            commerceService.deleteProduct(productDTO);
            return ResponseEntity.ok("상품 삭제 완료");
        }
    }

    @ApiOperation(value = "상품 조회")
    @GetMapping("/all/select/product")
    public ResponseEntity<List<String>> allSelectProduct () throws Exception {
        return ResponseEntity.ok(commerceService.allSelectProduct());
    }

    @ApiOperation(value = "주문 추가")
    @PostMapping("/insert/order")
    public ResponseEntity<String> insertOrder(@RequestBody OrderDTO orderDTO) throws Exception {
        if (ObjectUtils.isEmpty(orderDTO)) {
            throw new Exception("파라미터 오류");
        }else{
            commerceService.insertOrder(orderDTO);
            return ResponseEntity.ok("주문 추가 완료");
        }

    }

    @ApiOperation(value = "주문 삭제")
    @PostMapping("/delete/order")
    public ResponseEntity<String> deleteOrder(@RequestBody OrderDTO orderDTO) throws Exception {
        if (ObjectUtils.isEmpty(orderDTO)) {
            throw new Exception("파라미터 오류");
        }else{
            commerceService.deleteOrder(orderDTO);
            return ResponseEntity.ok("주문 삭제 완료");
        }
    }

    @ApiOperation(value = "주문 조회")
    @GetMapping("/all/select/order")
    public ResponseEntity<List<OrderDTO>> allSelectOrder() throws Exception {
        return ResponseEntity.ok(commerceService.allSelectOrder());
    }

}
