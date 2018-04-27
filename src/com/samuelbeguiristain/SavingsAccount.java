package com.samuelbeguiristain;

public class SavingsAccount extends BankAccount {

    private boolean status;

    public SavingsAccount(double bal, double intRate, double mon){
        super(bal, intRate, mon);
        status = getBalance() > 25;
    }

    public void withdraw(double amount){
        if(status){
            super.withdraw(amount);
            status = getBalance() > 25;
        }
    }

    public void deposit(double amount){

        super.deposit(amount);
        if(!status && super.getBalance() > 25){
            status = true;
        }
    }

    public void monthlyProcess(){
        if(super.getNumWithdrawals() > 4){
            int numOver = getNumWithdrawals() - 4;
            double monthlyCharge = numOver * 1;
            super.setMonthlyServiceCharge(monthlyCharge);
        }
        super.monthlyProcess();
        status = !(getBalance() < 25);
    }
}
