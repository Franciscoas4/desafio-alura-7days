package com.desafio.desafiodaytwo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApplicationDesafioAluraDayTwo {

    public static void main(String[] args) throws IOException, InterruptedException {

        final String url = "https://imdb-api.com/en/API/Top250Movies";
        final String key = "/k_ar79o7r5";

        HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url + key)).GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Error: " + response.statusCode());
        } else {
            String value = response.body();
            System.out.println(value);
        }

    }
}
