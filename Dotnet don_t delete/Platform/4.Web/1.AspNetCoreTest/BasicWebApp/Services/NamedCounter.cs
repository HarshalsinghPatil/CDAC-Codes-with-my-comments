namespace BasicWebApp.Services;

public class NamedCounter : ICounter
{
    private Dictionary<string, int> store = new();
    private int current;

    public int CountNext(string key)
    {
        return Interlocked.Increment(ref current);
    }

    public int CountNext(string key)
    {
        lock(store)
        {
            store.TryGetValue(key, out int value);
            store[key] = ++value;
            return value;
        }
    }
}
