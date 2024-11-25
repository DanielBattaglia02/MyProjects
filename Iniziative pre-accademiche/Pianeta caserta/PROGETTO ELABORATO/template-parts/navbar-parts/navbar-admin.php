<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container">
            <a class="navbar-brand" href="../homepage/index.php">DASHBOARD</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>

            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown ml-auto">
                <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"><?php echo $_SESSION['ruolo'] . ' : '.$_SESSION['nick']; ?></a>
                <div class="dropdown-menu">
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="../login-registrazione/logout.php">Logout</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="../database-parts/installazioneDB.php">Reset Database</a>
                </div>
                </li>
            </ul> 
            </div>

        </div>
        </nav>