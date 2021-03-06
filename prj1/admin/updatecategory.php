<?php
    require_once('connect.php');
    require_once('function.php');
    session_start();

    if($_SERVER["REQUEST_METHOD"] == "POST"){
        $category=[];
        $category["idcategory"]=$_POST["idcategory"];
        $category["namecategory"]=$_POST["namecategory"];
        update_category($category);
        redirect_to("category.php");
    }else{
        if(!isset($_GET["idcategory"])){
            redirect_to("category.php");
        }
        $id=$_GET["idcategory"];
        $category=find_category_by_id($id);
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
<title>Update category</title>
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
		margin: 100px auto;
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
        <form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="POST">
            <h2>Update</h2>
            <p class="hint-text">Update your category. It's free and only takes a minute.</p>
            <input type="hidden" name="idcategory" value="<?php echo $category['idcategory']?>">
            <div class="form-group">
                <input type="text" class="form-control" name="namecategory" placeholder="Name Category" value="<?php echo $category['namecategory'] ?>">
            </div>
            <div class="form-group">
                <input type="submit" name="submit" class="btn btn-success btn-lg btn-block"></input>
            </div>
        </form>
    </div>
    <?php } else { ?>
	<div class="alert alert-danger" style="margin:100px;">
		<strong>B???n ch??a ????ng nh???p!</strong> ????ng nh???p l???i <a href="logincategory.php"> t???i ????y.</a>
	</div>
	<?php } ?>
</body>
</html>
<?php 
    db_disconnect($db);    
?>
