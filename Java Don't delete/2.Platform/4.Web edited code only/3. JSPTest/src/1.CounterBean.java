package basic.web.app;
//How to write the bean 
/*
1. Your bean class must implement to java.io.serialisable
2. See the beandemo.jsp and find the jsp mapped using ctr(object of counterbean) 
*/

//first program 
//Trick here is the programmer good with the logic will write code for bean and the programmer good with the presentation will write the jsp code which will utilize this bean code and in this way the code will be written.JSP can execute the java code.
public class CounterBean implements java.io.Serializable {

	private int step = 1;// I've to set this step as the property so that the people can read and write the property ==> add getStep() and setStep()==> usually java coders write get and set but acc to jsp its compulsory to write the code.
	
	private long current = 0;//read only property(no setter)

	public final int getStep() { return step; }
	public final void setStep(int value) { step = value; }

	public synchronized long getNextCount() {//this is not the thread safe operation so we need to use the synchronized 
		return current += step;//increment the current value by step 
	}
}

