package com.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DiscordWebhook {
    private static final String WEBHOOK_URL = "https://discord.com/api/webhooks/1539794414673854486/JdKn3n3lrGSDvBKXq9cXaTBLPZlV2Gf8Ebi45ADAnVAgx5mfKNMRtLcSX6AyRYNHODjb";
    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public static void sendMessage(String playerName, String message) {
        String jsonPayload = String.format("{\"content\": \"**%s**: %s\"}", playerName, message);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(WEBHOOK_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                .build();
        httpClient.sendAsync(request, HttpResponse.BodyHandlers.discarding());
    }
}
