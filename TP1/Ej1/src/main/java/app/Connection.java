package app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.sound.midi.SoundbankResource;

public class Connection implements Runnable{
	Socket client;
	BufferedReader entry;
	PrintWriter exit;
	public Connection(Socket client) {
		this.client = client;
	}
	public String getName() {
		return this.client.getInetAddress().getHostAddress() + ":" + this.client.getPort();
	}
	@Override
	public void run() {
		try {
			exit = new PrintWriter(this.client.getOutputStream(), true);
			InputStreamReader streamReader = new InputStreamReader(this.client.getInputStream());
			entry = new BufferedReader(streamReader);

			String val = "";
			while(true){
				val = entry.readLine();
				send(this.getName() + ": " + val);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void send(String val) {
		exit.println(val);
	}
}
