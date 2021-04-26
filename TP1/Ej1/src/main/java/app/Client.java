package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	Socket host;
	BufferedReader entry;
	PrintWriter exit; 
	public Client(String host, int port) {
		try {
			this.host = new Socket(host, port);

			exit = new PrintWriter(this.host.getOutputStream(), true);

			InputStreamReader streamReader = new InputStreamReader(this.host.getInputStream());
			entry = new BufferedReader(streamReader);

			// Chequea mensajes del host
			Thread messageHandler = new Thread(new Runnable(){
				@Override
				public void run() {
					try {
						while (true) {
							String val;
							val = entry.readLine();
							System.out.println(val);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

			messageHandler.start();

			Scanner scanner = new Scanner(System.in);

			System.out.println("Escriba un mensaje...");
			while (true) {
				String line = scanner.nextLine();
				send(line);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public void send(String val) {
		exit.println(val);
	}

	public static int parseInt(String num, int def) {
		try {
			return Integer.parseInt(num);
		} catch (Exception e) {
			return def;
		}
	}
	public static void main(String[] args) {
		String host = args.length > 1 ? args[0] : "127.0.0.1";
		int port = args.length > 2 ? parseInt(args[1], 4000) : 4000;
		Client c = new Client(host, port);
	}
}
