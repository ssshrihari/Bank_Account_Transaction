package banking;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class threads {
	
	private  account acc1=new account();
	private  account acc2=new account();
	
	private Lock lock1=new ReentrantLock();
	private Lock lock2=new ReentrantLock();
	
	
	public void aquirelock(Lock lock1,Lock lock2) throws InterruptedException {
		boolean getfirstlock=false;
		boolean getsecondlock=false;
		while(true){
		try {
			getfirstlock=lock1.tryLock();
			getsecondlock=lock2.tryLock();
		}
		finally {
			if(getfirstlock&&getsecondlock) {
				return;
			}
			if(getfirstlock)
				lock1.unlock();
			if(getsecondlock)
				lock2.unlock();
			
		}
		Thread.sleep(1);
		}
	}
	public void firstthread() throws InterruptedException{
		// TODO Auto-generated method stub
		Random r=new Random();
		for(int i=0;i<10000;i++) {
			aquirelock(lock1,lock2);
		try {
		account.transfer(acc1, acc2, r.nextInt(100));
		}
		finally {
		lock1.unlock();
		lock2.unlock();
		}
		}
		
	}

	public void secondthread() throws InterruptedException{
		// TODO Auto-generated method stub
		Random r=new Random();
		for(int i=0;i<10000;i++) {
			aquirelock(lock2,lock1);
			try {
			account.transfer(acc2, acc1, r.nextInt(100));
			}
			finally {
			lock1.unlock();
			lock2.unlock();
			}
			
		}
		
		
	}

	public void finsihed() {
		// TODO Auto-generated method stub
		System.out.println("account 1 balance is"+acc1.getbalance()+"Account 2 balance is "+acc2.getbalance());
		System.out.println("Total Balnce is"+(acc1.getbalance()+acc2.getbalance()));
	}

}
