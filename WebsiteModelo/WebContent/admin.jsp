<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>

<t:template>
    <header class="masthead bg-primary text-black">
      <div class="container">
        <h3 class="text-uppercase mb-0 text-center">Painel de Administração</h3>
        <h5 class="text-uppercase mb-0 text-center">(<a href="Logout">Logout</a>)</h5><br><br>
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
    	<form method="post" action="EditarSobreLab">
      	<h6 class="text-uppercase mb-0">Nome:</h6>
      	<input type="text" class="form-control" id="nomeLab" name="nomeLab" value="${sobre.nome}" placeholder="Nome do laboratório"><br>
      	<h6 class="text-uppercase mb-0">Descrição:</h6>
    	<textarea class="form-control" id="descLab" name="descLab" rows="7">${sobre.descricao}</textarea><br>
			<button type="submit" class="btn btn-success">Salvar</button>
    	</form>
      </div>
      <div class="container">
	    <br><hr><br>
      	<h5 class="text-uppercase mb-0">Linhas de pesquisa:</h5><br>
      	<c:if test="${linhas != null}">
	      	<table class="table table-bordered table-striped table-hover">
			  <thead>
			    <tr>
			      <th scope="col">Título</th>
			      <th scope="col">Orientador</th>
			      <th scope="col" class="text-center">Opções</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach var="linha" items="${linhas}">
			  		<form id="formEditarLinha${linha.id}" action="RecuperarLinhaPesquisa" method="post">
				      	<input type="hidden" id="idLin" name="idLinha" value="${linha.id}">
				    </form>
				    <form id="formRemoverLinha${linha.id}" action="RemoverLinhaPesquisa" method="post">
				      	<input type="hidden" id="idLin" name="idLinha" value="${linha.id}">
				    </form>
				    <tr>
				      <td>${linha.titulo}</td>
				      <td>${linha.orientador}</td>
				      <th class="text-center" style="width: 16.66%">
				      <button type="submit" form="formEditarLinha${linha.id}" class="btn btn-dark"><i class="fas fa-edit"></i></button>
				      &ensp;
				      <button type="submit" form="formRemoverLinha${linha.id}" class="btn btn-dark"><i class="fas fa-trash-alt"></i></button>
				      </th>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</c:if>
      	<c:if test="${linhas == null}">
      		Não há linhas de pesquisa cadastradas!<br><br>
		</c:if>
		<a href="./adicionarLinhaPesquisa.jsp" class="btn btn-dark">Adicionar</a>
		
      </div>
      
      <div class="container">
	    <br><hr><br>
	    <h5 class="text-uppercase mb-0">Publicações:</h5><br>
	    <c:if test="${pubs != null}">
	      	<table class="table table-bordered table-striped table-hover">
			  <thead>
			    <tr>
			      <th scope="col">Título</th>
			      <th scope="col">Autores</th>
			      <th scope="col" class="text-center">Opções</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach var="pub" items="${pubs}">
			  		<form id="formEditarPub${pub.id}" action="RecuperarPublicacao" method="post">
				      	<input type="hidden" id="idPub" name="idPub" value="${pub.id}">
				    </form>
				    <form id="formRemoverPub${pub.id}" action="RemoverPublicacao" method="post">
				      	<input type="hidden" id="idPub" name="idPub" value="${pub.id}">
				    </form>
				    <tr>
				      <td>${pub.titulo}</td>
				      <td>${pub.autores}</td>
				      <th class="text-center" style="width: 16.66%">
				      <button type="submit" form="formEditarPub${pub.id}" class="btn btn-dark"><i class="fas fa-edit"></i></button>
				      &ensp;
				      <button type="submit" form="formRemoverPub${pub.id}" class="btn btn-dark"><i class="fas fa-trash-alt"></i></button>
				      </th>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</c:if>
		
      	<c:if test="${pubs == null}">
      		Não há publicações cadastradas!<br><br>
		</c:if>
		
	    <a href="./adicionarPublicacao.jsp" class="btn btn-dark">Adicionar</a>
		
	  </div>
	  
	  <div class="container table-responsive">
	    <br><hr><br>
	    <h5 class="text-uppercase mb-0">Integrantes:</h5><br>
	    <c:if test="${integs != null}">
	      	<table class="table table-bordered table-striped table-hover">
			  <thead>
			    <tr>
			      <th scope="col">Nome</th>
			      <th scope="col" class="text-center">Opções</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach var="integ" items="${integs}">
			  		<form id="formEditarInteg${integ.id}" action="RecuperarIntegrante" method="post">
				      	<input type="hidden" id="idInteg" name="idInteg" value="${integ.id}">
				    </form>
				    <form id="formRemoverInteg${integ.id}" action="RemoverIntegrante" method="post">
				      	<input type="hidden" id="idInteg" name="idInteg" value="${integ.id}">
				    </form>
				    <tr>
				      <td>${integ.nome}</td>
				      <th class="text-center" style="width: 16.66%">
				      <button type="submit" form="formEditarInteg${integ.id}" class="btn btn-dark"><i class="fas fa-edit"></i></button>
				      &ensp;
				      <button type="submit" form="formRemoverInteg${integ.id}" class="btn btn-dark"><i class="fas fa-trash-alt"></i></button>
				      </th>
				      </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</c:if>
		
		<c:if test="${integs == null}">
      		Não há integrantes cadastrados!<br><br>
		</c:if>
		
		<a href="./adicionarIntegrante.jsp" class="btn btn-dark">Adicionar</a>
		
	  </div>
    </header>
</t:template>

<script src="js/scripts.js"></script>