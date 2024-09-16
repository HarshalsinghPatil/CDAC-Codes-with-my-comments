/*  
    Generally when we use "record" to create a class then we get toString(),
    getHashCode(), Equals() method in this program. Sir has shown one Interval class 
    with the implementation same as the class which we will get without the 
    ==> setter method () == hence they are the immutable object means state/values 
    inside them can't changed.
*/
class Interval
{
    //immutable properties==> we can't change the values through setters
    public int Minutes { get; }
    public int Seconds { get; }

    public Interval(int min, int sec)
    {
        Minutes = min + sec / 60;
        Seconds = sec % 60;
    }

    public int Time()
    {//return o/p in the seconds
        return 60 * Minutes + Seconds;
    }
    //operator overloading
    public static Interval operator+(Interval lhs, Interval rhs)
    {
        return new Interval(lhs.Minutes + rhs.Minutes, lhs.Seconds + rhs.Seconds);
    }

    public override string ToString()
    {
        if(Seconds < 10)
            return Minutes + ":0" + Seconds;
        return Minutes + ":" + Seconds;
    }

    public override int GetHashCode()
    {
        return Minutes + Seconds;
    }

    public override bool Equals(object other)
    {//in Java we are writing the "instanceof" method but in the dotnet we are writing (X is Y that)
        if(other is Interval that)
        {
            //Interval that = (Interval) other;
            return (this.Minutes == that.Minutes) && (this.Seconds == that.Seconds);
        }
        return false;
    }
}

