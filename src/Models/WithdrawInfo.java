package Models;

import java.util.Calendar;

public class WithdrawInfo {
    private float amountInBDT;
    private Calendar date;

    public WithdrawInfo(float amountInBDT, Calendar date) {
        this.amountInBDT = amountInBDT;
        this.date = date;
    }

    @Override
    public String toString() {
        return "WithdrawInfo{" +
                "amountInBDT=" + amountInBDT +
                ", date=" + date +
                '}';
    }

    public float getAmountInBDT() {
        return amountInBDT;
    }

    public void setAmountInBDT(float amountInBDT) {
        this.amountInBDT = amountInBDT;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
}
