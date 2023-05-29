package org.example.sqlCommands;
import org.example.Database;
import prefs.Prefs;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabaseInitService {

    public static void main(String[] args) {

        Database database = Database.getInstance();

        try {

            String initDb = new Prefs().getString(Prefs.INIT_DB_SQL_FILE_PATH);
            String sql = String.join(
                    "\n", Files.readAllLines(Paths.get(initDb)));

            database.executeUpdate(sql);

            } catch (IOException e) {
                throw new RuntimeException(e);
        }

        database.close();
    }
}
