package banking.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(String accountNumber, double initialBalance){
        this.accountNumber=accountNumber;
        this.balance=initialBalance;
        this.transactionHistory=new ArrayList<>();

        // INITIAL means starting state of the account,a 1. initialBalance means account being recorded, 2. means balance before transaction and 3. means after transaction
        recordTransaction("INITIAL", initialBalance, initialBalance, initialBalance);
    }
    public void deposit(double amount){
        if(amount<=0){
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        double previousBalance= balance;
        balance=balance+amount;
        recordTransaction("DEPOSIT", amount, previousBalance, balance);
    }

    public void withdraw(double amount){
        if(amount<=0){
            throw new IllegalArgumentException("Withdrawal must be positive.");
        }
        if(amount>balance){
            throw new IllegalArgumentException("Insufficient funds");
        }
        double previousBalance= balance;
        balance= balance-amount;
        recordTransaction("WITHDRAWAL", amount, previousBalance, balance);
    }
    private void recordTransaction(String type, double amount, double balanceBefore, double balanceAfter) {
        transactionHistory.add(new Transaction(
                type,
                amount,
                balanceBefore,
                balanceAfter,
                LocalDateTime.now()
        ));
    }
    public double getBalance(){
        return balance;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public List<Transaction> getTransactionHistory(){
        return new ArrayList<>(transactionHistory);
    }
}
