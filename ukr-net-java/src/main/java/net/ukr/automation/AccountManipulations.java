package net.ukr.automation;

import net.ukr.automation.objects.Account;
import net.ukr.automation.objects.User;


public class AccountManipulations {

    public static void main(String[] args) {

        Account account = new Account("admin","parol");
        Account account1 = new Account("admin1","parol");
        Account account2 = new Account("admin2","parol");

//        User user = new User();
//        user.firstName = "Petya";
//        user.lastName = "Petrov";

Account.showPassword();

        account.showAllInfo();
        account1.showAllInfo();
        account2.showAllInfo();

        account.updatePassword("vasya");
        account2.updatePassword("vasya2");
       // account1.updatePassword("vasya3");

        account.showAllInfo();
        account1.showAllInfo();
        account2.showAllInfo();
//
////        account.user.lastName ="Vasiliy";
////        account.user.firstName = "Vasiliy";
////
////        account1.user = user;
////        account2.user = user;
//
//        account1.showAllInfo();
//        account2.showAllInfo();
//        //account.updatePassword("sd;lfjsdlk");
//        account.showAllInfo();
    }

}
