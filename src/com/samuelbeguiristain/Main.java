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
    Scene balanceScene, interestScene, serviceScene, totalMonths, withdrawScene, depositScene;
    Button balanceButton, interestButton, serviceButton, monthsButton, withdrawButton, depositButton, calculateButton;
    double balanceInput, interestInput,
            serviceInput, withdrawInput, depositInput;
    int monthsInput, counter = 0;
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

        //Button Actions
        balanceButton.setOnAction( e ->{
            isDouble(balance, balance.getText());
            balanceInput = Double.parseDouble(balance.getText());
            window.setScene(interestScene);
            savings = new SavingsAccount(balanceInput, interestInput, monthsInput);
        });
        interestButton.setOnAction( e ->{
            isDouble(interestRate, interestRate.getText());
            interestInput = Double.parseDouble(interestRate.getText());
            window.setScene(serviceScene);
        });
        serviceButton.setOnAction( e ->{
            isDouble(monthlyServiceCharge, monthlyServiceCharge.getText());
            serviceInput = Double.parseDouble(monthlyServiceCharge.getText());
            window.setScene(totalMonths);
        });
        monthsButton.setOnAction( e ->{
            isInt(textMonths, textMonths.getText());
            monthsInput = Integer.parseInt(textMonths.getText());
        });

        //Calculations
        calculateButton.setOnAction( e ->{
                System.out.println("Month: " + (counter++));
                System.out.println("Balance: " +
                        dollar.format(savings.getBalance()));
                System.out.println("Number of deposits: " +
                        savings.getNumDeposits());
                System.out.println("Number of withdrawals: " +
                        savings.getNumWithdrawals());
        });
        withdrawButton.setOnAction( e ->{
            isDouble(withdrawAmount, withdrawAmount.getText());
            savings.withdraw(Double.parseDouble(withdrawAmount.getText()));
        });
        depositButton.setOnAction( e ->{
            isDouble(depositAmount, depositAmount.getText());
            savings.deposit(Double.parseDouble(depositAmount.getText()));
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
        Text serviceText = new Text("Enter Monthly Service Fee: ");
        serviceLayout.getChildren().addAll(serviceText, monthlyServiceCharge, serviceButton);

        StackPane monthsLayout = new StackPane();
        monthsLayout.setPadding(new Insets(20, 20, 20, 20));
        Text monthsLayoutText = new Text("Enter the amount of months: ");
        StackPane.setAlignment(monthsLayoutText, Pos.TOP_LEFT);
        StackPane.setAlignment(textMonths, Pos.CENTER_LEFT);
        StackPane.setAlignment(monthsButton, Pos.BOTTOM_LEFT);
        StackPane.setAlignment(calculateButton, Pos.BOTTOM_CENTER);
        monthsLayout.getChildren().addAll(monthsLayoutText, textMonths, monthsButton, calculateButton);

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
        totalMonths = new Scene(monthsLayout, 300, 120);
        withdrawScene = new Scene(withdrawLayout, 300, 120);
        depositScene = new Scene(depositLayout, 300, 120);

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