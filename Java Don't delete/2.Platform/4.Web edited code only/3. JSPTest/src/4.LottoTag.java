//Lotto tag means like the lottery 
package basic.web.app;
//second program of the tag 
import java.io.*;
import java.util.*;
//Latest one things java to jakarta
import jakarta.servlet.jsp.*;
import jakarta.servlet.jsp.tagext.*;
//If you don't want to write the all five methods then you can simply extend to the simpleTagSupport code
public class LottoTag extends SimpleTagSupport {
//
	private int digitCount = 6;
	private String digitVar;
	private Random rdm = new Random();//Lets generate some random number

	public void setDigitCount(int value) { digitCount = value; }

	public void setDigitVar(String name) { digitVar = name; }

	@Override
	public void doTag() throws JspException, IOException {
		//I get body and JspContext 
		//because we are not implementing the Tag ourself so we don't have the direct access to the Jspbody and jspcontext so we are extending its functionality to the super class(i.e. SimpleTagSupport)
		var context = super.getJspContext();
		var body = super.getJspBody();
		for(int i = 0; i < digitCount; ++i){//I am running the loop for the i times less than digitCount
			int digitVal = rdm.nextInt(10);//here it will generate random numbers for i times
			context.setAttribute(digitVar, digitVal);//what is the number generated I have copied it from digit val to digitvar.
			body.invoke(null);//and now I am printing the area of the body between the open and close bracket will be sent to client for  6 times (I am running the loop for 6 times)
		}
	}

}

