package isp.lab6.exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        OnlineStore store = new OnlineStore();
        LoginSystem loginSystem = new LoginSystem(store);
        UserInterface userInterface = new UserInterface(loginSystem, store);
        userInterface.loadInterface();
    }
}
