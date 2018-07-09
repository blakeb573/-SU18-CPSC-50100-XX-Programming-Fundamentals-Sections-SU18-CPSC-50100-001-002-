import java.util.Random;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Assignment5 extends Application {

       public int MainSquareSize = 0;
       public int MainSquareInnerSize = 0;
       
       public static void main(String[] args) {
              launch(args);
       }
       
       @Override
       public void start (Stage primaryStage) {
              Group root = new Group();
              Scene scene = new Scene(root, 512, 512, Color.WHITE);
              Stage s = new Stage();
              
              GenerateRandomPatterns(root);
              GenerateMainSquares(Corners.TopLeft, root);
              GenerateMainSquares(Corners.TopRight, root);
              GenerateMainSquares(Corners.BottomLeft, root);
                  
           s.setScene(scene);
           s.show();
       }
       
       public void GenerateRandomPatterns(Group group) {
              int xCord = 0;
              int yCord = 0;
              int numOfTenSquareDimensions = 510/10;
              int setBlack = 0;
              Random rand = new Random();
              
              for (int y = 0; y < numOfTenSquareDimensions; y++) {
                     xCord = 0;
                     for (int x = 0; x < numOfTenSquareDimensions; x++) {              
                           setBlack = rand.nextInt(2);
                           xCord = xCord + 10;
                           if (setBlack == 1) {
                                  Rectangle r = new Rectangle(xCord, yCord, 10, 10);
                                  r.setFill(Color.BLACK);
                                  
                                  group.getChildren().add(r);                           
                           }
                     }
                     yCord = yCord + 10; 
              }
       }
       
       public void GenerateMainSquares(Corners corner, Group group) {
              int startX = 5;
              int startY = 5;
              int sizeX = 0;
              int sizeY = 0;
              Random rand = new Random();
              Group innerGroup = new Group();
              
              if (MainSquareSize == 0)
                     MainSquareSize = rand.nextInt(150-100 + 1) + 100;    
              
              if (corner == Corners.TopLeft) {        
              }
              else if (corner == Corners.TopRight) {
                     startX = 507-MainSquareSize;
              }
              else if (corner == Corners.BottomLeft) {
                     startY = 507 - MainSquareSize;                 
              }
                     
              Rectangle r = new Rectangle(startX, startY, MainSquareSize, MainSquareSize);
              r.setFill(Color.WHITE);
              r.setStrokeWidth(10);
              r.setStroke(Color.BLACK);
              
              innerGroup.getChildren().add(r);
              GenerateMainInnerSquares(innerGroup, startX, startY);
              
              group.getChildren().add(innerGroup);
       }
       
       public void GenerateMainInnerSquares(Group group, int startX, int startY) {           
              Random rand = new Random();
              
              
              if (MainSquareInnerSize == 0)
                     MainSquareInnerSize = rand.nextInt(((MainSquareSize - 70)-30) + 1) + (MainSquareSize - 30)-30; 
              
              int diffInSize = MainSquareSize - MainSquareInnerSize;
              
              Rectangle r = new Rectangle((startX + (diffInSize/2)), (startY + (diffInSize/2)), MainSquareInnerSize, MainSquareInnerSize);
              r.setFill(Color.BLACK);
              group.getChildren().add(r);
              r.toFront();
       }

       public enum Corners{
              TopLeft, TopRight, BottomLeft, BottomRight;
       }
       
}
