package net.ukr.automation.oop.child;

import net.ukr.automation.oop.base.Printer;
import net.ukr.automation.oop.base.WebDriver;

public class ChromeDriver implements WebDriver, Printer {

    @Override
    public void setDriver() {

    }

    @Override
    public int getDriverVersion() {
        return 0;
    }

    @Override
    public void printVersion() {
        print();
      System.out.println("I'm Chrome 10");
    }

    @Override
    public void print() {

    }
}
