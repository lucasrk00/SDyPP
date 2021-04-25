package app;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Random;

public class ServerRunner implements RemoteInt, Remote {
	@Override
	public String getWeather() {
		Random response = new Random();
		int max = 32;
		int min = 10;
		return (response.nextInt(max - min) + min + 1) + " °C";
	}

	@Override
	public int[] vectorsAddition(int[] firstVector, int[] secondVector) throws RemoteException {
		int[] responseVector = new int[firstVector.length];
		for (int i = 0; i<firstVector.length; i++) {
			responseVector[i] = firstVector[i] + secondVector[i];
			firstVector[i] = responseVector[i];
			secondVector[i] = responseVector[i];
		}
		return responseVector;
	}

	@Override
	public int[] vectorsSubtraction(int[] firstVector, int[] secondVector) throws RemoteException {
		int[] responseVector = new int[firstVector.length];
		for (int i = 0; i < firstVector.length; i++) {
			responseVector[i] = firstVector[i] - secondVector[i];
			firstVector[i] = responseVector[i];
			secondVector[i] = responseVector[i];
		}
		return responseVector;
	}

	public void runTask(Tarea tarea) throws RemoteException {
		tarea.run();
	}
}
