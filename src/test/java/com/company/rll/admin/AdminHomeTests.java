package com.company.rll.admin;

import com.company.rll.entity.admin.AdminEntity;
import com.company.rll.repository.user.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Order;
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
class AdminHomeTests {
  @Autowired
  private MockMvc mvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private UserRepository userRepository;

  @Test
  @Order(1)
  void shouldCalculateTotalUsers() throws Exception {
    MvcResult result =
      this.mvc.perform(MockMvcRequestBuilders.get("/user/totalNumberOfUsers"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();
    Long c = this.userRepository.count();
    c = objectMapper.readValue(result.getResponse().getContentAsString(), Long.class);
  }

  @Test
  @Order(2)
  void shouldCalculateTotalBuses() throws Exception {
    MvcResult result =
      this.mvc.perform(MockMvcRequestBuilders.get("/bus/totalNumberOfBuses"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();
    Long c = this.userRepository.count();
    c = objectMapper.readValue(result.getResponse().getContentAsString(), Long.class);
  }
}
