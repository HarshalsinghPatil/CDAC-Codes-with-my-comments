namespace DemoApp.Shopping;
//poco = plain old class object
public class Order
{
    public int Id { get; set; }

    public DateTime OrderDate { get; set; }

    public string CustomerId { get; set; }

    public int ProductId { get; set; }

    public int Quantity { get; set; }
}