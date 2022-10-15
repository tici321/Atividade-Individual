<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterando o Cliente jsp</title>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>
	
<body>

	<div class="container">
		<h5>Alteração do cliente ${cliente.nome} </h5>
		<form action="editar" method="post" class="form-control">

			<input type="hidden" name="id" value="${cliente.id}">
			<p>Nome:</p>
			<p>
				<input type="text" name="nome" value="${cliente.nome}">
			</p>
			<p>Usuario:</p>
			<p>
				<input type="text" name="usuario" value="${cliente.usuario}">
			</p>
			
			<p>Endereco:</p>
			<p>
				<input type="text" name="endereco" value="${cliente.endereco}">
			</p>
			<p>Email:</p>
			<p>
				<input type="text" name="email" value="${cliente.email}">
			</p>
			<p>Senha:</p>
			<p>
				<input type="text" name="senha" value="${cliente.senha}">
			</p>
			<button type="submit" class="btn btn-success">Atualizar</button>
		</form>
			</div>
</body>
</html>