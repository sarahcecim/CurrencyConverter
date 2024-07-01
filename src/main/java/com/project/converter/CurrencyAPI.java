package com.project.converter;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class CurrencyAPI {

    private final String apiKey = "SUA_CHAVE_API"; // Substitua pela sua chave da API
    private final String apiUrl = "https://api.exchangerate-api.com/v4/latest/"; // URL da API do Exchange

    public Map<String, Double> getLatestRates() throws IOException, InterruptedException {
        // Crie o cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Construa a requisição HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl + apiKey))
                .GET()
                .build();

        // Execute a requisição
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Verifique se a resposta foi bem-sucedida
        if (response.statusCode() == 200) {
            // Converta a resposta JSON para um mapa
            return new Gson().fromJson(response.body(), Map.class);
        } else {
            throw new IOException("Erro ao obter taxas de câmbio: " + response.statusCode());
        }
    }
}
