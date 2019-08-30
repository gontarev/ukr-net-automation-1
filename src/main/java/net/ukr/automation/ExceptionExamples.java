package net.ukr.automation;



public class ExceptionExamples {

    static int print(int x, int y)
    {
        System.out.println("From Method: " + (int)(x+y));
      return x+y;
    }

    static void print(String x, int y)
    {
        System.out.println("From Method: " + x+y);

    }

    public static void main(String[] args) {

        int[] array = {2,3,4} ;

        final int A;
;;;;;
;;;;


       try {
           int a = print(array[2], 4);

           System.out.println("from try: "+ a);

           throw new ArrayIndexOutOfBoundsException("Array is bad");
       }
       catch (ArrayIndexOutOfBoundsException ex)
       {
           System.out.println("Sorry? use correct index  " +ex.getMessage());
       }
       finally {
           System.out.println("Almost done");
       }

        System.out.println("Everything is fine");
    }
}
