using System;

class Investment
{
    //here in this code first we kept risk as false 
    public static double FutureValue(double payment, int count, bool risky=false)
    {
        float i = risky ? 0.08f : 0.06f;
        return (payment / i) * (Math.Pow(1 + i, count) - 1);
    }
}