<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>

<t:template>
    <header class="masthead bg-primary text-black">
      <div class="container">
        <h3 class="text-uppercase mb-0">Linhas de Pesquisa:</h3><br><br>
      </div>
      <div class="container">
	    <c:if test="${linhas != null}">
	        <c:forEach var="linha" items="${linhas}">
	          <br><hr><br>
	          
		      <h5 class="text-uppercase mb-0 text-center">${linha.titulo}</h5>
		      <center><b>Orientador:</b>&ensp;${linha.orientador}</center><br>
		      <p align="justify"><b>Resumo:</b> &ensp;${linha.resumo} </p>
		      <p align="justify"><b>Referências:</b><br>${linha.referencias} </p>
		    </c:forEach>
      	</c:if>
      	<c:if test="${linhas == null}">
      		Não há linhas de pesquisa neste laboratório!<br><br>
		</c:if>
      </div>
    </header>
</t:template>