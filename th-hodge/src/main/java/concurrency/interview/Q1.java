package concurrency.interview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
/**
 * 每秒4次输出log
 *
 */
public class Q1 {
	public static void main(String[] args) throws Exception {
		System.out.println("begin:" + (System.currentTimeMillis() / 1000));
		
		
		ExecutorService threadPool = Executors.newFixedThreadPool(4);
		
		/**
		 * 
		 */
		for(int i = 0; i < 16; i++) {
			final String log = "" + (i + 1);
			{
				threadPool.execute(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						Q1.parseLog(log);
					}
				});
			}
		}
		
	}
	public static void parseLog(String log) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(log + ":" + (System.currentTimeMillis() / 1000));
	}
}