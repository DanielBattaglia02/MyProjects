<main class="form-signin">
<form action="confermalogreg.php" method="post">
    <input type="hidden" name="MODE" value="reg"></input>
    <h1 class="h3 mb-3 fw-normal">Registrazione</h1>

    <div class="form-floating">
      <input type="text" class="form-control" id="nome" name="nome" placeholder="Antonio" required="">
      <label for="nome">Nome</label>
    </div>
    <div class="form-floating">
      <input type="text" class="form-control" id="cognome" name="cognome" placeholder="Silvestri" required="">
      <label for="cognome">Cognome</label>
    </div>
    <div class="form-floating">
      <input type="radio" id="uomo" name="sesso" value="UOMO" checked>Uomo</input>
      <input type="radio" id="donna" name="sesso" value="DONNA">Donna</input>
      <input type="radio" id="altro" name="sesso" value="ALTRO">Altro</input>
    </div>
    <div class="form-floating">
      <input type="date" class="form-control" id="data" name="data" placeholder="03/07/2002" required="">
      <label for="data">Data di Nascita</label>
    </div>
    <div class="form-floating">
      <input type="text" class="form-control" id="ln" name="ln" placeholder="Napoli" required="">
      <label for="ln">Luogo di Nascita</label>
    </div>
    <div class="form-floating">
      <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com" required="">
      <label for="email">Email</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="pass1" name="pass1" placeholder="!weatp45" required="">
      <label for="pass1">Password  <font size="2"><i>(min6-max10)</i></font></label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="pass2" name="pass2" placeholder="ciao!!" required="">
      <label for="pass2">Conferma Password</label>
    </div>

    <button class="w-100 btn btn-lg btn-primary" type="submit">Submit</button>
  </form>
</main>