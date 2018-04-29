/**
 * AUTHOR: SAMUEL A. BEGUIRISTAIN
 * DATE: APRIL 20th, 2018
 * STUDENT ID: 1001532454
 * COP2800-2183-2912
 * FINAL PROJECT
 * */
package com.samuelbeguiristain;

import java.io.*;
import java.text.DecimalFormat;

public class SavingsDemo
{
    public static void main(String[] args) throws FileNotFoundException
    {
        PrintWriter writer = new PrintWriter("output.txt");

        DecimalFormat dollar = new DecimalFormat("$#,##0.00");

        SavingsAccount savings =
                new SavingsAccount(1000, 0.03, 1.00);
        System.out.println("Balance: " +
                dollar.format(savings.getBalance()));
        System.out.println("Number of deposits: " +
                savings.getNumDeposits());
        System.out.println("Number of withdrawals: " +
                savings.getNumWithdrawals());
        System.out.println();

        // Write to file
        writer.println("Balance: " +
                dollar.format(savings.getBalance()));
        writer.println("Number of deposits: " +
                savings.getNumDeposits());
        writer.println("Number of withdrawals: " +
                savings.getNumWithdrawals());
        writer.println();


        savings.deposit(100);
        savings.deposit(100);
        savings.deposit(100);
        savings.withdraw(500);

        System.out.println("Balance: " +
                dollar.format(savings.getBalance()));
        System.out.println("Number of deposits: " +
                savings.getNumDeposits());
        System.out.println("Number of withdrawals: " +
                savings.getNumWithdrawals());
        System.out.println();

        //Write to file
        writer.println("Balance: " +
                dollar.format(savings.getBalance()));
        writer.println("Number of deposits: " +
                savings.getNumDeposits());
        writer.println("Number of withdrawals: " +
                savings.getNumWithdrawals());
        writer.println();

        savings.deposit(100);
        savings.withdraw(100);
        savings.withdraw(100);
        savings.withdraw(110);
        savings.withdraw(110);
        savings.withdraw(50);
        savings.withdraw(20);
        savings.withdraw(10);

        System.out.println("Balance: " +
                dollar.format(savings.getBalance()));
        System.out.println("Number of deposits: " +
                savings.getNumDeposits());
        System.out.println("Number of withdrawals: " +
                savings.getNumWithdrawals());
        System.out.println();

        //Write to file
        writer.println("Balance: " +
                dollar.format(savings.getBalance()));
        writer.println("Number of deposits: " +
                savings.getNumDeposits());
        writer.println("Number of withdrawals: " +
                savings.getNumWithdrawals());
        writer.println();

        savings.monthlyProcess();

        System.out.println("Balance: " +
                dollar.format(savings.getBalance()));
        System.out.println("Number of deposits: " +
                savings.getNumDeposits());
        System.out.println("Number of withdrawals: " +
                savings.getNumWithdrawals());

        //Write to file
        writer.println("Balance: " +
                dollar.format(savings.getBalance()));
        writer.println("Number of deposits: " +
                savings.getNumDeposits());
        writer.println("Number of withdrawals: " +
                savings.getNumWithdrawals());
        writer.println();

        writer.close();
    }
}