import java.util.Queue;
import java.util.Scanner;

public class Assignment7LaunchQueue {
       public static Scanner reader = new Scanner(System.in);
       public static int Choice = 0;

       public static void main(String[] args) {
              String inputChar;
              int inputOption;           
              CustomQueue qu = new CustomQueue();
              
              
              while (Choice != 9) {
                     Choice = Prompt();
                     
                     System.out.println("Enter a character value...");
                     inputChar = reader.next();
                     
                     if (Choice == 1) {
                           qu.enqueue(inputChar);
                     }
                     else if (Choice == 2) {
                           qu.denqueue(inputChar);
                     }
              }
       }
       
       public static int Prompt() {

              System.out.println("Please Enter: ");
              System.out.println("1 to add a character to the queue... ");
              System.out.println("2 to remove a character from the queue... ");
              System.out.println("9 to exit... ");
              
              return reader.nextInt();
       }

}
