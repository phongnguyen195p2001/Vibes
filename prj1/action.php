<?php
require_once("admin/connect.php");
$conn = new mysqli("localhost", "root", "", "eproject1");
if ($conn->connect_error) {
    die("Failed to connect!" . $conn->connect_error);
}
if (isset($_GET['query'])) {
    $inpText = $_GET['query'];
    $query = "SELECT image, namewatchs FROM watchs WHERE namewatchs LIKE '%$inpText%'";
    $result = $conn->query($query);  
        if ($result->num_rows > 0) {
            while ($row = $result->fetch_assoc()) {
                $data= '<img src="admin/img/' . $row['image'] . '" width="50" height="50"/>';
                echo "<a href='#' class='list-group-item list-group-item-action border-1'>". $data . $row['namewatchs'] . "</a>";
            }
        } else {
           
        }
}
