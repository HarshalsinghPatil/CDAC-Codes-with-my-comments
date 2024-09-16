<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="customer" class="classic.web.app.CustomerBean" scope="session"/>
<c:if test="${empty customer.id}">
	<!-- If you have the correct id then it will be saved and but you haven't put the proper id and pwd then it will directly redirect to the login page -->
	<c:redirect url="customer.jsp"/>
</c:if>
<html>
	<head>
		<title>ClassicWebApp</title>
	</head>
	<body>
		<h1>Welcome Customer ${customer.id}</h1>
		<h3>Your Orders</h3>
		<table border="1">
			<!-- write the entries we wanted to insert in to the page -->
			<tr> 
				<th>Product No</th>
				<th>Quantity</th>
				<th>Order Date</th>
			</tr>

			<c:forEach var="entry" items="${customer.orders}">
				<tr>

					<!-- run for each loop for each time -->
					<td>${entry.productNo}</td>
					<td>${entry.quantity}</td>
					<td>${entry.orderDate}</td>
				</tr>
			</c:forEach>
			
		</table>
		<p>
			<a href="customer.jsp?signout=true">Logout</a>
		</p>
	</body>
</html>

