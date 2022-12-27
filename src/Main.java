import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class Main {
    public static HttpHandler index() {
        return new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) {
                System.out.println("Index has been accessed!");
            }
        };
    }

    public static void main(String[] args) {
        try {
            var address = new InetSocketAddress("127.0.0.1", 3000);
            var server = HttpServer.create(address, 0);
            server.createContext("/", Main.index());
            server.start();
            System.out.println("HTTP server is now running at " + server.getAddress());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}