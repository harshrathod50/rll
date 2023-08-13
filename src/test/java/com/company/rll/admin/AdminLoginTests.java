package com.company.rll.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.company.rll.entity.admin.AdminEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
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
public class AdminLoginTests {
  @Autowired
  private MockMvc mockmvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void shouldLoginSampleAdmin1() throws Exception {
    MvcResult result =
      this.mockmvc.perform(
          MockMvcRequestBuilders
            .put("/admin/login")
            .content("{\"username\":\"admin@example.com\",\"password\":\"admin\"}")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();
    AdminEntity admin =
      this.objectMapper.readValue(
          result.getResponse().getContentAsString(),
          AdminEntity.class
        );
    assertEquals("Admin", admin.getName());
  }

  @Test
  void shouldLoginSampleAdmin2() throws Exception {
    MvcResult result =
      this.mockmvc.perform(
          MockMvcRequestBuilders
            .put("/admin/login")
            .content("{\"username\":\"admin@example.com\",\"password\":\"admin\"}")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();
    AdminEntity admin =
      this.objectMapper.readValue(
          result.getResponse().getContentAsString(),
          AdminEntity.class
        );
    assertEquals("Admin", admin.getName());
  }
}
