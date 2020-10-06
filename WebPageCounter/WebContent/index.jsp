<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counting the page hit on Web</title>
<%Integer pageCount=(Integer)request.getAttribute("count"); %>
<script type="text/javascript">
window.onload = function()
				{
					var count = "<%out.print(pageCount); %>";
					alert("page visited for : " + count + " times");
				}
</script>
</head>
<body>

	<br/>
	<br/>
	<p> 
		<h3> <b>  No of times this pages has been visited : </b>
		<%=request.getAttribute("count") %> </h3>
		
		
	</p>

</body>
</html>