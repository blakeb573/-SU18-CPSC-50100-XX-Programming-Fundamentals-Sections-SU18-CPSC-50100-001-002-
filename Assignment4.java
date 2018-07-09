import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Assignment4 {
       
       public static int Exam1;
       public static int Exam2;
       public static int Exam3;
       public static int Exam4;
       public static final int ExamMax = 50;
       
       public static int Assignment1;
       public static int Assignment2;
       public static int Assignment3;
       public static int Assignment4;
       public static final int AssignmentMax = 75;
       
       public static double FinalGrade;
       
       public static Scanner reader;
       
       public static List Scores;
       
       public static int Exit = 0;
       
       public static void main(String[] args) {
              reader = new Scanner(System.in);
              Scores = new ArrayList<Double>();
              
              while (Exit == 0) {
                     FinalGrade = 
                                  TakeGrade(1, "E") +
                                  TakeGrade(2, "E") +
                                  TakeGrade(3, "E") +
                                  TakeGrade(4, "E") +
                                  TakeGrade(1, "A") + 
                                  TakeGrade(2, "A") + 
                                  TakeGrade(3, "A") + 
                                  TakeGrade(4, "A");
                     
                     Scores.add(FinalGrade);
                     
                     System.out.println("Final Score: " + FinalGrade);
                     
                     System.out.println("To Add Another Student, Enter 0. 1 - 9 to Exit.");
                     Exit = reader.nextInt();
              }
              
              double AverageScore = CalulateAverage(Scores);
              double StDev = CalculateStDev(Scores, AverageScore);
                           
              System.out.println("Average Student Score = " + AverageScore);
              System.out.println("Standard Deviation = " + StDev);
              
              double MaxA = AverageScore + (2 * StDev);
              double MaxB = AverageScore + (1 * StDev) >= MaxA ? MaxA - 1 : AverageScore + (1 * StDev);
              double MaxC = AverageScore >= MaxB ? MaxB - 1 : AverageScore;
              double MaxD = AverageScore - (1 * StDev) >= MaxC ? MaxC - 1 : AverageScore - (1 * StDev);
              double MaxF = AverageScore - (2 * StDev);
              
              System.out.println("A: " + (int)MaxA + " - " + ((int)MaxB + 1));
              System.out.println("B: " + (int)MaxB + " - " + ((int)MaxC + 1));
              System.out.println("C: " + (int)MaxC + " - " + ((int)MaxD + 1));
              System.out.println("D: " + (int)MaxD + " - " + ((int)MaxF + 1));
              System.out.println("F: less than " + (int)MaxF); 
              
       }
       
       public static double CalulateAverage(List<Double> Scores) {
              double AverageScore = 0;
              for(int a = 0; a < Scores.size(); a++) {
                     AverageScore += (double)Scores.get(a);
              }
              return AverageScore/Scores.size();
       }
       
       public static double CalculateStDev(List<Double> Scores, double AverageScore) {
              
              double SumOfSquares = 0;
              double[] Squares = new double[Scores.size()];
              double[] Deviations = new double[Scores.size()];
              
              for (int d = 0; d < Scores.size(); d++) {
                     Deviations[d] = (double)Scores.get(d) - AverageScore;             
              }
                           
              for(int s = 0; s < Squares.length; s++) {
                     Squares[s] = Deviations[s] * Deviations[s];
              }
              
              for (int ss = 0; ss < Squares.length; ss++) {
                     SumOfSquares = SumOfSquares + Squares[ss];
              }
              
              SumOfSquares = SumOfSquares / (Squares.length - 1);
              
              return Math.sqrt(SumOfSquares);
       }
       
       public static double TakeGrade(int taskNum, String taskType) {
              double Score;
              int MaxScore = taskType == "E" ? ExamMax : AssignmentMax;
              String TaskType = taskType == "E" ? "Exam" : "Assignment";
              
              
              switch(taskNum) {
                     case 1: System.out.println("Please Enter " + TaskType + " 1 Score: "); 
                     break;
                     case 2: System.out.println("Please Enter " + TaskType + " 2 Score: ");
                     break;
                     case 3: System.out.println("Please Enter " + TaskType + " 3 Score: ");
                     break;
                     case 4: System.out.println("Please Enter " + TaskType + " 4 Score: ");
                     break;

              }
                           
              Score = reader.nextDouble();
              
              if (Score > MaxScore || Score < 0) {
                     System.out.println("Invalid Score.");
                     Score = TakeGrade(taskNum, taskType);
              }
              
              return Score;
       }
}
