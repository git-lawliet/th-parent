package concurrency.readwritelock;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
	 public static void main(String[] args) {
		new Thread( new Runnable() {
			@Override
			public void run() {
				while(true)
					Queue3.get();
			}
		}).start();
		while(true) {
			Queue3.put(new Random().nextInt());
		}
	}
	 
}
class Queue3 {
	private static Object obj;
	private static ReadWriteLock lock = new ReentrantReadWriteLock();
	public static void put(Object _obj) {
		lock.writeLock().lock();
		try {
			System.out.println("ready write");
			Thread.sleep(100);
			obj = _obj;
			System.out.println("done  write.....");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.writeLock().unlock();
		}
	}
	public static void get() {
		lock.readLock().lock();
		try {
			System.out.println("ready read");
			Thread.sleep(100);
			System.out.println("done  read....." + obj);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
		}
	}
}