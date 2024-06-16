package com.self.threads;

class BankAccount {
    private int balance;
    //To be used in synchronized block, must be object
    private Integer balance2;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
        this.balance2 = initialBalance;
    }

    synchronized void makeWithdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw");
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " has withdrawn " + amount);
        } else {
            System.out.println("Sorry, not enough balance for " + Thread.currentThread().getName());
        }
    }
    
    //We can also have only a block synhronized
    void makeWithdraw2(int amount) {
    	synchronized (balance2) {

        if (balance2 >= amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw");
            balance2 -= amount;
            System.out.println(Thread.currentThread().getName() + " has withdrawn " + amount);
        } else {
            System.out.println("Sorry, not enough balance for " + Thread.currentThread().getName());
        }
    	}
    	System.out.println("outside sync block " );
        

    }

    synchronized int getBalance() {
        return balance;
    }
}


