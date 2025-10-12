package com.example.chatapp.controller;

import com.example.chatapp.service.OpenRouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {

    @Autowired
    private OpenRouterService openRouterService;

    // Display form for chat interface
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("userMessage", "");
        model.addAttribute("responseMessage", "");
        return "chat";
    }

    // Handle POST request and interact with OpenRouter API
    @PostMapping("/sendMessage")
    public String sendMessage(@RequestParam String userMessage, Model model) {
        String responseMessage = openRouterService.getResponseFromOpenRouter(userMessage);
        model.addAttribute("userMessage", userMessage);
        model.addAttribute("responseMessage", responseMessage);
        return "chat";
    }
}
