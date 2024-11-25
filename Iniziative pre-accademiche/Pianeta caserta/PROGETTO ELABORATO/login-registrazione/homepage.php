<?php 
    
    include '../template-parts/header.php';

    include '../template-parts/navbar-parts/navbar-utente.php';

?>

        <div id="main" class="container" style="margin-top:100px; margin-bottom:100px;">
            <div class="row">

                <?php
                        /*stampa di eventuali errori*/
                    if(isset($_GET['er']))
                    {
                        if($_GET['er']==1)
                        {
                ?>

                <script>

                    alert ("ERRORE : Errore nell'inserimento della password!");

                </script>

                <?php

                        }

                        if($_GET['er']==3)
                        {
                ?>

                <script>

                    alert ("ERRORE : Errore nel login!");

                </script>

                <?php

                        }
                    }
      
                ?>
                
                <div class="col-4" style="margin-right:25%;">

                    <?php include 'login.php'; ?>    

                </div>

                <div class="col-4">

                    <?php include 'sign-in.php'; ?>

                </div>

            </div>
        </div>

<?php include '../template-parts/footer.php'; ?>