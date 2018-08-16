package banking;

public class app {
public static void main(String[] args) {
	final threads t=new threads();
	
	Thread t1=new Thread(new Runnable() {
		public void run() {
			try {
				t.firstthread();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});
	Thread t2=new Thread(new Runnable() {
		public void run() {
			try {
				t.secondthread();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});
	
	t1.start();
	t2.start();
	

	try {
		t2.join();
		t1.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	t.finsihed();
}
}
