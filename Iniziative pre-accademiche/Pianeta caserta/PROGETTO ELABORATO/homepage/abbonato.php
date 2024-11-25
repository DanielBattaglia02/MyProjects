<div id="main" class="container" style="margin-top:100px; margin-bottom:100px;">
    <div class="row">

        <div class="col-9">

            <div id="contenuto">
                <div class="row">

                    <?php 

                        $i = 1 ;
                        $b = 0 ;

                        while($b==0)
                        {
                            $query = 'SELECT PN_STRUTTURE_LAVORATIVE.ID, PN_STRUTTURE_LAVORATIVE.NOME, PN_CATEGORIE.TIPO FROM PN_STRUTTURE_LAVORATIVE, PN_CATEGORIE WHERE PN_STRUTTURE_LAVORATIVE.ID='.$i.' AND PN_STRUTTURE_LAVORATIVE.IDCATEGORIA=PN_CATEGORIE.ID' ;
                            
                            $risp = mysqli_query($conn, $query) ;
                            if($risp)
                            {
                                if(mysqli_num_rows($risp) > 0)     //questa funzione verifica se la query di risposta dal database contiene almeno una riga
                                {
                                    $riga = mysqli_fetch_array($risp) ;
                        
                                    $query2 = 'SELECT PN_CONTATTI.DESCRIZIONE, PN_CONTATTI.IDLABEL, PN_LABELS.NOME FROM PN_CONTATTI, PN_LABELS WHERE PN_CONTATTI.IDSTRUTTURA='.$i.' AND PN_CONTATTI.IDLABEL=PN_LABELS.ID ORDER BY PN_CONTATTI.IDLABEL ASC' ;
                                
                                    $risp2 = mysqli_query($conn, $query2) ;
                                    if($risp2)
                                    {
                                        
                    ?>
                    
                    <hr size="5" style="margin-bottom:50px;">
                    <p class="lead" style="margin-bottom:10px;">
                        
                        <?php  echo '<b>' .$i. ') NOME STRUTTURA</b>: ' . $riga['NOME'] ; ?> &emsp; &emsp; &emsp; &emsp; &emsp; <?php echo '<b>CATEGORIA</b>: ' . $riga['TIPO'];  ?>
                        
                    </p>

                    <a href="../homepage/index.php?page=visualizzaeventi&struttura=<?php echo $riga['ID']; ?>" class="btn btn-primary">Eventi Disponibili</a>

                    <div class="col-5" style="margin-top:50px;">

                        <?php
                                            
                                        while($riga2 = mysqli_fetch_array($risp2))
                                        {

                        ?>
                                
                                <p class="lead"><?php if($riga2['NOME'] == 'POSIZIONE'){ ?><iframe src="<?php echo $riga2['DESCRIZIONE'];?>" width="400px" height="200px" style="border:0;" allowfullscreen="" loading="lazy"></iframe><?php } ?></p>
                                <p class="lead"><?php if($riga2['NOME'] == 'INDIRIZZO'){ ?> <b>INDIRIZZO</b>: <?php echo $riga2['DESCRIZIONE'] ; } ?> </p>
                                <p class="lead"><?php if($riga2['NOME'] == 'EMAILUFFICIO'){ ?> <b>EMAIL</b>: <?php echo $riga2['DESCRIZIONE'] ; } ?> </p>
                                <p class="lead"><?php if($riga2['NOME'] == 'TELEFONO'){ ?> <b>TELEFONO</b>: <?php echo $riga2['DESCRIZIONE'] ; } ?>  </p>

                        <?php

                                            }
        
                        ?>
            
                    </div>
                    <div class="col-7" style="margin-top:10px;">
                                        
                        <h4 class="card-title" align="center">Recensioni</h4>

                        <?php include '../pages/recensioni.php'; ?>

                    </div>                         

                    <?php

                                    }
                                    else
                                    {
                                        echo 'ERRORE QUERY2 : ' . mysqli_error($conn) ;
                                    }
                                }
                                else
                                {
                                    $b = 1 ;    //assegnando questo flag, il ciclo esterno si interromperà poichè non sono più presenti tuple in PN_STRUTTURE_LAVORATIVE
                                }
                            }
                            else
                            {
                                echo 'ERRORE QUERY1 : ' . mysqli_error($conn) ;
                            }

                            $i++;
                        }        

                    ?>

                    <hr size="5" style="margin-top:50px;">

                </div>
            </div>

        </div>