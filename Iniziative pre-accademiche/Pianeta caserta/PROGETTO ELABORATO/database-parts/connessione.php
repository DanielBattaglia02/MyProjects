<?php

    $db_host = "localhost";
    $db_user = "root";  //indica l'utente amministratore, colui che ha più permessitra tutti gli altri utenti
    $db_pass = "";
    $db_name = "PIANETA_CASERTA";

            /*connessione al DB*/
    $conn = mysqli_connect($db_host, $db_user, $db_pass) ;
        
    if(!$conn)
    {
        echo 'ERRORE1 : ' . mysqli_error($conn) ;
        exit ; 
    }

            /*selezione del DB*/
    $db = mysqli_select_db($conn, $db_name) ;

    if(!$db)
    {
        echo 'ERRORE2 : ' . mysqli_error($conn) ;
        exit ; 
    }

?>
