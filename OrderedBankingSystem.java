package com.company;

import java.math.BigDecimal;
import java.util.*;

public class OrderedBankingSystem {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Map<String, BigDecimal>> bankAccountBalance = new HashMap<>();
        Map<String, List<String>> bankAccounts = new HashMap<>();
        Map<String, BigDecimal> bankBalances = new HashMap<>();
        List<String> banks = new ArrayList<>();
        while (!input.equals("end")) {
            String[] theInput = input.split(" -> ");
            String bank = theInput[0];
            String account = theInput[1];
            BigDecimal balance = new BigDecimal(theInput[2]);
            Map<String, BigDecimal> accountBalance = new HashMap<>();
            accountBalance.put(account, balance);
            if (!bankAccountBalance.containsKey(bank)) {
                bankAccountBalance.put(bank, accountBalance);
                List<String> accounts = new ArrayList<>();
                accounts.add(account);
                bankAccounts.put(bank, accounts);
                banks.add(bank);
                bankBalances.put(bank, balance);
            } else if (!bankAccountBalance.get(bank).containsKey(account)) {
                bankAccountBalance.get(bank).put(account, balance);
                bankAccounts.get(bank).add(account);
                BigDecimal currentBalance = bankBalances.get(bank);
                bankBalances.put(bank, currentBalance.add(balance));
            } else {
                BigDecimal currentBalance = bankAccountBalance.get(bank).get(account);
                bankAccountBalance.get(bank).put(account, bankAccountBalance.get(bank).get(account).add(currentBalance));
            }
            input = scan.nextLine();
        }
// we have all input

        for (int i = 0; i < banks.size(); i++) {
            BigDecimal firstBankDeposit = bankBalances.get(banks.get(i));
            for (int j = 0; j < banks.size(); j++) {
                BigDecimal secondBankDeposit = bankBalances.get(banks.get(j));
                if (firstBankDeposit.compareTo(secondBankDeposit) > 0) {
                    String currentBank = banks.get(i);
                    banks.set(i, banks.get(j));
                    banks.set(j, currentBank);
                }
            }
        }

        for (int i = 0; i < banks.size(); i++) {
            for (String account : bankAccounts.get(banks.get(i))) {
                System.out.print(account + " -> " + bankAccountBalance.get(banks.get(i)).get(account) + " (" + banks.get(i) + ")");
                System.out.println();
            }
        }
    }
}
