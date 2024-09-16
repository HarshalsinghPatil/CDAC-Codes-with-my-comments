package basic.web.app;
//first program of the tag tagdemo.jsp is used for 
//Jsp allows you to present your content to the browser because most content is aquired from the server.Most of the browser works through html,css,javaScript etc.and it aquires the data using javabeans. But javabeans are very simple objects i.e. they don't know they are used inside webpage .They are simple classes there is no way to know from which client the request is coming. They can't participate in presentation .they are on complete mercy of the java developer.They are simple like pojos but pojo don't contain logical operations whereas the Javabeans contain the logical operations
//so tag extensions can be included by jsp programmer. they are more powerful than beans as they know they are part of webpage and they can directly interact with the webpage and directly insert the data inside the webpage.where as the webpage need to  ask to the javabean about data and webpage itself need to insert the data in webpage and present to the client.
import java.io.*;
import java.util.*;
import java.text.*;
import jakarta.servlet.jsp.*;
import jakarta.servlet.jsp.tagext.*;
//See the screenshot of the basic format of the tag
public class ClockTag implements SimpleTag {
//here we are setting Iso time format but our user wants different time format.	Which we will do in doTag function
	private JspContext context;
	private JspFragment body;
	private JspTag parent;
	private SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss yyyy-MM-dd");//ISO date format international

	public void setJspContext(JspContext value) { context = value; }

	public void setJspBody(JspFragment value) { body = value; }

	public void setParent(JspTag value) { parent = value; }

	public JspTag getParent() { return parent; }

	public void setFormat(String value) {
		formatter.applyPattern(value);
	}

	public void doTag() throws JspException, IOException {
		var out = context.getOut();//it gives output from the region where the tag is placed
		var now = new Date();//Current time
		out.print(formatter.format(now));//It will convert your current time into 
	}
//Now the next step=> need to describe this tag to the jsp so we will need one special file taglib.tld which will place into the BasicWebApp2/WEB-INF/taglib.tld
}

