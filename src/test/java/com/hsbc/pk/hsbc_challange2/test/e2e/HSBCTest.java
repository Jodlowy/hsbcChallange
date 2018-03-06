package com.hsbc.pk.hsbc_challange2.test.e2e;

import com.hsbc.pk.hsbc_challange2.com.hsbc.pk.hsbc_challange2.controller.WallController;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class HSBCTest {

//    @Autowired
//    MockMvc mock;
//
//    @InjectMocks
//    private WallController wallController;
//
//    @Before
//    public void setUp() throws Exception {
//        mock = MockMvcBuilders.standaloneSetup(wallController)
//                                .build();
//    }


    //when user posts the tweet then it should show up on his wall

//    @Test
//    public void userPostsAndSeesMessageOnTheWall() throws Exception {
//        String message = "test tweet";
//
//        mock.perform(post("/wall")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"message\": \"" + message + "\"}"))
//                .andExpect(status().isCreated());

//       mock.perform(get("/wall"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", Matchers.hasSize(1)))
//                .andExpect(jsonPath("$.[1].value", Matchers.equalTo(message)));
//    }

//    @Test
//    public void TweetCreation() throws Exception {
//        mock.perform(post("/wall/tweet")
//                .accept(MediaType.APPLICATION_JSON_VALUE)
//                .accept("application/json"))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.content",
//                        Matchers.is("tweet bullshit")));
//
//    }


    //when user post tweet longer then 140 then exception is thrown 400 bad request

    //when user looks at the wall then he sees his tweets in reverse chronological order

    //when user follows another user then he sees other user's tweets on timeline i reverse chronological order


}
