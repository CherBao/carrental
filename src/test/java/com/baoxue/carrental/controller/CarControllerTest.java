package com.baoxue.carrental.controller;

import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class CarControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void queryAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/car/query?offset=0&limit=10")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void queryById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/car/query/A888888")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void queryCarModelsWithStock() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/car/query/models")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    void queryStockByModel() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/car/query/stock/Toyota Carmy")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    void add() throws Exception {
        JSONObject params = new JSONObject();
        params.put("id", "G888888");
        params.put("model", "Harvard H6");
        params.put("status", "0");
        params.put("price", new BigDecimal("100.00"));
        System.out.println(params);
        mockMvc.perform(MockMvcRequestBuilders.post("/car")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(JSONObject.toJSONString(params))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void update() throws Exception {
        JSONObject params = new JSONObject();
        params.put("id", "A888888");
        params.put("model", "Harvard H6");
        params.put("status", "0");
        params.put("price", new BigDecimal("150.00"));
        System.out.println(params);
        mockMvc.perform(MockMvcRequestBuilders.put("/car/A888888")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(JSONObject.toJSONString(params))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/car/A888888")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}