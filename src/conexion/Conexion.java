package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion implements Configuracion {

    private static Connection con = null;
    
    static {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
            if (con != null) {
                System.out.println("Conexion exitosa");
            } else {
                System.out.println("Conexion fallida");
            }
        } catch (ClassNotFoundException | SQLException error) {
            error.printStackTrace();
            System.out.println("Error en conexión: "+error);
        }
    }
    
    public static Connection getConnection() {
        return con;
    }
    
//    public static void cerrar() {
//        try {
//            con.close();
//        } catch (SQLException e) {
//            System.out.println("Error en cerrar : "+e);
//        }
//         
//    } 

    public boolean ejecutar(String sql) {
        boolean var;
        try {
            Statement sentencia;
            sentencia = getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            if(sentencia.executeUpdate(sql)==0)
                var=false;
            else            
                var = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en ejecución : "+e);
            var = false;
        }
        return var;        
    }

    public ResultSet consultar(String sql) {
        ResultSet resultado;
        try {
            Statement sentencia;
            sentencia = getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql); 
        } catch (SQLException error) {
            error.printStackTrace();
            System.out.println("Error en la consulta : "+error);
            resultado = null;
        }
        return resultado;
    }
}
