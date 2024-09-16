/*
    We can use LINQ queries in two ways:
        1. Query Syntax
        2. Method Syntax
*/

if(args[0] == "items")
{
    Item[] items = Shop.GetItems();
// 2. Method Syntax
    items.Where(i => i.Brand == args[1])//similar to filter
        .Select(i => i.Name)//similar to mapping the data i.e. select
        .Capitalize()
        .PrintEachWith(Console.WriteLine);
}
else if(args[0] == "customers")
{
    decimal min = decimal.Parse(args[1]);
    ICollection<Customer> customers = Shop.GetCustomers();
    //  1. Query Syntax
    var selection = from c in customers
                    where c.Payment >= min
                    orderby c.Id
                    select new
                    {
                        Name = c.Id,
                        Stars = new string('*', c.Rating)
                    };
    foreach(var entry in selection)
        Console.WriteLine("{0, -12}{1, 6}", entry.Name, entry.Stars);

}