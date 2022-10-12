package com.company.demo;

import com.company.model.Account;
import com.company.model.Transaction;
import com.company.model.User;
import com.company.service.AccountService;
import com.company.service.TransactionService;
import com.company.service.UserService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.query_executor.UserQueryExecutor.addAccount;
import static com.company.query_executor.UserQueryExecutor.addUser;
import static com.company.query_executor.UserQueryExecutor.checkAccount;
import static com.company.query_executor.UserQueryExecutor.checkBalance;
import static com.company.query_executor.UserQueryExecutor.checkingBalance;
import static com.company.query_executor.UserQueryExecutor.replenishmentBalance;
import static com.company.query_executor.UserQueryExecutor.withdrawalsBalance;

public class AplicationDb {
    private static final String JDBC_DRIVER_PATH = "org.sqlite.JDBC";
    private static final String DATABASE_URL = "jdbc:sqlite:d:\\Md-AT1_project\\homework3\\SqLiteProject\\mySqlDb.db";

    public static void main(String[] args) throws SQLException {
        if (isDriverExist()) {
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            int action;
            do {
                printMenu();
                action = new Scanner(System.in).nextInt();
                switch (action) {
                    case 1:
                        User user = UserService.inputUser();
                        addUser(connection, user);
                        break;


                    case 2:
                        Account account = AccountService.inputAccount();
                        if (checkAccount(connection, account.getUserId(), account) > 0) {
                            System.out.println("You already have an account in this currency");
                        } else
                        addAccount(connection, account);
                        break;


                    case 3:
                        System.out.println("Enter accountId for Replenishment: ");
                        int accountReplenishment = new Scanner(System.in).nextInt();
                        System.out.println("Enter the deposit amount: ");
                        Transaction transactionReplenishment = TransactionService.transactions();
                        if ((checkBalance(connection, accountReplenishment) + transactionReplenishment.getAmount())
                                <= 2000000) {
                            replenishmentBalance(connection, transactionReplenishment, accountReplenishment);
                        } else {
                            System.out.println("The balance cannot exceed 2 000 000 ");
                        }
                        break;
                    case 4:
                        System.out.println("Enter accountId for Withdrawals: ");
                        int accountWithdrawals = new Scanner(System.in).nextInt();
                        System.out.println("Enter the withdrawal amount: ");
                        Transaction transactionWithdrawals = TransactionService.transactions();
                        if ((checkBalance(connection, accountWithdrawals) - transactionWithdrawals.getAmount()) >= 0) {
                            withdrawalsBalance(connection, transactionWithdrawals, accountWithdrawals);
                        } else
                            System.out.println("The amount to withdraw exceeds the balance ");
                        break;
                    case 5:
                        System.out.println("Enter userId for checking: ");
                        int checkUserId = new Scanner(System.in).nextInt();
                        checkingBalance(connection, checkUserId);
                        break;
                    case 6:
                        System.out.println("Thanks for using the system");
                        connection.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Select an action from the list:");
                        break;
                }
            } while (true);

        }

    }

    private static void printMenu() {
        System.out.println("Select the desired action:");
        System.out.println("1 - Registration of a new user");
        System.out.println("2 - Adding a new account to a user");
        System.out.println("3 - Replenishment of an existing account");
        System.out.println("4 - Withdrawal of funds from an existing account");
        System.out.println("5 - Checking the balance");
        System.out.println("6 - Finish working with the program");
    }

    public static boolean isDriverExist() {
        try {
            Class.forName(JDBC_DRIVER_PATH);
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC Driver was not found");
            return false;
        }
    }
}
