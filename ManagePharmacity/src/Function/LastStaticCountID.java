package Function;

import java.io.Serializable;

public class LastStaticCountID implements Serializable {
    private int lastIDAccount = 1;
    private int lastIDMedicine = 1;
    private int lastIDOrder = 1;
    private int lastIDCustomer = 1;

    public LastStaticCountID() {
    }

    public int getLastIDAccount() {
        return lastIDAccount;
    }

    public void setLastIDAccount(int lastIDAccount) {
        this.lastIDAccount = lastIDAccount;
    }

    public int getLastIDMedicine() {
        return lastIDMedicine;
    }

    public void setLastIDMedicine(int lastIDMedicine) {
        this.lastIDMedicine = lastIDMedicine;
    }

    public int getLastIDOrder() {
        return lastIDOrder;
    }

    public void setLastIDOrder(int lastIDOrder) {
        this.lastIDOrder = lastIDOrder;
    }

    public int getLastIDCustomer() {
        return lastIDCustomer;
    }

    public void setLastIDCustomer(int lastIDCustomer) {
        this.lastIDCustomer = lastIDCustomer;
    }
}
