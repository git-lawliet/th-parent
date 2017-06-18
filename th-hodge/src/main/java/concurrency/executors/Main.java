package concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main  {
	 
	public static void main(String[] args) {
		ExecutorService treadPool = Executors.newFixedThreadPool(3); // 3个线程的线程池
		for(int i = 0; i < 10; i++) {
			final int task = i;
			treadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for(int j = 0; j < 10; j++) {
						System.out.println(Thread.currentThread().getName() + " in task " + task);
					}
				}
			});
		}
		
	}
	
	
	
}