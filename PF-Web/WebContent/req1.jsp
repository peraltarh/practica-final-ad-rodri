<%@page import="clienteWeb.WebController"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script type="text/javascript">
function submitFom(){
	document.getElementById("formulario1").submit();
}
</script>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Alta Producto Semielaborado</h1>
	<form action="req1" name="req1" method="get" id="formulario1">
	<a>Descripcion:</a>
	<input type="text" name="descripcion" id="descripcion" />
	<br>
	<a>Costo:</a>
	<input type="text" name="costo" id="costo" />
	<br>
	<a>Materia Prima:</a>
	<select id="matPrima" name="matPrima" size="1" >
	<% for (String valueS : WebController.getInstancia().getMateriasPrimas()) { %>
		<option value="<%=valueS %>">
		<%=valueS %>
		</option>
	<%} %>
	</select>
	<br>
	<a>Unidad:</a>
	<select id="unidad" name="unidad" size="1" >
	<% for (String valueS : WebController.getInstancia().getUnidades()) { %>
		<option value="<%=valueS %>">
		<%=valueS %>
		</option>
	<%} %>
	</select>
	<br>
	<button name="crear" id="crear" onclick="submitFom();">Crear</button>
	</form>


</body>
</html>