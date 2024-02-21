package isp.lab3.exercise6;

public class VendingMachineTest {
    public static void main(String[] args) {
        VendingMachine vendingMachine1 = VendingMachine.getInstance();
        VendingMachine vendingMachine2 = VendingMachine.getInstance();

        System.out.println(vendingMachine1 == vendingMachine2); // true

        vendingMachine1.displayProducts();
        vendingMachine1.insertCoin(1);
        vendingMachine1.selectProduct(0);
        vendingMachine1.displayCredit();
        vendingMachine1.userMenu();
    }
}
