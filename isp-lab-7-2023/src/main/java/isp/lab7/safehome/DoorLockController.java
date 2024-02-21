package isp.lab7.safehome;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoorLockController implements ControllerInterface {

    private Door door;
    private Map<Tenant, AccessKey> validAccess;
    private List<AccessLog> accessLogs;
    private final Integer Max_Tries = 3;
    private Integer Tries = 0;

    public DoorLockController(Door door, List<AccessLog> accessLogs) {
        this.door = door;
        this.accessLogs = accessLogs;
        this.validAccess = new HashMap<>();
        this.validAccess.put(new Tenant(MASTER_TENANT_NAME), new AccessKey(ControllerInterface.MASTER_KEY));
    }

    @Override
    public DoorStatus enterPin(String pin) throws TooManyAttemptsException, InvalidPinException {
        Integer ok = 0;
        String ms = null;
        for (AccessKey a : validAccess.values()) {
            if (ms == null)
                ms = a.getPin();
            if (a.getPin().equals(pin))
                ok = 1;
        }

        if (ok == 0) {
            this.Tries++;
            if (this.isPermanentlyLocked()) {
                this.accessLogs.add(this.createAccessLog("", "enter pin", "TooManyAttemptsException"));
                throw new TooManyAttemptsException();
            } else {
                this.accessLogs.add(this.createAccessLog("", "enter pin", "InvalidPinException"));
                throw new InvalidPinException();
            }
        } else {
            if (ms.equals(pin)) {
                this.Tries = 0;
            } else if (this.isPermanentlyLocked()) {
                this.accessLogs.add(this.createAccessLog("", "enter pin", "TooManyAttemptsException"));
                throw new TooManyAttemptsException();
            }
            if (door.getStatus() == DoorStatus.OPEN) {
                door.lockDoor();
            } else {
                door.unlockDoor();
            }
            this.accessLogs.add(this.createAccessLog(String.valueOf(validAccess.get(pin)), "enter pin", ""));
            return door.getStatus();
        }
    }

    @Override
    public void addTenant(String pin, String name) throws TenantAlreadyExistsException {
        final Tenant tenant = new Tenant(name);
        if (validAccess.containsKey(tenant)) {
            this.accessLogs.add(this.createAccessLog(name, "add tenant", "TenantAlreadyExistsException"));
            throw new TenantAlreadyExistsException();
        }
        this.accessLogs.add(this.createAccessLog(name, "add tenant", ""));
        validAccess.put(new Tenant(name), new AccessKey(pin));
    }

    @Override
    public void removeTenant(String name) throws TenantNotFoundException {
        final Tenant tenant = new Tenant(name);
        Integer ok = 0;
        for (Tenant a : validAccess.keySet()) {
            String b = a.getName();
            if (b.equals(name)) ;
            ok = 1;
        }
        if (ok == 0) {
            this.accessLogs.add(this.createAccessLog(name, "Stergere Tenant", "TenantNotFoundException"));
            throw new TenantNotFoundException();
        }

        this.accessLogs.add(this.createAccessLog(name, "Stergere Tenant", ""));
        this.validAccess.remove(tenant);
    }

    public List<AccessLog> getAccessLogs() {
        return accessLogs;
    }

    private AccessLog createAccessLog(final String tenant, final String operation, final String errMessage) {
        return new AccessLog(tenant, LocalDateTime.now(), operation, this.door.getStatus(), errMessage);
    }

    private boolean isPermanentlyLocked() {
        return this.Tries >= Max_Tries;
    }
}
