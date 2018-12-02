<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>

<t:template>
    <header class="masthead bg-primary text-black">
   	<br>
   	<br>
      <div class="container">
      	<c:if test="${msgErro != null}">
	      	<div class="alert alert-danger alert-dismissible fade show" role="alert">
				${msgErro}
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				  <span aria-hidden="true">&times;</span>
				</button>
			</div>
			<br>
		</c:if>
        <h3 class="text-uppercase mb-0 text-center">Login</h3><br>
      </div>
      <div class="container">
      	<center>
        <div class="col-sm-3 text-center">
        	<form method="post" action="login">
			    <label for="senhaInput">Digite a senha de administrador:</label>
			    <input type="password" class="form-control" id="senhaInput" name="senhaInput" placeholder="Senha"><br>
			    <button type="submit" class="btn btn-dark">Entrar</button>
		  	</form>
		  </div>
		</center>
      </div>
   	<br>
   	<br>
   	<br>
    </header>
</t:template>