public class Person {
	private String FirstName;
	private String LastName;
	
	public Person() {
		FirstName = "";
		LastName = "";
	}
	
	public Person(String first, String last) {
		FirstName = first;
		LastName = last;
	}
	
	public String ToString() {
		return (FirstName + " " + LastName);
	}

	public void SetName(String first, String last) {
		FirstName = first;
		LastName = last;
	}
	
	public String GetLastName() {
		return LastName;
	}
}