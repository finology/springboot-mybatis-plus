package gy.finolo.springbootmybatisplus;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @description:
 * @author: Simon
 * @date: 2020-05-21 14:33
 */

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
@EnableAutoConfiguration(exclude = {RabbitAutoConfiguration.class})
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void list() throws Exception {
        MvcResult mvcResult = mockMvc.perform((MockMvcRequestBuilders.get("/users")
                .contentType(MediaType.APPLICATION_JSON))
                .param("name", "x"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        int status = mvcResult.getResponse().getStatus();

        String content = mvcResult.getResponse().getContentAsString();
        log.info(content);
        Assertions.assertEquals(200, status);
    }
}
