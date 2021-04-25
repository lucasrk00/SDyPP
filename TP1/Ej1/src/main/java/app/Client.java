package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

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

			send("Hola me llamo Facu");


			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public void send(String val) {
		exit.println(val);
	}
}
