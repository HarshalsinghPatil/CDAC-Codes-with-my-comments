static class Printable
{//Fluent function is like the stream of data in java functional programming
    //a fluent function is a method which returns a type to
    //which such other functions can be applied
    //In .Net any data source which implements the IEnumerable interface can be used for querying, filtering, grouping, ordering, & projecting data.
    //<Angular bracket> shows the type safety in collections
    public static IEnumerable<string> Capitalize<T>(this IEnumerable<T> source)
    {//method for converting the data to  capital case
        foreach(T item in source)
            yield return item.ToString().ToUpper();//here we converting to capital case only
        //yield performs custom and stateful iteration and returns each element of a collection one at a time
    } 
/*
The yield keyword is use to do custom stateful iteration over a collection. The yield keyword tells the compiler that the method in which it appears is an iterator block.

yield return <expression>;
yield break;
The yield return statement returns one element at a time. The return type of yield keyword is either IEnumerable or IEnumerator. The yield break statement is used to end the iteration.

We can consume the iterator method that contains a yield return statement either by using foreach loop or LINQ query.*/
    public static void PrintEachWith<T>(this IEnumerable<T> source, Action<T> write)
    {
        foreach(T item in source)
            write(item);
    }
}