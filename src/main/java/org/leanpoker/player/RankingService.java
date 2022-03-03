package org.leanpoker.player;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class RankingService {

    public static final String URL_2 = "http://rainman.leanpoker.org/rank";

    public int call(List<Card> cards) {
        try {

            HttpClient httpClient = HttpClient.newBuilder().build();

            String cardsString = cards.stream()
                    .map(c -> "{\"rank\":\"%s\",\"suit\":\"%s\"}".formatted(c.getRank(), c.getSuit()))
                    .collect(Collectors.joining(","));

            String form =
                    """
                            cards=[
                            %s
                             ]
                            """.formatted(cardsString);

            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(form))
                    .uri(URI.create(URL_2))
                    .headers("Content-Type", "application/x-www-form-urlencoded")
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            JsonElement jsonElement = JsonParser.parseString(response.body());
            String rank = jsonElement.getAsJsonObject().get("rank").getAsString();

            return Integer.parseInt(rank);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


}
