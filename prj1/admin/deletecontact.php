<?php
require_once('connect.php');
require_once('function.php');

if ($_SERVER["REQUEST_METHOD"] == 'POST') {
    //db delete
    delete_contact($_POST['idcontact']);
    redirect_to('contact.php');
} else { // form loaded
    if (!isset($_GET['idcontact'])) {
        redirect_to('contact.php');
    } else {
        $id = $_GET['idcontact'];
        $contact = find_contact_by_id($id);
    }
}

?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
    <title>Delete contact</title>
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

        .signup-form {
            width: 400px;
            margin: 113px auto;
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
            z-index: 2;
        }

        .signup-form h2:before {
            left: 0;
        }

        .signup-form h2:after {
            right: 0;
        }

        .signup-form .hint-text {
            color: #999;
            margin-bottom: 30px;
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

        .signup-form .row div:first-child {
            padding-right: 10px;
        }

        .signup-form .row div:last-child {
            padding-left: 10px;
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
    <div class="signup-form">
        <form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="POST">
            <h2>Delete</h2>
            <p class="hint-text">Are you sure you want to delete the contact?</p>
            <input type="hidden" name="idcontact" value="<?php echo $contact['idcontact'] ?>">
            <div class="form-group">
                <input type="text" class="form-control" name="namecontact" value="<?php echo $contact['user_name'] ?>">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="namecontact" value="<?php echo $contact['user_email'] ?>">
            </div>
            <div class="form-group">
                <textarea type="text" name="editor1" id="editor1" class="form-control"><?php echo $contact['content'] ?></textarea>
            </div>
            <div class="form-group">
                <input type="submit" name="submit" class="btn btn-success btn-lg btn-block" value="Delete"></input>
            </div>
        </form>
    </div>
</body>

</html>


<?php
db_disconnect($db);
?>