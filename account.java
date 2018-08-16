package banking;

 class account {
	private int balance=10000;
	
	

	public void add(int amount) {
		// TODO Auto-generated method stub
		balance+=amount;
		
	}

	public void remove(int amount) {
		// TODO Auto-generated method stub
		balance-=amount;
		
	}

	public int getbalance() {
		// TODO Auto-generated method stub
		return balance;
	}
	public static void transfer(account acc1, account acc2, int amount) throws InterruptedException {
		
		// TODO Auto-generated method stub
		acc1.remove(amount);
		acc2.add(amount);
		
	}

}
