package app;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
	HashMap<String, User> users = new HashMap<String, User>();

	public Server(int port) {
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Server ready and listening on port: " + port);

			while (true) {
				Socket client = serverSocket.accept();

				Connection newConn = new Connection(client, this);

				Thread serverThread = new Thread(newConn);
				serverThread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public User registerUser(String username, String password) {
		if (users.containsKey(username)) return null; // No se puede crear el usuario
		User newUser = new User(username, password);
		users.put(username, newUser);
		return newUser;
	}

	public User getUser(String username) {
		return users.get(username);
	}

	public void sendMessage() {

	}
}
