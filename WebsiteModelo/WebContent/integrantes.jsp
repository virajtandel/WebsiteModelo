<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>

<t:template>
    <header class="masthead bg-primary text-black">
      <div class="container">
        <h3 class="text-uppercase mb-0">Integrantes do Laboratório:</h3><br><br>
        <h5 class="text-uppercase mb-0">Orientadores:</h5><br>
      </div>
      <div class="container">
	    	<c:if test="${orients != null}">
		      <c:forEach var="orient" items="${orients}">
		        <div class="row">
		          <div class="col-md-3 mb-4">
		            <img alt="foto_integrante" src="img/u_${orient.id}.png" height="180" width="180">
		          </div>
		          <div class="col-md-5 mb-4">
		            <h5 class="text-uppercase mb-0"> ${orient.nome} </h5><br>
					${orient.descricao}<br>
		            <i class="fa fa-envelope"></i>&ensp;<a href=""> ${orient.email} </a>
		          </div>
		        </div>
		        <br>
			  </c:forEach>
	      	</c:if>
	      	<c:if test="${orients == null}">
	      		Não há orientadores neste laboratório!<br><br>
			</c:if>
	      <br><br>
	      <h5 class="text-uppercase mb-0">Estudantes:</h5><br>
	    	<c:if test="${estuds != null}">
		      <c:forEach var="estud" items="${estuds}">
		        <div class="row">
		          <div class="col-md-3 mb-4">
		            <img alt="foto_integrante" src="img/u_${estud.id}.png" height="180" width="180">
		          </div>
		          <div class="col-md-5 mb-4">
		            <h5 class="text-uppercase mb-0"> ${estud.nome} </h5><br>
					${estud.descricao}<br>
		            <i class="fa fa-envelope"></i>&ensp;<a href="">${estud.email}</a>
		          </div>
		        </div>
		        <br>
		      </c:forEach>
	      	</c:if>
	      	<c:if test="${estuds == null}">
	      		Não há estudantes neste laboratório!<br><br>
			</c:if>
      </div>
    </header>
</t:template>