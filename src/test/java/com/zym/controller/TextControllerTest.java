package com.zym.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TextController.class)
// ComponentScan注解必须得有,否则找不到依赖类.
@ComponentScan(basePackages = {"com.zym"})
public class TextControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() {
    }

    @Test
    public void testTextController() throws Exception {

        /**
         * Controller 层单测：
         * 示例：TextController.java
         * 接口：/cfp
         *
         */
        RequestBuilder requestBuilder;
        requestBuilder = get("/cfp").contentType(MediaType.TEXT_HTML_VALUE);
        this.mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("host : 192.168.1.1<br>port : 3306<br>dbname : crm-test<br>uname : admin<br>passwd : 123456"));
    }
}
