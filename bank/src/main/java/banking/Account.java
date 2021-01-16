package banking;

import java.util.*;

public class Account {
    List<long[]> log = new ArrayList<>();
    private static long code = 1;
    int balance = 0;

    long useLuhnAlg(long code) {
        int controlNum;
        long code1 = code;
        int sum = 0;

        for (int i = 16; i >= 0; i--) {
            controlNum = (int)(code1 % 10);
            if (i % 2 != 0) {
                controlNum *= 2;
            }
            if (controlNum >= 10) {
                controlNum -= 9;
            }
            sum += controlNum;
            // System.out.println(sum + "sum\n");
            code1 = code1 / 10;
        }
        sum %=  10;
        if (sum > 0) {
            sum = 10 - sum;
        }
        //System.out.println(sum);
        code = code + sum;
        return (code);
    }
    public void createAccount() {
        Random generator = new Random();
        int password = generator.nextInt(10000);
        long code1 = 4000000000000000L + code * 10;
        long code2 = useLuhnAlg(code1);
        log.add(new long[] {code2, password});
        System.out.println("\nYour card has been created\nYour card number:\n" +
                code2 + "\nYour card PIN:");
        System.out.printf("%04d\n", password);
        code++;
        //System.out.println(code2);
        //System.out.println(password);
    }

    public void logIn(Account account) {
        System.out.println("Enter your card number:");
        Scanner scan = new Scanner(System.in);
        long cardNumber = Long.parseLong(scan.next());
        System.out.println("Enter your PIN:");
        String pass = scan.next();
        if (pass.length() < 4) {
            System.out.println("Wrong card number or PIN!");
            return;
        }
        int password = Integer.parseInt(pass);
        for (long[] row : account.log) {
            if (cardNumber == row[0] && password == row[1]) {
                System.out.println("You have successfully logged out!");
                logIn1(account);
                return;
            }
        }
        System.out.println("Wrong card number or PIN!");
    }
    public void logIn1(Account account) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Balance\n" +
                    "2. Log out\n" +
                    "0. Exit");
            int num = Integer.parseInt(scan.next());
            if (num == 0) {
                System.out.println("Bye!");
                System.exit(0);
            } else if (num == 2) {
                System.out.println("You have successfully logged in!");
                return;
            } else if (num == 1) {
                System.out.println("\nBalance: " + account.balance);
            }
        }

    }
}

