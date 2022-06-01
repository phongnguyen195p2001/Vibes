<?php
define("DB_SERVER", "localhost");
define("DB_USER", "root");
define("DB_PASS", "");
define("DB_NAME", "eproject1");

function db_connect()
{
  $connection = mysqli_connect(DB_SERVER, DB_USER, DB_PASS, DB_NAME);
  return $connection;
}
$db = db_connect();

function db_disconnect($connection)
{
  if (isset($connection)) {
    mysqli_close($connection);
  }
}

function confirm_query_result($result)
{
  global $db;
  if (!$result) {
    echo mysqli_error($db);
    db_disconnect($db);
    exit;
  } else {
    return $result;
  }
}

function insert_watchs($watch)
{
  global $db;

  $sql = "SELECT * FROM `watchs`";
  $result = mysqli_query($db, $sql);
  return confirm_query_result($result);
}

function find_all_contact()
{
  global $db;
  $sql = "SELECT * FROM `tblcontact`";
  $result = mysqli_query($db, $sql);
  return confirm_query_result($result);
}

function find_all_watchs()
{
  global $db;
  $sql = "SELECT * FROM `watchs`";
  $result = mysqli_query($db, $sql);
  return confirm_query_result($result);
}

function find_all_brand()
{
  global $db;
  $sql = "SELECT * FROM `brand`";
  $result = mysqli_query($db, $sql);
  return confirm_query_result($result);
}

function find_all_admins()
{
  global $db;
  $sql = "SELECT * FROM `admin`";
  $result = mysqli_query($db, $sql);
  return confirm_query_result($result);
}

function find_all_category()
{
  global $db;
  $sql = "SELECT * FROM `category`";
  $result = mysqli_query($db, $sql);
  return confirm_query_result($result);
}

function selectWithManufacturer($name)
{
  global $db;
  $sql = "SELECT * FROM `watchs` WHERE `idbrand` = '" . $name . "';";
  $result = mysqli_query($db, $sql);
  return confirm_query_result($result);
}

// function search_all_watchs($search){
//     global $db;
//     $search = mysqli_real_escape_string($db,$search);
//     $sql = "SELECT * FROM watchs WHERE (`namewatchs` LIKE '%".$search."%') OR (`brand` LIKE '%".$search."%')";
//     $result = mysqli_query($db,$sql);
//     return confirm_query_result($result);
// }

// function search_all_admins($search){
//     global $db;
//     $search = mysqli_real_escape_string($db,$search);
//     $sql = "SELECT * FROM `admin` WHERE (`username` LIKE '%".$search."%') OR (`name` LIKE '%".$search."%')";
//     $result = mysqli_query($db,$sql);
//     return confirm_query_result($result);
// }

function find_watch_by_id($id)
{
  global $db;

  $sql = "SELECT * FROM watchs ";
  $sql .= "WHERE idwatchs='" . $id . "'";
  $result = mysqli_query($db, $sql);
  confirm_query_result($result);
  $watch = mysqli_fetch_assoc($result);
  mysqli_free_result($result);
  return $watch;
}

function find_admin_by_id($id)
{
  global $db;

  $sql = "SELECT * FROM `admin` ";
  $sql .= "WHERE idadmin='" . $id . "'";
  $result = mysqli_query($db, $sql);
  confirm_query_result($result);
  $admin = mysqli_fetch_assoc($result);
  mysqli_free_result($result);
  return $admin;
}

function find_brand_by_id($id)
{
  global $db;

  $sql = "SELECT * FROM brand ";
  $sql .= "WHERE idbrand='" . $id . "'";
  $result = mysqli_query($db, $sql);
  confirm_query_result($result);
  $watch = mysqli_fetch_assoc($result);
  mysqli_free_result($result);
  return $watch;
}

function find_category_by_id($id)
{
  global $db;

  $sql = "SELECT * FROM category ";
  $sql .= "WHERE idcategory='" . $id . "'";
  $result = mysqli_query($db, $sql);
  confirm_query_result($result);
  $watch = mysqli_fetch_assoc($result);
  mysqli_free_result($result);
  return $watch;
}

function find_contact_by_id($id)
{
  global $db;

  $sql = "SELECT * FROM tblcontact ";
  $sql .= "WHERE idcontact='" . $id . "'";
  $result = mysqli_query($db, $sql);
  confirm_query_result($result);
  $watch = mysqli_fetch_assoc($result);
  mysqli_free_result($result);
  return $watch;
}

function delete_watch($id)
{
  global $db;

  $sql = "DELETE FROM watchs ";
  $sql .= "WHERE idwatchs='" . $id . "' ";
  $sql .= "LIMIT 1";
  $result = mysqli_query($db, $sql);
  return confirm_query_result($result);
}

function delete_contact($id)
{
  global $db;

  $sql = "DELETE FROM tblcontact ";
  $sql .= "WHERE idcontact='" . $id . "' ";
  $sql .= "LIMIT 1";
  $result = mysqli_query($db, $sql);
  return confirm_query_result($result);
}

function delete_category($id)
{
  global $db;

  $sql = "DELETE FROM `category` ";
  $sql .= "WHERE idcategory='" . $id . "' ";
  $sql .= "LIMIT 1";
  $result = mysqli_query($db, $sql);
  return confirm_query_result($result);
}

function delete_brand($id)
{
  global $db;

  $sql = "DELETE FROM `brand` ";
  $sql .= "WHERE idbrand='" . $id . "' ";
  $sql .= "LIMIT 1";
  $result = mysqli_query($db, $sql);
  return confirm_query_result($result);
}

