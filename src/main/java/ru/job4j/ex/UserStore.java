package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        int result = -1;
        boolean isValid = false;
        for (int index = 0; index < users.length; index++) {
            if (login.equals(users[index].getUsername())) {
                result = index;
                isValid = users[index].isValid();
            }
        }
        if (result == -1) {
            throw new UserNotFoundException("User not found with login " + login);
        } else {
            return new User(login, isValid);
        }
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() <= 3) {
            throw new UserInvalidException("User " + user.getUsername() + " is not valid");
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}