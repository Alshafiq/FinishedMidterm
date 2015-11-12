
public class Citation {
	
	private String firstName;
	private String lastName;
	
	public Citation(String first, String last)
	{
		firstName = first;
		lastName = last;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getFirstNameAbbrev() {
		return firstName.charAt(0) + ".";
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getLastNameWPeriod() {
		return (lastName + ".");
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
