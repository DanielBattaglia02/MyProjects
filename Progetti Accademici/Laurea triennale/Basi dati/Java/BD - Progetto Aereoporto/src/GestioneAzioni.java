import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class GestioneAzioni
{
    public static void visualizzaAerei(DefaultTableModel modelloTabella, Connection c)
    {
        try
        {
            Statement query = c.createStatement();
            ResultSet result = query.executeQuery("SELECT * FROM Aereo a JOIN Documentazione d where a.ID_Documentazione=d.ID");

                //svuota la tabella
            modelloTabella.setRowCount(0);

            while(result.next())
            {
                int ID = result.getInt("a.ID");
                int ID_CompagniaAerea = result.getInt("a.ID_CompagniaAerea");
                String n = result.getString("a.nome");
                String s = result.getString("a.stato");
                String note1 = result.getString("a.note");
                int ID_Documentazione = result.getInt("a.ID_Documentazione");
                Double al= result.getDouble("d.altezza");
                Double la = result.getDouble("d.larghezza");
                Double lu = result.getDouble("d.lunghezza");
                Double p = result.getDouble("d.peso");
                Double cm = result.getDouble("d.carico_Max");
                int np = result.getInt("d.num_Passeggeri");
                int ne = result.getInt("d.num_Equipaggio");
                int nm = result.getInt("d.num_Motori");
                String dt = result.getString("d.data_Costruzione");
                String lg = result.getString("d.luogo_Costruzione");
                String note2 = result.getString("d.note");

                if(note1 == null)
                {
                    note1 = "null";
                }

                if(note2 == null)
                {
                    note2 = "null";
                }

                modelloTabella.addRow(new Object[]{ID, ID_CompagniaAerea, n, s, note1, ID_Documentazione, al, la, lu, p, cm, np, ne, nm, dt, lg, note2});
                System.out.println( ID + " | " + ID_CompagniaAerea + " | " + n + " | " + s + " | " + note1 + " | " + ID_Documentazione + " | " + al + " | " + la + " | " + lu + " | " + p + " | " + cm + " | " + np + " | " + ne + " | " + nm + " | " + dt + " | " + lg + " | " + note2 + ";");
            }

            System.out.println("Visualizzazione avvenuta con successo");
        }
        catch(Exception exception)
        {
            System.out.println("Errore nella Visualizzazione");
            exception.printStackTrace();  // Stampa la traccia dello stack dell'eccezione
        }
    }


    public static void popolareComboBox(JComboBox<CompagniaAerea> comboBox, Connection c)
    {
        try
        {
            Statement query = c.createStatement();
            ResultSet result = query.executeQuery("SELECT ID, Nome FROM CompagniaAerea ORDER BY ID");

            while(result.next())
            {
                int id = result.getInt("ID");
                String nomeCompagnia = result.getString("Nome");
                comboBox.addItem(new CompagniaAerea(id, nomeCompagnia));
                System.out.println(id + " - " + nomeCompagnia + ";");
            }

            System.out.println("Compagnie aeree visualizzate correttamente nella comboBox");
        }
        catch(Exception exception)
        {
            System.out.println("Errore nella Visualizzazione delle compagnie aeree");
            exception.printStackTrace();  // Stampa la traccia dello stack dell'eccezione
        }
    }

    public static void InserisciAereo(String n, int ca, String s, String note1, double al, double lu, double la, double p, double cm, int np, int ne, int nm, String dt, String lg, String note2, Connection c)
    {
        try
        {
            Statement maxIdStatement = c.createStatement();
            ResultSet maxIdResult = maxIdStatement.executeQuery("SELECT MAX(ID) FROM Documentazione");
            int lastInsertedId = 0;

            if (maxIdResult.next())
            {
                lastInsertedId = maxIdResult.getInt(1);
                lastInsertedId++;
            }

            String insertQuery = "INSERT INTO Documentazione (ID, altezza, lunghezza, larghezza, peso, carico_Max, num_Passeggeri, num_Equipaggio, num_Motori, data_Costruzione, luogo_Costruzione, Note) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Preparazione della dichiarazione SQL
            PreparedStatement insertStatement = c.prepareStatement(insertQuery);

            // Impostazione dei parametri nella dichiarazione preparata
            insertStatement.setDouble(1, lastInsertedId);
            insertStatement.setDouble(2, al);
            insertStatement.setDouble(3, la);
            insertStatement.setDouble(4, lu);
            insertStatement.setDouble(5, p);
            insertStatement.setDouble(6, cm);
            insertStatement.setInt(7, np);
            insertStatement.setInt(8, ne);
            insertStatement.setInt(9, nm);
            insertStatement.setString(10, dt);
            insertStatement.setString(11, lg);
            insertStatement.setString(12, note2);

                // Esecuzione della query di inserimento
            int rowCount = insertStatement.executeUpdate();

            Statement maxIdStatement2 = c.createStatement();
            ResultSet maxIdResult2 = maxIdStatement2.executeQuery("SELECT MAX(ID) FROM Aereo");
            int lastInsertedId2 = 0;

            if (maxIdResult2.next())
            {
                lastInsertedId2 = maxIdResult2.getInt(1);
                lastInsertedId2++;
            }

            String insertQuery2 = "INSERT INTO Aereo (ID ,ID_CompagniaAerea, ID_Documentazione, nome, stato, note) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement insertStatement2 = c.prepareStatement(insertQuery2);

            insertStatement2.setInt(1, lastInsertedId2);
            insertStatement2.setInt(2, ca);
            insertStatement2.setInt(3, lastInsertedId);
            insertStatement2.setString(4, n);
            insertStatement2.setString(5, s);
            insertStatement2.setString(6, note1);

            int rowCount2 = insertStatement2.executeUpdate();

            System.out.println(rowCount + " riga/i inserita/e con successo.");

        }
        catch (SQLIntegrityConstraintViolationException integrityException)
        {
                // Gestione delle eccezioni di violazione del vincolo di integrità
            System.err.println("Violazione del vincolo di integrità: " + integrityException.getMessage());
            System.out.println("Errore nell'inserimento di un Aereo: ");

            try
            {
                Statement maxIdStatement = c.createStatement();
                ResultSet maxIdResult = maxIdStatement.executeQuery("SELECT MAX(ID) FROM Documentazione");
                int lastInsertedId = 0;

                if (maxIdResult.next()) {
                    lastInsertedId = maxIdResult.getInt(1);
                }

                String deleteQuery = "DELETE FROM Documentazione WHERE ID=?";
                PreparedStatement deleteStatement = c.prepareStatement(deleteQuery);

                deleteStatement.setInt(1, lastInsertedId);
                int rowCount = deleteStatement.executeUpdate();

                System.out.println("Eliminazione della documentazione precedentemente inserita avvenuta con successo");
            }
            catch (SQLException exception)
            {
                System.out.println("Errore nell'eliminazione della documentazione dell'aereo che non è stato inserito: " + exception.getMessage());
                exception.printStackTrace();
            }
        }
        catch (SQLException exception)
        {
            System.out.println("Errore nell'inserimento della documentazione: " + exception.getMessage());
            exception.printStackTrace();
        }
    }

    public static void modificaAereo( int id, String n, int ca, String s, String note1, String al, String lu, String la, String p, String cm, String np, String ne, String nm, String dt, String lg, String note2, Connection c) {
        try
        {
            String query = "SELECT ID_Documentazione FROM Aereo where ID=?";

            PreparedStatement Statement = c.prepareStatement(query);
            Statement.setInt(1, id);
            ResultSet result = Statement.executeQuery();
            int idDoc = 0;

            if (result.next()) {
                idDoc = result.getInt(1);
            }

                // Creazione della query di aggiornamento
            StringBuilder updateQuery = new StringBuilder("UPDATE Aereo SET ID_CompagniaAerea=?, stato=?, note=?, ");
            java.util.List<Object> parameters = new ArrayList<>();

            parameters.add(ca);
            parameters.add(s);
            parameters.add(note1);

            if (n != null) {
                updateQuery.append("nome=?, ");
                parameters.add(n);
            }

            updateQuery.delete(updateQuery.length() - 2, updateQuery.length()); // Rimuovi l'ultima virgola e lo spazio
            updateQuery.append(" WHERE ID=?");
            parameters.add(id);

                /* Esegui l'aggiornamento solo se ci sono valori da aggiornare*/
            if(!parameters.isEmpty())
            {
                try
                {
                        // Creazione di un oggetto PreparedStatement per la query di aggiornamento
                    PreparedStatement updateStatement = c.prepareStatement(updateQuery.toString());

                        // Impostazione dei valori dei parametri
                    for (int i = 0; i < parameters.size(); i++)
                    {
                        updateStatement.setObject(i + 1, parameters.get(i));
                    }

                        // Esecuzione dell'operazione di aggiornamento
                    int rowCount = updateStatement.executeUpdate();

                        // Stampa del numero di righe aggiornate
                    System.out.println("Numero di righe aggiornate in aereo: " + rowCount);
                }
                catch (SQLException e)
                {
                    System.out.println("Errore nella modifica dati in aereo");
                    e.printStackTrace();
                }
            }

                // Creazione della query di aggiornamento in documentazione
            StringBuilder updateQuery2 = new StringBuilder("UPDATE Documentazione SET note=?, ");
            List<Object> parameters2 = new ArrayList<>();

            parameters2.add(note2);

            if (al != null) {
                updateQuery2.append("altezza=?, ");
                parameters2.add(Double.parseDouble(al));
            }

            if (lu != null) {
                updateQuery2.append("lunghezza=?, ");
                parameters2.add(Double.parseDouble(lu));
            }

            if (la != null) {
                updateQuery2.append("larghezza=?, ");
                parameters2.add(Double.parseDouble(la));
            }

            if (p != null) {
                updateQuery2.append("peso=?, ");
                parameters2.add(Double.parseDouble(p));
            }

            if (cm != null) {
                updateQuery2.append("carico_Max=?, ");
                parameters2.add(Double.parseDouble(cm));
            }

            if (np != null) {
                updateQuery2.append("num_Passeggeri=?, ");
                parameters2.add(Integer.parseInt(np));
            }

            if (ne != null) {
                updateQuery2.append("num_Equipaggio=?, ");
                parameters2.add(Integer.parseInt(ne));
            }

            if (nm != null) {
                updateQuery2.append("num_Motori=?, ");
                parameters2.add(Integer.parseInt(nm));
            }

            if (dt != null) {
                updateQuery.append("data_Costruzione=?, ");
                parameters.add(dt);
            }

            if (lg != null) {
                updateQuery.append("luogo_Costruzione=?, ");
                parameters.add(lg);
            }

            updateQuery2.delete(updateQuery2.length() - 2, updateQuery2.length()); // Rimuovi l'ultima virgola e lo spazio
            updateQuery2.append(" WHERE ID=?");
            parameters2.add(idDoc);

                /* Esegui l'aggiornamento solo se ci sono valori da aggiornare*/
            if (!parameters2.isEmpty())
            {
                try
                {
                        // Creazione di un oggetto PreparedStatement per la query di aggiornamento
                    PreparedStatement updateStatement2 = c.prepareStatement(updateQuery2.toString());

                        // Impostazione dei valori dei parametri
                    for (int i = 0; i < parameters2.size(); i++)
                    {
                        updateStatement2.setObject(i + 1, parameters2.get(i));
                    }

                        // Esecuzione dell'operazione di aggiornamento
                    int rowCount2 = updateStatement2.executeUpdate();

                        // Stampa del numero di righe aggiornate
                    System.out.println("Numero di righe aggiornate in documentazione: " + rowCount2);
                }
                catch (SQLException e)
                {
                    System.out.println("Errore nella modifica dati in documentazione");
                    e.printStackTrace();
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println("Errore nella selezione dell'id_documentazione in aereo");
            e.printStackTrace();
        }
    }

    public static void eliminaAereo(int id, Connection c)
    {
        try
        {
            String deleteQuery = "delete from aereo, documentazione using aereo join Documentazione on aereo.ID_Documentazione=Documentazione.id where aereo.ID=?";
            PreparedStatement deleteStatement = c.prepareStatement(deleteQuery);

            deleteStatement.setInt(1, id);
            int rowCount = deleteStatement.executeUpdate();
            System.out.println(rowCount + "Aereo eliminato con successo");
        }
        catch (SQLException exception)
        {
            System.out.println("Errore durante l'esecuzione della query di eliminazione: " + exception.getMessage());
            exception.printStackTrace();
        }
    }
}