using BasicWebApp.Services;
using Tourism;
//In this program of the MVC we are creating
var builder = WebApplication.CreateBuilder(args);//Taking the argument of the app to create an web app

builder.Services.AddControllersWithViews();//1.method to add the services
//services
builder.Services.AddSingleton<ICounter, CommonCounter>();
builder.Services.AddTransient<ISiteStore, XmlSiteStore>();
//app builder 
var app = builder.Build();
app.MapDefaultControllerRoute();//It will automatically map to controller
app.Run();
