package db;

import libs.Database;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

public class TestDB {
    Database database;
    @Before
    public void setup() throws SQLException, IOException, ClassNotFoundException {
        database = new Database("MySQL_PADB_DB","MySQL");
    }

    @Test
    public void testDB() throws SQLException {

        System.out.println(database.selectTable("select * from seleniumTable where login = 'test'"));
        database.changeTable("INSERT INTO seleniumTable VALUES (1,2,'test12345','pass')");
        System.out.println(database.selectTable("select * from seleniumTable where login = 'test12345'"));
    }

    @After
    public void tearDown() throws SQLException {
        database.quit();
    }

}
