import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connessione {
    private Connection con; //memorizza le informazioni sulla connessione al database

    public Connessione() {
        try {
            /*carica la classe del driver JDBC per MySQL. Questo è necessario per registrare
            il driver con il DriverManager in modo che possa essere utilizzato
            per stabilire una connessione al database.
             */
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/Aereoporto";
            con = DriverManager.getConnection(url,"root",
                    "basidati23");
            System.out.println("Connessione avvenuta \n");
        } catch (Exception e) {
            System.out.println("Connessione fallita");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return con;
    }

    public void closeConnection() throws SQLException {
        try
        {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
