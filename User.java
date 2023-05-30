package money;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class User {
	private String userId;
    private String userPin;

    User(String userId, String userPin) {
        this.userId = userId;
        this.userPin = userPin;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPin() {
        return userPin;
    }
}

class Bank {
	private User[] users;
    private double[] balances;
    private String[] transactionHistory;
    private String currentUserId;
    Bank() {
        // Initialize users, balances, and transaction history
        users = new User[]{
                new User("user1", "1234"),
                new User("user2", "5678")
        };
        balances = new double[]{1000, 2000};
        transactionHistory = new String[]{"Transaction 1", "Transaction 2"};
    }

    public void setCurrentUserId(String userId) {
        currentUserId = userId;
    }

    public boolean authenticateUser(String userId, String userPin) {
        for (User user : users) {
            if (user.getUserId().equals(userId) && user.getUserPin().equals(userPin)) {
                return true;
            }
        }
        return false;
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    
        // Withdraw logic
    	public void withdraw(String userId,double amount) throws IOException {
    		  
    	        
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Get the user's account index
            int accountIndex = -1;
            for (int i = 0; i < users.length; i++) {
                
			
				if (users[i].getUserId().equals(userId)) {
                    accountIndex = i;
                    break;
                }
            }

            if (accountIndex == -1) {
                System.out.println("User account not found.");
                return;
            }

            double currentBalance = balances[accountIndex];

            if (amount <= 0) {
                System.out.println("Invalid withdrawal amount.");
            } else if (amount > currentBalance) {
                System.out.println("Insufficient balance. Current balance: $" + currentBalance);
            } else {
                // Perform the withdrawal
                balances[accountIndex] -= amount;

                // Update transaction history
                String transaction = "Withdrawal of $" + amount;
                transactionHistory[accountIndex] += "\n" + transaction;

                System.out.println("Withdrawal successful. New balance: $" + balances[accountIndex]);
            }
        }
    
    

   
        // Deposit logic
    	public void deposit(String userId,double amount) throws IOException {
    		   
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Get the user's account index
            int accountIndex = -1;
            for (int i = 0; i < users.length; i++) {
                if (users[i].getUserId().equals(userId)) {
                    accountIndex = i;
                    break;
                }
            }

            if (accountIndex == -1) {
                System.out.println("User account not found.");
                return;
            }

            if (amount <= 0) {
                System.out.println("Invalid deposit amount.");
            } else {
                // Perform the deposit
                balances[accountIndex] += amount;

                // Update transaction history
                String transaction = "Deposit of $" + amount;
                transactionHistory[accountIndex] += "\n" + transaction;

                System.out.println("Deposit successful. New balance: $" + balances[accountIndex]);
            }
        }
    
    

    
        // Transfer logic
    	public void transfer(String senderId,String recipientId, double amount) throws IOException {
    		   
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Get the sender's account index
            int senderAccountIndex = -1;
            for (int i = 0; i < users.length; i++) {
                if (users[i].getUserId().equals(senderId)) {
                    senderAccountIndex = i;
                    break;
                }
            }

            // Get the recipient's account index
            int recipientAccountIndex = -1;
            for (int i = 0; i < users.length; i++) {
                if (users[i].getUserId().equals(recipientId)) {
                    recipientAccountIndex = i;
                    break;
                }
            }

            if (senderAccountIndex == -1 || recipientAccountIndex == -1) {
                System.out.println("Invalid sender or recipient account.");
                return;
            }

            double senderBalance = balances[senderAccountIndex];

            if (amount <= 0) {
                System.out.println("Invalid transfer amount.");
            } else if (amount > senderBalance) {
                System.out.println("Insufficient balance. Current balance: $" + senderBalance);
            } else {
                // Perform the transfer
                balances[senderAccountIndex] -= amount;
                balances[recipientAccountIndex] += amount;

                // Update transaction history for the sender
                String senderTransaction = "Transfer of $" + amount + " to " + recipientId;
                transactionHistory[senderAccountIndex] += "\n" + senderTransaction;

                // Update transaction history for the recipient
                String recipientTransaction = "Transfer of $" + amount + " from " + senderId;
                transactionHistory[recipientAccountIndex] += "\n" + recipientTransaction;

                System.out.println("Transfer successful. New balance: $" + balances[senderAccountIndex]);
            }
        }
    
    }


