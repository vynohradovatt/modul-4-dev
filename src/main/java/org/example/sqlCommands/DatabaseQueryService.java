package org.example.sqlCommands;
import org.example.Database;
import org.example.dto.*;
import prefs.Prefs;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

   private static Database database = Database.getInstance();

    static {
        try {
            database.getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        database.close();
    }

    public List<MaxSalary> findMaxSalary(){

        List<MaxSalary> listOfMaxSalary = new ArrayList<>();

        try {

            String longestProj = new Prefs().getString(Prefs.MAX_SALARY_SQL_FILE_PATH);
            String sql = String.join(
                    "\n", Files.readAllLines(Paths.get(longestProj)));

            ResultSet resultSet = database.executeQuery(sql);
            while (resultSet.next()){
                String name = resultSet.getString("name");
                int salary = resultSet.getInt("salary_for_a_month");
                MaxSalary maxSalary = new MaxSalary(name, salary);
                listOfMaxSalary.add(maxSalary);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        database.close();

        return listOfMaxSalary;
    }

    public List<LongestProject> findLongestProject(){

        List<LongestProject> longestProjectList = new ArrayList<>();

        try {

            String longestProj = new Prefs().getString(Prefs.LONGEST_PROJECT_SQL_FILE_PATH);
            String sql = String.join(
                    "\n", Files.readAllLines(Paths.get(longestProj)));

            ResultSet resultSet = database.executeQuery(sql);
            while (resultSet.next()){
                String name = resultSet.getString("name");
                int month = resultSet.getInt("month_count");

                LongestProject longestProject = new LongestProject(name, month);
                longestProjectList.add(longestProject);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        database.close();
        return longestProjectList;
    }
    public List<MaxProjectClient> findMaxProjectClient(){

        List<MaxProjectClient> maxProjectClients = new ArrayList<>();

        try {

            String longestProj = new Prefs().getString(Prefs.MAX_PROJECT_CLIENT_SQL_FILE_PATH);
            String sql = String.join(
                    "\n", Files.readAllLines(Paths.get(longestProj)));

            ResultSet resultSet = database.executeQuery(sql);
            while (resultSet.next()){
                String name = resultSet.getString("name");
                int project_count = resultSet.getInt("project_count");

                MaxProjectClient maxProjectClient = new MaxProjectClient(name, project_count);
                maxProjectClients.add(maxProjectClient);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        database.close();
        return maxProjectClients;
    }

    public List<YoungestEldestWorker> findYoungestEldestWorker(){

        List<YoungestEldestWorker> youngestEldestWorkers = new ArrayList<>();

        try {

            String longestProj = new Prefs().getString(Prefs.YOUNGEST_ELDEST_WORKER_SQL_FILE_PATH);
            String sql = String.join(
                    "\n", Files.readAllLines(Paths.get(longestProj)));

            ResultSet resultSet = database.executeQuery(sql);
            while (resultSet.next()){
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                LocalDate birthday = LocalDate.parse(resultSet.getString("birthday"));

                YoungestEldestWorker youngestEldestWorker = new YoungestEldestWorker(type,name, birthday);
                youngestEldestWorkers.add(youngestEldestWorker);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        database.close();
        return youngestEldestWorkers;
    }

    public List<ProjectPrices> findProjectPrices(){

        List<ProjectPrices> projectPricesList = new ArrayList<>();

        try {

            String longestProj = new Prefs().getString(Prefs.PROJECT_PRICES_SQL_FILE_PATH);
            String sql = String.join(
                    "\n", Files.readAllLines(Paths.get(longestProj)));

            ResultSet resultSet = database.executeQuery(sql);
            while (resultSet.next()){
                String name = resultSet.getString("name");
                int price = resultSet.getInt("project_prices");

                ProjectPrices prices = new ProjectPrices(name, price);
                projectPricesList.add(prices);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        database.close();
        return projectPricesList;
    }
}
