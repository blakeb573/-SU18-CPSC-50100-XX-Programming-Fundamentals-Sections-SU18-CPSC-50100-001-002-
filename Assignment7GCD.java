import java.util.Scanner;


public class Assignment7GCD {
       
       public static Scanner reader = new Scanner(System.in);

       public static void main(String[] args) {
              int val1;
              int val2;
              System.out.println("GCD Calc...");
              
              System.out.println("Please enter the first value...");
              val1 = reader.nextInt();
              
              System.out.println("Please enter the second value...");
              val2 = reader.nextInt();
              
              try {
                     System.out.println("" + CalculateGdc(val1, val2));
              }
              catch(ArithmeticException ex) {
                     System.out.println(ex.getMessage());
              }
       }
       
       public static int CalculateGdc(int val1, int val2) {
              int result;
              if (val1 == 0 || val2 == 0) 
                     result = val1 + val2;            
              else
                     return CalculateGdc(val2, val1%val2);
              
              if (result == 1)
                     throw new ArithmeticException("GCD is 1");
              
              return result;             
       }
}
