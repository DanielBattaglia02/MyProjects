<main class="form-signin">
  <form action="confermalogreg.php" method="post">
    <input type="hidden" name="MODE" value="log"></input>
    <h1 class="h3 mb-3 fw-normal">Login</h1>

    <div class="form-floating">
      <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com" required="">
      <label for="email">Email</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="pass" name="pass" placeholder="!weatp45" required="">
      <label for="pass">Password</label>
    </div>
    <div class="form-floating">
      <input type="radio" id="abbonato" name="utente" value="abbonato" checked>Abbonato</input>
      <input type="radio" id="azienda" name="utente" value="azienda">Azienda</input>
      <input type="radio" id="admin" name="utente" value="admin">Admin</input>
    </div>

    <button class="w-100 btn btn-lg btn-primary" type="submit">Submit</button>
  </form>
</main>