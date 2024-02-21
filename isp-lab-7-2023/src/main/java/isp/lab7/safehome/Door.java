package isp.lab7.safehome;

public class Door {
    private DoorStatus status;

    public void lockDoor() {
        status = DoorStatus.CLOSE;
    }

    public void unlockDoor() {
        status = DoorStatus.OPEN;
    }

    public DoorStatus getStatus() {
        return status;
    }
}
