package StaticData;

import Models.BankAccountHolder;

import java.util.ArrayList;

public class UserDB {
    private static final ArrayList<BankAccountHolder> userInfo = new ArrayList<>();

    public static ArrayList<BankAccountHolder> getUserInfo() {
        return userInfo;
    }
}
