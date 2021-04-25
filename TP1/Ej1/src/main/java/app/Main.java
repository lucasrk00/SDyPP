package app;
public class Main {
	public static int parseInt(String num) {
		try {
			return Integer.parseInt(num);
		} catch (Exception e) {
			return 0;
		}
	}
	public static void main(String[] args) {
		boolean isHost = true;
		if (args.length > 0) {
			isHost = !"client".equalsIgnoreCase(args[0]);
		}


		if (isHost) { 
			int port = args.length > 1 ? parseInt(args[1]) : 4000;
			Server server = new Server(port);
		} else {
			String host = args.length > 1 ? args[1] : "127.0.0.1";
			int port = (int) args.length > 2 ? parseInt(args[2]) : 4000;

			Client client = new Client(host, port);
		}
	}
	
}
