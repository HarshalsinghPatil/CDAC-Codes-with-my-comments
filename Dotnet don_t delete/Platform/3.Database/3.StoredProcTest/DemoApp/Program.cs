using System.Data;
//here we are first taking the argument from the user and  in between when transaction begins and close we dont take the argument from the user
string customerId = args[0].ToUpper();
int productNo = int.Parse(args[1]);
int quantity = int.Parse(args[2]);
//to create the connection
using var con = new Microsoft.Data.SqlClient.SqlConnection();
con.ConnectionString = "Server=(localdb)\\METIIT;Database=Shop";
con.Open();
//here we are only using cmd object 
using var cmd = con.CreateCommand();
cmd.CommandText = "PlaceOrder";
cmd.CommandType = CommandType.StoredProcedure;
cmd.Parameters.AddWithValue("@Customer", customerId);
cmd.Parameters.AddWithValue("@Product", productNo);
cmd.Parameters.AddWithValue("@Quantity", quantity);
var orderIdParam = cmd.Parameters.Add("@OrderId", SqlDbType.Int);
//we are expecting it to be "int" datatype
orderIdParam.Direction = ParameterDirection.Output;
try
{
    cmd.ExecuteNonQuery();
    Console.WriteLine("New Order Number: {0}", orderIdParam.Value);
}
catch(Exception)
{
    Console.WriteLine("Order Failed!");
}
