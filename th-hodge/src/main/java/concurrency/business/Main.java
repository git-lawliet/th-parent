package concurrency.business;

/**
 * 子线程循环2次，接着主线程循环3次。 如此循环10次
 * @author Lawliet
 *
 */
public class Main {
	public static void main(String[] args) throws Exception {
		final Business b = new Business();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					b.sub(i);
				}
			}
		}).start();
		for (int i = 0; i < 10; i++) {
			b.main(i);
		}
	}
}