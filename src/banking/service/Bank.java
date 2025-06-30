package banking.service;

import banking.model.Account;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts;
    public Bank(){
        this.accounts=new HashMap<>();
    }
    public void addAccount(Account account){
        accounts.put(account.getAccountNumber(), account);
    }
    public void removeAccount(String accountNumber){
        accounts.remove(accountNumber);
    }

    public void depositMoney(String accountNumber, double amount){
        Account account = accounts.get(accountNumber);
        if(account!= null){
            account.deposit(amount);
        }
        else {
            throw new IllegalArgumentException("Unable to find account");
        }
    }

    public void withdrawMoney(String accountNumber, double amount){
        Account account=accounts.get(accountNumber);
        if(account!= null){
            account.withdraw(amount);
        }
        else {
            throw new IllegalArgumentException("Unable to find account");
        }
    }

    public Account getAccount(String accountNumber){
        return accounts.get(accountNumber);
    }
}
