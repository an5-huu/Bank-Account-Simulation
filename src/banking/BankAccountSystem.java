package banking;

import banking.model.Account;
import banking.service.Bank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BankAccountSystem {
    private BufferedReader reader;
    private Bank bank;

    public BankAccountSystem(){
        this.reader= new BufferedReader(new InputStreamReader(System.in));  // for up BufferedReader  for user i/p
        this.bank=new Bank();
    }

    public void start() {
        while(true) {
            displayMenu();
            try {
                String input = reader.readLine();
                if (input == null)
                    break; // handle end of file (EOF)

                int choice = Integer.parseInt(input); // convert integer into input

                switch (choice) {
                    case 1:
                        createAccount();
                        break;
                    case 2:
                        performTransaction();
                        break;
                    case 3:
                        displayTransactionHistory();
                        break;
                    case 4:
                        System.out.println("Thank you for using our banking system.");
                        return;
                    default:
                        System.out.println("Please try again");
                }
            } catch (NumberFormatException e) { // will handle non-numeric i/p
                System.out.println("Enter a valid number.");
            } catch (IOException e) { // will handle errors
                System.out.println("ERROR: " + e.getMessage());
                return;
            }
        }
    }

                // for account creation method
            public void createAccount() throws IOException {
                System.out.print("Enter account number: ");
                String accountNumber= reader.readLine();

                System.out.print("Enter initial balance: ");
                String balanceStr= reader.readLine();

                try{
                    double initialBalance= Double.parseDouble(balanceStr); // convert balance string into numeric value

                    Account account=new Account(accountNumber, initialBalance); // create new account instance
                    bank.addAccount(account);
                    System.out.println("Account created successfully!");
                }
                catch (NumberFormatException e){
                    System.out.println("Invalid amount, please try again.");
                }
            }

            // for transaction processing method
    private void performTransaction() throws IOException {
        System.out.print("Enter account number: ");
        String accountNumber= reader.readLine();
        Account account=bank.getAccount(accountNumber);

        // what if account doesn't exist
        if(account==null){
            System.out.println("Account not found");
            return;
        }


        // show transaction type options
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.print("Enter your choice: ");
        String transactionStr= reader.readLine();

        int transactionChoice;
        try{
            transactionChoice=Integer.parseInt(transactionStr);
        }
        catch (NumberFormatException e){
            System.out.println("Invalid transaction type.");
            return;
        }


        // will get transaction amount
        System.out.print("Enter amount: ");
        String amountStr = reader.readLine();
        try {
            double amount = Double.parseDouble(amountStr);
            // Execute transaction based on type
            if (transactionChoice == 1) {
                bank.depositMoney(accountNumber, amount);
                System.out.println("Deposit successful!");
            } else if (transactionChoice == 2) {
                bank.withdrawMoney(accountNumber, amount);
                System.out.println("Withdrawal successful!");
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a valid number.");
        }
    }

    public void displayTransactionHistory() throws IOException{
        System.out.print("Enter account number: ");
        String accountNumber = reader.readLine();
        Account account = bank.getAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("\nTransaction History for Account "+ accountNumber);
        System.out.println("----------------------------------------");

        // iterate through all transactions
        account.getTransactionHistory().forEach(transaction -> {
            System.out.printf(
                    "%s: %s $%.2f (Balance: $%.2f -> $%.2f)%n",
                    transaction.timestamp(),
                    transaction.type(),
                    transaction.amount(),
                    transaction.balanceBefore(),
                    transaction.balanceAfter()
            );
        });
        System.out.println("----------------------------------------");
    }

    private void displayMenu(){
        System.out.println("\nBank Account System");
        System.out.println("1. Create Account");
        System.out.println("2. Perform Transaction");
        System.out.println("3. View Transaction History");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        BankAccountSystem system= new BankAccountSystem();
        system.start();
    }
    }

