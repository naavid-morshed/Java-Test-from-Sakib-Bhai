package Interfaces;

import java.util.Calendar;

public interface BankingOperation {
    void deposit(float amount, Calendar date);

    boolean withdraw(float amount, Calendar date);
}
