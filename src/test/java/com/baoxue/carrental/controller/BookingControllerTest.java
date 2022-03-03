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
import java.util.Date;

@SpringBootTest
@AutoConfigureMockMvc
class BookingControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void queryAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/book/query?offset=0&limit=10")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void queryByKey() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/book/query/2022030200000")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void queryByUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/book/query/user_id/1")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void order() throws Exception {
        JSONObject params = new JSONObject();
        params.put("order_no", "2022030200003");
        params.put("user_id", 1);
        params.put("car_id", "D888888");
        params.put("status", "0");
        params.put("rent", new BigDecimal("300"));
        params.put("pickup_date", new Date().getTime());
        params.put("return_date", new Date().getTime());
        System.out.println(params);
        mockMvc.perform(MockMvcRequestBuilders.post("/book/order")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(JSONObject.toJSONString(params))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void pickup() throws Exception {
        JSONObject params = new JSONObject();
        params.put("order_no", "2022030200000");
        params.put("user_id", 1);
        params.put("car_id", "A888888");
        params.put("status", "0");
        params.put("rent", new BigDecimal("300"));
        params.put("pickup_date", new Date().getTime());
        params.put("return_date", new Date().getTime());
        mockMvc.perform(MockMvcRequestBuilders.post("/book/pickup")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(JSONObject.toJSONString(params))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void returnBack() throws Exception {
        JSONObject params = new JSONObject();
        params.put("order_no", "2022030200000");
        params.put("user_id", 1);
        params.put("car_id", "A888888");
        params.put("status", "0");
        params.put("rent", new BigDecimal("300"));
        params.put("pickup_date", new Date().getTime());
        params.put("return_date", new Date().getTime());
        mockMvc.perform(MockMvcRequestBuilders.post("/book/return")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(JSONObject.toJSONString(params))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void update() throws Exception {
        JSONObject params = new JSONObject();
        params.put("order_no", "2022030200001");
        params.put("user_id", 2);
        params.put("car_id", "B888888");
        params.put("status", "0");
        params.put("rent", new BigDecimal("310"));
        params.put("pickup_date", new Date().getTime());
        params.put("return_date", new Date().getTime());
        mockMvc.perform(MockMvcRequestBuilders.put("/book/2022030200001")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(JSONObject.toJSONString(params))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/book/2022030200002")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}