package net.ukr.automation.oop.child;

import net.ukr.automation.oop.base.Element;

public class Input extends Element {

    private String value="";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setValue(String str1, String str2) {
        this.setValue(str1 +" : "+str2);
    }


    public void setValue(int value) {
        this.value = Integer.toString(value);
    }

    public void printValue()
    {
        System.out.println(this.value);
    }

    @Override
    public void getRect() {
        System.out.println("I'm Input with:");
        //getRectParams();
    }
}
