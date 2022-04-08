package controlador;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import conexion.Conexion;
import java.sql.ResultSet;
import modelo.Producto1;
 
public class ControlDatos {

    private Producto1 modelo;
    private Connection con;
     
    public ControlDatos(){
      
        modelo = new Producto1();
    }
     
    public PreparedStatement insertar(Producto1 producto){
          Conexion conectar = new Conexion();
        PreparedStatement ps = null;

        String sql;
     
        try{
                
            con = conectar.getConnection();
            sql = "INSERT INTO producto(nombre_producto,precio,descripcion, garantia, oferta,"
                    + "promociones,descuentos,estado,imagen, categoria_idcategoria,proveedor_nit, marca_nombre_comercial) values(?,?,?,?,?,?,?,?,?,?,?,?)";    
            
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getnombre_producto());
            ps.setString(4, producto.getgarantia());
            ps.setString(5, producto.getoferta());
            ps.setString(6, producto.getpromociones());
            ps.setInt(10, producto.getcategoria_idcategoria());
            ps.setString(12, producto.getmarca_nombre_comercial());
            ps.setInt(11, producto.getproveedor_nit());
            ps.setFloat(7, producto.getdescuento());
            ps.setFloat(2, producto.getprecio());
            ps.setString(3, producto.getdescripcion());
            ps.setInt(8, producto.getestado());
            ps.setString(9, producto.getimagen());
            
            ps.executeUpdate();
                
            JOptionPane.showMessageDialog(null, "Se han insertado los datos");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
     return ps;
    }

   public void Actualizar(String nombres, String apellidos, String email, String celular, 
                      String direccion, String ciudad, String idcontacto){

int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea modificar los datos actuales?");

if(confirmar == JOptionPane.YES_OPTION){

    Connection conexion = null;
    
    try {
    
//        conexion = metodospool.dataSource.getConnection();
        
        String Ssql = "UPDATE contacto SET nombres=?, apellidos=?, email=?, celular=?, direccion=?, ciudad=? "
                    + "WHERE id_contacto=?";
        
        PreparedStatement prest = conexion.prepareStatement(Ssql);
        
        prest.setString(1, nombres);
        prest.setString(2, apellidos);
        prest.setString(3, email);
        prest.setString(4, celular);
        prest.setString(5, direccion);
        prest.setString(6, ciudad);
        prest.setString(7, idcontacto);
        
        if(prest.executeUpdate() > 0){
        
            JOptionPane.showMessageDialog(null, "Los datos han sido modificados con éxito", "Operación Exitosa", 
                                          JOptionPane.INFORMATION_MESSAGE);
            
        }else{
        
            JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                                          + "Inténtelo nuevamente.", "Error en la operación", 
                                          JOptionPane.ERROR_MESSAGE);
        
        }
        
    } catch (SQLException e) {
    
        JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                                          + "Inténtelo nuevamente.\n"
                                          + "Error: "+e, "Error en la operación", 
                                          JOptionPane.ERROR_MESSAGE);
    
    }finally{
    
        if(conexion!=null){
        
            try {
                
                conexion.close();
            
            } catch (SQLException e) {
            
                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión."
                                          + "Error: "+e, "Error en la operación", 
                                          JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
           
    }
    

}

}



  

 


}
//private double precio,descuento;
//private int proveedor_nit, categoria_idcategoteria, codigo_producto;
//private String nombre_producto,garantia,oferta,promociones,imagen,estado, marca_nombre_comercial;