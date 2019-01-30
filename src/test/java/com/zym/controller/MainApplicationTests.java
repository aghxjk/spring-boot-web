package com.zym.controller;

import com.zym.beans.BlogProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainApplicationTests {

    @Autowired
    private BlogProperties blogProperties;

    @Test
    public void getBlogProperties() {
        Assert.assertEquals(blogProperties.getName(), "一千零一夜");
        Assert.assertEquals(blogProperties.getTitle(), "SpringBoot");
    }

}
