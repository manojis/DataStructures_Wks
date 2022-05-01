package com.Java_Experimentation.threads;

public class AccountLedger implements Runnable {

    private Account account = new Account();

    @Override
    public void run(){
        for(int x=0; x<5; x++) {
            makeWithDrawal(10);
            if(account.getBalance() < 0){
                System.out.println(" account is overdrawn");
            }
        }
    }

    private void makeWithDrawal(int amount){
        if(account.getBalance() >= amount){
            System.out.println(Thread.currentThread().getName()
                    + " about to withdraw");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName()
                    + " completes the withdrawal");
        } else {
            System.out.println("Not enough in the account for "
                    + Thread.currentThread().getName()
                    + " withdraw " + account.getBalance());
        }
    }

    public static void main(String[] args) {

        AccountLedger ld = new AccountLedger();
        Thread one = new Thread(ld);
        one.setName("Arya");
        one.start();
        Thread two = new Thread(ld);
        two.setName("Manoj");
        two.start();
    }
}
