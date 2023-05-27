package prefs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Prefs {

    public static final String DB_JDBC_CONNECTION_URL = "urlDB";
    public static final String INIT_DB_SQL_FILE_PATH = "initDB";

    public static final String INSERT_DB_SQL_FILE_PATH = "insertDB";

    public static final String LONGEST_PROJECT_SQL_FILE_PATH = "longestProjectDB";

    public static final String MAX_SALARY_SQL_FILE_PATH = "maxSalaryDB";

    public static final String MAX_PROJECT_CLIENT_SQL_FILE_PATH = "maxProjectsClientDB";

    public static final String YOUNGEST_ELDEST_WORKER_SQL_FILE_PATH = "YoungestEldestWorkerDB";

    public static final String PROJECT_PRICES_SQL_FILE_PATH = "projectPricesDB";

    private Map<String, Object> prefs = new HashMap<>();
    public static final String DEFAULT_PREFS_FILENAME = "prefs.json";

    public Prefs(){
        this(DEFAULT_PREFS_FILENAME);
    }

    public Prefs(String fileName){
        try {
            String json = String.join("\n", Files.readAllLines(Paths.get(fileName)));

            prefs = new Gson().fromJson(json, new TypeToken<Map<String, Object>>(){}.getType());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//    public Object getPref(String key){
//        return prefs.get(key);
//    }
    public String getString(String key){
        return  prefs.get(key).toString();
    }
}
