package com.hsbc.pk.hsbc_challange2.test.e2e;

import com.hsbc.pk.hsbc_challange2.dto.TweetDTO;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class HSBCTest {

    @Autowired
    MockMvc mock;

    //when user posts the tweet then it should show up on his wall

    @Test
    public void userPostsAndSeesMessageOnTheWall() throws Exception {
        String message = "test tweet";

        mock.perform(post("/wall")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"message\": \""+ message + "\"}"))
                .andExpect(status().isCreated());

        mock.perform(get("/wall"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$.[1].value", Matchers.equalTo(message)));
    }

    //when user post tweet longer then 140 then exception is thrown 400 bad request

    //when user looks at the wall then he sees his tweets in reverse chronoligcal order

    //when user follows another user then he sees other user's tweets on timeline i reverse chronological order


}
