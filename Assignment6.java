import java.util.ArrayList;
import java.util.Scanner;

public class Assignment6 {

	private static final int End = 9;
	private static int CurrentSelection = 0;
	private static ArrayList<PaidAdvisor> PaidAdvisors;
    public static Scanner reader = new Scanner(System.in);
    public static PaidAdvisor SelectedAdvisor;
	
	public static void main(String[] args) {
		PaidAdvisor pa0 = new PaidAdvisor(25, (25 + (25/2)), 50, 12, 5, "John", "Doe"); 
		PaidAdvisor pa1 = new PaidAdvisor(25, (25 + (25/2)), 50, 40, 1, "Paul", "Simon");
		PaidAdvisor pa2 = new PaidAdvisor(25, (25 + (25/2)), 50, 40, 1, "Cameron", "Little");
		
		PaidAdvisors = new ArrayList<PaidAdvisor>();
		PaidAdvisors.add(pa0);
		PaidAdvisors.add(pa1);
		PaidAdvisors.add(pa2);
		
		
		while (CurrentSelection < End) {
			System.out.println("Please Enter...");
			System.out.println("1). List Current Employees");
			System.out.println("2). Create New Employee");
			System.out.println("3). Select Employee by Name");
			System.out.println("9). exit");
			
			CurrentSelection = reader.nextInt();
			
			if (CurrentSelection == 1)
				ListCurrentEmployees();			
			if (CurrentSelection == 2)
				AddEmployee();
			if (CurrentSelection == 3)
				SelectEmployee();
		}		
	}
	
	public static void ListCurrentEmployees() {
		for (int i = 0; i < PaidAdvisors.size(); i++) {
			System.out.println(((PaidAdvisor)PaidAdvisors.get(i)).ToString());
		}
	}
	
	public static void SelectEmployee() {
		System.out.println("Please Enter Last Name:");
		String lastName = "";
		lastName = reader.next();		

		for (int i = 0; i < PaidAdvisors.size(); i++) {
			String loopLastName = ((PaidAdvisor)PaidAdvisors.get(i)).GetLastName();
			if (loopLastName.equals(lastName)) {
				SelectedAdvisor = ((PaidAdvisor)PaidAdvisors.get(i));
			}
		}
				
		int end = 9;
		int current = 0;
		while (current != end) {
			System.out.println("You've selected: " + SelectedAdvisor.ToString());
			
			System.out.println("Regular Rate: " + SelectedAdvisor.GetPayRate(PaidAdvisor.PayRateTypes.Regular));
			System.out.println("Overtime Rate: " + SelectedAdvisor.GetPayRate(PaidAdvisor.PayRateTypes.Overtime));
			System.out.println("Special Rate: " + SelectedAdvisor.GetPayRate(PaidAdvisor.PayRateTypes.Special));
		
			System.out.println("Regular Hours Worked: " + SelectedAdvisor.GetHoursWorked(PaidAdvisor.HoursWorkedType.Regular));
			System.out.println("Special Hours Worked: " + SelectedAdvisor.GetHoursWorked(PaidAdvisor.HoursWorkedType.Special));
			
			System.out.println("Total Pay: " + SelectedAdvisor.CalculatePay(0, 0));
			
			System.out.println();
			System.out.println("Please Enter:");
			System.out.println("1). Add Hours Worked");
			System.out.println("2). Add Special Hours Worked");
			System.out.println("3). Set Rates");
			System.out.println("9). Return");
			
			current = reader.nextInt();
			
			if (current == 1) {
				AddRegHours();
			}
			else if (current == 2) {
				AddSpecHours();
			}
			else if (current == 3) {
				SetRates();
			}
		}		
	}
	
	public static void SetRates() {

		System.out.println("Please Enter...");
		System.out.println("1). for Regular Hours:");
		System.out.println("2). for Special Hours");
		
		int current = reader.nextInt();
		
		System.out.println("Rate:");
		
		int rate = reader.nextInt();
		
		if (current == 1) {
			SelectedAdvisor.SetPayRate(PaidAdvisor.PayRateTypes.Regular, rate);			
		}
		else if (current == 2) {
			SelectedAdvisor.SetPayRate(PaidAdvisor.PayRateTypes.Special, rate);		
		}
	}
	
	public static void AddRegHours() {
		System.out.println("Enter Hours:");
		int hours = reader.nextInt();
		SelectedAdvisor.AddHoursWorked(PaidAdvisor.HoursWorkedType.Regular, hours);
	}
	public static void AddSpecHours() {
		System.out.println("Enter Hours:");
		int hours = reader.nextInt();
		SelectedAdvisor.AddHoursWorked(PaidAdvisor.HoursWorkedType.Special, hours);
	}
	
	public static void AddEmployee() {
		System.out.println("Please Enter:");
		
		System.out.println("First Name:");
		String firstName = reader.next();
		
		System.out.println("Last Name:");
		String lastName = reader.next();
		
		System.out.println("Regular Rate:");
		int regRate = reader.nextInt();
		
		System.out.println("Special Rate:");
		int specRate = reader.nextInt();
		
		System.out.println("Regular Hours Worked:");
		int regHours = reader.nextInt();
		
		System.out.println("Special Hours Worked:");
		int specHours = reader.nextInt();
		
		PaidAdvisor pa0 = new PaidAdvisor(regRate, (regRate + (regRate/2)), specRate, regHours, specHours, firstName, lastName); 
		PaidAdvisors.add(pa0);
	}
}