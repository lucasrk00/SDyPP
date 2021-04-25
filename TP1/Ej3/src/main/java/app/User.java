package app;

import java.util.Queue;
import java.util.LinkedList;

public class User {
	private String username;
	private String password;
	//ArrayList<Message> messages = new ArrayList<Message>();
	Queue<Message> messages = new LinkedList<Message>();

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public Boolean checkPassword(String password) {
		return password.equals(this.password);
	}

	public Queue<Message> getMessages() {
		return this.messages;
	}

	// Le "envia" un mensaje a este usuario (Básicamente agrega a la queue)
	public void sendMessage(Message message) {
		this.messages.add(message);
	}
}
