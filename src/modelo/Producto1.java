
package modelo;

import javax.swing.JTable;

public class Producto1 {
private float precio,descuento;
private int proveedor_nit, categoria_idcategoteria, codigo_producto, estado;
private String nombre_producto,garantia,oferta,promociones,imagen, marca_nombre_comercial, descripcion;

    public Producto1() {
    }

    public Producto1(float precio, float descuento, int proveedor_nit, int categoria_idcategoteria, int codigo_producto, int estado, String nombre_producto, String garantia, String oferta, String promociones, String imagen, String marca_nombre_comercial, String descripcion) {
        this.precio = precio;
        this.descuento = descuento;
        this.proveedor_nit = proveedor_nit;
        this.categoria_idcategoteria = categoria_idcategoteria;
        this.codigo_producto = codigo_producto;
        this.estado = estado;
        this.nombre_producto = nombre_producto;
        this.garantia = garantia;
        this.oferta = oferta;
        this.promociones = promociones;
        this.imagen = imagen;
        this.marca_nombre_comercial = marca_nombre_comercial;
        this.descripcion = descripcion;
    }


public float getprecio(){
    return precio;
}

public void setprecio(float precio){
this.precio = precio;
}

public float getdescuento(){
return descuento;
}

public void setdescuento(float descuento){
    this.descuento = descuento;
}

public int getproveedor_nit(){
return proveedor_nit;
}

public void setproveedor_nit(int proveedor_nit){
    this.proveedor_nit = proveedor_nit;
}

public int getcategoria_idcategoria(){
return categoria_idcategoteria;
}

public void setcategoria_idcategoteria(int categoria_idcategoteria){
    this.categoria_idcategoteria = categoria_idcategoteria;
}

public int getcodigo_producto(){
return codigo_producto;
}
public void setcodigo_producto(int codigo_producto){
    this.codigo_producto = codigo_producto;
}



public int getestado(){
return estado;
}

public void setestado(int estado){
    this.estado = estado;
}

public String getnombre_producto(){
return nombre_producto;
}

public void setnombre_producto(String nombre_producto){
this.nombre_producto = nombre_producto;
}

public String getgarantia(){
return garantia;
}

public void setgarantia(String garantia){
this.garantia = garantia;
}


public String getdescripcion(){
return descripcion;
}

public void setdescripcion(String descripcion){
this.descripcion = descripcion;
}

public String getoferta(){
return oferta;
}

public void setoferta(String oferta){
this.oferta = oferta;
}

public String getpromociones(){
return promociones;
}

public void setpromociones(String promociones){
this.promociones = promociones;
}

public String getimagen(){
return imagen;
}

public void setimagen(String imagen){
this.imagen = imagen;
}

public void setmarca_nombre_comercial(String  marca_nombre_comercial){
this. marca_nombre_comercial =  marca_nombre_comercial;
}

public String getmarca_nombre_comercial(){
return  marca_nombre_comercial;
}

    public String Lbl_imagen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    public void eliminar(Producto1 producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
