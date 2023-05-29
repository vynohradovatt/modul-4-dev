package org.example.sqlCommands;

import org.example.Database;
import prefs.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabasePopulateService {

    public static void main(String[] args) {
        Database database = Database.getInstance();

        try {

            String insertDb = new Prefs().getString(Prefs.INSERT_DB_SQL_FILE_PATH);
            String sql = String.join(
                    "\n", Files.readAllLines(Paths.get(insertDb)));

            database.executeUpdate(sql);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        database.close();
    }
}
