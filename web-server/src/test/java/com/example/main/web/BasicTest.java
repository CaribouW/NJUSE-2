package com.example.main.web;

import com.example.main.MainApplication;
import com.example.main.controller.LoginController;
import com.example.main.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MainApplication.class})
public class BasicTest {
    private MockMvc mockMvc;
    @Autowired
    private LoginController loginController;
    @Autowired
    private UserController userController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
    }

    @Test
    public void testLogin() throws Exception {
        RequestBuilder request;
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        request = get("/favor/counter")
                .param("movieId", "12");
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.log());
    }
}
