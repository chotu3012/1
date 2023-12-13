import java.util.Scanner;

class Account {
    private String Bank_Name;
    private String Branch_Name;
    private String Acct_Name;
    private String Acct_No;
    private double Acct_Bal;
    private String Acct_Address;

    public Account(String bankName, String branchName, String acctName, String acctNo, double acctBal, String acctAddress) {
        Bank_Name = bankName;
        Branch_Name = branchName;
        Acct_Name = acctName;
        Acct_No = acctNo;
        Acct_Bal = acctBal;
        Acct_Address = acctAddress;
    }

    public void credit(double amount) {
        Acct_Bal += amount;
    }

    public void debit(double amount) {
        if (amount <= Acct_Bal) {
            Acct_Bal -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public double getBalance() {
        return Acct_Bal;
    }
}

public class SBIBankApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating accounts for Basar branch
        Account[] basarAccounts = new Account[5];
        basarAccounts[0] = new Account("SBI", "Basar", "John Doe", "BA001", 5000, "Basar, Telangana");
        basarAccounts[1] = new Account("SBI", "Basar", "Jane Smith", "BA002", 10000, "Basar, Telangana");
        basarAccounts[2] = new Account("SBI", "Basar", "David Williams", "BA003", 7500, "Basar, Telangana");
        basarAccounts[3] = new Account("SBI", "Basar", "Emily Johnson", "BA004", 3000, "Basar, Telangana");
        basarAccounts[4] = new Account("SBI", "Basar", "Michael Brown", "BA005", 20000, "Basar, Telangana");

        // Creating accounts for Nizamabad branch
        Account[] nizamabadAccounts = new Account[5];
        nizamabadAccounts[0] = new Account("SBI", "Nizamabad", "William Jones", "NA001", 15000, "Nizamabad, Telangana");
        nizamabadAccounts[1] = new Account("SBI", "Nizamabad", "Olivia Davis", "NA002", 8000, "Nizamabad, Telangana");
        nizamabadAccounts[2] = new Account("SBI", "Nizamabad", "Liam Miller", "NA003", 6000, "Nizamabad, Telangana");
        nizamabadAccounts[3] = new Account("SBI", "Nizamabad", "Ava Wilson", "NA004", 12000, "Nizamabad, Telangana");
        nizamabadAccounts[4] = new Account("SBI", "Nizamabad", "Sophia Taylor", "NA005", 5000, "Nizamabad, Telangana");

        System.out.println("Welcome to SBI Bank Application!");

        while (true) {
            System.out.println("Please enter your branch (Basar/Nizamabad):");
            String branch = scanner.nextLine();

            Account[] accounts;
            if (branch.equalsIgnoreCase("Basar")) {
                accounts = basarAccounts;
            } else if (branch.equalsIgnoreCase("Nizamabad")) {
                accounts = nizamabadAccounts;
            } else {
                System.out.println("Invalid branch!");
                continue;
            }

            System.out.println("Please enter your account number:");
            String accountNumber = scanner.nextLine();

            Account currentAccount = null;
            for (Account account : accounts) {
                if (account.getAcct_No().equalsIgnoreCase(accountNumber)) {
                    currentAccount = account;
                    break;
                }
            }

            if (currentAccount == null) {
                System.out.println("Account not found!");
                continue;
            }

            System.out.println("Welcome, " + currentAccount.getAcct_Name() + "!");
            System.out.println("Your current balance is: " + currentAccount.getBalance());

            while (true) {
                System.out.println("Choose an option:");
                System.out.println("1. Credit");
                System.out.println("2. Debit");
                System.out.println("3. Get Balance");
                System.out.println("4. Exit");

                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Enter credit amount:");
                        double creditAmount = scanner.nextDouble();
                        currentAccount.credit(creditAmount);
                        System.out.println("Amount credited successfully!");
                        break;
                    case 2:
                        System.out.println("Enter debit amount:");
                        double debitAmount = scanner.nextDouble();
                        currentAccount.debit(debitAmount);
                        System.out.println("Amount debited successfully!");
                        break;
                    case 3:
                        System.out.println("Your current balance is: " + currentAccount.getBalance());
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Invalid option!");
                        break;
                }
            }
        }
    }
}
