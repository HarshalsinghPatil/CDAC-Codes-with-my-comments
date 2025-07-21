//program of "for each" loop
class Program
{
//like default argument c++
//we have used this "params" instead of the "..." that we have used in the java to 
    private static double Average(double first, double second, params double[] other)
    {
        double total = first + second;
        // IN java we have use for (var item : Item)(i.e. object: class)
        foreach(double value in other)
            total += value;
        return total / (2 + other.Length);//other is array so we can call the array.lengh(

    }

    //an 'out' parameter is same as a 'ref' parameter but it accepts uninitialized
    //argument which must be initialized by the its declaring method(e.g. AverageWithDeviation) before it returns
    private static double AverageWithDeviation(double first, double second, out double dev)
    {
        dev = first > second ? (first - second) / 2 : (second - first) / 2;
        return Average(first, second);
    }

    public static void Main(string[] args)
    {
        Console.WriteLine("Average of two values = {0}", 
            Average(23.4, 29.1));
        Console.WriteLine("Average of three values = {0}", 
            Average(23.4, 29.1, 18.6));
        Console.WriteLine("Average of five values = {0}", 
            Average(23.4, 29.1, 18.6, 31.5, 24.7));
        if(args.Length > 1)
        {
            double x = double.Parse(args[0]);
            double y = double.Parse(args[1]);
        // the out keyword is used when we are just declaring the object and then assign it values in 
        // the the function/method where it is used
            double a = AverageWithDeviation(x, y, out double d);
            Console.WriteLine("Average is {0:0.000} with a deviation of {1:0.00}", a, d);           
        }
    }
}

/* Declaring out variables ? 
    1. way 1 : Inline declare out
    =============================
    double a = AverageWithDeviation(x, y, out double d);


    Explaination :
    --------------
    C# inline out variable declaration, introduced in C# 7.0.

        Why Declare d Inside Function Arguments?
        1. Conciseness:
        This eliminates the need for a separate declaration (double d;), reducing clutter in the code.
        Makes it clear that d is only used for this function call.

        2. Improved Readability:
        Keeps the scope of d limited to the function call, making it clear that d is only relevant in this context.
        Helps avoid accidental reuse of d elsewhere in the code, which can sometimes cause unexpected bugs.
        
        3. Modern C# Style:
        This is considered a more modern and idiomatic way to write C# code, making use of language features that enhance code simplicity.
        
        => Is This a Pattern?
        Yes, this follows a pattern of inlining temporary variables to keep code cleaner and scoped better. While not an official "design pattern," it's a best practice in modern C# programming where out parameters are needed but don't need to persist beyond the function call.

        => When Should You Use This Pattern?
        - When the out variable (d in this case) is only needed for this function call and won't be reused elsewhere.
        - When you want to write cleaner, more readable C# code.

    2. Way 2 : Saperately declare
    =================================
        double d;
        double a = AverageWithDeviation(x, y, out d);

    Explaination :
    --------------
        =>When Should You Declare d Separately?
        - If d needs to be used later in the function, outside of the method call.
        - If you are working with C# 6.0 or earlier, where inline out declarations are not supported.

*/