using BasicWebApp.Middlewares;
using BasicWebApp.Services;

var builder = WebApplication.CreateBuilder(args);
//loose coupling i.e we just telling the name of the services  and it will automatically select from them
//services
builder.Services.AddSingleton<ICounter, CommonCounter>();
builder.Services.AddSingleton<ICounter, NamedCounter>();
var app = builder.Build();
//middleware
app.UseStaticFiles();//default middleware
app.UseMiddleware<Pausing>(2);//customised middleware (i.e. created by us)
//here 2 is the count for refreshing the page
//http://localhost:5000/Welcome

//Controller
app.MapGet("/Welcome", DoGreeting);
//flow : request => middleware => and finally to handler(Below)

app.MapPost("/Count", DoCounting);
app.Run();


//handler
async Task DoGreeting(HttpResponse response, string guest = "Visitor")
{//http://localhost:5000/Welcome?guest=harshal
    await response.WriteAsync(@$"
        <html>
            <head>
                <title>BasicWebApp</title>
            </head>
            <body>
                <h1>Welcome {guest}</h1>
                <b>Current Time: </b>{DateTime.Now}
            </body>
        </html>
    ");
}
                                                                //loose coupling
async Task DoCounting(HttpRequest request, HttpResponse response, ICounter counter)
{
    string user = request.Form["guest"];
    if(user.Length == 0)
    {
        response.Redirect("/formpost.html?noname=true");
    }
    else
    {
//inside this @ we can write html code it will consider it as the complete string and $ for taking the exact values
        await response.WriteAsync(@$"
            <html>
                <head>
                    <title>BasicWebApp</title>
                </head>
                <body>
                    <h1>Hello {user}</h1>
                    <b>Number of Greetings: </b>{counter.CountNext(user)}
                </body>
            </html>
        ");
    }
}

