
package soft.java.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class MySQLConnection {
    
    private static Connection con;          
    private static final String drive = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://127.0.0.1/fifasm_bd";
            
    public MySQLConnection(){
        con = null;
        try {
            Class.forName(drive);
            con = DriverManager.getConnection(url, user, password);
            if (con != null) {
                System.out.println("Conexión Establecida");
            }
        } catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Driver no encontrado");
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Fallo al recibir base de datos");
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "No hay resultado");
        }
    }
    // Este metodo retorna la conexión
    public Connection getConnectionBD() {
        return con;
    }
    // Este metodo cierra la conexión
    public void getDisconnectBD() {
        con = null;
        if (con == null){
            JOptionPane.showMessageDialog(null,"Conexión terminada.");
        }
    }
    
}
