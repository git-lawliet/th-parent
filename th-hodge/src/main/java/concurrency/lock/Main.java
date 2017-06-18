package concurrency.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
	public static void main(String[] args) {
		while (true) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					Output.output("abcdef");
				}
			}).start();
			Output.output("123456");
		}
	}
}

class Output {
	static Lock lock = new ReentrantLock();
	static void output(String str) {
		if (str == null)
			return;
		lock.lock();
		try { // 防止异常抛出后没有unlock
			int len = str.length();
			for (int i = 0; i < len; i++) {
				System.out.print(str.charAt(i));
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}