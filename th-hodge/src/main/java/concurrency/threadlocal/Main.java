package concurrency.threadlocal;

import java.util.Random;

/**
 *
 */
public class Main {
	 
	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int id = new Random().nextInt();
					MyData.getThreadInstance().setId(id).setName(Thread.currentThread().getName());
					System.out.println(MyData.getThreadInstance());
					new A().getData();
					new B().getData();
					
				}
				
			}).start();
		}
	}
	
	 
	static class A {
		public void getData() {
			MyData myData = MyData.getThreadInstance();
			System.out.println(myData);
			
		}
	}
	
	static class B {
		public void getData() {
			MyData myData = MyData.getThreadInstance();
			System.out.println(myData);
			
		}
	}
}



class MyData {
	private int id;
	private String name;
	private static ThreadLocal<MyData> tLocal = new ThreadLocal<MyData>();
	private MyData() {}
	public static MyData getThreadInstance() {
		MyData m = tLocal.get();
		if(m == null) {
			m = new MyData();
			tLocal.set(m);
		}
		return m;
	}
	public MyData setId(int id) {
		this.id = id;
		return this;
	}
	public MyData setName(String name) {
		this.name = name;
		return this;
	}
 
	@Override
	public String toString() {
		return "id:" + id + ", name:" + name;
	}
	
	
}