package com.gemini.email.generator.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.gemini.email.generator.DTO.EmailRequest;
import com.gemini.email.generator.DTO.EmailResponse;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;
@Service
public class EmailService {

       @Value("${gemini.api.url}")
        private String apiUrl;

        @Value("${gemini.api.key}")
        private String apiKey;

        private final WebClient webClient;

        public EmailService() {
            this.webClient = WebClient.builder().baseUrl(apiUrl).build();
        }

    public String generateEmailReply(EmailRequest request) {

        String prompt = buildPrompt(request);

        Map<String, Object> payload = Map.of(
            "contents", new Object[] {
                Map.of(
                    "parts", new Object[] {
                        Map.of("text", prompt)
                    })
        });

        String response = webClient.post()
        .uri(apiUrl + "?key=" + apiKey)
        .header("Content-Type", "application/json")
        .bodyValue(payload)
        .retrieve()
        .bodyToMono(String.class)
        .block();

        return extractResponseContent(response);
    }

    private String extractResponseContent(String response) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response);
            return rootNode.path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText();
        } catch (Exception e) {
            return "Error processing request: " + e.getMessage();
        }
    }

    private String buildPrompt(EmailRequest request){
        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate a professional email reply for the following email content. Please don't generate subject line ");

        if(request.tone() != null && !request.tone().isEmpty()){
            prompt.append("Use a").append(request.tone()).append(" tone.");
        }
        prompt.append("\nOriginal email: \n").append(request.emailContent());
        return prompt.toString();
    }
    
}
