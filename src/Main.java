import Enums.AccountType;
import Models.BankAccountHolder;
import StaticData.UserDB;

import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        BankAccountHolder bankAccountHolder1 = new BankAccountHolder("Osman", "osman1234", AccountType.SAVINGS, 500);
        BankAccountHolder bankAccountHolder2 = new BankAccountHolder("John Doe", "doe123", AccountType.CURRENT, 2000);

        UserDB.getUserInfo().add(bankAccountHolder1);
        UserDB.getUserInfo().add(bankAccountHolder2);

//        for (BankAccountHolder bankAccountHolder : UserDB.getUserInfo()) {
//            System.out.println(bankAccountHolder);
//        }

        for (int count = 0; count < 10; count++) {
            bankAccountHolder2.withdraw(100,Calendar.getInstance());
        }

        System.err.println(bankAccountHolder2);

//        System.out.println("Enter User name: ");
//        String userName = stdIn.nextLine();
//        System.out.println("Enter User pass: ");
//        String pass = stdIn.nextLine();
//
//        for (BankAccountHolder bankAccountHolder : UserDB.getUserInfo()) {
//            if (bankAccountHolder.getUserName().equals(userName) && bankAccountHolder.getPassword().equals(pass)) {
//                System.out.println("Logged in as " + bankAccountHolder.getUserName());
//
//                boolean check = true;
//                while (check){
//                    System.out.println("Press 1 to check balance");
//                    System.out.println("Press 2 to deposit");
//                    System.out.println("Press 3 to withdraw");
//                    System.out.println("Press 4 to check withdraw count per each month");
//
//                    int buttonPress = stdIn.nextInt();
//
//                    if (buttonPress == 1) {
//                        System.out.println("Current balance is : " + bankAccountHolder.getBalance() + " BDT");
//                    } else if (buttonPress == 2) {
//                        bankAccountHolder.deposit(200, Calendar.getInstance());
//                    } else if (buttonPress == 3) {
////                        Calendar calendar = Calendar.getInstance();
////                        calendar.set(2024,Calendar.APRIL,20);
////                        calendar.setTime();
//                        bankAccountHolder.withdraw(400, Calendar.getInstance());
//                    } else {
//                        System.err.println("Invalid input, try again");
//                    }
//
//                    System.out.println("Press 1 to perform other operations");
//                    System.out.println("Press 2 to Log out");
//                    int a = stdIn.nextInt();
//
//                    if (a == 1) {
//                        check = true;
//                    } else if (a == 2) {
//                        check = false;
//                    } else {
//                        System.err.println("Invalid input, logging out");
//                        check = false;
//                    }
//                }
//            }
//        }
    }
}