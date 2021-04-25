package app;

public class Message {
	private User from;
	private User to;
	private String message;
	public Message(User from, User to, String message) {
		this.from = from;
		this.to = to;
		this.message = message;
	}

	public User getFrom() {
		return from;
	}
	public User getTo() {
		return to;
	}
	public String getMessage() {
		return message;
	}

	public String toString() {
		return "De: " + from.getUsername() + "\nPara: " + to.getUsername() + " \nMensaje:\n" + message;
	}
}
