package app;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	public Server(int port) {
		try {
			Registry registry = LocateRegistry.createRegistry(port);
			System.out.println("RMI Registry litening on port " + port);

			ServerRunner runner = new ServerRunner();

			RemoteInt service = (RemoteInt) UnicastRemoteObject.exportObject(runner, port);


			registry.rebind("service", service);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static  void main(String[] args) {
		int port = 4000;
		if (args.length > 0) {
			try {
				port = Integer.parseInt(args[0]);
			} catch (Exception e) {

			}
		}

		Server s = new Server(port);
	}

}
