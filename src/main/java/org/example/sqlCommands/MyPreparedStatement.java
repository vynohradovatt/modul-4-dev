package org.example.sqlCommands;
import org.example.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class MyPreparedStatement {

    private PreparedStatement insertStWoker;
    private PreparedStatement insertStClient;
    private PreparedStatement insertStProject;
    private PreparedStatement insertStProject_Worker;

    public  MyPreparedStatement(Database database) {

        Connection connection = database.getConnection();

        try {
            insertStWoker = connection.prepareStatement("INSERT INTO worker VALUES(?, ?, ?, ?, ?)");

            insertStClient = connection.prepareStatement("INSERT INTO client VALUES(?, ?)");

            insertStProject = connection.prepareStatement("INSERT INTO project VALUES (?, ?, ?, ?)");

            insertStProject_Worker = connection.prepareStatement("INSERT INTO project_worker VALUES(?, ?)");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertIntoTableWorker(int id, String name, LocalDate birthday, String level, int salary){

        try {
            insertStWoker.setInt(1, id);
            insertStWoker.setString(2, name);
            insertStWoker.setString(3, String.valueOf(birthday));
            insertStWoker.setString(4, level);
            insertStWoker.setInt(5, salary);

            return insertStWoker.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    public int insertIntiTableClient(int id, String name){
        try {
            insertStClient.setInt(1, id);
            insertStClient.setString(2, name);

            return insertStClient.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertIntoTableProject(int id, int client_id, LocalDate start_proj, LocalDate finish_proj){

        try {
            insertStProject.setInt(1, id);
            insertStProject.setInt(2, client_id);
            insertStProject.setString(3, String.valueOf(start_proj));
            insertStProject.setString(4, String.valueOf(finish_proj));

            return insertStProject.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public int insertIntoTableProject_Worker(int project_id, int worker_id) {

        try {
            insertStProject_Worker.setInt(1, project_id);
            insertStProject_Worker.setInt(2, worker_id);

            return insertStProject_Worker.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
