<div id="main" class="container" style="margin-top:100px; margin-bottom:100px;">
    <div class="row">

        <div class="col-9">
        <table class="table">
                <thead class="thead-dark">
                    <tr align="center">
                        <th scope="col" colspan="5"><b><font size="5">RECENSIONI</font></b></th>
                    </tr>
                    <tr>
                        <th scope="col">Nr</th>
                        <th scope="col">Descrizione</th>
                        <th scope="col">Valutazione</th>
                        <th scope="col">Utente</th>
                        <th scope="col">Data</th>
                    </tr>
                </thead>

                <tbody>

                    <?php

                        $query = "SELECT PN_RECENSIONI.DESCRIZIONE, PN_RECENSIONI.DATADICONDIVISIONE, PN_RECENSIONI.VALUTAZIONE, CONCAT(PN_UTENTI.NOME ,' ', PN_UTENTI.COGNOME)AS NOME FROM PN_RECENSIONI, PN_UTENTI WHERE PN_RECENSIONI.IDSTRUTTURA='".$_SESSION['id']."' AND PN_RECENSIONI.IDUTENTE=PN_UTENTI.ID ORDER BY PN_RECENSIONI.DATADICONDIVISIONE DESC" ;
                                                                    
                        $risp = mysqli_query($conn, $query) ;
                        if($risp)
                        {
                            $i=1;

                            while($riga = mysqli_fetch_array($risp))
                            {
                                
                    ?>

                    <tr>
                        <td><?php echo $i; ?></td>
                        <td><?php echo $riga['DESCRIZIONE']; ?></td>
                        <td>

                            <div class="c4l-rating">
                                <?php

                                    $j=0;

                                    while($j<$riga['VALUTAZIONE'])
                                    {

                                ?>

                                <input name="c4l-rating" id="c4l-rate1" />
                                <label for="c4l-rate1"></label>

                                <?php

                                        $j++;
                                    }

                                ?>
                            </div>

                        </td>
                        <td><?php echo $riga['NOME']; ?></td>
                        <td><?php echo $riga['DATADICONDIVISIONE']; ?> </td>
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