package com.company.rll;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminLoginTests {
  @Autowired
  private MockMvc mockmvc;

  @Test
  void contextLoads() {}

  @Test
  void testGreet() throws Exception {
    this.mockmvc.perform(MockMvcRequestBuilders.get("/admin/greet", ""))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"));
  }

  @Test
  void testloginNotfound() throws Exception {
    String jsonInput = "{\"username\": \"\", \"password\": \"\"}";

    this.mockmvc.perform(
        MockMvcRequestBuilders
          .post("/admin/login")
          .content(jsonInput)
          .contentType(MediaType.APPLICATION_JSON)
          .accept(MediaType.APPLICATION_JSON)
      )
      .andExpect(MockMvcResultMatchers.status().isNotFound());
  }
}
