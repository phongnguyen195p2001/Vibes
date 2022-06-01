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
            <div class="col-md-2" style="position: absolute; margin-top: 200px; margin-left: 200px;">
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
    <div class="carousel-inner" role="listbox">

        <!--First slide-->
        <div class="carousel-item active">
            <!--Mask-->
            <div class="view">
                <!--Video source-->
                <video autoplay loop playsinline muted>
                    <source src="admin/video/videodep.webm" type="video/mp4" />
                </video>
                <!-- Carousel content -->
                <div class="full-bg-img flex-center mask rgba-indigo-light white-text">
                    <ul class="animated fadeInUp col-md-12 list-unstyled list-inline">
                        <li>
                            <h1 class="font-weight-bold text-uppercase">Watch</h1>
                        </li>
                        <li>
                            <p class="font-weight-bold text-uppercase py-4">Clock symbol of vintage style</p>
                        </li>

                    </ul>
                </div>
            </div>
            <!--/Mask-->
        </div>
        <!--/First slide-->

        <!--Second slide-->
        <div class="carousel-item">
            <!--Mask color-->
            <div class="view">
                <!--Video source-->
                <video autoplay loop playsinline muted>
                    <source src="" type="video/mp4" />
                </video>
                <!-- Carousel content -->
                <div class="full-bg-img flex-center mask rgba-purple-light white-text">
                    <!-- <ul class="animated fadeInUp col-md-12 list-unstyled">
                            <li>
                                <h1 class="font-weight-bold text-uppercase">Lots of tutorials at your disposal</h1>
                            </li>
                            <li>
                                <p class="font-weight-bold text-uppercase py-4">And all of them are FREE!</p>
                            </li>
                            <li>
                                <a target="_blank" href="" class="btn btn-pink btn-rounded btn-lg">Start learning</a>
                            </li>
                        </ul> -->
                </div>
            </div>
            <!--/Mask color-->
        </div>
        <!--/Second slide-->

        <!--Third slide-->
        <div class="carousel-item">
            <!--Mask color-->
            <div class="view">
                <!--Video source-->
                <video autoplay loop playsinline muted>
                    <source src="admin/img/videoAura.mp4" type="video/mp4" />
                </video>
                <!-- Carousel content -->
                <div class="full-bg-img flex-center mask rgba-blue-light white-text">
                    <!-- <ul class="animated fadeInUp col-md-12 list-unstyled">
                            <li>
                                <h1 class="font-weight-bold text-uppercase">Visit our support forum</h1>
                            </li>
                            <li>
                                <p class="font-weight-bold text-uppercase py-4">Our community can help you with any question</p>
                            </li>
                            <li>
                                <a target="_blank" href="" class="btn btn-lg btn-indigo btn-rounded">Support forum</a>
                            </li>
                        </ul> -->
                </div>
            </div>
            <!-- Mask color -->
        </div>
        <!--/Third slide-->
    </div>
    <!-- <a class="carousel-control-prev" href="#carousel-example-2" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carousel-example-2" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a> -->
    <!--/.Controls-->

    <br>
    <div class="container" id="container">
        <div class="row">
            <div class="col-md-12" id="text-dongho">
                <div class="title_mod">
                    <span> Brand </span>
                </div>
                <br>
            </div>
            <marquee scrollamount="30">
                <?php
                $brand = find_all_brand();
                $count = mysqli_num_rows($brand);
                for ($i = 0; $i < $count; $i++) :
                    $show = mysqli_fetch_assoc($brand);
                ?>
                    <a id="Library" style="text-decoration:none;" href="<?php echo "chitiet_brand.php?idbrand=" . $show["idbrand"]; ?>">
                        <img class="img-thumbnail p" style="width:230px; height:190px; margin-bottom:40px;margin-right:40px;" src="admin/img/logo/<?php echo $show['imagebr']; ?>">
                    </a>
                <?php
                endfor;
                mysqli_free_result($brand);
                ?>
            </marquee>
        </div>
    </div>
    <div class="container" id="container">
        <!-- <div >
            <video class="container" id="video_background" preload="auto" autoplay="true" loop="loop" muted volume="0">
                <source src="img/videoindex.mp4" type="video/mp4"/>           
            </video>
        </div> -->
        <div class="row">
            <div class="col-md-12">
                <div class="title_mod">
                    <span> New watchs </span>
                </div>
                <br>
            </div>
            <!-- Thêm các dữ liệu từ database -->
            <!-- <?php
                    $watchs = find_all_watchs();
                    $count = mysqli_num_rows($watchs);
                    for ($i = 0; $i < $count; $i++) :
                        $show = mysqli_fetch_assoc($watchs);
                    ?>
                <div id="Library-show" class="col-md-3">
                    <div class="col-md-12">
                        <div id="Library" class="box-hover">
                            <img class="img-thumbnai" style="width:230px; height:190px;" src="admin/img/<?php echo $show['image']; ?>">
                            <h3><a href="<?php echo "chitiet_watchs.php?idwatchs=" . $show["idwatchs"]; ?>"><button type="button" class="btn btn-primary">View Detail</button> </a></h3>
                        </div>
                        <p class="name"><?php echo $show['namewatchs']; ?></p>
                        <p class="name" style="color:rgb(247, 90, 90); text-align:center; margin-bottom:40px;">Price : $<?php echo $show['price']; ?></p>
                    </div>
                </div>
            <?php
                    endfor;
                    mysqli_free_result($watchs);
            ?> -->
            <?php
            $product_set = search_product();
            $count = mysqli_num_rows($product_set);
            for ($i = 0; $i < $count; $i++) :
                $show = mysqli_fetch_assoc($product_set);
            ?>
                <div id="Library-show" class="col-md-3">
                    <div class="col-md-12 card">
                        <div id="Library" class="box-hover">
                            <img class="img-thumbnai" style="width:230px; height:190px;" src="admin/img/<?php echo $show['image']; ?>">
                            <h3><a href="<?php echo "chitiet_watchs.php?idwatchs=" . $show["idwatchs"]; ?>"><button type="button" class="btn btn-primary">View Detail</button> </a></h3>
                        </div>
                        <p class="name"><?php echo $show['namewatchs']; ?></p>
                        <p class="name" style="color:rgb(247, 90, 90); text-align:center; margin-bottom:40px;">Price : $<?php echo $show['price']; ?></p>
                    </div>
                </div>
            <?php
            endfor;
            mysqli_free_result($product_set);
            ?>
            <?php
            $result = mysqli_query($db, "SELECT COUNT(idwatchs) AS total FROM watchs");
            $row = mysqli_fetch_assoc($result);
            $page = $row['total'];
            $currenpage = isset($_GET['page']) ? $_GET['page'] : 1;
            $limit = 8;
            $Next = $currenpage + 1;
            $Previous = $currenpage - 1;
            $total_page = ceil($page / $limit);
            if ($currenpage > $total_page) {
                $currenpage = $total_page;
            } else if ($currenpage < 1) {
                $currenpage = 1;
            }
            $start = ($currenpage - 1) * $limit;
            $result = mysqli_query($db, "SELECT * FROM watchs LIMIT $start, $limit");
            ?>
            <div class="example ">
                <nav aria-label="Page navigation example btn-floating light-green">
                    <ul class="pagination">
                        <?php if ($currenpage > 1 && $total_page > 1) : ?>
                            <li class="page-item">
                                <a href="index.php?page=<?= $Previous; ?>" aria-label="Previous">
                                    <span aria-hidden="true"><i class="fa fa-arrow-left" aria-hidden="true"></i></span>
                                </a>
                            </li>
                        <?php endif; ?>
                        <?php for ($i = 1; $i <= $total_page; $i++) : ?>
                            <?php if ($i == $currenpage) : ?>
                                <span><?php echo $i ?></span>
                            <?php else : ?>
                                <li class="page-item examples"><a href="index.php?page=<?= $i; ?>"><?= $i ?></a></li>
                            <?php endif; ?>
                        <?php endfor; ?>
                        <?php if ($currenpage < $total_page && $total_page > 1) : ?>
                            <li class="page-item examples">
                                <a href="index.php?page=<?= $Next; ?>" aria-label="Previous">
                                    <span aria-hidden="true"><i class="fa fa-arrow-right" aria-hidden="true"></i></span>
                                </a>
                            </li>
                        <?php endif; ?>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
    <div id="carousel-example-2" class="carousel slide carousel-fade" data-ride="carousel" data-interval="false">
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