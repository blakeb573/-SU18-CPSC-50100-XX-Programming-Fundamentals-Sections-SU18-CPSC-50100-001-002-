import java.util.Scanner;

public class Assignment3 {


    public static final String ElevatorState_Open = "O";
    public static final String ElevatorState_Closed = "C";
    public static String CurrentElevatorState = "C";
    
    public static final int FloorCount = 3;
    public static int CurrentFloor = 0;
    public static int RequestedFloor = 0;
    
    public static final String WheelState_Up = "U";
    public static final String WheelState_Down = "D";
    public static final String WheelState_Resting = "R";
    public static String CurrentWheelState = "R";
    
    public static Boolean exit;
    
    public static Scanner reader = new Scanner(System.in);
       
       public static void main(String[] args) {
              
              while (TakeFloorRequestInput() != 9) {
                     int floorChangeCount = Math.abs(CurrentFloor - RequestedFloor);
                     ControlWheelState(CurrentFloor, RequestedFloor);
                     MoveElevator(CurrentWheelState, floorChangeCount);
                     
                     System.out.println("The Elevator has arrived at floor: " + CurrentFloor);
                     
                     ControlDoorState(true);
                     
                     try        
                     {
                           Thread.sleep(floorChangeCount * 3000);
                     } 
                     catch(InterruptedException ex) 
                     {
                           Thread.currentThread().interrupt();
                     }
                     
                     
                     ControlDoorState(false);
              }
        
        return;
       }
       
       public static int TakeFloorRequestInput() {
              
        System.out.println("Current Floor: " + CurrentFloor); 
        System.out.println("SELECTION: 0, 1, 2... 9 to exit"); 
        RequestedFloor = reader.nextInt();
        System.out.println("Requested Floor: " + RequestedFloor);
        return RequestedFloor;
       }
       
       public static void ControlWheelState(int currentFloor, int requestedFloor) {
              if (currentFloor == requestedFloor) {
                     CurrentWheelState = WheelState_Resting;
                     System.out.println("The wheel is in state: " + WheelState_Resting);
              }
              else if (currentFloor < requestedFloor) {
                     CurrentWheelState = WheelState_Up;            
                     System.out.println("The wheel is in state: " + WheelState_Up);    
              }
              else if (currentFloor > requestedFloor) {
                     CurrentWheelState = WheelState_Down;                 
                     System.out.println("The wheel is in state: " + WheelState_Down);
              }
       }
       
       public static void MoveElevator(String wheelState, int floorCount) {
              if (wheelState == WheelState_Up) {
                     CurrentFloor += floorCount;
                     System.out.println("The Elevator is moving up " + floorCount + " floors.");
              }
              else if (wheelState == WheelState_Down) {
                     CurrentFloor -= floorCount;                    
                     System.out.println("The Elevator is moving down " + floorCount + " floors.");
              }
       }
       
       public static void ControlDoorState(Boolean open) {
              if (open) {
                     CurrentElevatorState = ElevatorState_Open;
                     System.out.println("The Elevator State is: " + ElevatorState_Open);
              }
              else {
                     CurrentElevatorState = ElevatorState_Closed;
                     System.out.println("The Elevator State is: " + ElevatorState_Closed);
                     
              }
       }
}
