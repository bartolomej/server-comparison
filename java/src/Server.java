import com.sun.net.httpserver.*;

import java.io.*;
import java.math.BigInteger;
import java.net.InetSocketAddress;


public class Server {

    private static int port = 8004;

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new Handler());
        server.setExecutor(null);
        server.start();
    }

    static class Handler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String path = t.getRequestURI().getPath();
            if (path.length() < 2) {
                send(t, "Please enter path.");
                return;
            }
            try {
                String response = compute(path.substring(1));
                send(t, response);
            } catch (NumberFormatException e) {
                send(t, "Not a number");
            }
        }

        private void send(HttpExchange t, String response) throws IOException {
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static String compute(String max) {
        BigInteger[] sequence = compute(Integer.parseInt(max));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sequence.length; i++) {
            sb.append(i + 1);
            sb.append(": ");
            sb.append(sequence[i]);
            sb.append("\n");
        }
        return sb.toString();
    }

    static BigInteger[] compute(int max) {
        BigInteger[] sequence = new BigInteger[max];
        sequence[0] = new BigInteger("0");
        sequence[1] = new BigInteger("1");
        for (int i = 2; i < max; i++) {
            sequence[i] = sequence[i - 1].add(sequence[i - 2]);
        }
        return sequence;
    }

}