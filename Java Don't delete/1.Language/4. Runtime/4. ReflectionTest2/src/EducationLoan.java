package finance;

public class EducationLoan {
//if we want to extend this loan to the max duration 
	@MaxDuration 
	public float common(double amount, int period) {
		return 6;
	}

	public float masters(double amount, int period) {
		return 6.5f;
	}
}

