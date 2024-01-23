# Servidor Genérico

```java
public class Server {
	public static void main(String[] args) {		
		try {
		ServerSocket sock = new ServerSocket(8080);
		while (true) {
			Socket clientSocket = sock.accept();
			new Thread(() -> handleClient(clientSocket)).start();
			}
			
		} catch (Exception e) {	
			// handle exception
		}
	}
		
	private static void handleClient(Socket clientSocket) {	
		try (
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))
		) {
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			// handle client mesage;		
		}
			System.out.println("Client disconnected");
		} catch (Exception e) {
			// hanle exception
		}
	}
}```

# Cliente Genérico
```java
public class Client {
	public static void main(String[] args) {
		try(
		Socket sock= new Socket("localhost",8080);
		BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))
		){
		// fazer cena
		} catch (Exception e) {e.printStackTrace();
		}
		
	}
}``` 
