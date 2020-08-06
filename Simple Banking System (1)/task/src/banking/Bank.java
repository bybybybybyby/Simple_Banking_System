package banking;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void createAccount() {

        Account newAccount = new Account();
        accounts.add(newAccount);


        for (Account acc : accounts) {
            System.out.println(acc.getCcNum() +" : " + acc.getPinNum());
        }


    }

    public List<Account> getAccounts() {
        return accounts;
    }

}
