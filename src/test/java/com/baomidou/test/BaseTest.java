package com.baomidou.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

/**
 * @Auther: yyg
 * @Date: 2019/12/26 13:46
 * @Description:
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MASApplication.class)
@WebAppConfiguration
public class BaseTest {
    @Autowired
    protected WebApplicationContext context;
    protected MockMvc mockMvc;
    protected MockHttpSession session;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        session = new MockHttpSession();
        session.setAttribute("sessionId", StringUtils.replace(UUID.randomUUID().toString(), "-", ""));
        log.debug("sessionId: {}", session.getAttribute("sessionId"));
    }

}
