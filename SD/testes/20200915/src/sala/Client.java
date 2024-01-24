package sala;

import java.net.Socket;

public class Client {
    String name;
    Socket sock;

    public Client(String n, int serverPort) {
        name = n;
        try {
            sock = new Socket("localhost", serverPort);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    boolean espera(String nome) {
        return false;
    };

    void desiste(String nome) {
    };

}
