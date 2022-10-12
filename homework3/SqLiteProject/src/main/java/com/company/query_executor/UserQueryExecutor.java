package com.company.query_executor;

import com.company.model.Account;
import com.company.model.Transaction;
import com.company.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.String.format;

public class UserQueryExecutor {

    public static void addUser(Connection connection, User user) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(format("INSERT INTO Users (name, address) VALUES('%s', '%s')",
                user.getName(), user.getAddress()));
        ResultSet resultSet = statement.executeQuery(format("SELECT * FROM Users WHERE name = '%s';",
                user.getName()));
        System.out.println("Your userId: " + resultSet.getInt("userId"));
        statement.close();
        resultSet.close();
    }

    public static void addAccount(Connection connection, Account account) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(format("INSERT INTO Accounts (userId, currency) VALUES('%d', '%s');",
                account.getUserId(), account.getCurrency()));
        checkingBalance(connection, account.getUserId());
        statement.close();
    }

    public static int checkAccount(Connection connection, int userId, Account account) throws SQLException {
        int num;
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(format("SELECT COUNT(*) FROM Accounts WHERE userId = %d;",
                userId));
       if (resultSet.getInt("COUNT(*)") == 0) {
            num = 0;
           resultSet.close();
       } else { ResultSet resultSet1 =
               statement.executeQuery(format("SELECT COUNT(*) FROM Accounts WHERE userId = %d AND currency = '%s';",
                            userId, account.getCurrency()));
            num = resultSet1.getInt("COUNT(*)");
            resultSet1.close();
        }
        statement.close();
        return num;
    }

    public static void replenishmentBalance(Connection connection, Transaction transaction, int accountReplenishment)
            throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(format("SELECT * FROM Accounts WHERE accountId = %d;",
                accountReplenishment));
        int balance = resultSet.getInt("balance");

        statement.executeUpdate(format("INSERT INTO Transactions (accountId, amount) VALUES('%d', '%d');",
                accountReplenishment, transaction.getAmount()));

        statement.executeUpdate(format("UPDATE Accounts SET balance = %d WHERE accountId = %d;",
                (balance + transaction.getAmount()), accountReplenishment));

        System.out.println("Your current balance: " + (balance + transaction.getAmount()));

        resultSet.close();
        statement.close();
    }

    public static void withdrawalsBalance(Connection connection, Transaction transaction, int accountWithdrawals)
            throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(format("SELECT * FROM Accounts WHERE accountId = %d;",
                accountWithdrawals));
        int balance = resultSet.getInt("balance");

        statement.executeUpdate(format("INSERT INTO Transactions (accountId, amount) VALUES('%d', '-%d');",
                accountWithdrawals, transaction.getAmount()));

        statement.executeUpdate(format("UPDATE Accounts SET balance = %d WHERE accountId = %d;",
                (balance - transaction.getAmount()), accountWithdrawals));

        System.out.println("Your current balance: " + (balance - transaction.getAmount()));

        resultSet.close();
        statement.close();
    }

    public static int checkBalance(Connection connection, int accountId) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(format("SELECT * FROM Accounts WHERE accountId = %d;",
                accountId));
        int balanceCheck = resultSet.getInt("balance");
        resultSet.close();
        statement.close();
        return balanceCheck;

    }

    public static void checkingBalance(Connection connection, int userId) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(format("SELECT * FROM Accounts WHERE userId = %d;",
                userId));
        while (resultSet.next()) {
            System.out.println("\n" + "accountId: " + resultSet.getInt("accountId"));
            System.out.println("balance: " + resultSet.getInt("balance") + " " + resultSet.getString("currency"));
        }
        resultSet.close();
        statement.close();
    }


}
