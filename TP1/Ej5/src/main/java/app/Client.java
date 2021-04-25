package app;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Client {
	public Client (String host, int port) {
		try {
			Registry registry = LocateRegistry.getRegistry(host, port);

			RemoteInt remote = (RemoteInt) registry.lookup("service");

			System.out.println("------ Ej 5 ------\n");
			String weather = remote.getWeather();
			System.out.println("El clima en el server RMI es: " + weather);

			System.out.println("\n------ Ej 6 ------\n");

			System.out.println("Vectores antes de la ejecucion:");

			int[] firstVector = { 1, 1, 1, 1, 1, 1, 1 };
			int[] secondVector = { 2, 2, 2, 2, 2, 2, 2 };

			System.out.println("Primer vector: " + vectorToString(firstVector));
			System.out.println("Segundo vector: " + vectorToString(secondVector));

			int[] addVector = remote.vectorsAddition(firstVector, secondVector);

			System.out.println("\nVectores luego de ejecutar la suma:");
			System.out.println("Primer vector: " + vectorToString(firstVector));
			System.out.println("Segundo vector: " + vectorToString(secondVector));
			System.out.println("Resultado suma: " + vectorToString(addVector));

			int[] subVector = remote.vectorsSubtraction(firstVector, secondVector);
			System.out.println("\nVectores luego de ejecutar la resta:");
			System.out.println("Primer vector: " + vectorToString(firstVector));
			System.out.println("Segundo vector: " + vectorToString(secondVector));
			System.out.println("Resultado resta: " + vectorToString(subVector));

			System.out.println("\n------ Ej 7 ------\n");
			TareaRandom randomNumberTask = new TareaRandom(10, 20);
			remote.runTask(randomNumberTask);
			int randomNumber = randomNumberTask.getResult();

			System.out.println("resultado random: " + randomNumber);

			TareaPrimeNumber primeNumber = new TareaPrimeNumber(randomNumber);
			remote.runTask(primeNumber);

			System.out.println("el numero " + primeNumber.getNumber() + " es primo? " + primeNumber.getResult());
		} catch (Exception e) {
			
		}
	}

	public String vectorToString(int[] vector) {
		String vectorString = "(";
		if (vector.length < 1) {
			return "()";
		}

		for (int i = 0; i < vector.length - 1; i++){
			vectorString += vector[i] + ", ";
		}
		vectorString += vector[vector.length-1] + ")";
		return vectorString;
	}

	public static void main(String[] args) {
		String host = "127.0.0.1";
		int port = 4000;
		Client client = new Client(host, port);
	}
}

