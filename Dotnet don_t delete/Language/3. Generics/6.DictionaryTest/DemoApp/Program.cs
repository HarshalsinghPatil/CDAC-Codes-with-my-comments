//IDictionary<string, Interval> store = new Dictionary<string, Interval>();
//IDictionary<string, Interval> store = new SortedList<string, Interval>();
IDictionary<string, Interval> store = new SortedDictionary<string, Interval>();
store.Add("monday", new Interval(5, 31));
store.Add("tuesday", new Interval(3, 42));
store.Add("wednesday", new Interval(7, 13));
store.Add("thursday", new Interval(8, 24));
store.Add("friday", new Interval(6, 45));
store["monday"] = new Interval(5, 21);
foreach(var pair in store)
    Console.WriteLine("{0, -12}{1, 8}", pair.Key, pair.Value);
if(args.Length > 0)
{
    string key = args[0].ToLower();
    if(store.TryGetValue(key, out Interval val))
        Console.WriteLine("Interval with specified key = {0}", val);
}