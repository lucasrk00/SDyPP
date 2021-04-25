package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TareaPrimeNumber extends UnicastRemoteObject implements Tarea{
	private int number;
	private Boolean result;
	protected TareaPrimeNumber(int number) throws RemoteException {
		super();
		this.number = number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getNumber() {
		return number;
	}
	public Boolean getResult() {
		return result;
	}

	public Boolean isPrime() {
		int actualNumber = 2;
		Boolean response = true;
		while ((response) && (actualNumber < (number/2))) {
			if ((number % actualNumber) == 0) {
				response = false;
			}
			actualNumber++;
		}
		return response;
	}
	@Override
	public void run() throws RemoteException {
		result = isPrime();
	}
	
}
