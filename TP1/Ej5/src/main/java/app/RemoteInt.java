package app;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface RemoteInt extends Remote {
	// Ej 5
	public String getWeather() throws RemoteException;
	// Ej 6
	public int[] vectorsAddition(int[] firstVector, int[] secondVector) throws RemoteException;
	public int[] vectorsSubtraction(int[] firstVector, int[] secondVector) throws RemoteException;
	// Ej 7
	public void runTask(Tarea tarea) throws RemoteException;
}
