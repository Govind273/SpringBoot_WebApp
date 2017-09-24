<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<head>
<title>Welcome to the Todo Application</title>
</head>
<body>
<h1> Your Todo</h1>

//add a table
<table>
<caption> Your Todos are here </caption>
<tr>
<th>Description</th>
<th></th>
<th></th>
</tr>
</table>

${todo1}



<a href="/add-todo">Add a todo</a>
</body>
</html>