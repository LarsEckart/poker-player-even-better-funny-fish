package org.leanpoker.player;

import java.io.IOException;

import org.slf4j.Logger;

import com.google.gson.JsonParser;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static org.slf4j.LoggerFactory.getLogger;

@WebServlet("/")
public class PlayerServlet extends HttpServlet {

    private static final Logger log = getLogger(PlayerServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().print("Java player is running");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getParameter("action").equals("bet_request")) {
            String gameState = req.getParameter("game_state");

            log.info("bet_request: {}", gameState);

            int bet = Player.betRequest(JsonParser.parseString(gameState));
            log.info("we bet {}", bet);
            resp.getWriter().print(bet);
        }
        if (req.getParameter("action").equals("showdown")) {
            String gameState = req.getParameter("game_state");

            log.info("showdown: {}", gameState);

            Player.showdown(JsonParser.parseString(gameState));
        }
        if (req.getParameter("action").equals("version")) {
            resp.getWriter().print(Player.VERSION);
        }
    }
}
