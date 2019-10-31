package net.ukr.automation.oop.child;

import net.ukr.automation.oop.base.Element;

public class Button extends Element {

    public void click()
    {
        System.out.println("Button clicked");
    }


    @Override
    public void getRect() {
        Text txt = new Text();
        txt.setValue("Sds");

        System.out.println("I'm button with:");

    }

  public class Text
   {
       public String getValue() {
          System.out.println("aaaa");
           return value;
       }

       public void setValue(String value) {
           this.value = value;
       }

       String value;


   }

}


