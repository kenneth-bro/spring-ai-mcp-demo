package com.investoday.boot.springaidemo.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kenneth
 * @date 2025/7/21
 **/
@RestController
@RequestMapping(value = "/mcp")
@Slf4j
public class MCPTestController {


	@Resource(name = "mcpToolCallbacks")
	SyncMcpToolCallbackProvider syncMcpToolCallbackProvider;

	@Resource
	private ChatClient.Builder chatClientBuilder;


	@GetMapping("/to-ai")
	public String askAI(){
		ChatClient chatClient = chatClientBuilder
                .defaultToolCallbacks(syncMcpToolCallbackProvider)
                .build();
        // 直接用自然语言提问，AI会自动调用 MCP 工具
        return chatClient.prompt("600839的基本信息").call().content();
	}


}
