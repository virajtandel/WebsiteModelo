<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>

<t:template>
    <header class="masthead bg-primary text-black">
      <div class="container">
        <h3 class="text-uppercase mb-0 text-center">Editar Publicação</h3><br><br>
        <c:if test="${msgSucesso != null}">
	      	<div class="alert alert-success alert-dismissible fade show" role="alert">
				${msgSucesso}
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				  <span aria-hidden="true">&times;</span>
				</button>
			</div>
			<br>
		</c:if>
		<c:if test="${msgErro != null}">
	      	<div class="alert alert-danger alert-dismissible fade show" role="alert">
				${msgErro}
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				  <span aria-hidden="true">&times;</span>
				</button>
			</div>
			<br>
		</c:if>
      </div>
      <div class="container">
      	<form action="EditarPublicacao" method="post">
     	
      	  <label for="titulo">Título*:</label>
		  <input autocomplete="off" type="text" class="form-control" id="titulo" name="titulo" placeholder="Título" value="${pub.titulo}"><br>
		  
		  <label for="autores">Autores*:</label>
		  <input autocomplete="off" type="text" class="form-control" id="autores" name="autores" placeholder="Autores" value="${pub.autores}"><br>
		  
		  <label for="locPublicacao">Local de publicação:</label>
		  <input autocomplete="off" type="text" class="form-control" id="locPublicacao" name="locPublicacao" placeholder="Local de publicação" value="${pub.locPublicacao}"><br>
		  
		  <label for="resumo">Resumo*:</label>
		  <textarea class="form-control" id="resumo" name="resumo" rows="3">${pub.resumo}</textarea><br>
		  
		  <label for="link">Link:</label>
		  <input autocomplete="off" type="text" class="form-control" id="link" name="link" placeholder="Link" value="${pub.link}"><br>
		  
		  <input type="hidden" id="idPub" name="idPub" value="${pub.id}">
	      <br>
		  
		  <button type="submit" class="btn btn-dark">Salvar</button>
		  &ensp;
		  <a href="./admin" class="btn btn-danger">Cancelar</a>
		</form>
      </div>
    </header>
</t:template>

<script src="js/scripts.js"></script>