package net.ukr.automation.selenium.pages.data;

public class User {
    private String login;
    private String password;

    public User(String login, String password) {
        setLogin(login);
        setPassword(password);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return login + "@ukr.net";
    }

    @Override
    public String toString()
    {
        return login +"/"+password;
    }
}
