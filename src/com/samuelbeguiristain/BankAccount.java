/**
 * AUTHOR: SAMUEL A. BEGUIRISTAIN
 * DATE: APRIL 20th, 2018
 * STUDENT ID: 1001532454
 * COP2800-2183-2912
 * FINAL PROJECT
 * */

package com.samuelbeguiristain;

public abstract class BankAccount {
    /** The constructor should accept arguments for the balance and annual interest rate */
    BankAccount() {}
    /** A method that accepts an argument for the amount of deposit.
     * The method should add the argument to the account balance.
     * It should also increment the variable holding the number of deposits. */
    public double deposit(double getDepositAmount) {
        return 0;
    }
    /** A method that accepts an argument for the amount of the withdrawal.
     * The method should subtract the argument from the balance.
     * It should also increment the variable holding the number of withdrawals. */
    public double withdraw(double getWithdrawAmount) {
        return 0;
    }
    /** A method that updates the balance by calculating the monthly interest earned by the account,
     * and adding this interest to the balance.
     * This is performed by the following formulas:
     Monthly Interest Rate = (Annual Interest Rate/12)
     Monthly Interest = Balance * Monthly Interest Rate
     Balance = Balance + Monthly Interest */
    public double calcInterest() {
        return 0;
    }
    /** A method that subtracts the monthly service charges from
     * the balance, calls the calcInterest method, and then sets
     * the variable that hold the number of withdrawals, number
     * of deposits and monthly service charge to zero. */
    public double monthlyProcess() {
        return 0;
    }

    public class SavingAccount extends BankAccount {
        /** A method that determines whether the account is
         * inactive before a withdrawal is made. No withdrawal
         * will be allowed if the account is not active. A withdrawal
         * is then made by calling the super-class version of the method. */
        public double withdraw(double getWithdrawAmount) {
            return 1;
        }
        /** A method that determines whether the account is inactive
         * before a deposit is made. If the account is inactive and
         * the deposit brings the balance above $25, the account becomes
         * active again. The deposit is then made by calling the
         * super-class version of the method. */
        public double deposit(double getDepositAmount) {
            return 1;
        }
        /**  Before the super-class method is called, this method checks
         * the number of withdrawals. If the number of withdrawals for the
         * month is more than 4, a service charge of $1 for each withdrawal
         * above 4 is added to the super-class fields that holds the monthly
         * service charges. (Don’t forget the check the account balance after
         * the service charge is taken. If the balance falls below $25, the
         * account becomes inactive.) */
        public double monthlyProcess() {
            return 1;
        }
    }
}