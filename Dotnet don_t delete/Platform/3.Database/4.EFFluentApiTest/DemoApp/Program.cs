using DemoApp.Shopping;
//This is like the jpa in java
/*Entity framework core == to consume the relational data with the help of poco 
    1. Entity == map to the column of the database
    2. Dbset == DbSet<TEntity> which is called as the set of entity.e.g. Order,Product etc.
    3. DbContext == load and stores the entities from database using the DBset and open/close the connection with the database.
*/
var db = new ShopDbContext();

if(args.Length == 0)//If user gives no i/p show complete table
{
    foreach(var product in db.Products)
        Console.WriteLine("{0, -6}{1, 12:0.00}{2, 8}", product.Id, product.Price, product.Stock);
}
else
{//
    int pno = int.Parse(args[0]);
    var product = db.Products//mapping the product
                .Where(p => p.Id == pno)
                .Include(p => p.Orders)
                .FirstOrDefault();
    if(product != null){//if product available then give all details of that order
        foreach(var order in product.Orders)
            Console.WriteLine("{0}\t{1}\t{2:yyyy-MMM-dd}", order.CustomerId, order.Quantity, order.OrderDate);
    }
}
