package com.company.model;

public class Account {
    private  int accountId;
    private  int userId;
    private  int balance;
    private String currency;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (accountId != account.accountId) return false;
        if (userId != account.userId) return false;
        if (balance != account.balance) return false;
        return currency.equals(account.currency);
    }

    @Override
    public int hashCode() {
        int result = accountId;
        result = 31 * result + userId;
        result = 31 * result + balance;
        result = 31 * result + currency.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", userId=" + userId +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                '}';
    }
}

