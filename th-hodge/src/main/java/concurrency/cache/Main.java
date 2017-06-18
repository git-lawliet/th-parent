package concurrency.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	private Map<String, Object> cache = new HashMap<String, Object>();

	public static void main(String[] args) {
	}

	public Object getData(String key) {
		lock.readLock().lock();
		Object data = null;
		try {
			data = cache.get(key);
			if (data == null) {
				lock.readLock().unlock();
				lock.writeLock().lock();
				try {
					if(data == null) { 
						data = "aaa"; // 从数据库读 
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.writeLock().unlock();
				}
				lock.readLock().lock();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
		}
		return data;
	}
}