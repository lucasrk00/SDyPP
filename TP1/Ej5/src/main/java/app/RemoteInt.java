package app;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface RemoteInt extends Remote {
	// Ej 5
	public String getWeather() throws RemoteException;
	// Ej 6
	//public int[] vectorsAdd(int[] firstVector, int[] secondVector) throws RemoteException;
}
