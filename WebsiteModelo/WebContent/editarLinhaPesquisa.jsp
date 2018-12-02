<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>

<t:template>
    <header class="masthead bg-primary text-black">
      <div class="container">
        <h3 class="text-uppercase mb-0 text-center">Editar Linha de Pesquisa</h3><br><br>
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
      	<form action="EditarLinhaPesquisa" method="post">
     	
    	  <label for="titulo">Título*:</label>
		  <input autocomplete="off" type="text" class="form-control" id="titulo" name="titulo" placeholder="Título" value="${lin.titulo}"><br>
		  <label for="orientador">Orientador*:</label>
		  <input autocomplete="off" type="text" class="form-control" id="orientador" name="orientador" placeholder="Orientador" value="${lin.orientador}"><br>
		  <label for="resumo">Resumo*:</label>
		  <textarea class="form-control" id="resumo" name="resumo" rows="3">${lin.resumo} </textarea><br>
		  <label for="referencias">Referências*:</label>
		  <textarea class="form-control" id="referencias" name="referencias" rows="3">${lin.referencias} </textarea><br>
		  <input type="hidden" id="idLinha" name="idLinha" value="${lin.id}">
	      <br>
		  
		  <button type="submit" class="btn btn-dark">Salvar</button>
		  &ensp;
		  <a href="./admin" class="btn btn-danger">Cancelar</a>
		</form>
      </div>
    </header>
</t:template>

<script src="js/scripts.js"></script>