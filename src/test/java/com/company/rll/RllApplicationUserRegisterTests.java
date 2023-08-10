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
public class RllApplicationUserRegisterTests {
  @Autowired
  private MockMvc mvc;

  @Test
  void testApiWithJsonInput() throws Exception {
    String jsonInput = "{\"username\": \"tina\", \"password\": \"tina26\"}";
    this.mvc.perform(
        MockMvcRequestBuilders
          .post("/user/register")
          .content(jsonInput)
          .contentType(MediaType.APPLICATION_JSON)
          .accept(MediaType.APPLICATION_JSON)
      )
      .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  void testApiWithJsonInputAndResponseMessage() throws Exception {
    String jsonInput = "{\"username\": \"tina\", \"password\": \"tina26\"}";
    String expectedResponse = "";

    this.mvc.perform(
        MockMvcRequestBuilders
          .post("/user/register")
          .content(jsonInput)
          .contentType(MediaType.APPLICATION_JSON)
          .accept(MediaType.APPLICATION_JSON)
      )
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().string(expectedResponse));
  }
}
