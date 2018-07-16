import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Assignment8{
       public static Scanner reader = new Scanner(System.in);
       public static String Choice = "";
       public static List<Node> nodeList;

       public static void main(String[] args) {
              
              nodeList = new ArrayList<Node>();
              
              while (Choice != "Exit") {
                     Choice = Prompt();
                                         
                     if (Choice == "Print") {
                           PrintList();
                     }
                     else {                     
                           AddItem(Choice);                        
                     }
              }
       }
       
       public static void PrintList() {

              SortList();
              for(int i = 0; i < nodeList.size(); i++) {
                     String Left = nodeList.get(i).left != null ? nodeList.get(i).left.value : "n/a";
                     String Right = nodeList.get(i).right != null ? nodeList.get(i).right.value : "n/a";
                     
                     System.out.println(Left + " | " + nodeList.get(i).value + " | " + Right);
              }
       }      
       
       public static void AddItem(String Value) {
              Node n = new Node(Value);
              Node compareNode;
              
              if (nodeList.size() == 0) {
                     nodeList.add(0, n);
              }
              else { 
                     Boolean add = false;
                     for(int i = 0; i < nodeList.size(); i++) {
                           compareNode = nodeList.get(i); 
                           
                           
                           int compareResult = n.value.compareTo(compareNode.value);
                           if (compareResult <= 0) {
                                  nodeList.add(i, n);
                                  break;       
                           }                    
                           else if (i == nodeList.size() - 1) {   
                                  nodeList.add(n);
                                  break;                                   
                           }                    
                     }
              }
              
              
              PrintList();
       }
       
       public static void SortList() {
              for(int i = 0; i < nodeList.size(); i++) {
                     if (i - 1 >= 0)
                           nodeList.get(i).left = nodeList.get(i - 1);   
                     
                     if (i + 1 < nodeList.size())
                           nodeList.get(i).right = nodeList.get(i + 1);
              }
       }
       
       public static String Prompt() {

              System.out.println("Please Enter a string to add it to the list. Type: 'Print' to print and 'Exit' to exit");
              
              return reader.next();
       }

}
