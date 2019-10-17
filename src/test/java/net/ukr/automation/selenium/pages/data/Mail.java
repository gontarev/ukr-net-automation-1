package net.ukr.automation.selenium.pages.data;

public class Mail {
    User user;
    String subject;
    String body;


    public Mail(User user) {
        setUser(user);
    }

    public User getUser() {
        return user;
    }

    private void setUser(User user) {
        this.user = user;
    }

    public String getSubject() {
        return subject;
    }

    public Mail setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getBody() {
        return body;
    }

    public String getSubjAndBodyLine() {
        return subject+"  "+body;
    }

    public Mail setBody(String body) {
        this.body = body;
        return this;
    }
}
