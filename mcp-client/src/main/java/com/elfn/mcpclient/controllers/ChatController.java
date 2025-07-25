package com.elfn.mcpclient.controllers;

import com.elfn.mcpclient.agents.AIAgent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Elimane
 */
@Controller
@CrossOrigin("*")
public class ChatController {
    private final AIAgent agent;

    public ChatController(AIAgent agent) {
        this.agent = agent;
    }

    @GetMapping("/")
    public String chatPage() {
        return "chat";
    }

    @PostMapping("/chat/send")
    @ResponseBody
    public String sendMessage(@RequestParam String message) {
        return agent.askLLM(message);
    }
}
