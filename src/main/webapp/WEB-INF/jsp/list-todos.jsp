<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  s

<html>

<head>
<title>Welcome to the Todo Application</title>
</head>
<body>
<h1> Your Todo</h1>

//add a table
<table>
<caption> Your Todos are here </caption>
<thead>
	<tr>
		<th>Description</th>
		<th>Date</th>
		<th>Is it Done?</th>
	</tr>
</thead>

<tbody>
	 <c:forEach items="${todo1}" var="item">
		<tr>
			<td>${item.desc}</td>
			<td>${item.targetDate}</td>
			<td>${ietm.isDone}</td>
		</tr>
	</c:forEach>
</tbody>
</table>



<a href="/add-todo">Add a todo</a>
</body>
</html>