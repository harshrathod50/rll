package com.company.rll;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class AdminRegistrationTests {
  @Autowired
  private MockMvc mvc;

  @Test
  void contextLoads() {}

  @Test
  void testGreet() throws Exception {
    this.mvc.perform(MockMvcRequestBuilders.get("/admin/greet", ""))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"));
  }

  @Test
  void testApiWithJsonInput() throws Exception {
    String jsonInput = "{\"username\": \"\", \"password\": \"\"}";
    this.mvc.perform(
        MockMvcRequestBuilders
          .post("/admin/register")
          .content(jsonInput)
          .contentType(MediaType.APPLICATION_JSON)
          .accept(MediaType.APPLICATION_JSON)
      )
      .andExpect(MockMvcResultMatchers.status().isCreated());
  }
}
