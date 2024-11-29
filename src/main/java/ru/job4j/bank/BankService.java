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
        users.remove(findByPassport(passport));
    }

    public void addAccount(String passport, Account account) {
        if (findByPassport(passport) != null && !getAccounts(findByPassport(passport)).contains(account)) {
            users.computeIfAbsent(findByPassport(passport), k -> new ArrayList<>()).add(account);
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
        if (findByPassport(passport) != null) {
            for (Account account : getAccounts(findByPassport(passport))) {
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
        boolean isRequisitesSuccessful = findByPassport(sourcePassport) != null
                && findByPassport(destinationPassport) != null
                && findByRequisite(sourcePassport, sourceRequisite) != null
                && findByRequisite(destinationPassport, destinationRequisite) != null
                && findByRequisite(sourcePassport, sourceRequisite).getBalance() >= amount;
        if (isRequisitesSuccessful) {
            double sourceBalance = findByRequisite(sourcePassport, sourceRequisite).getBalance();
            findByRequisite(sourcePassport, sourceRequisite).setBalance(sourceBalance - amount);
            double destinationBalance = findByRequisite(destinationPassport, destinationRequisite).getBalance();
            findByRequisite(destinationPassport, destinationRequisite).setBalance(destinationBalance + amount);
        }
        return isRequisitesSuccessful;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}