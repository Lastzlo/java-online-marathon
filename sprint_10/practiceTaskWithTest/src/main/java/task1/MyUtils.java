package task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyUtils {
    private Connection connection;
    private Statement statement;
    private String schemaName;

    public Connection createConnection() throws SQLException {
        DriverManager.registerDriver(new org.h2.Driver());
        connection = DriverManager.getConnection("jdbc:h2:mem:test", "", "");
        return connection;
    }
    public void closeConnection() throws SQLException {
        connection.close();
    }
    public Statement createStatement() throws SQLException {
        statement = connection.createStatement();
        return statement;
    }
    public void closeStatement() throws SQLException {
        statement.close();
    }
    public void createSchema(String schemaName) throws SQLException {
        String sql = String.format("CREATE SCHEMA IF NOT EXISTS %s", schemaName);
        statement.executeUpdate(sql);
        this.schemaName = schemaName;
    }
    public void dropSchema() throws SQLException {
        String sql = String.format("DROP SCHEMA IF EXISTS %s", this.schemaName);
        statement.executeUpdate(sql);
    }
    public void useSchema() throws SQLException {
        /*не работает connection.setSchema(schemaName)*/
        //connection.setSchema(schemaName);
        String sql = String.format("SET SCHEMA %s", schemaName);
        statement.executeUpdate(sql);
    }
    public void createTableRoles() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS roles " +
                "(id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY, " +
                " roleName VARCHAR(255), " +
                " PRIMARY KEY ( id ))";
        statement.executeUpdate(sql);
    }
    public void createTableDirections() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS directions " +
                "(id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY, " +
                " directionName VARCHAR(255), " +
                " PRIMARY KEY ( id ))";
        statement.executeUpdate(sql);
    }
    public void createTableProjects() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS projects  " +
                "(id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY, " +
                " projectName VARCHAR(255), " +
                " directionId INT NOT NULL, " +
                " PRIMARY KEY ( id ), " +
                " FOREIGN KEY ( directionId)" +
                " REFERENCES directions ( id ))";
        statement.executeUpdate(sql);
    }
    public void createTableEmployee() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS employee  " +
                "(id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY, " +
                " firstName VARCHAR(255), " +
                " roleId INT NOT NULL, " +
                " projectId INT NOT NULL, " +
                " PRIMARY KEY ( id ), " +
                " FOREIGN KEY ( roleId)" +
                " REFERENCES roles ( id ), " +
                " FOREIGN KEY ( projectId)" +
                " REFERENCES projects ( id ))";
        statement.executeUpdate(sql);
    }

    public void dropTable(String tableName) throws SQLException {
        String sql = String.format("DROP TABLE IF EXISTS %s", tableName);
        statement.executeUpdate(sql);
    }

    public void insertTableRoles(String roleName) throws SQLException {
        String sql = String.format("INSERT INTO roles (roleName) VALUES ('%s')", roleName);
        statement.executeUpdate(sql);
    }

    public void insertTableDirections(String directionName) throws SQLException {
        String sql = String.format("INSERT INTO directions (directionName) VALUES ('%s')", directionName);
        statement.executeUpdate(sql);
    }

    public void insertTableProjects(String projectName, String directionName) throws SQLException {
        String sql = "INSERT INTO projects (projectName, directionId) " +
                "VALUES (" +
                "   '" + projectName + "', " +
                "   (   SELECT id " +
                "       FROM directions " +
                "       WHERE directionName = '" + directionName + "')" +
                ")";
        statement.executeUpdate(sql);
    }
    public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException {
        String sql = "INSERT INTO employee (firstName, roleId, projectId) " +
                "VALUES (" +
                "   '" + firstName + "', " +
                "   (   SELECT id " +
                "       FROM roles " +
                "       WHERE rolename = '" + roleName + "'), " +
                "   (   SELECT id " +
                "       FROM projects " +
                "       WHERE projectname = '" + projectName + "')" +
                ")";
        statement.executeUpdate(sql);
    }

    public int getRoleId(String roleName) throws SQLException {
        String sql = "SELECT id FROM roles WHERE rolename = '" + roleName + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        int id = resultSet.getInt("id");
        resultSet.close();
        return id;
    }
    public int getDirectionId(String directionName) throws SQLException {
        String sql = "SELECT id FROM directions WHERE directionname = '" + directionName + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        int id = resultSet.getInt("id");
        resultSet.close();
        return id;
    }
    public int getProjectId(String projectName) throws SQLException {
        String sql = "SELECT id FROM projects WHERE projectname = '" + projectName + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        int id = resultSet.getInt("id");
        resultSet.close();
        return id;
    }
    public int getEmployeeId(String firstName) throws SQLException {
        String sql = "SELECT id FROM employee WHERE firstname = '" + firstName + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        int id = resultSet.getInt("id");
        resultSet.close();
        return id;
    }
    public List<String> getAllRoles() throws SQLException {
        String sql = "SELECT rolename FROM roles";
        List<String> result = new ArrayList<>();
        try (ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()) {
                result.add(resultSet.getString(1));
            }
        }
        return result;
    }
    public List<String> getAllDirestion() throws SQLException {
        String sql = "SELECT directionname FROM directions";
        List<String> result = new ArrayList<>();
        try (ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()) {
                result.add(resultSet.getString(1));
            }
        }
        return result;
    }
    public List<String> getAllProjects() throws SQLException {
        String sql = "SELECT projectname FROM projects";
        List<String> result = new ArrayList<>();
        try (ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()) {
                result.add(resultSet.getString(1));
            }
        }
        return result;
    }
    public List<String> getAllEmployee() throws SQLException {
        String sql = "SELECT firstname FROM employee";
        List<String> result = new ArrayList<>();
        try (ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()) {
                result.add(resultSet.getString(1));
            }
        }
        return result;
    }
    public List<String> getAllDevelopers() throws SQLException {
        String sql = "SELECT firstname " +
                "       FROM employee" +
                "       WHERE roleid = (SELECT id FROM roles WHERE rolename = 'Developer')";
        List<String> result = new ArrayList<>();
        try (ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()) {
                result.add(resultSet.getString(1));
            }
        }
        return result;
    }
    public List<String> getAllJavaProjects() throws SQLException {
        String sql = "SELECT projectname " +
                "       FROM projects" +
                "       WHERE directionid = (SELECT id FROM directions WHERE directionname = 'Java')";
        List<String> result = new ArrayList<>();
        try (ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()) {
                result.add(resultSet.getString(1));
            }
        }
        return result;
    }
    public List<String> getAllJavaDevelopers() throws SQLException {
        String sql = "SELECT firstname " +
                "       FROM employee" +
                "       WHERE projectid IN " +
                "           (SELECT id " +
                "           FROM projects " +
                "           WHERE directionid = " +
                "               (SELECT id " +
                "               FROM directions " +
                "               WHERE directionname = 'Java'" +
                "               )" +
                "           )" +
                "       AND roleid = (SELECT id FROM roles WHERE rolename = 'Developer')";
        List<String> result = new ArrayList<>();
        try (ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()) {
                result.add(resultSet.getString(1));
            }
        }
        return result;
    }
}


