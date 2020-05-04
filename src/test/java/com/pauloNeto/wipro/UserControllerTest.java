package com.pauloNeto.wipro;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pauloNeto.wipro.model.User;
import com.pauloNeto.wipro.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserControllerTest {

    private static final ObjectMapper om = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void addUsers(){
        User user = new User();
        user.setId("1");user.setLogin("login");user.setPassword("password");
        User otherUser = new User();
        otherUser.setId("2");otherUser.setLogin("login2");otherUser.setPassword("password2");

        userRepository.save(user);
        userRepository.save(otherUser);
    }

    @After
    public void deleteUsers(){

        User user = new User();
        user.setId("1");user.setLogin("login");user.setPassword("password");
        User otherUser = new User();
        otherUser.setId("2");otherUser.setLogin("login2");otherUser.setPassword("password2");

        userRepository.delete(user);
        userRepository.delete(otherUser);
    }

    @Test
    public void newUserTest() throws Exception{

        User user = new User();
        user.setId("1");user.setLogin("login");user.setPassword("password");

        mockMvc.perform(post("/user")
                .content(om.writeValueAsString(user))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is("1")))
                .andExpect(jsonPath("$.login", is("login")))
                .andExpect(jsonPath("$.password", is("password")));

    }

    @Test
    public void getUsersTest() throws Exception{

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is("1")))
                .andExpect(jsonPath("$[1].id", is("2")))
                .andExpect(jsonPath("$[0].login", is("login")))
                .andExpect(jsonPath("$[1].login", is("login2")))
                .andExpect(jsonPath("$[0].password", is("password")))
                .andExpect(jsonPath("$[1].password", is("password2")));
    }

    @Test
    public void getUserTest() throws Exception{

        mockMvc.perform(get("/user/login"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is("1")))
                .andExpect(jsonPath("$.login", is("login")))
                .andExpect(jsonPath("$.password", is("password")));
    }
}
