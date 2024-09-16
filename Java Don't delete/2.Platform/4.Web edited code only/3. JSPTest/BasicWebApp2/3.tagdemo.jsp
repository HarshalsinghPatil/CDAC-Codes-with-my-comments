<!-- we have also one taglib.tld file into the WEB-INF directory for the connecting the taglib java and jsp files -->

<%@taglib prefix="my" uri="http://java.met.edu/basicwebapp" %>
<!--JSP Server will SCAN ALL .tld FILES FROM WEB-INF with name "my" and uri "http://java......app"  -->
<html>
	<head>
		<title>BasicWebApp</title>
	</head>
	<body>
		<h1>Welcome Gambler</h1>
		<!--In markup level languages any thing before the colon is called prefix of that tag -->
		<b> Current Time: </b><my:clock format="MMM, dd yyyy hh:mm:ss a"/>
		<!-- small hh shows the 12 hrs time format and a-> represents the am -->
		<p>
			<b>WINNER: </b>
			<!-- we are writing the below function only once but in the source code in browser it is showing that it is doing that code five times -->
			<my:lotto digitCount="9" digitVar="d">
				<i>${d}</i>
			</my:lotto>
	
		</p>
	</body>
</html>

