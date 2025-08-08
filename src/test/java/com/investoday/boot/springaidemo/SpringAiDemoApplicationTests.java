package com.investoday.boot.springaidemo;

import com.investoday.boot.springaidemo.controller.MCPTestController;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@WebAppConfiguration
@Slf4j
class SpringAiDemoApplicationTests {

	@Resource
	MCPTestController mcpTestController;

	@Test
	void contextLoads() {

	}

	@Test
	public void testMcpTools(){
		String answer = mcpTestController.askAI();
		log.info("回答:{}", answer);
	}

}
