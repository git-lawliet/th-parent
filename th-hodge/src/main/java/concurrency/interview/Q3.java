package concurrency.interview;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 *  相同的key下一秒输出
 */
public class Q3 extends Thread {
	private TestDo testDo;
	private String key;
	private String value;

	public Q3(String key, String key2, String value) {
		this.testDo = TestDo.getInstance();
		this.key = key + key2;
		this.value = value;
	}

	public static void main(String[] args) {
		Q3 a = new Q3("1", "", "1");
		Q3 b = new Q3("1", "", "2");
		Q3 c = new Q3("3", "", "3");
		Q3 d = new Q3("4", "", "4");
		Q3 e = new Q3("1", "", "5");
		Q3 f = new Q3("3", "", "6");
		Q3 g = new Q3("5", "", "7");
		System.out.println("begin:" + (System.currentTimeMillis()) / 1000);
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
		f.start();
		g.start();
	}

	public void run() {
		testDo.doSome(key, value);
	}
}

class TestDo {
	private CopyOnWriteArrayList<Object> cache = new CopyOnWriteArrayList<Object>();

	private TestDo() {
	}

	private static TestDo _instance = new TestDo();

	public static TestDo getInstance() {
		return _instance;
	}

	public void doSome(Object key, String value) {
		
		Object _key = null;
		if (!cache.contains(key)) {
			cache.add(key);
			_key = key;
		} else {
			for (Object o : cache) {
				if (o.equals(key)) {
					_key = o;
					break;
				}
			}
		}
		synchronized (_key) {
			try {
				Thread.sleep(1000);
				System.out.println(key + ":" + value + ":" + (System.currentTimeMillis() / 1000));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}