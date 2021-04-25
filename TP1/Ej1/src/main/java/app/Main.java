package app;

public class Main {
	public static void main(String[] args) {
		boolean isHost = true;
		if (args.length > 0) {
			isHost = !"client".equalsIgnoreCase(args[0]);
		}


		if (isHost) { 
			int port = 4000;
			Server server = new Server(port);
		} else {
			Client client = new Client("127.0.0.1", 4000);
		}
	}
	
}
