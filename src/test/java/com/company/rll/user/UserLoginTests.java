package com.company.rll.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.company.rll.entity.user.UserEntity;
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
public class UserLoginTests {
  @Autowired
  private MockMvc mvc;

  @Autowired
  private ObjectMapper objectMapper;

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

  @Test
  void shouldLoginSampleUser1() throws Exception {
    MvcResult result =
      this.mvc.perform(
          MockMvcRequestBuilders
            .put("/user/login")
            .content("{\"username\":\"user@example.com\",\"password\": \"user\"}")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();
    UserEntity user =
      this.objectMapper.readValue(
          result.getResponse().getContentAsString(),
          UserEntity.class
        );
    assertEquals("User", user.getName());
  }

  @Test
  void shouldLoginSampleUser2() throws Exception {
    MvcResult result =
      this.mvc.perform(
          MockMvcRequestBuilders
            .put("/user/login")
            .content("{\"username\":\"foo@bar.com\",\"password\": \"foo\"}")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();
    UserEntity user =
      this.objectMapper.readValue(
          result.getResponse().getContentAsString(),
          UserEntity.class
        );
    assertEquals("Foo Bar", user.getName());
  }

  @Test
  void shouldReturnNotFoundOnWrongCredentials() throws Exception {
    this.mvc.perform(
        MockMvcRequestBuilders
          .put("/user/login")
          .content("{\"username\":\"wrong@email.com\",\"password\": \"wrong\"}")
          .contentType(MediaType.APPLICATION_JSON)
          .accept(MediaType.APPLICATION_JSON)
      )
      .andExpect(MockMvcResultMatchers.status().isNotFound());
  }
}
