package net.ukr.automation.objects;

import java.util.UUID;

public  class Account extends User{

    UUID id = UUID.randomUUID();
    String login;
   static String password;
   // public User user = new User();

    public Account()
    {
        id = UUID.randomUUID();
    }

    public Account(String login, String password)
    {
        this.login = login;
        this.password = password;
    }

    public void updatePassword(String newPassword) {
        password = newPassword;
    }

    public static String showPassword()
    {
        System.out.println("static called");
        return password;
    }



    public void showAllInfo()
    {
        System.out.println("User:" +super.toString()+"\n"
                + "password: " + this.password+"\n"
                + "login: " + this.login+"\n"
                + "id: " + this.id+"\n" );
    }

    public String showUserInfo()
    {
        return super.toString();
    }
}
