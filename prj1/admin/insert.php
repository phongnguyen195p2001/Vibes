<?php
session_start();
require_once('connect.php');
require_once('function.php');
error_reporting();

if (isset($_POST['upload'])) {
  $img = $_POST['img'];
  $na = $_POST['name'];
  $pr = $_POST['price'];
  $cd = $_POST['code'];
  $ed = $_POST['editor1'];
  $br = $_POST['idbrand'];
  $ca = $_POST['idcategory'];

  $sql = "INSERT INTO `watchs` (`idwatchs`, `image`, `namewatchs`, `price`, `code`, `descriptions`, `idbrand`, `idcategory`) VALUES ('', '$img', '$na', '$pr', '$cd', '$ed', '$br', '$ca')";
  $result = mysqli_query($db, $sql);
}
?>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="robots" content="noindex, nofollow">
  <title>Create a product</title>
  <link href="css/font-awesome.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://cdn.ckeditor.com/4.14.1/standard-all/ckeditor.js"></script>
  <style>
    body {
      color: #fff;
      background: #63738a;
      font-family: 'Roboto', sans-serif;
    }

    .signup-form {
      width: 400px;
      margin: 10px auto;
      padding: 30px 0;
    }

    .signup-form h2 {
      color: #636363;
      margin: 0 0 15px;
      position: relative;
      text-align: center;
    }

    .signup-form h2:before,
    .signup-form h2:after {
      content: "";
      height: 2px;
      width: 30%;
      background: #d4d4d4;
      position: absolute;
      top: 50%;
      z-index: 3;
    }

    .signup-form h2:before {
      left: 0;
    }

    .signup-form h2:after {
      right: 0;
    }

    .signup-form .hint-text {
      color: #999;
      margin-bottom: 20px;
      text-align: center;
    }

    .signup-form form {
      color: #999;
      border-radius: 3px;
      margin-bottom: 15px;
      background: #f2f3f7;
      box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
      padding: 30px;
    }

    .signup-form .form-group {
      margin-bottom: 20px;
    }

    .signup-form input[type="checkbox"] {
      margin-top: 3px;
    }

    .signup-form .btn {
      font-size: 16px;
      font-weight: bold;
      min-width: 140px;
      outline: none !important;
    }

    .signup-form a {
      color: #fff;
      text-decoration: underline;
    }

    .signup-form a:hover {
      text-decoration: none;
    }

    .signup-form form a {
      color: #5cb85c;
      text-decoration: none;
    }

    .signup-form form a:hover {
      text-decoration: underline;
    }

  </style>
</head>

<body>
  <?php
  if (!empty($_SESSION['user'])) {
  ?>
    <div class="signup-form">
      <form action="<?php echo $_SERVER["PHP_SELF"]; ?>" method="POST">
        <h2>Create</h2>
        <p class="hint-text">Create a new product</p>
        <div class="form-group">
          <input type="hidden" name="img"><input type="file" id="img" name="img" class="form-control" placeholder="Ảnh"></input>
        </div>
        <div class="form-group">
          <input type="text" name="name" class="form-control" placeholder="Tên">
        </div>
        <div class="form-group">
          <input type="number" name="price" class="form-control" placeholder="Giá">
        </div>
        <div class="form-group">
          <input type="text" name="code" class="form-control" placeholder="Mã">
        </div>
        <div class="form-group">
          <textarea name="editor1" id="editor1"></textarea>
        </div>
        <div class="form-group">
          <select name="idbrand" class="form-control">
            <?php
            $result = find_all_brand();
            while ($row = mysqli_fetch_array($result)) :; ?>
              <option value="<?php echo $row[0]; ?>"><?php echo $row[2]; ?></option>
            <?php endwhile; ?>
          </select>
        </div>
        <div class="form-group">
          <select name="idcategory" class="form-control">
            <?php
            $result = find_all_category();
            while ($row = mysqli_fetch_array($result)) :; ?>
              <option value="<?php echo $row[0]; ?>"><?php echo $row[1]; ?></option>
            <?php endwhile; ?>
          </select>
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
  <?php }
  if (isset($_POST['upload'])) {
    redirect_to('watch.php');
  }
  ?>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  <script>
    CKEDITOR.replace('editor1', {
      width: 340,
      height: 175,
      resize_dir: 'both',
      resize_minWidth: 100,
      resize_minHeight: 200,
      resize_maxWidth: 800
    });
  </script>
</body>

</html>
<?php
db_disconnect($db);
?>