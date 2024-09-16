package basic.web.app;
// this is the first code after the Welcome.html created and then to make it dynamic we have mapped it to the web.xml
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
//To use the servlet you need to write the class which implements the Servlet interface
public class GreetingServlet implements Servlet {
	
	private ServletConfig config;

	public void init(ServletConfig cfg) throws ServletException {
		//called when first time servlet is initialised
		config = cfg;
	}

	public ServletConfig getServletConfig() { return config; }

	public String getServletInfo() { return "Basic Greeting Servlet"; }
//Generally everything in this code remains the same only this service method changes from one web server to another like glassfish/tomcat etc.
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {//all request to response conversion happens in this method 
		//here we are setting two important variables response and request 
		String name = request.getParameter("guest");
		if(name == null)
			name = "Visitor";
		response.setContentType("text/html");//we are sending the text which is formated as the html
		var out = response.getWriter();//whatever you put here will be sent to the client just like what we do with the system.out.println();
		out.println("<html>");
		out.println("<head><title>BasicWebApp</title></head>");
		out.println("<body>");
		out.printf("<h1>Welcome %s</h1>%n", name);
		out.printf("<b>Current Time: </b>%s%n", new Date());
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
//if you do something in init this is right place to destroy/cancel it ==> when we undeploy the servlet it is called 
	public void destroy() {};

}

