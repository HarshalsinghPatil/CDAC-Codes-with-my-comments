//ISet<Interval> store = new HashSet<Interval>();
//ISet<Interval> store = new SortedSet<Interval>();
ISet<Interval> store = new SortedSet<Interval>(new IntervalComparison());
store.Add(new Interval(5, 31));
store.Add(new Interval(3, 42));
store.Add(new Interval(7, 13));
store.Add(new Interval(8, 24));
store.Add(new Interval(6, 45));
store.Add(new Interval(4, 91));
foreach(Interval item in store)
    Console.WriteLine(item);

class IntervalComparison : IComparer<Interval>
{
    public int Compare(Interval x, Interval y)
    {
        return x.Seconds - y.Seconds;
    }
}
