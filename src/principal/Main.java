package principal;

import java.util.concurrent.Semaphore;

public class Main {

	public static Semaphore semaforo;
	
	public static void main(String[] args) {
		
		int totalCorredores = 4;
		int maxCorredoresPorta = 1;
		semaforo = new Semaphore(maxCorredoresPorta);
		
		for (int i = 0; i < totalCorredores; i++) {
			Thread corredores = new iniciarCorrida (i, semaforo);
			corredores.start();
		}
	}
}
