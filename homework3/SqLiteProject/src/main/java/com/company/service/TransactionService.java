package com.company.service;

import com.company.model.Transaction;

import java.util.Scanner;

public class TransactionService {

    public static Transaction transactions() {
        Transaction transaction = new Transaction();
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.println("Enter value between 1-100000: ");
            number = scanner.nextInt();
        } while (number < 0 || number > 100000);
        //System.out.println("correct amount " + number);
        transaction.setAmount(number);
        return transaction;
    }

}
