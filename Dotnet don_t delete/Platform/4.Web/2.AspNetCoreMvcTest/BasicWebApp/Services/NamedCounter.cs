namespace BasicWebApp.Services;

public class NamedCounter : ICounter
{
    private Dictionary<string, int> store = new();//name as key

    public int CountNext(string key)
    {
        lock(store)
        {
            store.TryGetValue(key, out int value);//using key get value
            store[key] = ++value;//increment value after each visit
            return value;
        }
    }
}
