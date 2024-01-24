package sala;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    SalaDeEspera sala = new SalaDeEsperaImpl();

    public static void main(String[] args) {
        try (ServerSocket s = new ServerSocket(2024);) {
            while (true) {
                Socket clientSock = s.accept();
                new Thread(() -> handleClient(clientSock)).start();
            }
        } catch (Exception e) {
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received from client: " + inputLine);
                out.write("Server received: " + inputLine);
            }

            System.out.println("Client disconnected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
