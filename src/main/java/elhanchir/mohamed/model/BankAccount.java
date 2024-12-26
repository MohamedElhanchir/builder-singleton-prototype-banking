package elhanchir.mohamed.model;

import elhanchir.mohamed.enums.AccountStatus;
import elhanchir.mohamed.enums.AccountType;

public class BankAccount implements Cloneable{
    private Long accountId;
    private double balance;
    private String currency;
    private AccountType accountType;
    private AccountStatus accountStatus;

    public BankAccount(Long accountId, double balance, String currency, AccountType accountType, AccountStatus accountStatus) {
        this.accountId = accountId;
        this.balance = balance;
        this.currency = currency;
        this.accountType = accountType;
        this.accountStatus = accountStatus;
    }

    public BankAccount() {
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountId=" + accountId +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", accountType=" + accountType +
                ", accountStatus=" + accountStatus +
                '}';
    }

    @Override
    public BankAccount clone() throws CloneNotSupportedException {
        return (BankAccount) super.clone();
    }

    public static AccountBuilder builder(){
        return new AccountBuilder();
    }

    public static class AccountBuilder {
        private BankAccount bankAccount=new BankAccount();

        public AccountBuilder accoundId(Long accountId){
            bankAccount.setAccountId(accountId);
            return this;
        }

        public AccountBuilder balance(double balance){
            bankAccount.setBalance(balance);
            return this;
        }

        public AccountBuilder currency(String currency){
            bankAccount.setCurrency(currency);
            return this;
        }

        public AccountBuilder accountType(AccountType accountType){
            bankAccount.setAccountType(accountType);
            return this;
        }

        public AccountBuilder accountStatus(AccountStatus accountStatus){
            bankAccount.setAccountStatus(accountStatus);
            return this;
        }

        public BankAccount build(){
            return bankAccount;
        }
    }
}


