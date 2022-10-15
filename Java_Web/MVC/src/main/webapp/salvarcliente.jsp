<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC Cliente</title>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>
	
</head>
<body>
<h1>Cadastro de Clientes</h1>
<form action="../MVC/Inserir" method="post" class="form-control">
<fieldset>


<legend>Dados do Cliente</legend>

<table>
<tr>
<td>  <label for="nome">Nome:</label></td>
<td> <input type="text"id="nome"name="nome">  </td>
</tr>

<tr>
<td><label for="email">Email:</label></td>
<td><input type="text"id="email"name="email"></td>
</tr>

<tr>
<td><label for="usuario">Usuario:</label></td>
<td><input type="text"id="usuario"name="usuario"></td>
</tr>

<tr>
<td><label for="senha">Senha:</label></td>
<td><input type="password"id="senha"name="senha"></td>
</tr>

<tr>
<td> <label for="endereco">Endereco:</label></td>
<td><input type="text"id="endereco"name="endereco"></td>
</tr>



</table>
<br><input type="submit"value="Cadastrar"> <br><br>



<a href="http://localhost:8080/MVC/home" class="btn btn-primary">Clique aqui para ver a lista e realizar operacoes</a>
</fieldset>

</form>

<br>
		<h5>Clientes cadastrados</h5>
	
	<table class="table">
		<thead>
			<tr>
				<th>Nome</th>
				<th>ID</th>
			
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<jstl:forEach items="${listaCliente}" var="cliente">
				<tr>
					<td>${cliente.nome}</td>
					<td>${cliente.id}</td>
					
					

					
					<td>
						<a href="editar?id=${cliente.id}" class="btn btn-success">Editar</a> 
				
						<a href="excluir?id=${cliente.id}" onclick="return confirm('Deseja Excluir?')" class="btn btn-danger">Excluir</a>
					</td>
				</tr>
				</jstl:forEach>
			
		</tbody>
	</table>
	
</body>
</html>

