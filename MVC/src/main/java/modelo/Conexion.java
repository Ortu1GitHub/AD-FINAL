package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection miconexion=null;

    public Connection getMiconexion() {
        try {
            miconexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "user1", "Aldebaran1!*");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  miconexion;
    }
}
