package app;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Client {
	public Client (String host, int port) {
		try {
			Registry registry = LocateRegistry.getRegistry(host, port);

			RemoteInt remote = (RemoteInt) registry.lookup("service");

			String weather = remote.getWeather();
			System.out.println("El clima en el server RMI es:" + weather);
		} catch (Exception e) {
			
		}
	}
	

	public static void main(String[] args) {
		String host = "127.0.0.1";
		int port = 4000;
		Client client = new Client(host, port);
	}
}
