package money;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Bank bank = new Bank();

        System.out.println("Welcome to the ATM!");
        
        String userId = null;
        String userPin = null;


      

        while (true) {
            System.out.println("\nATM Functionalities:");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            System.out.println("\nEnter your choice:");
            int choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    bank.displayTransactionHistory();
                    break;
                case 2:
                	System.out.println("Enter user ID:");
                    userId = reader.readLine();
                    System.out.println("Enter user PIN:");
                    userPin = reader.readLine();
                	 if (bank.authenticateUser(userId, userPin)) {
                         System.out.println("Authentication successful!");
                        
                     } else {
                         System.out.println("Invalid user id or pin. Please try again.");
                         break;
                     }

                     System.out.println("Enter the withdrawal amount:");
                     double withdrawalAmount = Double.parseDouble(reader.readLine());
                     bank.withdraw(userId,withdrawalAmount);
                     break;
                case 3:
                	System.out.println("Enter user ID:");
                    userId = reader.readLine();
                    System.out.println("Enter user PIN:");
                    userPin = reader.readLine();
                	 if (bank.authenticateUser(userId, userPin)) {
                         System.out.println("Authentication successful!");
                     } else {
                         System.out.println("Invalid user id or pin. Please try again.");
                         break;
                     }

                     System.out.println("Enter the deposit amount:");
                     double depositAmount = Double.parseDouble(reader.readLine());
                     bank.deposit(userId,depositAmount);
                     break;
                    
                case 4:
                	 if (bank.authenticateUser(userId, userPin)) {
                         System.out.println("Authentication successful!");
                     } else {
                         System.out.println("Invalid user id or pin. Please try again.");
                         break;
                     }

                     System.out.println("Enter the recipient user id:");
                     String recipientId = reader.readLine();
                     System.out.println("Enter the transfer amount:");
                     double transferAmount = Double.parseDouble(reader.readLine());
                     bank.transfer(userId,recipientId, transferAmount);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}