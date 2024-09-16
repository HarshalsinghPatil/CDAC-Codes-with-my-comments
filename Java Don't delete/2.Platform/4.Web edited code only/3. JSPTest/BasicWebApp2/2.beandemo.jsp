<!-- this is the second program -->
<!-- scopes default(everytime)<<session(same browser and close restart counting )<<application (It will keeps counting even after the browser is closed and reopened again)-->
<jsp:useBean id="ctr" class="basic.web.app.CounterBean" scope="application"/>
<!-- we want object of counter class ctr  and give fully qualified name of the class and for each browser we are creating one object( if we don't mension this scope then for everytime one new object will be created and we can not keep count of the reloads)-->
<!-- Why we can't keep the track of the object? because every time when we render the page to the user at that time the object is also passed to the users -->
<jsp:setProperty name="ctr" property="step" value="3"/>




<jsp:useBean id="greeter" class="basic.web.app.GreeterBean"/>
<!-- property ="*" means select all the properties of from Greeterbean -->
<jsp:setProperty name="greeter" property="*"/>
<html>
	<head>
		<title>BasicWebApp</title>
	</head>
	<body>
		<!-- This is like controller and methods(actions) inside the controller -->
		<h1>${greeter.greetingMessage}</h1>
		<b>Number of Greetings: </b>${ctr.nextCount}
		<!-- to get the count of how many clicks on the Greetings done we are using nextCount(kim its not the method) -->
		<hr/>
		<form method="POST">
			<p>
				<b>Person: </b>
				<input type="text" name="person"/>
			</p>
			<p>
				<b>Period: </b>
				<select name="period">
					<option>Night</option>
					<option>Morning</option>
					<option>Afternoon</option>
					<option>Evening</option>
				</select>
			</p>
			<p>
				<input type="submit" value="Greet"/>
			</p>
		</form>
	</body>
</html>

