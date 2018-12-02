<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>
	
	<c:if test="${sobre != null}">
	    <header class="masthead bg-primary text-black">
	      <div class="container text-center">
	      	<h2 class="text mb-0">${sobre.nome}</h2><br><br>
	      </div>
	      <div class="container">
	      	<h4 class="text-uppercase mb-0">Sobre nós:</h4><br>
	      	<p align="justify">${sobre.descricao}</p>
	      	<br>
	      	<br>
	      	
	      </div>
	    </header>
	</c:if>
	<c:if test="${sobre == null}">
	   <header class="masthead bg-primary text-black">
	      <div class="container text-center">
	      	<h2 class="text mb-0">Nome do laboratório</h2><br><br>
	      </div>
	      <div class="container text-center">
	      	<h4 class="text-uppercase mb-0">Sobre nós:</h4><br>
	      	<p align="justify">Descrição do laboratório</p>
	      	
	      </div>
	    </header>
	</c:if>
</t:template>