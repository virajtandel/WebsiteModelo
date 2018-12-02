<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>

<t:template>
    <header class="masthead bg-primary text-black">
      <div class="container">
        <h3 class="text-uppercase mb-0 text-center">Editar Integrante</h3><br><br>
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
      	<form action="EditarIntegrante" method="post">
      	
	      <label for="nome">Nome*:</label>
		  <input autocomplete="off" type="text" class="form-control" id="nome" name="nome" placeholder="Nome" value="${integ.nome}"/><br>
		  
		  <label for="descricao">Descrição:</label>
		  <textarea class="form-control" id="descricao" name="descricao" rows="3">${integ.descricao}</textarea><br>
		  
		  <label for="email">Email*:</label>
		  <input autocomplete="off" type="text" class="form-control" id="email" name="email" placeholder="Email" value="${integ.email}"><br>
		  
		  <label for="website">Website:</label>
		  <input autocomplete="off" type="text" class="form-control" id="website" name="website" placeholder="Website" value="${integ.website}"><br>
		  
		  <label for="tipo">Tipo de integrante*:</label>
		  <select class="form-control" id="tipo" name="tipo">
		      <option value="0">Orientador</option>
		      <option value="1">Estudante</option>
		  </select>
		  
		  <input type="hidden" id="id" name="id" value="${integ.id}">
		  
		  <br>
		  
		  <button type="submit" class="btn btn-dark">Salvar</button>
		  &ensp;
		  <a href="./admin" class="btn btn-danger">Cancelar</a>
		</form>
      </div>
    </header>
</t:template>

<script src="js/scripts.js"></script>