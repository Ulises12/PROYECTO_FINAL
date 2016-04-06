/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author Gary
 */
public class Conection{

    
    // Atributos de la base de datos
    private static String ipAddress;
    private static String dbName ;
    private static final String user = "root";
    private static final String password = "root";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/canciones";

    // método para poder realizar la conexion con la base de datos requerida
    public static Connection getConexion() throws SQLException {
        /*try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }*/

        /*if (dbProperties == null) {
            dbProperties = ResourceBundle.getBundle("control");
            ipAddress = dbProperties.getString("ip_address");
            dbName = dbProperties.getString("db_name");
            user = dbProperties.getString("user");
            password = dbProperties.getString("password");
            service = dbProperties.getString("service");
        }*/
       
        return DriverManager.getConnection(CONN_STRING,user,password);
    }
}
