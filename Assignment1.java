//*******************************************************
//
// Class: Programming Fundamentals CPSC-50100
// Author: Blake Buchanan
// Assignment: Week 1, Assignment1
//
//*******************************************************


package javaTurorial1Math;

import java.text.DecimalFormat;

public class Assignment1
{

	public static void main(String[] args) 
	{
		DecimalFormat df = new DecimalFormat("#0.00");
		DecimalFormat dfint = new DecimalFormat("##.##");
		
		double tScore1 = 75;
		double tScore2 = 95;
		double tScore3 = 85;
		double tScore4 = 55;
		double tScore5 = 65;
		double tScore6 = 70;
		
		double tWeight1 = 0.10;
		double tWeight2 = 0.20;
		double tWeight3 = 0.25;
		double tWeight4 = 0.25;
		double tWeight5 = 0.10;
		double tWeight6 = 0.10;
		
		double weightedTestAverage1 = (tScore1 / 100) * tWeight1;
		double weightedTestAverage2 = (tScore2 / 100) * tWeight2;
		double weightedTestAverage3 = (tScore3 / 100) * tWeight3;
		double weightedTestAverage4 = (tScore4 / 100) * tWeight4;
		double weightedTestAverage5 = (tScore5 / 100) * tWeight5;
		double weightedTestAverage6 = (tScore6 / 100) * tWeight6;
		
		double aScore1 = 55;
		double aScore2 = 65;
		double aScore3 = 65;
		double aScore4 = 60;
		double aScore5 = 55;
		double aScore6 = 50;
		
		double aWeight1 = 0.05;
		double aWeight2 = 0.10;
		double aWeight3 = 0.15;
		double aWeight4 = 0.25;
		double aWeight5 = 0.25;
		double aWeight6 = 0.20;
		
		double weightedAssignmentAverage1 = (aScore1 / 100) * aWeight1;
		double weightedAssignmentAverage2 = (aScore2 / 100) * aWeight2;
		double weightedAssignmentAverage3 = (aScore3 / 100) * aWeight3;
		double weightedAssignmentAverage4 = (aScore4 / 100) * aWeight4;
		double weightedAssignmentAverage5 = (aScore5 / 100) * aWeight5;
		double weightedAssignmentAverage6 = (aScore6 / 100) * aWeight6;
		
		double totalWeightedTestAverage = (weightedTestAverage1 + weightedTestAverage2 + weightedTestAverage3
											+ weightedTestAverage4 + weightedTestAverage5 + weightedTestAverage6) * 100; 
		
		double totalWeightedAssignmentAverage = (weightedAssignmentAverage1 + weightedAssignmentAverage2 
											+ weightedAssignmentAverage3 + weightedAssignmentAverage4 
											+ weightedAssignmentAverage5
											+ weightedAssignmentAverage6) * 100;
		
		System.out.println("The first test score is "+ dfint.format(tScore1) + " and the weight is " + df.format(tWeight1) 
							+ " which equals a weighted average of " + df.format(weightedTestAverage1) + "");
		
		System.out.println("The first test score is "+ dfint.format(tScore2) + " and the weight is " + df.format(tWeight2)
				+ " which equals a weighted average of " + df.format(weightedTestAverage2) + "");
		
		System.out.println("The first test score is "+ dfint.format(tScore3) + " and the weight is " + df.format(tWeight3)
				+ " which equals a weighted average of " + df.format(weightedTestAverage3) + "");
		
		System.out.println("The first test score is "+ dfint.format(tScore4) + " and the weight is " + df.format(tWeight4)
				+ " which equals a weighted average of " + df.format(weightedTestAverage4) + "");
		
		System.out.println("The first test score is "+ dfint.format(tScore5) + " and the weight is " + df.format(tWeight5)
				+ " which equals a weighted average of " + df.format(weightedTestAverage5) + "");
		
		System.out.println("The first test score is "+ dfint.format(tScore6) + " and the weight is " + df.format(tWeight6)
				+ " which equals a weighted average of " + df.format(weightedTestAverage6) + "");
		
		System.out.println();
		
		System.out.println("The Master Average of all six test scores is " + df.format(totalWeightedTestAverage) + "" );
		
		System.out.println();
		System.out.println();
		
		System.out.println("The first assignment score is "+ dfint.format(aScore1) + " and the weight is " + df.format(aWeight1)
				+ " which equals a weighted average of " + df.format(weightedAssignmentAverage1) + "");
		
		System.out.println("The first assignment score is "+ dfint.format(aScore2) + " and the weight is " + df.format(aWeight2)
				+ " which equals a weighted average of " + df.format(weightedAssignmentAverage2) + "");
		
		System.out.println("The first assignment score is "+ dfint.format(aScore3) + " and the weight is " + df.format(aWeight3)
				+ " which equals a weighted average of " + df.format(weightedAssignmentAverage3) + "");
		
		System.out.println("The first assignment score is "+ dfint.format(aScore4) + " and the weight is " + df.format(aWeight4)
				+ " which equals a weighted average of " + df.format(weightedAssignmentAverage4) + "");
		
		System.out.println("The first assignment score is "+ dfint.format(aScore5) + " and the weight is " + df.format(aWeight5)
				+ " which equals a weighted average of " + df.format(weightedAssignmentAverage5) + "");
		
		System.out.println("The first assignment score is "+ dfint.format(aScore6) + " and the weight is " + df.format(aWeight6)
				+ " which equals a weighted average of " + df.format(weightedAssignmentAverage6) + "");
		
		System.out.println();
		
		System.out.println("The Master Average of all six Assignment scores is " + df.format(totalWeightedAssignmentAverage) + "" );
	}

}
