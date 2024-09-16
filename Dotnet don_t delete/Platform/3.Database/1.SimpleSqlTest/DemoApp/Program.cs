using var connection = new Microsoft.Data.Sqlite.SqliteConnection();//create the connection

connection.ConnectionString = "Filename=shop.db";
//1. open the connection
connection.Open();
//2. create command
using var command = connection.CreateCommand();
if(args.Length == 0)//no result set
{
    command.CommandText = "SELECT ProductNo, Price, Stock FROM ProductInfo";
    using var dataReader = command.ExecuteReader();
    while(dataReader.Read())
        Console.WriteLine("{0, -6}{1, 12:0.00}{2, 8}", dataReader.GetInt32(0), dataReader.GetDecimal(1), dataReader.GetInt32(2));
}
else
{
    int pno = int.Parse(args[0]);
    command.CommandText = $"UPDATE ProductInfo SET Stock=Stock+5 WHERE ProductNo={pno}";
    int n = command.ExecuteNonQuery();
    if(n == 0)
        Console.WriteLine("No such product!");
}
