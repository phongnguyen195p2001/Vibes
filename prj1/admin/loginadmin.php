<?php
session_start();
require_once("connect.php");

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LOGIN ADMIN</title>
    <style>
        

        html, body{
            width: 100%;
            height: 100%;
            font-family: 'Courier';
            font-size: 16px;
            font-weight: bolder;
        }
        .bg{
            background: url('img/nen.jpg');
            background-size: cover;
            width: 100%;
            height: 100%;
        }

        label, .form-check-label{
            color: white;
            text-shadow: 2px 2px 10px black;
            font-family: 'Courier';
            font-weight: bold;
        }
        h1{
            text-shadow: 2px 2px 10px black;
            
        }
        .row-container{
            border: 1px solid white;
            border-radius: 20px;
            margin-top: 20vh;
            -webkit-box-shadow: 0px 1px 22px 5px rgb(255,250,250);
            -moz-box-shadow: 0px 1px 22px 5px rgb(255,250,250);
            box-shadow: 0px 1px 22px 5px rgb(255,250,250);
        }
        ::placeholder{
            font-family: 'Courier';
        }
    </style>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<body>
    <div class="container-fluid bg">
        <div class="row justify-content-center">
            <div class="col-md-3 col-sm-6 col-xs-12 row-container">
                <form action="" method="post">
                <h1 style="color: white;font-family: Courier;font-weight: bold;">Login Admin</h1>
                <div class="form-group">
                    <label for="user">Username:</label>
                    <input type="text" class="form-control" id="user" name="user" placeholder="Username">
                </div>
                <div class="form-group">
                    <label for="pwd" class="label">Password:</label>
                    <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Password">
                </div>
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="rememberMe">
                    <label for="rememberMe" class="form-check-label">Remember Me</label>
                </div>
                <button type="submit" name="submit" style="font-family: 'Courier';font-weight: bold; " class="btn btn-success btn-block my-3">Login</button>
                </form>
                <?php
                    if(isset($_POST['submit'])){
                        $uname = $_POST['user'];
                        $pass = $_POST['pwd'];
                        $escapedName = mysqli_real_escape_string($db,$uname);
                        $escapedPW = mysqli_real_escape_string($db,$pass);
                    
                        $sql = "select * from admin where username='".$escapedName."'AND password='".md5("$escapedPW")."'limit 1";
                        $result = mysqli_query($db,$sql);
                    
                        if(mysqli_num_rows($result)==1){
                            $_SESSION['user'] = $escapedName;
                            header('location:index.php');
                        }else{
                            db_disconnect($db);
                            header('location:loginadmin.php');
                        }
                    }
                ?>
            </div>
        </div>
    </div>
</body>
</html>