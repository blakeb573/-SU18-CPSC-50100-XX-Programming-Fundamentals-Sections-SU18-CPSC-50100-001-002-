import java.util.Scanner;
import java.text.DecimalFormat;

public class Flyers {

       public static final String DA = "Delivery";
       public static final String DNA = "Delivery not Available";
       public static final String DX = "Delivery with Extra Cost";
       public static final String InvalidInput = "Invalid Input, Please Try Again...";
       public static void main(String[] args) {
              int orderChoice = 0; //1 = pick-up, 2 = delivery
              int storeZipCode = 60446;
              int inputZipCode;
              double billTotal = 0.00;
              String zipResult = "";
              Scanner reader;
              Boolean finishedOrdering = false;
              
              
              reader = new Scanner(System.in);
              
              while (orderChoice != 1 && orderChoice != 2) {                           
                     orderChoice = GreetCustomer(reader);
                     if (orderChoice > 2 || orderChoice < 1) {
                           System.out.println(InvalidInput);                           
                     }
              }
                           
              if (orderChoice == 2) {
                     System.out.println("Please enter your Zip Code:");
                     
                     inputZipCode = reader.nextInt();
                     zipResult = IsValidZip(storeZipCode, inputZipCode);
                     System.out.println(zipResult);
                     
                     if (zipResult == DNA)
                           return;
              }
              
              while (!finishedOrdering) {
                     double singleOrder = TakeOrder(reader);
                     if (singleOrder == 0) {
                           finishedOrdering = true;                       
                     }
                     else if (singleOrder == -1) {
                           System.out.println(InvalidInput);
                     }
                     else {                     
                           billTotal += singleOrder;
                     }                    
              }
              
              billTotal += billTotal + (billTotal * .05);
              billTotal += CalculateDeliveryCost(zipResult);
              
              DecimalFormat dec = new DecimalFormat("#0.00");
              System.out.println("Total Bill Amount: " + dec.format(billTotal));
              
              
              
       }
       
       public static int GreetCustomer(Scanner reader) {          
              System.out.println("Hello Customer, Welcome to Fryers!");
              System.out.println("Would you like pick-up or delivery? Enter 1 for pick-up, and 2 for delivery.");
              
              return reader.nextInt();
       }
       
       public static double CalculateDeliveryCost(String deliveryResult) {
              switch (deliveryResult) {
                     case DA: return 5.00;
                     case DX: return 7.00;
                     default: return 0;
              }
       }
       
       public static double TakeOrder(Scanner reader) {
              int inputOrder;
              double burgerValue = 4.50;
              double drinkValue = 1.50;
              double friesValue = 2.50;
              double dessertValue = 3.00;
              
              System.out.println("Please choose from our menu:");
              System.out.println("Enter 1 for a Burger..." + burgerValue);
              System.out.println("Enter 2 for a Drink..." + drinkValue);
              System.out.println("Enter 3 for Fries..." + friesValue);
              System.out.println("Enter 4 for Dessert..." + dessertValue);
              System.out.println("Enter 5 when you are finished ordering");
              
              inputOrder = reader.nextInt();
              
              switch (inputOrder) {
                     case 1: return burgerValue;
                     case 2: return drinkValue;
                     case 3: return friesValue;
                     case 4: return dessertValue;
                     case 5: return 0;
                     default: return -1;
              }
                     
              
       }
       
       
       public static String IsValidZip(int baseZipCode, int inputZipCode) {
              int availableMax = baseZipCode + 4;
              int availableMin = baseZipCode - 4;
              int extraMax = baseZipCode + 5;
              int extraMin = baseZipCode - 5;
              
              if (inputZipCode <= availableMax && inputZipCode >= availableMin) {
                     return DA;
              }
              else if (inputZipCode <= extraMax && inputZipCode >= extraMin) {
                     return DX;
              }
              else {
                     return DNA;
              }
                     
              
       }

}
