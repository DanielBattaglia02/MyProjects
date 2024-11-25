<?php

    session_start() ;

    require_once( "../database-parts/connessione.php" ) ;

	$idstruttura=$_SESSION['id'];			
	$descrizione=$_POST['descrizione'];	
    $titolo=$_POST['titolo'];	
    $datainizio=$_POST['datainizio'];			
	$datafine=$_POST['datafine'];	
    $orarioinizio=$_POST['orarioinizio'];			
	$orariofine=$_POST['orariofine'];	

	$_SESSION['idstruttura']=$idstruttura;
	$_SESSION['descrizione']=$descrizione;
	$_SESSION['titolo']=$titolo;
	$_SESSION['datainizio']=$datainizio;
	$_SESSION['datafine']=$datafine;
	$_SESSION['orarioinizio']=$orarioinizio;
	$_SESSION['orariofine']=$orariofine;

	include '../login-registrazione/mail.php?stampa=2';	    //invio email
			
	$query = "INSERT INTO PN_EVENTI(TITOLO, DESCRIZIONE, DATAINIZIO, DATAFINE, ORARIOINIZIO, ORARIOFINE, IDSTRUTTURA) VALUES('".$titolo."','".$descrizione."','".$datainizio."','".$datafine."','".$orarioinizio."','".$orariofine."','".$idstruttura."')" ;		
			
	$risp = mysqli_query($conn, $query) ;	//la query viene inviata al database e quest'ultimo risponderá
	if($risp) 
	{					
		header("location:../homepage/index.php?stampa=1");	//viene raggiunta la pagina presente nel percorso inserito
	}
	else
	{
		echo('Errore : '.mysqli_error($conn));
		exit;
	}

    mysqli_close($conn);	//fine connessione

?>