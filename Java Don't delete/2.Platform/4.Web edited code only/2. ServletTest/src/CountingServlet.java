package basic.web.app;
//Previously in GreetingServlet when I was directly implementing servlet interface at that time I required to write the five methods
/*
But in this program I am directly using servlet api where it also provides for http servlet class which implements Servlet Interface.So now you have two options -
1. Either you manually create a servlet class which implements the servlet interface and write the five methods (we can extend for one class in java but what if i want to extend it to one more class then I need to use this method only)
2. You should extend your servlet class to the http servlet class implementing the servlet interface(including those 5 extra methods).If you don't want to inherit from any other class then its better to extend to  http servlet class.
	import jakarta.servlet.http.*;==> in place of service method http servlet class has the doGet and doPost methods which we need to overrided.  
*/
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;//it is different from the above package
import jakarta.servlet.annotation.*;
//here in this program we are counting how many times the data submitted using the greet class.
@WebServlet("/count")//it will automatically find the object class and 
public class CountingServlet extends HttpServlet {
	
	@Override//whenever you will override the compiler will cross check and whoever read this method get to know that method is overrided.  
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//In post method we take input as form
		String person = request.getParameter("person");//user
		String period = request.getParameter("period");
		if(person.length() == 0){//no input from user 1.
			response.sendRedirect("welcome");
			return;
		}
		//problem in this program after we have closed the browser still we are getting the number of counts ==> saving info /privacy issue.
		//solution: implement session like shown below.
		//session starts
		var session = request.getSession(true);//In request look for session id (which is there till the browser is open when you close the browser it will end) and if its not found then by using the true option we can create the object.
		Integer count = (Integer)session.getAttribute(person);//give me the value associated with "person" name
		if(count == null)// if null is returned then it means no value is assigned to it so set the value to null 1
			count = 1;//or 0
		response.setContentType("text/html");//2.
		var out = response.getWriter();
		//to send the code which we want to show to the user
		out.println("<html>");
		out.println("<head><title>BasicWebApp</title></head>");
		out.println("<body>");
		out.printf("<h1>Good %s %s</h1>%n", period, person);
		out.printf("<b>Number of Greetings = </b>%d%n", count);//or count++
		out.println("</body>");
		out.println("</html>");
		out.close();
		session.setAttribute(person, count + 1);//or count
		if(count == 5)
			session.invalidate();
	}
}

