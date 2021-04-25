package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class TareaRandom extends UnicastRemoteObject implements Tarea{
	
	public int min;
	public int max;
	private int result;
	
	protected TareaRandom(int min, int max) throws RemoteException {
		super();
		this.min = min;
		this.max = max;
	}
	public void setValorMin(int min) {
		this.min = min;
	}
	public void setValorMax(int max) {
		this.max = max;
	}
	public int getResult() {
		return result;
	}

	@Override
	public void run() throws RemoteException {
		Random response = new Random();
		result = (response.nextInt(max - min) + min + 1);
	}
	
}
