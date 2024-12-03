package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user, new ArrayList<>());
    }

    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    public void addAccount(String passport, Account account) {
        User foundUser = findByPassport(passport);
        if (foundUser != null && !getAccounts(foundUser).contains(account)) {
            users.computeIfAbsent(foundUser, k -> new ArrayList<>()).add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User foundUser = findByPassport(passport);
        if (foundUser != null) {
            for (Account account : getAccounts(foundUser)) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite, 
                                 double amount) {
        Account foundSourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account foundDestinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        boolean isRequisitesSuccessful = foundSourceAccount != null
                && foundDestinationAccount != null
                && foundSourceAccount.getBalance() >= amount;
        if (isRequisitesSuccessful) {
            double sourceBalance = foundSourceAccount.getBalance();
            foundSourceAccount.setBalance(sourceBalance - amount);
            double destinationBalance = foundDestinationAccount.getBalance();
            foundDestinationAccount.setBalance(destinationBalance + amount);
        }
        return isRequisitesSuccessful;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}