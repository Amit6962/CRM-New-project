<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
	<diV id="wrapper">
		<div id="header">
			<h2>CRM - Customer RelationShip Manager</h2>
		</div>
	</diV>
	<div id="container">
		<h3>Save Customer</h3>
		<form:form action="saveCustomer" modelAttribute="customer"
			method="POST">
			
			<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><label>FirstName:</label></td>
						<td><form:input path="firstName" />
					</tr>
					<tr>
						<td><label>LastName:</label></td>
						<td><form:input path="lastName" />
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" />
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>

			</table>


		</form:form>
		<div style=""></div>
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>

		</p>

	</div>

</body>
</html>