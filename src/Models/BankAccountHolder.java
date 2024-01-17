package Models;

import Enums.AccountType;
import Interfaces.BankingOperation;
import StaticData.UserDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class BankAccountHolder implements BankingOperation {
    private String userName;
    private String password;
    private final AccountType accountType;
    private float balance;
    private final int withdrawLimit; // this is only to show how many times user is allowed to withdraw per month, otherwise redundant.
    private int[] withdrawnPerMonthLimit = new int[12];
    ArrayList<DepositInfo> depositInfo = new ArrayList<>();
    ArrayList<WithdrawInfo> withdrawInfo = new ArrayList<>();

    public BankAccountHolder(String userName, String password, AccountType accountType, int balance) {
        this.userName = userName;
        this.password = password;
        this.accountType = accountType;
        this.balance = balance;

        if (accountType == AccountType.SAVINGS) {
            this.withdrawLimit = 3;
            Arrays.fill(this.getWithdrawnPerMonthLimit(), 3);
        } else {
            this.withdrawLimit = 5;
            Arrays.fill(this.getWithdrawnPerMonthLimit(), 5);
        }
    }

    @Override
    public String toString() {
        return "BankAccountHolder{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", accountType=" + accountType +
                ", balance=" + balance +
                ", withdrawLimit=" + withdrawLimit +
                ", withdrawnPerMonth=" + Arrays.toString(withdrawnPerMonthLimit) +
                ", depositInfo=" + depositInfo +
                ", withdrawInfo=" + withdrawInfo +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public int getWithdrawLimit() {
        return withdrawLimit;
    }


    public ArrayList<DepositInfo> getDepositInfo() {
        return depositInfo;
    }

    public ArrayList<WithdrawInfo> getWithdrawInfo() {
        return withdrawInfo;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int[] getWithdrawnPerMonthLimit() {
        return withdrawnPerMonthLimit;
    }

    public void setWithdrawnPerMonthLimit(int[] withdrawnPerMonthLimit) {
        this.withdrawnPerMonthLimit = withdrawnPerMonthLimit;
    }

    @Override
    public void deposit(float amount, Calendar date) {
        this.getDepositInfo().add(new DepositInfo(amount, date));
        this.setBalance(this.getBalance() + amount);
    }

    @Override
    public boolean withdraw(float amount, Calendar date) {
        if (this.getBalance() < amount) {
            System.err.println("Not enough balance.");
            return false;
        } else if (this.getAccountType() == AccountType.SAVINGS) {

            if (this.getWithdrawnPerMonthLimit()[date.get(Calendar.MONTH)] > 0) {

                this.getWithdrawnPerMonthLimit()[date.get(Calendar.MONTH)]--;
                this.setBalance(this.getBalance() - amount);
                this.getWithdrawInfo().add(new WithdrawInfo(amount, date));

                return true;
            } else {
                System.err.println("Withdraw limit reached");

                return false;
            }
        } else if (this.getAccountType() == AccountType.CURRENT) {
            if (this.getWithdrawnPerMonthLimit()[date.get(Calendar.MONTH)] > 0) {

                this.getWithdrawnPerMonthLimit()[date.get(Calendar.MONTH)]--;
                this.setBalance(this.getBalance() - amount);
                this.getWithdrawInfo().add(new WithdrawInfo(amount, date));

                return true;
            } else {

                this.getWithdrawnPerMonthLimit()[date.get(Calendar.MONTH)]--;
                this.setBalance(this.getBalance() - amount - 10);
                this.getWithdrawInfo().add(new WithdrawInfo(amount, date));

                return true;
            }
        } else {
            System.err.println("Some error occurred");
            return false;
        }
    }
}
