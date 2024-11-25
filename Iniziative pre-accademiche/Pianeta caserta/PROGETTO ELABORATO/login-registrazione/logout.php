<?php

	session_start() ;
			
				/*le variabili di sessione vengono disattivate*/
	unset($_SESSION['id']) ;		
	unset($_SESSION['nick']) ;		
	unset($_SESSION['email']) ;		
	unset($_SESSION['ruolo']) ;		
		
	session_destroy() ;			//la sessione viene distrutta

	if(isset($_GET['er']))
	{
		header("location:../homepage/index.php?er=0");
	}
	else
	{
		header("location:../homepage/index.php");
	}
	
?>