package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection implements Runnable {
	Socket client;
	BufferedReader entry;
	PrintWriter exit;

	boolean closed = false;
	User user;
	Server server;

	public Connection(Socket client, Server server) {
		this.client = client;
		this.server = server;
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

			authMenu();
			mainMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void send(String val) {
		exit.println(val);
	}
	private String readLn() {
		try {
			return entry.readLine();
		} catch (Exception e) {
			e.getStackTrace();
			return "";
		}
	}

	public void close() {
		try {
			client.close();
			closed = true;
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	private void authMenu() {
		while (user == null && !closed) {
			send("----- Login -----");
			send("[1] Login");
			send("[2] Register");
			send("[0] Salir");

			String option = readLn();
			send("");
			switch (option) {
				case "1":
					loginFlow();
					break;
				case "2":
					registerFlow();
					break;
				case "0":
					send("Nos vemos!");
					close();
					break;
				default:
					send("Opcion invalida");
					break;
			}
			send("");
		}
	}
	
	private void mainMenu() {
		// Mostrar mensajes y alguna data yqc...
		String option = "";
		while (!option.equals("0") && !closed){
			send("");
			send("----- Menu -----");
			send("[1] Escribir mensaje");
			send("[2] Leer mensajes");
			send("[0] Salir");

			option = readLn();
			send("");
			switch (option) {
			case "1":
				writeMessageFlow();
				break;
			case "2":
				readMessagesFlow();
				break;
			case "0":
				send("Nos vemos!");
				close();
				break;
			}
			send("");
		} while (!option.equals("0"));
	}

	private void loginFlow() {
		send("Iniciar sesion");
		send("Username:");
		String username = readLn();

		send("Password:");
		String password = readLn();

		User user  = this.server.getUser(username);
		if (user == null) {
			send("Ese usuario no existe");
		} else if (!user.checkPassword(password)) {
			send("Contraseña incorrecta");
		} else {
			this.user = user;
		}
	}

	private void registerFlow() {
		send("Registrarse");
		send("Username:");
		String username = readLn();

		if (this.server.getUser(username) == null) {
			send("Password:");
			String password = readLn();
			this.user = this.server.registerUser(username, password);
		} else {
			send("Ya existe un usuario registrado con ese nombre de usuario");
		}
	}

	private void writeMessageFlow() {
		send("Destinatario: ");
		String username = readLn();
		User to = server.getUser(username);

		if (to == null) {
			send("No existe un usuario con ese username");
			return;
		}
		send("Mensaje: ");
		String text = readLn();
		Message message = new Message(this.user, to, text);
		to.sendMessage(message);
		send("Mensaje enviado a " + to.getUsername());
	}

	private void readMessagesFlow() {
		String option = "1";

		while (!option.equals("0") && this.user.messages.size() > 0) {
			if (option.equals("1")) {
				Message currentMessage = this.user.messages.poll();
				send("\n---------------------------------------------------\n");
				send(currentMessage.toString());
			}

			send("---------------------------------------------------");
			send("\n" + this.user.messages.size() + " Mensajes restantes\n");
			send("[1] Siguiente [0] Salir");
			option = readLn();
		}
		send("No hay mas mensajes!");
	}
}