import java.util.*;

class ATM {
     private int pin = 1234;
     private  int balance = 10000;
     
      private int addAmount = 0;
     private int takeAmount = 0;
     String name;

    public boolean verifyPin(int inputPin) {
        return inputPin == pin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void displayWelcomeMessage() {
        System.out.println("Welcome " + name);
    }

    public void checkBalance() {
        System.out.println("Your current Balance is: " + balance);
    }

    public void addAmount(int amount) {
        addAmount = amount;
        balance += addAmount;
        System.out.println("Successfully Credited");
    }

    public void takeAmount(int amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance");
            System.out.println("Try less Amount");
        } else {
            takeAmount = amount;
            balance -= takeAmount;
            System.out.println("Successfully Debited");
        }
    }

    public void printReceipt() {
        System.out.println("Welcome to IOB ATM");
        System.out.println("Available Balance is: " + balance);
        System.out.println("Amount Deposited: " + addAmount);
        System.out.println("Amount Debited: " + takeAmount);
        System.out.println("We are so grateful for your visit Mr/Mrs " + name + "... Thanks again!!");
    }
}

public class ATMProject {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ATM atm = new ATM();
        int count=3;
         System.out.println("If You entered the wrong PIN 3 times. Your account will be locked");
        
        while(true){
             System.out.println();
        System.out.println("Please Enter your 4 digit pin number:");
        int password = scan.nextInt();

        if (atm.verifyPin(password)) {
            System.out.println("Enter your name:");
            String name = scan.next();
            atm.setName(name);
            atm.displayWelcomeMessage();

            System.out.println("Press 1 to check Balance");
            System.out.println("Press 2 to add Amount");
            System.out.println("Press 3 to take Amount");
            System.out.println("Press 4 to get Receipt");
            System.out.println("Press 5 to Exit");

            while (true) {
                System.out.println("");
                System.out.println("Enter your choice: ");
                int option = scan.nextInt();
                switch (option) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.println("How much amount you want to Add:");
                        int addAmount = scan.nextInt();
                        atm.addAmount(addAmount);
                        break;
                    case 3:
                        System.out.println("How much amount you want to Take:");
                        int takeAmount = scan.nextInt();
                        atm.takeAmount(takeAmount);
                        break;
                    case 4:
                        atm.printReceipt();
                        break;
                    case 5:
                        System.out.println("Thank You!");
                        return;
                    default:
                        System.out.println("Press a number between 1 and 5");
                        break;
                }
            }
        }
        else {
            count--;
            if(count>0){
            System.out.println("Wrong Pin number... "+count+" Chances only left.");
            }
            
            if(count==0){
                System.out.println("Your account is locked. Please contact customer support.");
                break;
            }
        }}
    }
}