function delete_admins($id)
{
  global $db;

  $sql = "DELETE FROM `admin` ";
  $sql .= "WHERE idadmin='" . $id . "' ";
  $sql .= "LIMIT 1";
  $result = mysqli_query($db, $sql);
  return confirm_query_result($result);
}

function update_watch($watch)
{
  global $db;
  $sql = "UPDATE `watchs` SET ";
  $sql .= "image='" . $watch['image'] . "', ";
  $sql .= "namewatchs='" . $watch['namewatchs'] . "', ";
  $sql .= "price='" . $watch['price'] . "', ";
  $sql .= "code='" . $watch['code'] . "', ";
  $sql .= "descriptions='" . $watch['descriptions'] . "', ";
  $sql .= "idbrand='" . $watch['idbrand'] . "', ";
  $sql .= "idcategory='" . $watch['idcategory'] . "' ";
  $sql .= "WHERE idwatchs='" . $watch['idwatchs'] . "' ";
  $sql .= "LIMIT 1";

  $result = mysqli_query($db, $sql);
  return confirm_query_result($result);
}

function update_admin($admin)
{
  global $db;
  $sql = "UPDATE `admin` SET ";
  $sql .= "username='" . $admin['username'] . "', ";
  $sql .= "password='" . MD5($admin['password']) . "', ";
  $sql .= "name='" . $admin['name'] . "', ";
  $sql .= "mail='" . $admin['mail'] . "' ";
  $sql .= "WHERE idadmin='" . $admin['idadmin'] . "' ";
  $sql .= "LIMIT 1";

  $result = mysqli_query($db, $sql);
  return confirm_query_result($result);
}

function update_contact($admin)
{
  global $db;
  $sql = "UPDATE `tblcontact` SET ";
  $sql .= "user_name='" . $admin['user_name'] . "', ";
  $sql .= "user_email='" . $admin['user_email'] . "', ";
  $sql .= "content='" . $admin['content'] . "' ";
  $sql .= "WHERE idcontact='" . $admin['idcontact'] . "' ";
  $sql .= "LIMIT 1";

  $result = mysqli_query($db, $sql);
  return confirm_query_result($result);
}

function update_category($category)
{
  global $db;
  $sql = "UPDATE `category` SET ";
  $sql .= "namecategory='" . $category['namecategory'] . "' ";
  $sql .= "WHERE idcategory='" . $category['idcategory'] . "' ";
  $sql .= "LIMIT 1";

  $result = mysqli_query($db, $sql);
  return confirm_query_result($result);
}

function update_brand($brand)
{
  global $db;
  $sql = "UPDATE `brand` SET ";
  $sql .= "imagebr='" . $brand['imagebr'] . "', ";
  $sql .= "namebrand='" . $brand['namebrand'] . "' ";
  $sql .= "WHERE idbrand='" . $brand['idbrand'] . "' ";
  $sql .= "LIMIT 1";

  $result = mysqli_query($db, $sql);
  return confirm_query_result($result);
}

function join_watch_brand()
{
  global $db;
  $sql = "SELECT * FROM watchs ";
  $sql .= "INNER JOIN brand ON brand.idbrand=watchs.idbrand ";
  $sql .= "INNER JOIN category ON category.idcategory=watchs.idcategory ";
  $result = mysqli_query($db, $sql);
  return confirm_query_result($result);
}

function search_product()
{
  global $db;
  if (isset($_POST["submit"])) {
    $limit = 8;
    $page = isset($_GET['page']) ? $_GET['page'] : 1;
    $start = ($page - 1) * $limit;
    $name_search = $_POST['key'];
    $sql = "SELECT * FROM watchs ";
    // $sql .= "INNER JOIN Category ON Category.CategoryId=Product.ProductType ";
    $sql .= "WHERE namewatchs LIKE" . '"%' . $name_search . '%"' . "OR price LIKE" . '"%' . $name_search . '%"' . "LIMIT $start,$limit";
    $result = mysqli_query($db, $sql);
    confirm_query_result($result);
  } else {
    $limit = 8;
    $page = isset($_GET['page']) ? $_GET['page'] : 1;
    $start = ($page - 1) * $limit;
    $sql = "SELECT * FROM watchs LIMIT $start, $limit";
    $result = mysqli_query($db, $sql);
    confirm_query_result($result);
  }
  return $result;
}

function search_watchs()
{
  global $db;
  if (isset($_POST["submit"])) {
    $limit = 16;
    $page = isset($_GET['page']) ? $_GET['page'] : 1;
    $start = ($page - 1) * $limit;
    $name_search = $_POST['key'];
    $sql = "SELECT * FROM watchs ";
    // $sql .= "INNER JOIN Category ON Category.CategoryId=Product.ProductType ";
    $sql .= "WHERE namewatchs LIKE" . '"%' . $name_search . '%"' . "OR price LIKE" . '"%' . $name_search . '%"' . "LIMIT $start,$limit";
    $result = mysqli_query($db, $sql);
    confirm_query_result($result);
  } else {
    $limit = 16;
    $page = isset($_GET['page']) ? $_GET['page'] : 1;
    $start = ($page - 1) * $limit;
    $sql = "SELECT * FROM watchs LIMIT $start, $limit";
    $result = mysqli_query($db, $sql);
    confirm_query_result($result);
  }
  return $result;
}

function find_all_facturer_type($name)
{
  global $db;
  $sql = "SELECT * FROM `watchs` WHERE `idcategory` = '" . $name . "';";
  $result = mysqli_query($db, $sql);
  return confirm_query_result($result);
}
