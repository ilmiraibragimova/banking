package banking;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //int account[] = new int[2];
        Account account = new Account();
        while (true) {
            System.out.println("\n1. Create an account\n" +
                    "2. Log into account\n" +
                    "0. Exit");
            Scanner scan = new Scanner(System.in);
            int num = Integer.parseInt(scan.next());
            if (num == 0) {
                System.out.println("Bye!");
                return;
            }
            if (num == 1) {
                account.createAccount();
            }
            if (num == 2) {
                account.logIn(account);
            }
            //for (long[] row: account.log) {
            //System.out.println( Arrays.toString(row));
            // }
        }
    }
}
