<?php
	require_once("connect.php");
	session_start();
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Admin Home</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/css.css" rel="stylesheet">
	
	<!--Custom Font-->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
	<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
<?php 
	if(!empty($_SESSION['user'])){
?>
	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse"><span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span></button>
				<a class="navbar-brand" href="#"><span>Team-PSKD </span>Admin</a>
			</div>
		</div>
	</nav>
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<div class="profile-sidebar">
			<div class="profile-userpic">
				<img src="pppp.jpeg" class="img-responsive" alt="">
			</div>
			<div class="profile-usertitle">
				<div class="profile-usertitle-name">
				<?php  
				echo "User: ".$_SESSION['user'];
				?>
				</div>
				<div class="profile-usertitle-status"><span class="indicator label-success"></span>Online</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="divider"></div>
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
		</form>
		<ul class="nav menu">
			<li class="parent "><a data-toggle="collapse" href="#sub-item-1" class="" aria-expanded="true">
				<em class="fa fa-navicon fa-minus">&nbsp;</em> Danh mục quản lý <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right" aria-expanded="true"><em class="fa fa-plus fa-minus"></em></span>
				</a>
				<ul class="children collapse in" id="sub-item-1" aria-expanded="true" style="">
					<li><a class="" href="index.php">
						<span class="fa fa-arrow-right">&nbsp;</span> Đồng hồ
					</a></li>
					<li><a class="" href="loaidongho.php">
						<span class="fa fa-arrow-right">&nbsp;</span> Loại đồng hồ
					</a></li>
					<li><a class="" href="brand.php">
						<span class="fa fa-arrow-right">&nbsp;</span> Hãng
					</a></li>
				</ul>
			</li>
			<li><a href="logout.php" class="logout"><em class="fa fa-power-off">&nbsp;</em> Logout</a></li>
		</ul>
	</div>
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="../index.php">
					<em class="fa fa-home"></em>
				</a></li>
				<li class="active">Loại đồng hồ</li>
			</ol>
		</div>
		
		<div class="row">
			<div class="col-lg-12">
				<h2 class="page-header">Loại đồng hồ</h2>
			</div>
		</div>
		<!-- day -->
		
		
	</div>
	<p id="demo1"></p>
	<?php } else { ?>
	<div class="alert alert-danger" style="margin:100px;">
		<strong>Bạn chưa đăng nhập!</strong> Đăng nhập lại <a href="loginadmin.php"> tại đây.</a>
	</div>
	<?php } ?>
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/custom.js"></script>
	<script language="JavaScript" type="text/javascript">
	$(document).ready(function(){
		$("a.logout").click(function(e){
			if(!confirm('Are you sure?')){
				e.preventDefault();
				return false;
			}
			return true;
		});
	});
	</script>
</body>
</html>