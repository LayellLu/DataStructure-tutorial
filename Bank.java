//package tt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

class BankAccount {
    private long id;
    private double balance;

    public BankAccount(long id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}

public class Bank {
    private final Map<String, List<BankAccount>> holdersMapsAccount = new HashMap<>();

    public void add(String holderName, long accountId, double balance) {
        if (holdersMapsAccount.containsKey(holderName)) {
            final List<BankAccount> holdersAccount = holdersMapsAccount.get(holderName);
            // query for this account
            final Optional<BankAccount> accountOp = holdersAccount.stream()
                    .filter(account -> account.getId() == accountId)
                    .findFirst();
            if (accountOp.isPresent()) {
                // increase account
                final BankAccount account = accountOp.get();
                account.setBalance(account.getBalance() + balance);
                System.out.println("Account found so increased the balance");
            } else {
                // new account
                holdersAccount.add(new BankAccount(accountId, balance));
                System.out.println("Account created");
            }
        } else {
            // new account
            final List<BankAccount> accounts = new ArrayList<>();
            accounts.add(new BankAccount(accountId, balance));
            holdersMapsAccount.put(holderName, accounts);
            System.out.println("Account created");
        }
    }

    public void delete(long accountId) {
        for (final List<BankAccount> account : holdersMapsAccount.values()) {
            final boolean findIt = account.removeIf(acc -> acc.getId() == accountId);
            if (findIt) {
                System.out.println("Account deleted");
            } else {
                System.out.println("Account not found");
            }
        }
    }

    public void display() {
        if (holdersMapsAccount.isEmpty()) {
            System.out.println("No account available");
            return;
        }
        for (Map.Entry<String, List<BankAccount>> entry : holdersMapsAccount.entrySet()) {
            final List<BankAccount> accounts = entry.getValue();
            for (final BankAccount account : accounts) {
                System.out.println(entry.getKey() + " " + account.getId() + " " + account.getBalance());
            }
        }
    }

    public void withdraw(long accountId, double balance) {
        boolean findIt = false;
        outer: for (final List<BankAccount> accounts : holdersMapsAccount.values()) {
            for (final BankAccount account : accounts) {
                if (account.getId() == accountId) {
                    // withdraw
                    if (account.getBalance() >= balance) {
                        account.setBalance(account.getBalance() - balance);
                        System.out.println("Money withdrawn");
                    } else {
                        System.out.println("Not enough balance");
                    }
                    findIt = true;
                    break outer;
                }
            }
        }
        if (!findIt) {
            System.out.println("Account not found");
        }
    }

    public void find(String holder) {
        if (holdersMapsAccount.containsKey(holder)) {
            final List<BankAccount> accounts = holdersMapsAccount.get(holder);
            for (final BankAccount account : accounts) {
                System.out.println(holder + " " + account.getId() + " " + account.getBalance());
            }
        } else {
            System.out.println("Account not found");
        }
    }

    public static void main(String... args) {
        final Bank bank = new Bank();
        final Scanner sc = new Scanner(System.in);
        for (;;) {
            final String cmdStr = sc.nextLine().trim();
            if ("QUIT".equals(cmdStr))
                break;

            final List<String> cmdAndParams = Arrays.stream(cmdStr.split(" "))
                    .map(String::trim)
                    .filter(s -> s.length() > 0)
                    .collect(Collectors.toList());

            if (cmdAndParams == null || cmdAndParams.isEmpty()) {
                System.out.println("Invalid command received");
                continue;
            }

            final String cmd = cmdAndParams.get(0);
            if ("ADD".equals(cmd) && cmdAndParams.size() >= 4) {
                bank.add(cmdAndParams.get(1), Integer.parseInt(cmdAndParams.get(2)),
                        Double.parseDouble(cmdAndParams.get(3)));
            } else if ("DISPLAY".equals(cmd)) {
                bank.display();
            } else if ("DEL".equals(cmd) && cmdAndParams.size() >= 2) {
                bank.delete(Integer.parseInt(cmdAndParams.get(1)));
            } else if ("WITHDRAW".equals(cmd) && cmdAndParams.size() >= 3) {
                bank.withdraw(Integer.parseInt(cmdAndParams.get(1)), Double.parseDouble(cmdAndParams.get(2)));
            } else if ("FIND".equals(cmd) && cmdAndParams.size() >= 2) {
                bank.find(cmdAndParams.get(1));
            } else {
                System.out.println("Invalid command received: " + cmdStr);
            }

        }
        sc.close();
    }
}
