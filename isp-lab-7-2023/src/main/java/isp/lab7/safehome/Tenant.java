package isp.lab7.safehome;

public class Tenant {
    private String name;

    public Tenant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tenant tenant = (Tenant) obj;
        return name.equals(tenant.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
