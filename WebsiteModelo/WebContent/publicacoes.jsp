<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>

<t:template>
    <header class="masthead bg-primary text-black">
      <div class="container">
      	<h3 class="text-uppercase mb-0">Publicações:</h3><br><br>
      </div>
      <div class="container">
	    <c:if test="${publics != null}">
      	<c:forEach var="pub" items="${publics}">
      	
      		<hr><br>
	      	<h5 class="text-uppercase mb-0">${pub.titulo}</h5>
	      	<b>Autores:&ensp;</b>${pub.autores}<br>
	      	<b>Publicação:&ensp;</b>${pub.locPublicacao}<br><br>
	      	<b>Resumo:&ensp;</b>${pub.resumo}<br><br>
	      	<b>Link:&ensp;</b><a href="${pub.link}">${pub.link}</a><br><br>

      	</c:forEach>
      	</c:if>
      	<c:if test="${publics == null}">
      		Não há publicações deste laboratório!<br><br>
		</c:if>
      </div>
    </header>
</t:template>