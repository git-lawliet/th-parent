package concurrency.interview;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 开10个线程轮流输出log
 */
public class Q2 {
	public static void main(String[] args) throws Exception {
		System.out.println("begin:" + (System.currentTimeMillis() / 1000));
		final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						String output = queue.take();
						System.out.println(Thread.currentThread().getName() + ":" + output);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}
		for (int i = 0; i < 10; i++) {
			String input = "" + i;
			String output = Q2.doSomething(input);
			try {
				queue.put(output);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static String doSomething(String input) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String output = input + ":" + (System.currentTimeMillis() / 1000);
		return output;
	}
}