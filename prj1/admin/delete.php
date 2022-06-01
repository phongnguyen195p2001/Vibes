<?php
require_once('connect.php');
require_once('function.php');
session_start();

if ($_SERVER["REQUEST_METHOD"] == 'POST'){
    //db delete
    delete_watch($_POST['idwatchs']);
    redirect_to('watch.php');
} else { // form loaded
    if(!isset($_GET['idwatchs'])) {
        redirect_to('watch.php');
    }else{
    $id = $_GET['idwatchs'];
    $watch = find_watch_by_id($id);
    }
}

?>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="robots" content="noindex, nofollow">
  <title>Delete</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link href="css/font-awesome.min.css" rel="stylesheet">
  <script src="https://cdn.ckeditor.com/4.14.1/standard-all/ckeditor.js"></script>
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
        <form action="<?php echo $_SERVER["PHP_SELF"]; ?>" class="isform" method="POST" enctype="multipart/form-data">
            <h2>Delete</h2>
            <p class="hint-text">Are you sure you want to delete this product ?</p>
            <div class="editor1">
                <input type="hidden" name="idwatchs" value="<?php echo $watch['idwatchs'] ?>">
                <div class="form-group">    
                   <input type="text" name="img" class="form-control" value="<?php echo $watch['image'] ?>">
                </div>
                <div class="form-group">
                        <input type="text" name="name" class="form-control" placeholder="Tên" value="<?php echo $watch['namewatchs'] ?>">
                </div>
                <div class="form-group">
                    <input type="number" name="price" class="form-control" placeholder="Giá" value="<?php echo $watch['price'] ?>">
                </div>
                <div class="form-group">
                    <input type="text" name="code" class="form-control" placeholder="Mã" value="<?php echo $watch['code'] ?>">
                </div>
                <div class="form-group">
                        <textarea type="text" name="editor1" id="editor1" class="form-control"><?php echo $watch['descriptions'] ?></textarea>
                </div>
                <div class="form-group">
                    <input type="text" name="idbrand" class="form-control" placeholder="Hãng" value="<?php echo $watch['idbrand'] ?>">
                </div>
                <div class="form-group">
                    <input type="text" name="idcategory" class="form-control" placeholder="Thể loại" value="<?php echo $watch['idcategory'] ?>">
                </div>
                <div class="form-group">
                    <input type="submit" name="submit" style="font-family: 'Courier';font-weight: bold; " value="Delete" class="btn btn-success btn-lg btn-block"></input>
                </div>
            </div>
        </form>
    </div>
    <?php } else { ?>
	  <div class="alert alert-danger" style="margin:100px;">
		<strong>Bạn chưa đăng nhập!</strong> Đăng nhập lại <a href="loginadmin.php"> tại đây.</a>
	</div>
	<?php } ?>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script>
        CKEDITOR.replace('editor1', {
            width: 338,
            height: 150,
            resize_dir: 'both',
            resize_minWidth: 200,
            resize_minHeight: 300,
            resize_maxWidth: 800   
        });
    </script>
</body>
</html>


<?php
db_disconnect($db);
?>