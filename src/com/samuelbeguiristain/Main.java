/**
 * AUTHOR: SAMUEL A. BEGUIRISTAIN
 * DATE: APRIL 20th, 2018
 * STUDENT ID: 1001532454
 * COP2800-2183-2912
 * FINAL PROJECT
 * */
package com.samuelbeguiristain;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.text.DecimalFormat;


    public class Main extends Application {

    Stage window;
    Scene balanceScene, interestScene, serviceScene, withdrawScene, depositScene, mainMenu;
    Button balanceButton, interestButton, serviceButton, monthsButton, withdrawButton,
            depositButton, calculateButton, primeDeposit, primeWithdraw, newMonth;
    double balanceInput, interestInput,
            serviceInput;
    int counter = 1;
    SavingsAccount savings;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Bank Account Demo");
        DecimalFormat dollar = new DecimalFormat("$#,##0.00");

        //Form
        TextField balance = new TextField();
        balance.setPromptText("Enter Balance");
        TextField interestRate = new TextField();
        interestRate.setPromptText("Enter Interest Rate");
        TextField monthlyServiceCharge = new TextField();
        monthlyServiceCharge.setPromptText("Enter Service Charge");
        TextField textMonths = new TextField();
        textMonths.setPromptText("Amount of Months");
        TextField withdrawAmount = new TextField();
        withdrawAmount.setPromptText("Enter Withdraw Amount");
        TextField depositAmount = new TextField();
        depositAmount.setPromptText("Enter Deposit Amount");

        //Buttons
        balanceButton = new Button("Enter");
        interestButton = new Button("Enter");
        serviceButton = new Button("Enter");
        monthsButton = new Button("Enter");
        withdrawButton = new Button("Enter");
        depositButton = new Button("Enter");
        calculateButton = new Button("Calculate");
        primeDeposit = new Button("Deposit");
        primeWithdraw = new Button("Withdraw");
        newMonth = new Button("New Month");

        //Button Actions
        balanceButton.setOnAction( e ->{
            isDouble(balance, balance.getText());
            balanceInput = Double.parseDouble(balance.getText());
            window.setScene(interestScene);
            savings = new SavingsAccount(balanceInput, interestInput, serviceInput);
        });
        interestButton.setOnAction( e ->{
            isDouble(interestRate, interestRate.getText());
            savings.setInterestRate(Double.parseDouble(interestRate.getText()));
            window.setScene(serviceScene);
        });
        serviceButton.setOnAction( e ->{
            isDouble(monthlyServiceCharge, monthlyServiceCharge.getText());
            savings.setMonthlyServiceCharge(Double.parseDouble(monthlyServiceCharge.getText()));
            window.setScene(mainMenu);
        });

        //Calculations
        calculateButton.setOnAction( e ->{
                System.out.println("Month: " + counter);
                System.out.println("Balance: " +
                        dollar.format(savings.getBalance()));
                System.out.println("Number of deposits: " +
                        savings.getNumDeposits());
                System.out.println("Number of withdrawals: " +
                        savings.getNumWithdrawals());
                System.out.println("Interest Rate: " + savings.getInterestRate());
                System.out.println("Monthly Service Charges: " + savings.getMonthlyServiceCharges());
        });
        withdrawButton.setOnAction( e ->{
            isDouble(withdrawAmount, withdrawAmount.getText());
            savings.withdraw(Double.parseDouble(withdrawAmount.getText()));
            window.setScene(mainMenu);
        });
        depositButton.setOnAction( e ->{
            isDouble(depositAmount, depositAmount.getText());
            savings.deposit(Double.parseDouble(depositAmount.getText()));
            window.setScene(mainMenu);
        });
        primeWithdraw.setOnAction( e -> window.setScene(withdrawScene));
        primeDeposit.setOnAction( e -> window.setScene(depositScene));
        newMonth.setOnAction( e ->{
            savings.monthlyProcess();
            System.out.println("Month: " + (counter++));
            System.out.println("Balance: " +
                    dollar.format(savings.getBalance()));
            System.out.println("Number of deposits: " +
                    savings.getNumDeposits());
            System.out.println("Number of withdrawals: " +
                    savings.getNumWithdrawals());
            System.out.println("Interest Rate: " +
                    savings.getInterestRate());
            System.out.println("Monthly Service Charges: " +
                    savings.getMonthlyServiceCharges());
            window.setScene(serviceScene);

        });

        //Layout
        VBox balanceLayout = new VBox(10);
        balanceLayout.setPadding(new Insets(20, 20, 20, 20));
        Text balanceText = new Text("Enter Balance: ");
        balanceLayout.getChildren().addAll(balanceText, balance, balanceButton);

        VBox interestLayout = new VBox(10);
        interestLayout.setPadding(new Insets(20, 20, 20, 20));
        Text interestText = new Text("Enter Interest Rate: ");
        interestLayout.getChildren().addAll(interestText, interestRate, interestButton);

        VBox serviceLayout = new VBox(10);
        serviceLayout.setPadding(new Insets(20, 20, 20, 20));
        Text serviceText = new Text("Enter Monthly Service Charge: ");
        serviceLayout.getChildren().addAll(serviceText, monthlyServiceCharge, serviceButton);

        StackPane menuDepositWithdraw = new StackPane();
        menuDepositWithdraw.setPadding(new Insets(20, 20, 20, 20));
        Text menuText = new Text("What would you like to do?");
        StackPane.setAlignment(menuText, Pos.TOP_LEFT);
        StackPane.setAlignment(calculateButton, Pos.CENTER);
        StackPane.setAlignment(primeDeposit, Pos.CENTER_LEFT);
        StackPane.setAlignment(primeWithdraw, Pos.CENTER_RIGHT);
        StackPane.setAlignment(newMonth, Pos. BOTTOM_CENTER);
        menuDepositWithdraw.getChildren().addAll(calculateButton, primeDeposit, primeWithdraw, newMonth);

        VBox depositLayout = new VBox(10);
        depositLayout.setPadding(new Insets(20, 20, 20, 20));
        Text depositText = new Text("Enter Deposit Amount: ");
        depositLayout.getChildren().addAll(depositText, depositAmount, depositButton);

        VBox withdrawLayout = new VBox(10);
        withdrawLayout.setPadding(new Insets(20, 20, 20, 20));
        Text withdrawText = new Text("Enter Withdraw Amount: ");
        withdrawLayout.getChildren().addAll(withdrawText, withdrawAmount, withdrawButton);


        balanceScene = new Scene(balanceLayout, 300, 120);
        interestScene = new Scene(interestLayout, 300, 120);
        serviceScene = new Scene(serviceLayout, 300, 120);
        withdrawScene = new Scene(withdrawLayout, 300, 120);
        depositScene = new Scene(depositLayout, 300, 120);
        mainMenu = new Scene(menuDepositWithdraw, 300, 120);

        window.setScene(balanceScene);
        window.show();
    }

    //Validate data
    private void isDouble(TextField input, String message){
        try{
            double number = Double.parseDouble(input.getText());
            System.out.println("Entered: " + number);
        }catch(NumberFormatException e){
            System.out.println("Error: " + message + " is not a valid number!");
        }
    }
    private void isInt(TextField input, String message){
        try{
            int number = Integer.parseInt(input.getText());
            System.out.println("Entered: " + number);
        }catch(NumberFormatException e){
            System.out.println("Error: " + message + " is not a valid number!");
        }
    }


}