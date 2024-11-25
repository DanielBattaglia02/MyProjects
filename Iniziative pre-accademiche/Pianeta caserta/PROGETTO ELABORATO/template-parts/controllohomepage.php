<?php

    if(isset($_SESSION['ruolo']))
    {
        $homepage = $_SESSION['ruolo'] ;
    }
    else
    {
        $homepage = 'utente' ;
    }

    if(isset($_GET["page"]))
    {
        $page = $_GET["page"] ;
    }
    else
    {
        $page = $homepage ;
    }

?>