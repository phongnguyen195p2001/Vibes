<?php
require_once('connect.php');
require_once('function.php');
session_start();
?>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
<title>Sign up Admin</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<style>
	body {
		color: #fff;
		background: #63738a;
		font-family: 'Roboto', sans-serif;
    }
    
	.signup-form{
		width: 400px;
		margin: 60px auto;
		padding: 30px 0;
	}
	.signup-form h2{
		color: #636363;
        margin: 0 0 15px;
		position: relative;
		text-align: center;
    }
	.signup-form h2:before, .signup-form h2:after{
		content: "";
		height: 2px;
		width: 30%;
		background: #d4d4d4;
		position: absolute;
		top: 50%;
		z-index: 2;
	}	
	.signup-form h2:before{
		left: 0;
	}
	.signup-form h2:after{
		right: 0;
	}
    .signup-form .hint-text{
		color: #999;
		margin-bottom: 30px;
		text-align: center;
	}
    .signup-form form{
		color: #999;
		border-radius: 3px;
    	margin-bottom: 15px;
        background: #f2f3f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
	.signup-form .form-group{
		margin-bottom: 20px;
	}
	.signup-form input[type="checkbox"]{
		margin-top: 3px;
	}
	.signup-form .btn{        
        font-size: 16px;
        font-weight: bold;		
		min-width: 140px;
        outline: none !important;
    }
	.signup-form .row div:first-child{
		padding-right: 10px;
	}
	.signup-form .row div:last-child{
		padding-left: 10px;
	}    	
    .signup-form a{
		color: #fff;
		text-decoration: underline;
	}
    .signup-form a:hover{
		text-decoration: none;
	}
	.signup-form form a{
		color: #5cb85c;
		text-decoration: none;
	}	
	.signup-form form a:hover{
		text-decoration: underline;
	}  
</style>
</head>
<body>
    <?php 
		if(!empty($_SESSION['user'])){
    ?>
    <div class="signup-form">
        <form action="" method="POST">
            <h2>Sign up</h2>
            <p class="hint-text">Create your account. It's free and only takes a minute.</p>
            <div class="form-group">
                <input type="text" class="form-control" name="name" placeholder="Name" required="required">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="username" placeholder="User Name" required="required">
            </div>
            <div class="form-group">
                <input type="email" class="form-control" name="mail" placeholder="Email" required="required">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="password" placeholder="Password" required="required">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="confirm_password" placeholder="Confirm Password" required="required">
            </div>        
            <div class="form-group">
                <label class="checkbox-inline"><input type="checkbox" required="required"> I accept the <a href="#">Terms of Use</a> &amp; <a href="#">Privacy Policy</a></label>
            </div>
            <div class="form-group">
                <input type="submit" name="submit" class="btn btn-success btn-lg btn-block"></input>
            </div>
        </form>
        <div class="text-center">Already have an account? <a href="#">Sign in</a></div>
    </div>
    <?php } else { ?>
	<div class="alert alert-danger" style="margin:100px;">
		<strong>B???n ch??a ????ng nh???p!</strong> ????ng nh???p l???i <a href="loginadmin.php"> t???i ????y.</a>
	</div>
	<?php } ?>
    <?php  
        if(isset($_POST['submit'])){
            $user = $_POST['username'];
            $pass = $_POST['password'];
            $name = $_POST['name'];
            $mail = $_POST['mail'];
            $sql = "INSERT INTO `admin` (`idadmin`, `username`, `password`, `name`, `mail`) VALUES ('','$user',MD5('$pass'),'$name','$mail')";
            $result = mysqli_query($db,$sql);
        }
    ?>    
    <?php 
        if(isset($_POST['submit'])){
            redirect_to('admininfo.php');
        }
    ?>
</body>
</html>
<?php 
    db_disconnect($db);    
?>
