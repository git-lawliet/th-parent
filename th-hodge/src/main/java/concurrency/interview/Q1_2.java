package concurrency.interview;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
 
/**
 * 每秒4次输出log
 *
 */
public class Q1_2 {
	public static void main(String[] args) throws Exception {
		System.out.println("begin:" + (System.currentTimeMillis() / 1000));
		
		final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1); // 详细请看api
		for(int i = 0; i < 4; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while(true) {
						try {
							parseLog(queue.take());
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
		
//		ExecutorService threadPool = Executors.newFixedThreadPool(4);
		
		/**
		 * 
		 */
		for(int i = 0; i < 16; i++) {
			final String log = "" + (i + 1);
			{
				queue.put(log);
//				threadPool.execute(new Runnable() {
//					@Override
//					public void run() {
//						// TODO Auto-generated method stub
//						Main2.parseLog(log);
//					}
//				});
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