import java.util.ArrayList;
import java.util.List;

public class CustomQueue {
       
       private static int MaxCharNum = 10;
       private static List<String> charList;
       
       public CustomQueue() {
              charList = new ArrayList<String>();
       }
       
       public static void enqueue(String value) {
              if (charList.size() <= MaxCharNum)
                     charList.add(value);
              else
                     throw new RuntimeException("Queue overflow");
       }

       public static void denqueue(String value) {
              if (!charList.contains(value)) {
                     throw new RuntimeException("Queue underflow");
              }
              else
                     charList.remove(value);
       }
       
}
