<?php

    session_start() ;

    require_once( "../database-parts/connessione.php" ) ;

    if(isset($_POST['chat']))
	{
		$id=$_SESSION['id'];
				
		$messaggio=$_POST['messaggio'];	
			
		$query = "INSERT INTO PN_MESSAGGI(MITTENTE, DESCRIZIONE) VALUES('".$id."','".$messaggio."')" ;		//query per l'inserimento del nuovo messaggio
			
		$risp = mysqli_query($conn, $query) ;	//la query viene inviata al database e quest'ultimo risponderá
		if($risp) 
		{					
			header("location:../homepage/index.php?page=chatglobale");	//viene raggiunta la pagina presente nel percorso inserito
		}
		else
		{
			echo('Errore : '.mysqli_error($conn));
			exit;
		}
	}

	if(isset($_POST['recensione']))
	{
		$id=$_SESSION['id'];		
		$messaggio=$_POST['messaggio'];	
		$struttura=$_POST['struttura'];	
		$valutazione=$_POST['c4l-rating'];	

		//echo $id . $messaggio . $struttura . $valutazione;
		
		$query = "INSERT INTO PN_RECENSIONI(DESCRIZIONE, VALUTAZIONE, IDUTENTE, IDSTRUTTURA) VALUES('".$messaggio."','".$valutazione."','".$id."','".$struttura."')" ;		//query per l'inserimento del nuovo messaggio
			
		$risp = mysqli_query($conn, $query) ;	//la query viene inviata al database e quest'ultimo risponderá
		if($risp) 
		{					
			header("location:../homepage/index.php?");	//viene raggiunta la pagina presente nel percorso inserito
		}
		else
		{
			echo('Errore : '.mysqli_error($conn));
			exit;
		}
		
	}

    mysqli_close($conn);	//fine connessione

?>