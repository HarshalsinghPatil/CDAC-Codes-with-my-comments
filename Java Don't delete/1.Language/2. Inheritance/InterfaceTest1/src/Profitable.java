package edu.met.banking;
//we will get interest in saving account only but we already extended it to the account class so have used profittable interface
public interface Profitable {

	double interest(int months);

	float MIN_RATE = 4.0f;
}

