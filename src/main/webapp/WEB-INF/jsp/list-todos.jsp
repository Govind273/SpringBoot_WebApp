<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<title>Welcome to the Todo Application</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"rel="stylesheet">
</head>
<body>
<h1> Todos for ${name}</h1>

<div class="container">
<table class="table table-striped">
<caption> Today's Todo </caption>
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
			<td>${item.done}</td>
		</tr>
	</c:forEach>
</tbody>
</table>


<div><a class="button" href="/add-todo">Add a todo</a></div>


<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</div>
</body>
</html>