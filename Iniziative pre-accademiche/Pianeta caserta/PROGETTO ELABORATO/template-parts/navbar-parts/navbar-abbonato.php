<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container">
            <a class="navbar-brand" href="../homepage/index.php?page=abbonato">HOME</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarColor01" >
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                <a class="nav-link active" href="../homepage/index.php?page=chi-siamo">Chi siamo
                    <span class="visually-hidden">(current)</span>
                </a>
                </li>
                <li class="nav-item">
                <a class="nav-link" href="../homepage/index.php?page=help">Help</a>
                </li>
                <li class="nav-item">
                <a class="nav-link" href="#">Nuove Prenotazioni</a>
                </li>
                <li class="nav-item">
                <a class="nav-link" href="../homepage/index.php?page=chatglobale">Chat Globale</a>
                </li>
            </ul>

            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown ml-auto">
                <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"><?php echo $_SESSION['ruolo'] . ' : '.$_SESSION['nick']; ?></a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Mie prenotazioni</a>
                    <a class="dropdown-item" href="#">My account</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="../login-registrazione/logout.php">Logout</a>
                </div>
                </li>
            </ul> 
            </div>

        </div>
        </nav>