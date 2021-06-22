package task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class MyUtilsPostgreTest {

    private static MyUtilsPostgre myUtils;

    @BeforeAll
    public static void setUpBasicConnectionPoolInstance() throws SQLException {
        myUtils = new MyUtilsPostgre();
    }

    @Test
    void givenMyUtilsPostgre_whenCalledCreateConnection_thenCorrect () throws SQLException {
        Connection connection = myUtils.createConnection();
        assertTrue(connection.isValid(1));
    }

    @Test
    void givenMyUtilsPostgre_whenCloseConnection_thenCorrect() throws SQLException {
        Connection connection = myUtils.createConnection();
        connection.close();
        assertTrue(connection.isClosed());
    }


}