<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>home page</title>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<script src="<c:url value="/resources/jquery-3.4.1.min.js" />"></script>

</head>
<body onload="viewpartner();">

		<div class="container-fluid" >
		<div class="row content text-center" style="background-color: #81DAF5;">
			<div class="col-sm-10 row" style="margin:1% 0 0 1%;">
				<div class="logo">
					<h4>Internship Report</h4>
				</div>
			</div>
			<div class="col-sm-1 sidenav" >
			
			</div>
		</div>
		<div class="row content" style="height: 550px;">
			<div  style="background-color: #E3F6CE;" class="col-sm-2">
            
				
				<div class="navbar">
					<ul>
						<li><a href="/LaborExport/home">Home</a></li>
						<li><a href="/LaborExport/partner">Partner Manage</a></li>
						<li><a href="/LaborExport/labor">Labor Manage</a></li>
					</ul>
				</div>
			</div>





		<div class="col-2"></div>
		<div class="col-6" style="margin-top: 40px; background-color:orange;">
		<form action="savelabor">
			<input name="idcompany" value="${id }" hidden="true">
			<div class="container">
				<div class="row" style="margin-top: 30px;">
					<div class="row col-12">
					<div style="margin-top: 8px;">
						Name: <input type="text" name="nameoflabor" placeholder="enter name" style="height: 30px;margin-left: 3px;">
						</div>
						<div style="margin-left: 20%;"> 
							Gender: 
							<div class="row">
							<input type="radio" name="gender" value="female" >female
							<input type="radio" name="gender" value="Male" style="margin-left: 10px;">Male
							</div>
						</div>	
					</div>				
				</div>
				<div class="row" style="margin-top: 30px;">
					<label >Born: </label> 
					
						<input type="text" name="born" placeholder="enter born" style="margin-left: 5px;">
						<div style="margin-left: 19%;">
							<label >Address:</label><input type="text" name="address" placeholder="enter address" style="margin-left: 5px;">
						</div>
				</div>
				<div class="row"style="margin-top: 30px;">
						<label >Phone: </label> 
						<input type="text" name="phone" placeholder="enter phone" style="margin-left: 5px;">
						<div style="margin-left: 17%;">
							<label >Level: </label><input type="text" name="level" placeholder="1-5" style="margin-left: 5px;">
						</div>
				</div>
				<div class="row" style="margin-top: 20px;">
					<input type="submit" value="Add labor" class="btn-success" style="margin-left: 45%;">
				</div>
			</div> 
		

		</form>
	</div>
	
</div>
	<c:if test="${notifice!=null }">
		<script type="text/javascript">
		 function ()
		 {
			 alert("${notifice}");
		 }
		</script>
	</c:if>
	

			<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
				integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
				crossorigin="anonymous"></script>
			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
				integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
				crossorigin="anonymous"></script>
			<script
				src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
				integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
				crossorigin="anonymous"></script>
			<script
				src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>


</body>
<style>
	.navbar>ul{
		list-style-type:none;
		padding:0;
		width:100%;
	}
	.navbar>ul>li{
		margin-top:5px;
		width:100%;
		height:30px;
	}
	.navbar>ul>li:hover, .navbar>ul>li>a:hover{	
		background-color:#066;
		color:#FFF;
		text-decoration:none;
	}
	.navbar>ul>li>a{
		color:#630;
	}
</style>
<footer class="page-footer font-small blue" style="background-color: #BDBDBD;height: 80px;">

	<div class="footer-copyright text-center">© 2019
		Copyright:Nguyen Van Toan</div>
</footer>

</html>

