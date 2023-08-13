package com.company.rll.admin;

import com.company.rll.entity.admin.AdminEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class AdminRegisterTests {
  @Autowired
  private MockMvc mvc;

  @Autowired
  private ObjectMapper objectMapper;

  private AdminEntity admin;

  @Test
  @Order(1)
  void shouldRegisterSampleAdmin() throws Exception {
    MvcResult result =
      this.mvc.perform(
          MockMvcRequestBuilders
            .post("/admin/register")
            .content("{\"username\":\"mock@test.com\",\"password\":\"mockTesting\"}")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
        )
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(
          MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)
        )
        .andReturn();
    this.admin =
      objectMapper.readValue(
        result.getResponse().getContentAsString(),
        AdminEntity.class
      );
  }

  @Test
  @Order(2)
  void shouldDeleteSampleAdmin() throws Exception {
    System.out.println(this.admin.getAdminId());
    this.mvc.perform(
        MockMvcRequestBuilders.delete("/admin/remove_one/" + this.admin.getAdminId())
      )
      .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
