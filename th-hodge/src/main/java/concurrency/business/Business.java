package concurrency.business;

class Business {
	private boolean isSub = true;

	public synchronized void sub(int count) {
		if (!isSub)
			try {
				this.wait(); // 当前线程将等待，直到其他线程调用此对象的notify()方法
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		for (int i = 0; i < 2; i++) {
			System.out.println("sub  " + i + " in " + count);
		}
		isSub = false;
		this.notify();
	}

	public synchronized void main(int count) {
		if (isSub)
			try {
				this.wait(); // 当前线程将等待，直到其他线程调用此对象的notify()方法
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		for (int i = 0; i < 3; i++) {
			System.out.println("main " + i + " in " + count);
		}
		isSub = true;
		this.notify();
	}
}