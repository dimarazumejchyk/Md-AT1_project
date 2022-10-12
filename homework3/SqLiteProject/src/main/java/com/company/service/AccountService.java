package com.company.service;

import com.company.model.Account;

import java.util.Scanner;

public class AccountService {
    public static Account inputAccount() {
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter userId:");
        account.setUserId(scanner.nextInt());


        int choiceCurrency;

        do {
            System.out.println("Enter currency:");
            System.out.println("1 - EUR");
            System.out.println("2 - USD");
            System.out.println("3 - BYN");

            choiceCurrency = scanner.nextInt();


            switch (choiceCurrency) {
                case 1:
                    account.setCurrency("EUR");
                    break;
                case 2:
                    account.setCurrency("USD");
                    break;
                case 3:
                    account.setCurrency("BYN");
                    break;
                default:
                    System.out.println("Incorrect input");
                    break;
            }
        } while (choiceCurrency < 1 || choiceCurrency > 3);
        return account;
    }
}
