package isp.lab6.exercise3;

import java.util.HashSet;
import java.util.Set;

class LoginSystem {
    private Set<User> users;
    private OnlineStore store;

    public LoginSystem(OnlineStore store) {
        this.users = new HashSet<>();
        this.store = store;
    }

    public void register(String username, String password) {
        users.add(new User(username, password));
    }

    public boolean login(String username, String password) {
        User user = new User(username, password);
        return users.contains(user);
    }

    public boolean logout(String username) {
        User user = new User(username, "");
        return users.contains(user);
    }
}
