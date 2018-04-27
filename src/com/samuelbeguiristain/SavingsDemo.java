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
                new SavingsAccount(500.0, 0.03, 1.00);
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


        savings.deposit(23.98);
        savings.deposit(16.36);
        savings.deposit(21.01);

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


        savings.withdraw(69.69);
        savings.withdraw(41.52);
        savings.withdraw(100.51);
        savings.withdraw(36.30);
        savings.withdraw(1.00);
        savings.withdraw(1.00);
        savings.withdraw(1.00);

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