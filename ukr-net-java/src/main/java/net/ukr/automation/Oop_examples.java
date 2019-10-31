package net.ukr.automation;

import net.ukr.automation.oop.base.Colors;
import net.ukr.automation.oop.base.Printer;
import net.ukr.automation.oop.base.WebDriver;
import net.ukr.automation.oop.child.Button;
import net.ukr.automation.oop.child.ChromeDriver;
import net.ukr.automation.oop.child.Input;
import net.ukr.automation.oop.child.MyNewDriver;

public class Oop_examples {

    public static void main(String[] args) {

        Button btn = new Button();
        Input input = new Input();

        btn.setLength(12);
        btn.getRect();
        btn.click();
//
        input.printValue();
        input.setValue("Lalala");
        input.setValue(10);
        input.setValue("Lalala", "bebe");
        ;
        input.printValue();
        input.getRect();

        System.out.println(10 + 10);
        System.out.println("10" + "10");

        WebDriver drv2 = new MyNewDriver();
        Printer drv3 = new ChromeDriver();

        drv2.printVersion();
       // drv3.printVersion();
        drv3.print();

        printColor(Colors.Yellow);
        Colors col = Colors.Yellow;
        col.print();

        Button btn2 = new Button();
        Button.Text txt = btn2.new Text();

       txt.setValue("asa");
        System.out.println(txt.getValue());


    }

    static void printColor(Colors col) {
        switch (col) {
            case BLUE:
                System.out.println("I'm blue");
                break;
            case RED:
                System.out.println("I'm Red");
                break;
            case GREEN:
                System.out.println("I'm Green");
                break;

        }
    }
}
