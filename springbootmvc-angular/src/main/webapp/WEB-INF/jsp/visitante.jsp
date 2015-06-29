<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>Angular Forms</title>

<!-- LOAD BOOTSTRAP CSS -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">

<!-- LOAD JQUERY -->
<!-- when building an angular app, you generally DO NOT want to use jquery -->
<!-- we are breaking this rule here because jQuery's $.param will help us send data to our PHP script so that PHP can recognize it -->
<!-- this is jQuery's only use. avoid it in Angular apps and if anyone has tips on how to send data to a PHP script w/o jQuery, please state it in the comments -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.0/angular.min.js"></script>


<script>
	//define angular module/app
	var formApp = angular.module('formApp', []);

	// create angular controller and pass in $scope and $http
	function formController($scope, $http) {
		$scope.formData = {};

		$scope.processForm = function() {

			$http({
				method : 'POST',
				url : './salvar',
				data : $scope.formData, // pass in data as strings
				headers : {
					'Content-Type' : 'application/json'
				}
			// set the headers so angular passing info as form data (not request payload)
			}).success(function(data) {
				console.log(data);
				
				$http.get("./listar").success(function(response) {
					$scope.visitantes = response;
		            $scope.refresh();

				});
				
				$scope.formData.nome = '';
				$scope.formData.email = '';
				
		    	$("#tabela").show();


			});
		};

		$http.get("./listar").success(function(response) {
		      if(response.length == 0){
		    	  $("#tabela").hide();
		      }
			$scope.visitantes = response;
            $scope.refresh();

		});
	}
	
</script>
</head>
<body ng-app="formApp" ng-controller="formController">
	<div class="container">
		<div class="col-md-6 col-md-offset-3">

			<!-- PAGE TITLE -->
			<div class="page-header">
				<h1>
					<span class="glyphicon glyphicon-user"></span> Cadastro de Visitantes
				</h1>
			</div>

			<!-- SHOW ERROR/SUCCESS MESSAGES -->
			<div id="messages"></div>

			<!-- FORM -->
			<form ng-submit="processForm()">
				<!-- NAME -->
				<div id="name-group" class="form-group">
					<label>Nome</label> <input type="text" name="nome"
						class="form-control" placeholder="Digite o Nome"
						ng-model="formData.nome"> <span class="help-block"></span>
				</div>

				<!-- SUPERHERO NAME -->
				<div id="superhero-group" class="form-group">
					<label>Email</label> <input type="text" name="email"
						class="form-control" placeholder="Digite o email"
						ng-model="formData.email"> <span class="help-block"></span>
				</div>

				<!-- SUBMIT BUTTON -->
				<button type="submit" class="btn btn-success btn-lg btn-block">
					<span class="glyphicon glyphicon-floppy-disk"></span> Salvar!
				</button>
			</form>
			
			<div id="tabela">
			<h2>Visitantes Cadastrados</h2>
			<table  class="table table-striped" >
				<thead>
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>Email</th>
						<th>Data Visita</th>
						<th>Deletar</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="visitante in visitantes">
						<td>{{ visitante.id }}</td>
						<td>{{ visitante.nome }}</td>
						<td>{{ visitante.email }}</td>
						<td>{{ visitante.dataVisita }}</td>
						
						<td><a  class="deleteLink" href="./delete/{{ visitante.id }}" >
						<span class="glyphicon glyphicon-trash"></span> </a></td>
					</tr>

				</tbody>
			</table>
			</div>
			

		</div>
	</div>
</body>
</html>