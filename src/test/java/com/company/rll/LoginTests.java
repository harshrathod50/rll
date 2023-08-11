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
public class LoginTests {
  @Autowired
  private MockMvc mvc;

  @Test
  public void hello() {}

  //test to check if the the viewAll returns a json file
  @Test
  void testviewAll() throws Exception {
    this.mvc.perform(MockMvcRequestBuilders.get("/user/viewAll", ""))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("application/json;"));
  }

  //wrong api test
  @Test
  void testwrongApi() throws Exception {
    this.mvc.perform(MockMvcRequestBuilders.get("/user/viewall", ""))
      .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  //login test
  //Testesd with input and the status check
  //Testing the api if its takes the input and gives a Ok status
  @Test
  void testApiWithJsonInput() throws Exception {
    String jsonInput = "{\"username\": \"\", \"password\": \"\"}";
    this.mvc.perform(
        MockMvcRequestBuilders
          .post("/user/login")
          .content(jsonInput)
          .contentType(MediaType.APPLICATION_JSON)
          .accept(MediaType.APPLICATION_JSON)
      )
      .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  void testjsonrespone() throws Exception {
    String jsonInput = "{\"username\": \"\", \"password\": \"\"}";
    String expectedResponse = "User Not found";

    this.mvc.perform(
        MockMvcRequestBuilders
          .post("/user/login")
          .content(jsonInput)
          .contentType(MediaType.APPLICATION_JSON)
          .accept(MediaType.APPLICATION_JSON)
      )
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().string(expectedResponse));
  }
}
