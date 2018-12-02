<%@tag description="Simple Template Tag" pageEncoding="ISO-8859-1"%>
<html>
<head>

    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Laboratorio</title>

    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css">

    <link href="css/freelancer.min.css" rel="stylesheet">

  </head>

  <body id="page-top">
    <nav class="navbar navbar-expand-lg bg-secondary fixed-top text-uppercase" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="./"><img alt="logo" src="img/logo.png" height="50" width="132"></a>
        <button class="navbar-toggler navbar-toggler-right text-uppercase bg-primary text-black rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item mx-0 mx-lg-1">
              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="pesquisa">Pesquisa</a>
            </li>
            <li class="nav-item mx-0 mx-lg-1">
              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="publicacoes">Publicações</a>
            </li>
            <li class="nav-item mx-0 mx-lg-1">
              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="integrantes">Integrantes</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    
  <jsp:doBody/>
  
  <footer class="footer text-center pt-4"> <!-- <footer class="footer text-center pt-4"> -->
      <div class="container">
        <div class="row">
          <div class="col-md-4 mb-4">
            <h4 class="text-uppercase mb-2">Localização</h4>
            <p class="lead">Prédio do NCAD/UFPI - Térreo<br><i class="fa fa-globe"></i>&ensp;<a href="https://goo.gl/maps/dAYq8w1w8Uo">Mapa</a></p>
          </div>
          <div class="col-md-4 mb-6 mb-lg-0">
          </div>
          <div class="col-md-4">
            <h4 class="text-uppercase mb-2">Contatos</h4>
            <p class="lead"><i class="fas fa-phone icon"></i>&ensp;(86)3237-2230 - PPGCC/UFPI<br><i class="fas fa-phone icon"></i>&ensp;(86)3237-2104 - UFPI</p>
          </div>
        </div>
      </div>
	    <div class="copyright py-1 text-center text-white">
	      <div class="container">
	        <small>PPGCC/UFPI&ensp;-&ensp;2018&ensp;</small>
	      </div>
	    </div>
    </footer>

    <div class="scroll-to-top d-lg-none position-fixed ">
      <a class="js-scroll-trigger d-block text-center text-white rounded" href="#page-top">
        <i class="fa fa-chevron-up"></i>
      </a>
    </div>

    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

    <script src="js/freelancer.min.js"></script>

  </body>
</html>