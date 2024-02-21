package isp.lab4.exercise2;

public class Exercise2 {
        public static void main(String[] args) {
            // Create Laptop object with initial battery level
            Chargeable laptop = new Laptop(30);

            // Create SmartPhone object with initial battery level
            Chargeable smartPhone = new SmartPhone(30);

            // Create SmartWatch object with initial battery level
            Chargeable smartWatch = new SmartWatch(30);

            // Charge the Laptop for 15 minutes
            laptop.charge(15);
            System.out.println("Laptop battery level after charging: " + laptop.getBatteryLevel());

            // Charge the SmartPhone for 15 minutes
            smartPhone.charge(15);
            System.out.println("SmartPhone battery level after charging: " + smartPhone.getBatteryLevel());

            // Charge the SmartWatch for 15 minutes
            smartWatch.charge(15);
            System.out.println("SmartWatch battery level after charging: " + smartWatch.getBatteryLevel());
        }
    }
