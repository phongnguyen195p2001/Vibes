<?php
require_once("connect.php");
session_start();
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <style>
        #dataTable_paginate {
            margin-bottom: 50px;
            text-align: center;
        }

        #dataTable_previous,
        a.paginate_button {
            margin: 6px;
            color: black;
            padding: 4px;
        }

        label {
            margin: 1%;
            float: right;
            font-family: sans-serif;
            font-size: 16px;
        }

        input {
            margin-left: 3px;
            border-radius: 8px;
        }
    </style>
</head>

<body>
    <?php
    if (!empty($_SESSION['user'])) {
    ?>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <a class="navbar-category" href="#"><strong style="color: #30a5ff;">Admin</strong>Home</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="nav-link" href="logout.php" id="logout"><em class="fa fa-sign-out">&nbsp;</em> Logout</a>
        </nav>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main" style="float:right;">
            <div class="row" ;>
                <ol class="breadcrumb">
                    <li><a style="color: #30a5ff;" href="../index.php">
                            <em class="fa fa-home"></em>
                        </a></li>
                    <li class="active">&nbspUI Home</li>
                </ol>
            </div>
            <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
                <div class="profile-sidebar">
                    <div class="profile-userpic">
                        <img src="pppp.jpeg" class="img-responsive" alt="">
                    </div>
                    <div class="profile-usertitle">
                        <div class="profile-usertitle-name">
                            <?php echo "User: " . $_SESSION['user']; ?>
                        </div>
                        <div class="profile-usertitle-status"><span class="indicator label-success"></span>Online</div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="divider"></div>
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item"><a class="nav-link" href="index.php"><em class="fa fa-dashboard">&nbsp;</em>Dashboard</a></li>
                    <li class="nav-item"><a class="nav-link" href="admininfo.php"><em class="fa fa-user">&nbsp;</em> 
Administration information</a></li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle fa fa-toggle-off" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Product management catalog
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="watch.php">Watch</a>
                            <a class="dropdown-item" href="brand.php">Brand</a>
                            <a class="dropdown-item" href="category.php">Category</a>
                        </div>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="contact.php"><em class="fa fa-user">&nbsp;</em> Contact</a></li>
                </ul>
                <hr>
            </div>
            <div>
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Category</h1>
                    </div>
                </div>
                <a href="insertcategory.php">
                    <button type="button" class="btn">
                        <i class="fa fa-plus"></i> Add Category
                    </button>
                </a>
                <div class="table-responsive">
                    <table id="dataTable" class="table" cellspacing="0" width="100%">
                        <thead>
                            <th class="th-sm">Name Category
                            </th>
                            </th>
                            <th class="th-sm">Edit
                            </th>
                            </th>
                            <th class="th-sm">Delete
                            </th>
                            </tr>
                        </thead>
                        <tbody>
                            <?php
                            $category_set = find_all_category();
                            $count = mysqli_num_rows($category_set);
                            for ($i = 0; $i < $count; $i++) :
                                $category = mysqli_fetch_assoc($category_set);
                            ?>
                                <tr>
                                    <td><?php echo $category['namecategory'] ?></td>
                                    <td style="text-align: center;"><a style="color:#30a5ff;" href="<?php echo 'updatecategory.php?idcategory=' . $category['idcategory']; ?>"><i class="fa fa-edit"></i></a></td>
                                    <td style="text-align: center;"><a style="color:#30a5ff;" href="<?php echo 'deletecategory.php?idcategory=' . $category['idcategory']; ?>"><i class="fa fa-trash"></i></td>
                                </tr>
                            <?php
                            endfor;
                            mysqli_free_result($category_set);
                            ?>
                        </tbody>
                        <tfoot>
                            <th class="th-sm">Name category
                            </th>
                            </th>
                            <th class="th-sm">Edit
                            </th>
                            </th>
                            <th class="th-sm">Delete
                            </th>
                            </tr>
                            </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
        </div>
    <?php } else { ?>
        <div class="alert alert-danger" style="margin:100px;">
            <strong>Bạn chưa đăng nhập!</strong> Đăng nhập lại <a href="loginadmin.php"> tại đây.</a>
        </div>
    <?php } ?>
    <script src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script language="JavaScript" type="text/javascript">
        $(document).ready(function() {
            $("a#logout").click(function(e) {
                if (!confirm('Are you sure?')) {
                    e.preventDefault();
                    return false;
                }
                return true;
            });
        });
        $(document).ready(function() {
            $('#dataTable').dataTable({
                "fnInitComplete": function() {
                    var myCustomScrollbar = document.querySelector('#dt-horizontal-scroll_wrapper .dataTables_scrollBody');
                    var ps = new PerfectScrollbar(myCustomScrollbar);
                },
                "scrollX": true,
                fixedColumns: {
                    leftColumns: 1,
                    rightColumns: 1
                }
            });
        });
    </script>
</body>

</html>
<?php
db_disconnect($db);
?>