<?php
// db.php - connessione procedurale a D-Line

$host = 'localhost';
$user = 'avid3969665';
$pass = '';
$dbName = 'my_avid3969665';

// Connessione procedurale
$conn = mysqli_connect($host, $user, $pass, $dbName);

if (!$conn) {
    die("Connessione fallita: " . mysqli_connect_error());
}
?>