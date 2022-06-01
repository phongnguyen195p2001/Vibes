<?php
session_start();
require_once('connect.php');
require_once('function.php');
?>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="robots" content="noindex, nofollow">
  <title>Create a category</title>
  <link href="css/font-awesome.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <style>
    body {
      color: #fff;
      background: #63738a;
      font-family: 'Roboto', sans-serif;
      }
      
    .signup-form{
      width: 400px;
      margin: 10px auto;
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
      z-index: 3;
    }	
    .signup-form h2:before{
      left: 0;
    }
    .signup-form h2:after{
      right: 0;
    }
    .signup-form .hint-text{
      color: #999;
      margin-bottom: 20px;
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
            <h2>Create</h2>
            <p class="hint-text">Create a new category</p>
            <div class="form-group">
                <input type="text" name="namecategory" class="form-control" placeholder="Tên">
            </div>   
            <div class="form-group">
                <input type="submit" name="upload" class="btn btn-success btn-lg btn-block"></input>
            </div>
        </form>
    </div>
    <?php } else { ?>
	  <div class="alert alert-danger" style="margin:100px;">
		<strong>Bạn chưa đăng nhập!</strong> Đăng nhập lại <a href="loginadmin.php"> tại đây.</a>
	</div>
	<?php } ?>
  <?php
    if(isset($_POST['upload'])){
      $na = $_POST['namecategory'];

      $sql = "INSERT INTO `category` (`idcategory`, `namecategory`) VALUES ('','$na')";
      $result = mysqli_query($db,$sql);
    } 
  ?>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  <?php 
    if(isset($_POST['upload'])){
      redirect_to('category.php');
    }
  ?>
</body>
</html>
<?php 
    db_disconnect($db);    
?>