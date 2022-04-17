package com.commerce.sample.service.impl;

import com.commerce.sample.model.OrderDTO;
import com.commerce.sample.model.PersonDTO;
import com.commerce.sample.model.ProductDTO;
import com.commerce.sample.repository.OrderRepository;
import com.commerce.sample.repository.PersonRepository;
import com.commerce.sample.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
class CommerceServiceImplTest {

    @Spy
    @InjectMocks
    private CommerceServiceImpl commerceService;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private OrderRepository orderRepository;

    @Test
    @DisplayName("인원 추가 TEST")
    void InsertPersonTest() {
        when(personRepository.save(any())).thenReturn(PersonDTO.builder().personId("1").personName("김길동").build());
        commerceService.insertPerson(PersonDTO.builder().personId("1").personName("김길동").build());
        verify(personRepository, times(1)).save(any());
        verify(personRepository, atLeast(1)).save(any());
        verify(personRepository, atMost(1)).save(any());
    }

    @Test
    @DisplayName("인원 추가 Exception")
    void InsertPersonException() {
        when(personRepository.save(any())).thenThrow();
        assertThrows(Exception.class, () -> {
            commerceService.insertPerson(null);;
            verify(personRepository, times(1)).save(any());
        });

        when(personRepository.save(any())).thenThrow();
        assertThrows(Exception.class, () -> {
            commerceService.insertPerson(PersonDTO.builder().build());
            verify(personRepository, times(1)).save(any());
        });
    }

    @Test
    @DisplayName("인원 삭제 TEST")
    void deletePersonTest() {
        commerceService.deletePerson(PersonDTO.builder().personId("1").personName("김길동").build());
        verify(personRepository, times(1)).deleteById(any());
        verify(personRepository, atLeast(1)).deleteById(anyString());
        verify(personRepository, atMost(1)).deleteById(anyString());
    }

    @Test
    @DisplayName("인원 삭제 Exception")
    void deletePersonException() {
        commerceService.deletePerson(PersonDTO.builder().build());
        verify(personRepository, never()).deleteById(any());

        commerceService.deletePerson(null);
        verify(personRepository, never()).deleteById(any());
    }

    @Test
    @DisplayName("인원 조회 TEST")
    void allSelectPersonTest() throws Exception {
        when(personRepository.findAll()).thenReturn(new ArrayList<>(){
            {
                add(PersonDTO.builder().personId("1").personName("김길동").build());
                add(PersonDTO.builder().personId("2").personName("이길동").build());
                add(PersonDTO.builder().personId("3").personName("최길동").build());
            }
        });
        List<String> personNameList = commerceService.allSelectPerson();
        assertEquals(personNameList.get(0), "김길동");
        assertSame(personNameList.get(1), "이길동");
        assertNotNull(personNameList.get(0));
    }

    @Test
    @DisplayName("인원 조회 Exception")
    void allSelectPersonException() throws Exception {
        when(personRepository.findAll()).thenReturn(null);
        assertThrows(Exception.class, () -> {
            List<String> personNameList = commerceService.allSelectPerson();
            assertNull(personNameList);
        });

        when(personRepository.findAll()).thenThrow();
        assertThrows(Exception.class, () -> {
            List<String> personNameList = commerceService.allSelectPerson();
            assertNull(personNameList);
        });
    }

    @Test
    @DisplayName("상품 추가 TEST")
    void insertProductTest() {
        when(productRepository.save(any())).thenReturn(ProductDTO.builder().productId("1").build());
        commerceService.insertProduct(ProductDTO.builder().productId("1").productName("컴퓨터").build());
        verify(productRepository, times(1)).save(any());
        verify(productRepository, atLeast(1)).save(any());
        verify(productRepository, atMost(1)).save(any());
    }

    @Test
    @DisplayName("상품 추가 Exception")
    void insertProductException() {
        when(productRepository.save(any())).thenThrow();
        assertThrows(Exception.class, () -> {
            commerceService.insertProduct(null);;
            verify(productRepository, times(1)).save(any());
        });

        when(productRepository.save(any())).thenThrow();
        assertThrows(Exception.class, () -> {
            commerceService.insertProduct(ProductDTO.builder().build());
            verify(productRepository, times(1)).save(any());
        });
    }

    @Test
    @DisplayName("상품 삭제 TEST")
    void deleteProductTest() {
        commerceService.deleteProduct(ProductDTO.builder().productId("1").productName("컴퓨터").build());
        verify(productRepository, times(0)).deleteById(any());
        verify(productRepository, atLeast(0)).deleteById(any());
        verify(productRepository, atMost(0)).deleteById(any());
    }

    @Test
    @DisplayName("상품 삭제 Exception")
    void deleteProductException() {
        commerceService.deleteProduct(ProductDTO.builder().build());
        verify(personRepository, never()).deleteById(anyString());
    }

    @Test
    @DisplayName("상품 조회 TEST")
    void allSelectProductTest() throws Exception {
        when(productRepository.findAll()).thenReturn(new ArrayList<>(){
            {
                add(ProductDTO.builder().productId("1").productName("컴퓨터").build());
                add(ProductDTO.builder().productId("2").productName("신발").build());
                add(ProductDTO.builder().productId("3").productName("옷").build());
            }
        });
        List<String> productNameList = commerceService.allSelectProduct();
        assertEquals(productNameList.get(0), "컴퓨터");
        assertSame(productNameList.get(1), "신발");
        assertNotNull(productNameList.get(0));
    }

    @Test
    @DisplayName("상품 조회 Exception")
    void allSelectProductException() {
        when(productRepository.findAll()).thenReturn(null);
        assertThrows(Exception.class, () -> {
            List<String> productNameList = commerceService.allSelectProduct();
            assertNull(productNameList);
        });

        when(productRepository.findAll()).thenThrow();
        assertThrows(Exception.class, () -> {
            List<String> productNameList = commerceService.allSelectProduct();
            assertNull(productNameList);
        });
    }

    @Test
    @DisplayName("주문 추가 TEST")
    void insertOrder() throws Exception {
        when(personRepository.findByPersonId(any())).thenReturn(new ArrayList<>(){
            {
                add(PersonDTO.builder().personId("1").personName("김길동").build());
            }
        });
        when(productRepository.findByProductId(any())).thenReturn(new ArrayList<>(){
            {
                add(ProductDTO.builder().productId("1").productName("컴퓨터").build());
            }
        });
        when(orderRepository.save(any())).thenReturn(OrderDTO.builder()
                .orderId(anyString())
                .personId(anyString())
                .productId(anyString())
                .personName(anyString())
                .productName(anyString())
                .orderDate(LocalDate.now())
                .build());
        commerceService.insertOrder(OrderDTO.builder().build());
        verify(personRepository, times(1)).findByPersonId(any());
        verify(productRepository, times(1)).findByProductId(any());
        verify(orderRepository, times(1)).save(any());
    }

    @Test
    void allSelectOrder() {
    }

    @Test
    void deleteOrder() {
    }

    @Test
    void sourceTreeTest() {
        System.out.println("ㅎㅎ");
    }
}