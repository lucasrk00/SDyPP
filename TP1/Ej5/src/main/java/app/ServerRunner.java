package app;

import java.rmi.Remote;

public class ServerRunner implements RemoteInt, Remote {
	@Override
	public String getWeather() {
		// TODO: Hacerlo
		return "holaa";
	}
}
