package task1;

import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.List;

public class MyUtilsPostgreDoWithDate {

    private static MyUtilsPostgre myUtils;

    @BeforeAll
    public static void setUpBasicConnectionPoolInstance() throws SQLException {
        myUtils = new MyUtilsPostgre();

        myUtils.createConnection();
        myUtils.createStatement();
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        myUtils.closeConnection();
    }

    @Test
    void createAllTables() throws SQLException{
        myUtils.createTableRoles();
        myUtils.createTableDirections();
        myUtils.createTableProjects();
        myUtils.createTableEmployee();
    }

    @Test
    void dropAllTables() throws SQLException{
        myUtils.dropTable("Employee");
        myUtils.dropTable("Projects");
        myUtils.dropTable("Roles");
        myUtils.dropTable("Directions");
    }

    @Test
    void insertDatai_insertTableRoles() throws SQLException {
        myUtils.insertTableRoles("Developer");
        myUtils.insertTableRoles("DevOps");
        myUtils.insertTableRoles("QC");
    }

    @Test
    void insertData_insertTableDirections() throws SQLException {
        myUtils.insertTableDirections("Java");
        myUtils.insertTableDirections("Python");
        myUtils.insertTableDirections(".Net");
    }

    @Test
    void insertData_insertTableProjects() throws SQLException {
        myUtils.insertTableProjects("MoonLight","Java");
        myUtils.insertTableProjects("Sun","Java");
        myUtils.insertTableProjects("Mars","Python");
    }

    @Test
    void insertData_insertTableEmployee() throws SQLException {
        myUtils.insertTableEmployee("Ivan","Developer","MoonLight");
        myUtils.insertTableEmployee("Petro","Developer","Sun");
        myUtils.insertTableEmployee("Stepan","Developer","Mars");
        myUtils.insertTableEmployee("Andriy","DevOps","MoonLight");
        myUtils.insertTableEmployee("Vasyl","DevOps","Mars");
        myUtils.insertTableEmployee("Ira","Developer","MoonLight");
        myUtils.insertTableEmployee("Anna","QC","MoonLight");
        myUtils.insertTableEmployee("Oly","QC","Sun");
        myUtils.insertTableEmployee("Maria","QC","Mars");
    }

    @Test
    void getData_getRoleId() throws SQLException {
        Assertions.assertEquals(1, myUtils.getRoleId("Developer"));
        Assertions.assertEquals(2, myUtils.getRoleId("DevOps"));
        Assertions.assertEquals(3, myUtils.getRoleId("QC"));
    }

    @Test
    void getData_getDirectionId() throws SQLException {
        Assertions.assertEquals(1, myUtils.getDirectionId("Java"));
        Assertions.assertEquals(2, myUtils.getDirectionId("Python"));
        Assertions.assertEquals(3, myUtils.getDirectionId(".Net"));
    }

    @Test
    void getData_getProjectId() throws SQLException {
        Assertions.assertEquals(1, myUtils.getProjectId("MoonLight"));
        Assertions.assertEquals(2, myUtils.getProjectId("Sun"));
        Assertions.assertEquals(3, myUtils.getProjectId("Mars"));
    }

    @Test
    void getData_getEmployeeId() throws SQLException {
        Assertions.assertEquals(1, myUtils.getEmployeeId("Ivan"));
        Assertions.assertEquals(2, myUtils.getEmployeeId("Petro"));
        Assertions.assertEquals(3, myUtils.getEmployeeId("Stepan"));
    }

    @Test
    void getData_getAllRoles() throws SQLException {
        //when
        List<String> allRoles = myUtils.getAllRoles();

        //then
        Assertions.assertEquals(3, allRoles.size());
        Assertions.assertEquals("Developer", allRoles.get(0));
    }

    @Test
    void getData_getAllJavaProjects() throws SQLException {

        List<String> allJavaProjects = myUtils.getAllJavaProjects();
        allJavaProjects.forEach(System.out::println);

        Assertions.assertEquals(2, allJavaProjects.size());

    }

    @Test
    void getData_getAllJavaDevelopers() throws SQLException {

        List<String> allJavaDevelopers = myUtils.getAllJavaDevelopers();
        allJavaDevelopers.forEach(System.out::println);

        Assertions.assertEquals(3, allJavaDevelopers.size());

    }
}
