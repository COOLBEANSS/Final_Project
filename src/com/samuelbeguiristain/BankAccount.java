/**
 * AUTHOR: SAMUEL A. BEGUIRISTAIN
 * DATE: APRIL 20th, 2018
 * STUDENT ID: 1001532454
 * COP2800-2183-2912
 * FINAL PROJECT
 * */

package com.samuelbeguiristain;

public abstract class BankAccount {
    private double balance;
    private int numDeposits;
    private int numWithdrawals;
    private double monthlyServiceCharge;
    private double interestRate;

    /**
     * The constructor should accept arguments for the balance and annual interest rate
     */
    public BankAccount(double bal, double intRate, double mon) {
        balance = bal;
        interestRate = intRate;
        monthlyServiceCharge = mon;
    }

    /**
     * A method that accepts an argument for the amount of deposit.
     * The method should add the argument to the account balance.
     * It should also increment the variable holding the number of deposits.
     */
    public void deposit(double amount) {
        balance += amount;
        numDeposits++;
    }

    /**
     * A method that accepts an argument for the amount of the withdrawal.
     * The method should subtract the argument from the balance.
     * It should also increment the variable holding the number of withdrawals.
     */
    public void withdraw(double amount) {
        if (balance > amount) {
            balance -= amount;
            numWithdrawals++;
        }
    }

    /**
     * A method that updates the balance by calculating the monthly interest earned by the account,
     * and adding this interest to the balance.
     * This is performed by the following formulas:
     * Monthly Interest Rate = (Annual Interest Rate/12)
     * Monthly Interest = Balance * Monthly Interest Rate
     * Balance = Balance + Monthly Interest
     */
    private void calcInterest() {
        double monthlyInterestRate = interestRate / 12;
        double monthlyInterest = balance * monthlyInterestRate;
        balance += monthlyInterest;
    }

    /**
     * A method that subtracts the monthly service charges from
     * the balance, calls the calcInterest method, and then sets
     * the variable that hold the number of withdrawals, number
     * of deposits and monthly service charge to zero.
     */
    public void monthlyProcess() {
        balance -= monthlyServiceCharge;
        calcInterest();
        numWithdrawals = 0;
        numDeposits = 0;
        monthlyServiceCharge = 0;
    }

    /** Below are getter methods */

    public void setMonthlyServiceCharge(double amount){
        monthlyServiceCharge = amount;
    }

    public void setInterestRate(double interest){
        interestRate = interest;
    }

    public double getBalance(){
        return balance;
    }

    public int getNumDeposits(){
        return numDeposits;
    }

    public int getNumWithdrawals(){
        return numWithdrawals;
    }

    public double getInterestRate(){
        return interestRate;
    }

    public double getMonthlyServiceCharges(){
        return monthlyServiceCharge;
    }
}