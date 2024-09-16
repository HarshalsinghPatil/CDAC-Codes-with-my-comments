var builder = WebApplication.CreateBuilder(args);//to start the app
// for using the services
builder.Services.AddControllers();
builder.Services.AddGrpcClient<Sales.OrderManager.OrderManagerClient>(
    options => options.Address = new Uri("http://localhost:4000")
);
//Building the app
var app = builder.Build();
app.UseStaticFiles();//using routing and endpoint middleware
app.MapControllers();//custome middleware
app.Run();

/*
Invoke-RestMethod -Uri http://localhost:5000/api/orders/CU204
Invoke-RestMethod -Method Post -ContentType 'application/json' -Body '{"customerId":"CU204", "productNo":202, "quantity":12}' -Uri http://localhost:5000/api/orders
*/