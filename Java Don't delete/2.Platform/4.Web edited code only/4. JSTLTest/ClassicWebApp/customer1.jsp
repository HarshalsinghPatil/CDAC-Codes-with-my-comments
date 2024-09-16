<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Remember this uri which stores the tag libraryy -->
<jsp:useBean id="customer" class="classic.web.app.CustomerBean" scope="session"/>
<!-- While logging it is kept in session -->
<jsp:setProperty name="customer" property="*"/>
	<!-- 1.Check whether the employee id is empty or not  or s/he has logged out then we will redirect them to  url-->
	<!-- <c:if test="${empty customer.id}">
		<c:redirect url="customer.jsp/>" -->
			<!-- If you have the correct id then it will be saved and but you haven't put the proper id and pwd then it will directly redirect to the login page -->
<!-- Sign out page redirection and the id here shows that of you sign out then you can use new id-->
<c:if test="${param.signout}">
	<c:set target="${customer}" property="id"/>
</c:if>
<!-- when you enter in any new page ==>  It will be checked in the every page except the login page-->
<html>
	<head>
		<title>ClassicWebApp</title>
	</head>
	<!-- Show the login page -->
	<body>
		<h1>Welcome Customer</h1>
		<form method="POST">
			<p>
				<b>Customer ID</b><br/>
				<input type="text" name="id"/>
			</p>
			<p>
				<b>Password</b><br/>
				<input type="password" name="password"/>
			</p>
			<p>
				<input type="submit" name="submit" value="Login"/>
			</p>
		</form>
		<!--  verify the login  or else -->
		<c:if test="${param.submit == 'Login'}">
			<c:choose>
				<c:when test = "${customer.authenticate()}">
					<c:redirect url="orders.jsp"/>
				</c:when>
				<c:otherwise>
					<b>Authentication Failed</b>
				</c:otherwise>
			</c:choose>
		</c:if>
	</body>
</html>

