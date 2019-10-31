package net.ukr.automation.oop.base;

public enum Colors implements WebDriver{
    GREEN,
    BLUE,
    RED,
    Yellow;

    public void print()
    {
        System.out.println(this);
    }

    @Override
    public void setDriver() {

    }

    @Override
    public int getDriverVersion() {
        return 0;
    }

    @Override
    public void printVersion() {

    }
}
