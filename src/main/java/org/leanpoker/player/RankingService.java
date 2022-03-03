package org.leanpoker.player;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import static org.slf4j.LoggerFactory.getLogger;

public class RankingService {

    private static final Logger log = getLogger(RankingService.class);

    public static final String URL_2 = "http://rainman.leanpoker.org/rank";
    private final HttpClient httpClient = HttpClient.newBuilder().build();

    public int call(List<Card> cards) {
        try {

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
            log.error(e.getMessage(), e);
            return 0;
        }
    }

}
