package _03_Threaded_Greeting;

public class Threaded_Greeter implements Runnable {
	int value;
	
	public Threaded_Greeter(int num) {
		value = num;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread value: " + value);
		if (value <= 50) {
			Thread newThread = new Thread(new Threaded_Greeter(value+1));
			newThread.start();
			try {
				newThread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
