package app;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Tarea extends Remote{
	public void run() throws RemoteException;
}
