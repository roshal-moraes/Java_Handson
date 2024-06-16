package com.self.threads;

class AccountRunnable implements Runnable {
    private BankAccount account;
    private int withdrawAmount;

    public AccountRunnable(BankAccount account, int withdrawAmount) {
        this.account = account;
        this.withdrawAmount = withdrawAmount;
    }

    @Override
    public void run() {
        account.makeWithdraw(withdrawAmount);
        account.makeWithdraw2(withdrawAmount);
        System.out.println("Balance after " + Thread.currentThread().getName() + " withdraws: " + account.getBalance());
    }
}
