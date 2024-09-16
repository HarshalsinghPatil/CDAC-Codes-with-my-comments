using System;
//In c# we provide the enum in this way
enum RiskLevel {None, Low, High}
//notice here we have used the Struct
struct Investment
{
    private double payment;
    private int count;
    private RiskLevel risk;

    public Investment(double amount, int years)
    {
        payment = amount;
        count = years;
        risk = RiskLevel.None;//1. by default we set the risk to the none
    }
//to use the all three types of risks we are doing here function overloading in ==> AllowRisk method
    public void AllowRisk(bool yes)
    {//2. using the boolean we can only switch between two risk levels
        risk = yes ? RiskLevel.Low : RiskLevel.None;
    }

    //method overloading - defining a method whose name matches
    //with another method defined in its type but with different
    //list of parameter types
    public void AllowRisk(RiskLevel level)
    {// hence to use the high level risk we have use this overloaded function
        risk = level;
    }

    public double TotalAmount()
    {
        return payment * count;       
    }
//here we are calculating the future value with the different types of the risks associated with them
    public double FutureValue()
    {
        float i;
        switch(risk)
        {
            case RiskLevel.Low:
                i = 0.08f;
                break;
            case RiskLevel.High:
                i = 0.11f;
                break;
            default:
                i = 0.06f;
                break;
        }
        return (payment / i) * (Math.Pow(1 + i, count) - 1);
    }
}
