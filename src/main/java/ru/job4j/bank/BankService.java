package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу простейшей имитации банковского приложения.
 * @author mikhail
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение всех данных происходит в HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в HashMap
     * вместе с пустым ArrayList.
     * @param user пользователь, который добавляется в систему.
     */
    public void addUser(User user) {
        users.put(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход паспорт пользователя
     * и удаляет пользователя с таким паспортом из HashMap.
     * @param passport паспорт пользователя, удаляемого из системы
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод принимает на вход паспорт пользователя и его счет, добавляя
     * счет, если он не существует уже в системе.
     * Если пользователь не найден или счет уже существует, то метод не
     * будет выполнять добавление.
     * @param passport паспорт пользователя
     * @param account счет пользователя для привязки
     */
    public void addAccount(String passport, Account account) {
        User foundUser = findByPassport(passport);
        if (foundUser != null && !getAccounts(foundUser).contains(account)) {
            users.computeIfAbsent(foundUser, k -> new ArrayList<>()).add(account);
        }
    }

    /**
     * Метод принимает на вход паспорт пользователя и ищет
     * пользователя с таким паспортом в ключах HashMap путем перебора.
     * @param passport паспорт искомого пользователя
     * @return возвращает пользователя с искомым паспортом. В случае неудачного поиска возвращает null.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход паспорт пользователя и реквизит его счета, после чего
     * перебирает HashMap на наличие пользователя с искомым счетом.
     * @param passport паспорт пользователя
     * @param requisite реквизит счета пользователя
     * @return в случае удачного перебора возвращает найденный счет, в случае неудачи возвращает null
     */
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

    /**
     * Метод является простейшей имитацией банковского перевода с одного счета на другой.
     * Принимает на вход паспорт и реквизит счета пользователя, со счета которого будет списана сумма,
     * паспорт и реквизит счета пользователя, на счет которого поступит сумма,
     * и количество списываемых средств.
     * @param sourcePassport паспорт исходного пользователя
     * @param sourceRequisite реквизит счета исходного пользователя
     * @param destinationPassport паспорт получателя
     * @param destinationRequisite реквизит счета получателя
     * @param amount количество средств
     * @return возвращает true, если реквизиты верны и средств достаточно у исходного пользователя,
     * а также верны реквизиты получателя. Возвращает false, если одно из условий не выполнено.
     */
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

    /**
     * Метод принимает на вход объект типа User и возвращает все счета этого пользователя
     * @param user пользователь, у которого ищутся счета
     * @return список счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}