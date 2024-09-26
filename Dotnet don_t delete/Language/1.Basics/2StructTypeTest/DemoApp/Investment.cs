using System;

struct Investment
{//In c# we have not declare the p'less c'tor (but its implicitely present internally)
    private double payment;
    private int count;
    private bool risk;

    public Investment(double amount, int years)
    {
        payment = amount;
        count = years;
        risk = false;//hardcoded can't be changed so we have used setter(allow risk)
    }

    public void AllowRisk(bool yes)//Setter for hardcoded value
    {
        risk = yes;
    }

    public double TotalAmount()
    {
        return payment * count;       
    }

    public double FutureValue()
    {
        float i = risk ? 0.08f : 0.06f;
        return (payment / i) * (Math.Pow(1 + i, count) - 1);
    }
}
