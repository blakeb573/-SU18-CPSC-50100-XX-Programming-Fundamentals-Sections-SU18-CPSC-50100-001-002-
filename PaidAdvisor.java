public class PaidAdvisor extends Person {
	public int RegularPayRate = 0;
	public int SpecialPayRate = 0;
	public int OvertimePayRate = 0;
	public int HoursWorked = 0;
	public int SpecialHoursWorked = 0;
	public final int MaxRegularHours = 30;
	
	public PaidAdvisor(int hoursWorked, int specialHoursWorked) {
		RegularPayRate = 25;
		SpecialPayRate = 50;
		OvertimePayRate = RegularPayRate + (RegularPayRate/2);
		HoursWorked = hoursWorked;
		SpecialHoursWorked = specialHoursWorked;
	}

	public PaidAdvisor(int regularPayRate, int overtimePayRate, int specialPayRate, int regularHoursWorked, int specialHoursWorked
			, String firstName, String lastName){
		
		SetNameRateHours(regularPayRate, overtimePayRate, specialPayRate, regularHoursWorked, specialHoursWorked, firstName, lastName);
	}

	public int GetPayRate(PayRateTypes payRateType) {
		if (payRateType == PayRateTypes.Regular)
			return RegularPayRate;
		else if (payRateType == PayRateTypes.Overtime)
			return OvertimePayRate;
		else if (payRateType == PayRateTypes.Special)
			return SpecialPayRate;
		
		return 0;
	}
	
	public int GetHoursWorked(HoursWorkedType hoursWorkedType) {
		if (hoursWorkedType == HoursWorkedType.Regular)
			return HoursWorked;
		else if (hoursWorkedType == HoursWorkedType.Special)
			return SpecialHoursWorked;
		
		return 0;
	}
	
	public double CalculatePay(int hoursWorked, int specialHoursWorked) {
		AddHoursWorked(HoursWorkedType.Regular, hoursWorked);
		AddHoursWorked(HoursWorkedType.Special, specialHoursWorked);
		
		
		int RegularPayRate = GetPayRate(PayRateTypes.Regular);
		int OvertimePayRate = GetPayRate(PayRateTypes.Overtime);
		int SpecialPayRate = GetPayRate(PayRateTypes.Special);
		int HoursWorked = GetHoursWorked(HoursWorkedType.Regular);
		int SpecialHoursWorked = GetHoursWorked(HoursWorkedType.Special);
		
		double pay = 0;
		
		if (HoursWorked > MaxRegularHours) {
			pay = RegularPayRate * MaxRegularHours;
			pay += OvertimePayRate * (HoursWorked - MaxRegularHours);
		}
		else 
			pay = RegularPayRate * HoursWorked;
			
		pay += SpecialPayRate * SpecialHoursWorked;
				
		return pay;
	}
	
	public void AddHoursWorked(HoursWorkedType hoursWorkedType, int hours) {
		if (hoursWorkedType == HoursWorkedType.Regular)
			HoursWorked += hours;
		else if (hoursWorkedType == HoursWorkedType.Special)
			SpecialHoursWorked += hours;		
	}
	
	public void SetPayRate(PayRateTypes payType, int rate) {
		
		if (payType == PayRateTypes.Regular)
			RegularPayRate = rate;
		else if (payType == PayRateTypes.Overtime)
			OvertimePayRate = rate;
		else if (payType == PayRateTypes.Special)
			SpecialPayRate = rate;
		
	}
	
	public void SetNameRateHours(int regularPayRate, int overtimePayRate, int specialPayRate, int regularHoursWorked, int specialHoursWorked
								, String firstName, String lastName) {
		
		SetName(firstName, lastName);
		SetPayRate(PayRateTypes.Regular, regularPayRate);
		SetPayRate(PayRateTypes.Overtime, overtimePayRate);
		SetPayRate(PayRateTypes.Special, specialPayRate);
		AddHoursWorked(HoursWorkedType.Regular, regularHoursWorked);
		AddHoursWorked(HoursWorkedType.Special, specialHoursWorked);
	}
	

	public enum PayRateTypes{
		Regular, Special, Overtime
	}
	public enum HoursWorkedType{
		Regular, Special
	}
	
}