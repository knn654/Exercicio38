package principal;

import java.util.concurrent.Semaphore;

public class Threads extends Thread {
	
	private int numCorredor;
	private Semaphore semaforo;
	
	public Threads(int numCorredor, Semaphore semaforo) {
		this.numCorredor = numCorredor;
		this.semaforo = semaforo;
	}
	
	public void run() {
		corredor();
		try {
			semaforo.acquire();
			ficaCorredor();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
	
	public void corredor() {
		System.out.println("Corredor " + numCorredor + " iniciou a corrida");
		int metros = 0;
		do {
			metros = metros + (int) (Math.random() * 6) + 4;
		} while (metros <= 200);
	}
	
	public void ficaCorredor() {
		int tempoEspera = (int) (Math.random() + 1) * 1001;
		try {
			Thread.sleep(tempoEspera);
		} catch (Exception e) {
			e.printStackTrace();
		}
		saiCorredor();
	}
	
	public void saiCorredor() {
		System.out.println("Corredor " + numCorredor + " terminou a corrida!");
	}
}
