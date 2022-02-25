package org.leanpoker.player;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class JettyServer {

    private static final Logger log = getLogger(JettyServer.class);

    public void start(int port) throws Exception {
        Server server = new Server();
        try (ServerConnector connector = new ServerConnector(server)) {
            log.info("Starting server on port {}", port);
            connector.setPort(port);
            server.setConnectors(new Connector[] { connector });
        }

        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        context.addServlet(PlayerServlet.class, "");

        server.setHandler(context);

        server.start();
    }

    public void start() throws Exception {
        int port = getPort();
        start(port);
    }

    private int getPort() {
        try {
            return Integer.parseInt(System.getenv("PORT"));
        } catch (NumberFormatException e) {
            log.warn("No env variable $PORT set, falling back to 8080.");
            return 8080;
        }
    }

}
