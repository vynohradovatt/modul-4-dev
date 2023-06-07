package org.example;
import org.example.dto.*;
import org.example.sqlCommands.DatabaseQueryService;
import org.example.sqlCommands.MyPreparedStatement;

import java.time.LocalDate;
import java.util.List;

public class TestsDB {
    public static void main(String[] args) {

        Database database = Database.getInstance();

        MyPreparedStatement ps = new MyPreparedStatement(database);
        int intoTable = ps.insertIntoTableWorker(
                25,
                "Maria",
                LocalDate.parse("1960-08-08"),
                "senior",
                40000
        );

        int client = ps.insertIntiTableClient(11, "Ivan");

        int project = ps.insertIntoTableProject(
                11,
                6,
                LocalDate.parse("2022-01-01"),
                LocalDate.parse("2022-02-02")
        );

        int project_worker = ps.insertIntoTableProject_Worker(2, 1);

        System.out.println("intoTable = " + intoTable);
        System.out.println("client = " + client);
        System.out.println("project = " + project);
        System.out.println("project_worker = " + project_worker);

        database.close();
    }
}