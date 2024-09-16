package finance;

public class CarLoan extends PersonalLoan {
// we are overriding this method
	@Override
	public float common(double amount, int period) {
		return 13.5f;
	}
}

