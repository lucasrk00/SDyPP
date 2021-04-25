package app;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class Server 
{
	public Server(int port) {
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Server ready and listening on port: " + port);
	
			while (true) {
				Socket client = serverSocket.accept();

				Connection newConn = new Connection(client);

				Thread serverThread = new Thread(newConn);
				serverThread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main( String[] args )
	{
		int port = 4000;
		Server server = new Server(port);
	}
}
