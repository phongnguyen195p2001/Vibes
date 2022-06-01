<?php
require_once('admin/connect.php');
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>auravn.com</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <link rel="stylesheet" href="index.css">
    <style>
        .menu {
            background: #2e2e2e;
        }

        .menu div ul li a {
            margin: 0 20px 0 0;
        }

        .navbar-brand {
            margin: 0 45px 0 0;
        }

        ul li a {
            font-size: 17px;
        }

        #banner img {
            margin-top: 20px;
            left: 10%;
            width: 961px;
            height: 262px;
        }

        #banner {
            left: 6.5%;
            margin-bottom: 50px;
        }

        #li a {
            display: inline-block;
        }

        #li a:hover {
            background: #555;
        }

        #li a:hover #li {
            display: block;
        }

        #li a #li a a {
            display: block !important;
        }

        #li a #li a:hover {
            background: #666;
        }

        body {
            background: #BDBDBD;
        }

        .p {
            border-radius: 30px;
            background-color: #fff;
            margin-bottom: 40px;
            margin-top: 120px;
        }

        #dinhvi {
            padding-top: 50px;
            border-left: dotted 3px white;
        }

        .a {
            padding-top: 50px;
        }
    </style>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light fixed-top">
        <div class="container">
            <a style="color: #fff;
            font-size: 25px;
            text-transform: uppercase;
            font-weight: bold;
            letter-spacing: 2px;" class="navbar-brand">A|U|R|A</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false">
                <span class="navbar-toggler-icon"></span>
            </button>
            <form action="chitiet_watchs.php" method="GET" id="form">
                <div class="search-box">
                    <input class="search-txt" type="text" name="search" placeholder="Type to search..." id="search">
                    <button class="search-btn" type="submit" name="submit">
                        <i class="fas fa-search"></i>
                    </button>
                </div>
            </form>
            <div class="col-md-2" style="position: absolute; margin-top: 255px; margin-left: 250px;">
                <span class="list-group" id="show-list">
                </span>
            </div>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto" style="font-size: 25px;text-transform: uppercase;font-weight: bold;letter-spacing: 2px;">
                    <li class="nav-item">
                        <a class="nav-link" href="index.php">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="thegioiaura.php">Aura Worlds</a>
                    </li>
                    <li class="nav-item dropdown" id="li">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Watch Lists
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <h2 class="dropdown-header">Brand</h2>
                            <div class="dropdown-divider"></div>
                            <?php
                            $brand = find_all_brand();
                            $count = mysqli_num_rows($brand);
                            for ($i = 0; $i < $count; $i++) :
                                $show = mysqli_fetch_assoc($brand);
                            ?>
                                <a class="dropdown-item" href="<?php echo "chitiet_brand.php?idbrand=" . $show["idbrand"]; ?>"><?php echo $show['namebrand']; ?></a>
                            <?php endfor; ?>
                            <div class="dropdown-divider"></div>
                            <h2 class="dropdown-header">Category</h2>
                            <div class="dropdown-divider"></div>
                            <?php
                            $category = find_all_category();
                            $count = mysqli_num_rows($category);
                            for ($i = 0; $i < $count; $i++) :
                                $show = mysqli_fetch_assoc($category);
                            ?>
                                <a class="dropdown-item" href="<?php echo "chitiet_type.php?idcategory=" . $show["idcategory"]; ?>"><?php echo $show['namecategory']; ?></a>
                            <?php endfor; ?>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="dinhvi.php">Location</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">

        <div class="container p">
            <br /><br />
            <div class="row">
                <div class="col-md-6 a">
                    <hr>
                    <?php
                    if (!empty($_POST["send"])) {
                        $name = $_POST["userName"];
                        $email = $_POST["userEmail"];
                        $content = $_POST["content"];

                        $conn = mysqli_connect("localhost", "root", "", "eproject1") or die("Connection Error: " . mysqli_error($conn));
                        mysqli_query($conn, "INSERT INTO tblcontact (user_name, user_email,content) VALUES ('" . $name . "', '" . $email . "','" . $content . "')");
                        $insert_id = mysqli_insert_id($conn);
                        //if(!empty($insert_id)) {
                        $message = "Your contact information is saved successfully.";
                        $type = "success";
                        //}
                    }
                    require_once "contact.php";
                    ?>
                    <hr>
                </div>
                <div class="col-md-6" id="dinhvi">
                    <hr>
                    <b><i class="fas fa-map-marker-alt"></i> Store address: 54 Le Thanh Nghi - Hai Ba Trung - Ha Noi.</b>
                    <div class="wrapper-info-agency cls">
                        <div class="info-l">
                            <div class="more_info">
                                <p><strong>Phone:</strong>&nbsp;(84)582571859 -&nbsp;<strong>Hotline</strong>: 11-222-3333<br />
                                    <strong>Brand:&nbsp;</strong>Rolex, Omega, Hublot, Casio, Philip.<br />
                                    <strong>Website:</strong>&nbsp;www.aura.com<br />
                                    <strong>Email</strong>: aurawatch4444@gmail.com<br />
                                    <strong>Time Work:</strong>&nbsp;All day and while from 9:30 am to 10:00 pm</p>
                            </div>
                        </div>
                    </div>
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.726181649695!2d105.84697855071762!3d21.003610485943405!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ad58455db2ab%3A0x9b3550bc22fd8bb!2zNTQgTMOqIFRoYW5oIE5naOG7iywgQsOhY2ggS2hvYSwgSGFpIELDoCBUcsawbmcsIEjDoCBO4buZaSwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2sus!4v1595861163508!5m2!1svi!2sus" width="100%" height="450" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
                    <hr>
                </div>
            </div>
        </div>
    </div>
    </div>
    <footer class="page-footer bg-dark">
        <div class="bg-success">
            <div class="container">
                <div class="row py-4 d-flex align-items-center">
                    <div class="col-md-12 text-center">
                        <a href="https://www.facebook.com/hhson2001/"><i class="fab fa-facebook-f text-white mr-5"></i></a>
                        <a href="#"><i class="fab fa-twitter text-white mr-5"></i></a>
                        <a href="#"><i class="fab fa-google-plus-g text-white mr-5"></i></a>
                        <a href="#"><i class="fab fa-pinterest-p text-white mr-5"></i></a>
                        <a href="#"><i class="fab fa-linkedin-in text-white mr-5"></i></a>
                        <a href="https://www.instagram.com/ins_cua_xon/"><i class="fab fa-instagram text-white"></i></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="container text-center text-md-left mt-5">
            <div class="row">
                <div class="col-md-3 mx-auto mb-4 text-white">
                    <h6 class="text-uppercase font-weight-bold">The Providers</h6>
                    <hr class="bg-success mb-4 mt-0 d-inline-block mx-auto" style="width: 125px; height: 2px;">
                    <p class="mt-2">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam </p>
                </div>
                <div class="col-md-3 mx-auto mb-4 text-white">
                    <h6 class="text-uppercase font-weight-bold">Products</h6>
                    <hr class="bg-success mb-4 mt-0 d-inline-block mx-auto" style="width: 85px; height: 2px;">
                    <ul class="list-unstyled">
                        <li class="my-2"><a href="">HTML5</a></li>
                        <li class="my-2"><a href="">CSS3</a></li>
                        <li class="my-2"><a href="">Bootstrap 4</a></li>
                        <li class="my-2"><a href="">Javascript</a></li>
                    </ul>
                </div>
                <div class="col-md-3 mx-auto mb-4 text-white">
                    <h6 class="text-uppercase font-weight-bold">Usefull Links</h6>
                    <hr class="bg-success mb-4 mt-0 d-inline-block mx-auto" style="width:110px; height: 2px;">
                    <ul class="list-unstyled">
                        <li class="my-2"><a href="">Home</a></li>
                        <li class="my-2"><a href="">About</a></li>
                        <li class="my-2"><a href="">Services </a></li>
                        <li class="my-2"><a href="">Contact</a></li>
                    </ul>
                </div>
                <div class="col-md-3 mx-auto mb-4 text-white">
                    <h6 class="text-uppercase font-weight-bold">Contact</h6>
                    <hr class="bg-success mb-4 mt-0 d-inline-block mx-auto" style="width: 75px; height: 2px;">
                    <ul class="list-unstyled">
                        <li class="my-2"><i class="fas fa-home mr-3"></i>54 Le Thanh Nghi</li>
                        <li class="my-2"><i class="far fa-envelope mr-3"></i>hson65169@gmail.com</li>
                        <li class="my-2"><i class="fas fa-phone mr-3"></i>+84582571859</li>
                        <li class="my-2"><i class="fas fa-print mr-3"></i>+11-222-3333</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="footer-copyright text-center py-3">
            <p>&copy; Copyright <a href="#">
                    theAurawatches.com
                </a></p>
            <p>Designed By the Aura Watches</p>
        </div>
    </footer>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#search").keyup(function() {
                var searchText = $(this).val();
                if (searchText != '') {
                    $.ajax({
                        url: "action.php",
                        method: "get",
                        data: {
                            query: searchText
                        },
                        success: function(response) {
                            $("#show-list").html(response);
                        }
                    });
                } else {
                    $("#show-list").html('');
                }
            });
            $(document).on('click', 'a', function() {
                $("#search").val($(this).text());
                $("#show-list").html('');
            });
        });
    </script>
</body>

</html>