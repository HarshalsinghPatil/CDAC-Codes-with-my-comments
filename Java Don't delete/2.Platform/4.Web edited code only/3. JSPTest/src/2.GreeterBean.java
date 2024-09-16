package basic.web.app;
// See the beandemo.jsp and find the jsp mapped using greeter(object of Greeterbean) 


//second program ==> we have to welcome the user according to the time of his visit(morning/afternoon/evening/night)
	//how to use the tomcat in to the jsp is at the end of 34 lec of the hussain sir.According to him everytime we want to we make changes we have to copy it again and causes the circus (tomcat commands at the end)so he used glassfish6 

public class GreeterBean implements java.io.Serializable {

	private String person;
	private String period;
	//if I want faster execution then write the methods with final(3x times) but don't use it with the JPA entities because get and set are not permitted
	public final String getPerson() { return person; }
	public final void setPerson(String value) { person = value; }

	public final String getPeriod() { return period; }
	public final void setPeriod(String value) { period = value; }
	//Javabeans are like POJO but they are they contains business logic like below method
	public String getGreetingMessage() {
//if no data entered it will welcome the user and show the data entry page 
		if(person == null)
			return "Welcome Visitor";
//or if user selects the options then we need to do the revision
		return String.format("Good %s %s", period, person);
	}
}
