using System;

class Investment
{

    // In java, in constructor we have initialised "risky=false" But
    //here in C#, we can make it false in default parameters directly 
    public static double FutureValue(double payment, int count, bool risky=false)
    {
        float i = risky ? 0.08f : 0.06f;
        return (payment / i) * (Math.Pow(1 + i, count) - 1);
    }

    /* 
     Understanding the Parameters:
        payment - The fixed payment amount made at regular intervals.
        count - The total number of payments (time periods).
        risky - A boolean flag indicating whether the investment is risky.
            If risky is true, the interest rate (i) is 8% (0.08).
            If risky is false, the interest rate (i) is 6% (0.06).
        
    ------------------------------------------------
       // Future Value formula:
         FV = (P * ((1 + i)^n - 1)) / i
         P = Payment per period
         i = Interest rate per period
         n = Number of periods


    */
}