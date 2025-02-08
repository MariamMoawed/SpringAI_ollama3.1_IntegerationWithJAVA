package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AIservice;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/ai")
public class AIcontroller {
     @Autowired
    AIservice aiService;

    @PostMapping("/chat")
    public String getResponse(@RequestParam String category, String year){
        return aiService.getResponse(category, year);
    }

    @PostMapping("/ask")
    public String getResponse(@RequestBody String query){
        return aiService.getSummarizeText(query);
    }



    @GetMapping("/image/chat")
    public String getMultiModalResp() throws IOException {
        return aiService.getMultiModalResponse();
    }
}
