package com.sunsat.sathish.java.hackerrank.preparation.general;

public class ThreadA implements Runnable {
	PrintNumbers p;

	ThreadA(PrintNumbers p) {
		this.p = p;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			synchronized (p) {
				while (p.isPrintOdd()) {
					try {
						p.wait();
					} catch (InterruptedException e) {

					}
				}
				System.out.println(p.number);
				p.setPrintOdd(true);
				p.notifyAll();
			}
		}

	}
}
