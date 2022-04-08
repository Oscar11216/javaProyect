/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Producto1;

/**
 *
 * @author SENA
 */
public class ControladorProductos {

    public ArrayList consulta() {
        Conexion conectar = new Conexion();
        ArrayList<Producto1> listaproductos = new ArrayList();
        
        ResultSet rs = null;
        String sql;
        sql = "SELECT * FROM producto where estado = '1'";
        try {
            rs = conectar.consultar(sql);
            while (rs.next()) {               
                Producto1 producto = new Producto1();
                producto.setnombre_producto(rs.getString("nombre_producto"));
                producto.setcodigo_producto(rs.getInt("codigo_producto"));
                producto.setgarantia(rs.getString("garantia"));
                producto.setoferta(rs.getString("oferta"));
                producto.setpromociones(rs.getString("promociones"));
                producto.setcategoria_idcategoteria(rs.getInt("categoria_idcategoria"));
                producto.setmarca_nombre_comercial(rs.getString("marca_nombre_comercial"));
                producto.setproveedor_nit(rs.getInt("proveedor_nit"));
                producto.setestado(rs.getInt("estado"));
                producto.setdescuento(rs.getFloat("descuentos"));
                producto.setprecio(rs.getFloat("precio"));
                producto.setimagen(rs.getString("imagen"));
                
                 listaproductos.add(producto);
            }
            
        } catch (Exception e) {
            System.out.println("Error al conectarse productos");
        }
        return listaproductos;
    }
    
    public void eliminar(String codigo){
        int id = Integer.parseInt(codigo);
        String sql = "update producto set estado = '0'  where codigo_producto =" + id;
        System.out.println("actualizacion: "+sql);
        Conexion conectar = new Conexion();
        try {
            if(conectar.ejecutar(sql)){
                JOptionPane.showMessageDialog(null,"Tus datos fueron eliminados satisfactoriamente");
            }else{
                JOptionPane.showMessageDialog(null,"sus datos no fueron eliminados");
            }
        } catch (Exception e) {
            System.out.println("El error en eliminar es: "+e);
        }
    }
    
    public void modificar(Producto1 producto){
        String sql = "update producto set precio="+producto.getprecio()+",descripcion= '"+producto.getdescripcion()+"', garantia='"+producto.getgarantia()+ "',oferta='"+producto.getoferta()+"', promociones='"+producto.getpromociones()+"', descuentos="+producto.getdescuento()+" where codigo_producto =" + producto.getcodigo_producto();
//        String sql = "update producto set precio="+producto.getprecio()+",descripcion= '"+producto.getdescripcion()+"', garantia='"+producto.getgarantia()+ "',oferta='"+producto.getoferta()+"', promociones='"+producto.getpromociones()+"', descuentos="+producto.getdescuento()+",imagen ="+producto.getimagen()+",  where codigo_producto =" + producto.getcodigo_producto();
        System.out.println("actualizacion: "+sql);
        Conexion conectar = new Conexion();
        try {
            if(conectar.ejecutar(sql)){
                JOptionPane.showMessageDialog(null,"Tus datos fueron modificados satisfactoriamente");
            }else{
                JOptionPane.showMessageDialog(null,"sus datos no fueron moficados");
            }
        } catch (Exception e) {
            System.out.println("El error en modificar es: "+e);
        }
        
    
    }
    
   
}
