package com.pjys.sample.controller;

import com.pjys.sample.service.CommerceService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CommerceControllerTest {

    @MockBean
    private CommerceService commerceService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("인원 추가 TEST")
    void insertPerson() throws Exception {
        mockMvc.perform(post("/insert/person")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("{" +
                        "  \"personId\":\"1\"," +
                        "  \"personName\":\"김길동\"" +
                        "}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("인원 삭제 TEST")
    void deletePerson() throws Exception {
        mockMvc.perform(post("/delete/person")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("{" +
                        "  \"personId\":\"1\"," +
                        "  \"personName\":\"김길동\"" +
                        "}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("인원 조회 TEST")
    void allSelectPerson() throws Exception {
        mockMvc.perform(get("/all/select/person"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("제품 추가 TEST")
    void insertProduct() throws Exception {
        mockMvc.perform(post("/insert/product")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("{" +
                        "  \"productId\":\"1\"," +
                        "  \"productName\":\"신발\"" +
                        "}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("제품 삭제 TEST")
    void deleteProduct() throws Exception {
        mockMvc.perform(post("/delete/product")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("{" +
                        "  \"productId\":\"1\"," +
                        "  \"productName\":\"신발\"" +
                        "}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("제품 조회 TEST")
    void allSelectProduct() throws Exception {
        mockMvc.perform(get("/all/select/product"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("주문 추가 TEST")
    void insertOrder() throws Exception {
        mockMvc.perform(post("/insert/order")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("{" +
                        "  \"orderId\":\"1\"," +
                        "  \"personId\":\"1\"," +
                        "  \"productId\":\"1\"" +
                        "}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("주문 삭제 TEST")
    void deleteOrder() throws Exception {
        mockMvc.perform(post("/delete/order")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("{" +
                        "  \"orderId\":\"1\"," +
                        "  \"personId\":\"1\"," +
                        "  \"productId\":\"1\"" +
                        "}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("주문 조회 TEST")
    void allSelectOrder() throws Exception {
        mockMvc.perform(get("/all/select/order"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
}