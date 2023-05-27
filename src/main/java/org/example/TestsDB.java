package org.example;
import org.example.dto.*;
import org.example.sqlCommands.DatabaseQueryService;
import java.util.List;

public class TestsDB {
    public static void main(String[] args) {

        DatabaseQueryService databaseQueryService = new DatabaseQueryService();

        List<MaxSalary> maxSalary = databaseQueryService.findMaxSalary();
        System.out.println(maxSalary.toString());

        List<LongestProject> longestProject = databaseQueryService.findLongestProject();
        System.out.println(longestProject);

        List<MaxProjectClient> maxProjectClient = databaseQueryService.findMaxProjectClient();
        System.out.println(maxProjectClient);

        List<YoungestEldestWorker> youngestEldestWorker = databaseQueryService.findYoungestEldestWorker();
        System.out.println(youngestEldestWorker);

        List<ProjectPrices> projectPrices = databaseQueryService.findProjectPrices();
        System.out.println(projectPrices);


    }
}