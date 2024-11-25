<div id="main" class="container" style="margin-top:100px; margin-bottom:100px;">
    <div class="row">

        <div class="col-9">
        <table class="table">
                <thead class="thead-dark">
                    <tr align="center">
                        <th scope="col" colspan="9"><b><font size="5">Miei Eventi</font></b></th>
                    </tr>
                    <tr>
                        <th scope="col">Nr</th>
                        <th scope="col">Titolo</th>
                        <th scope="col">Descrizione</th>
                        <th scope="col">Data Inizio</th>
                        <th scope="col">Data fine</th>
                        <th scope="col">Orario Inizio</th>
                        <th scope="col">Orario Fine</th>
                        <th scope="col" colspan="2">Azioni</th>
                    </tr>
                </thead>

                <tbody>

                    <?php

                        if(isset($_GET['struttura']))  
                        {
                            $query = "SELECT ID, TITOLO, DESCRIZIONE, DATAINIZIO, DATAFINE, ORARIOINIZIO, ORARIOFINE FROM PN_EVENTI WHERE PN_EVENTI.IDSTRUTTURA='".$_SESSION['i']."' ORDER BY PN_EVENTI.DATAFINE DESC" ;
                            unset($_SESSION['i']) ;
                        }
                        else
                        {
                            $query = "SELECT ID, TITOLO, DESCRIZIONE, DATAINIZIO, DATAFINE, ORARIOINIZIO, ORARIOFINE FROM PN_EVENTI WHERE PN_EVENTI.IDSTRUTTURA='".$_SESSION['id']."' ORDER BY PN_EVENTI.DATAFINE DESC" ;
                        }
                                                                  
                        $risp = mysqli_query($conn, $query) ;
                        if($risp)
                        {
                            $i=1;

                            while($riga = mysqli_fetch_array($risp))
                            {
                                
                    ?>

                    <tr>
                        <td><?php echo $i; ?></td>
                        <td><?php echo $riga['TITOLO']; ?></td>
                        <td><?php echo $riga['DESCRIZIONE']; ?></td>
                        <td><?php echo $riga['DATAINIZIO']; ?> </td>
                        <td><?php echo $riga['DATAFINE']; ?> </td>
                        <td><?php echo $riga['ORARIOINIZIO']; ?> </td>
                        <td><?php echo $riga['ORARIOFINE']; ?> </td>
                        <td>
                            <form action="#" method="post">
                                <button type="submit">MODIFICA</button>
                            </form>
                        </td>
                        <td>
                            <form action="#" method="post">
                                <button type="submit">CANCELLA</button>
                            </form>
                        </td>
                    </tr>

                    <?php 
             
                            }
                        }
                        else
                        {

                            echo('Errore : '.mysqli_error($conn));
                            exit;
                        }
                                                        
                    ?>

                </tbody>
            </table>
        </div>