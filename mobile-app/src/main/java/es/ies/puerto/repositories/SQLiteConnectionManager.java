package es.ies.puerto.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class SQLiteConnectionManager {

    private static String rutaDb = "src/main/resources/centroplus.db";

    public static void setDatabasePath(String path) {
        rutaDb = path;
    }

    public static String getDatabasePath() {
        return rutaDb;
    }

    public static Connection getConnection() throws SQLException {
        Connection c = DriverManager.getConnection("jdbc:sqlite:" + rutaDb);
        try (Statement st = c.createStatement()) {
            st.execute("PRAGMA foreign_keys = ON");
        }
        return c;
    }
}
