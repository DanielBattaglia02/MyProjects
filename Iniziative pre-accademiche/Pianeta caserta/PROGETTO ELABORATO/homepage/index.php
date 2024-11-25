<?php 

    session_start() ;

    require_once("../database-parts/connessione.php");

    include '../template-parts/controllohomepage.php';

    include '../template-parts/header.php';

    include '../template-parts/navbar-parts/navbar-' . $homepage . '.php';     //il punto serve a concatenare le stringhe

    if($homepage!=$page)
    {
        if(isset($_GET['struttura']))   //questo parametro identifica la chiamata alla pagina contenente gli eventi della struttura, il cui id é quello che preleviamo dall'id
        {
            $_SESSION['i']=$_GET['struttura'];
            include '../pages/' . $page . '.php';
        }
        else
        {
            include '../pages/' . $page . '.php';
        }
    }
    else
    {
        include $page . '.php';
    }
                
    include '../template-parts/sidebar-parts/sidebar-' . $homepage . '.php';

    include '../template-parts/footer.php'; 

    mysqli_close($conn);

?>

