IList<Interval> store = new List<Interval>();
store.Add(new Interval(5, 31));
store.Add(new Interval(3, 42));
store.Add(new Interval(7, 13));
store.Add(new Interval(8, 24));
store.Add(new Interval(6, 45));
store.Add(new Interval(4, 91));
foreach(Interval item in store)
    Console.WriteLine(item);
if(args.Length > 0)
{
    int i = int.Parse(args[0]);
    Console.WriteLine("Interval at given index = {0}", store[i]);
}