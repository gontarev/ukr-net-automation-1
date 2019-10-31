package net.ukr.automation.oop.child;

import net.ukr.automation.oop.base.WebDriver;

public class MyNewDriver implements WebDriver {

    @Override
    public void setDriver() {

    }

    @Override
    public int getDriverVersion() {
        return 0;
    }

    @Override
    public void printVersion() {
       System.out.println(version);
    }
}
