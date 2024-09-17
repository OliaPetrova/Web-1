
import java.io.BufferedOutputStream;

public class Main {
        public static void main(String[] args){
            final var server = new Server();

            // Добавление хендлеров
            server.addHandler("GET", "/messages", (request, responseStream) -> {
                String response = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/plain\r\n" +
                        "Content-Length: 13\r\n" +
                        "Connection: close\r\n\r\n" +
                        "Hello, World!";
                responseStream.write(response.getBytes());
                responseStream.flush();
            });

            server.addHandler("POST", "/messages", (request, responseStream) -> {
                String response = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/plain\r\n" +
                        "Content-Length: 16\r\n" +
                        "Connection: close\r\n\r\n" +
                        "Message received!";
                responseStream.write(response.getBytes());
                responseStream.flush();
            });

            server.listen(9999);
        }
    }
