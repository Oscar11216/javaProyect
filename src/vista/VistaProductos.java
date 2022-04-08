/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControlDatos;
import controlador.ControladorProductos;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.Icon;
import modelo.Producto1;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author SENA
 */
public final class VistaProductos extends javax.swing.JFrame {

    Path origen;
    Path destino;

    public static ArrayList<Producto1> listaproductos = new ArrayList();
    public static Producto1 producto = new Producto1();

    /**
     * Creates new form crud2
     */
    public VistaProductos() {
        initComponents();
        listaProductos();

        crear.addActionListener((ActionEvent e) -> {

        });

    }

    public void guardar() {
        ControlDatos insert = new ControlDatos();

        Producto1 producto = new Producto1();
        producto.setcategoria_idcategoteria(Integer.parseInt(categoria_idcategoria.getText()));
        producto.setcodigo_producto(Integer.parseInt(codigo_producto.getText()));
        producto.setdescuento(Float.parseFloat(descuento.getText()));
        producto.setgarantia(garantia.getText());
        producto.setmarca_nombre_comercial(marca_nombre_comercial.getText());
        producto.setoferta(oferta.getText());
        producto.setnombre_producto(nombre_producto.getText());
        producto.setpromociones(promociones.getText());
        producto.setproveedor_nit(Integer.parseInt(proveedor_nit.getText()));
        producto.setprecio(Float.parseFloat(precio.getText()));
        producto.setestado(1);
        producto.setdescripcion(descripcion.getText());
        producto.setimagen(destino.toString());

        insert.insertar(producto);
        listaProductos();

    }

    public void eliminar() {
        ControladorProductos ctrproducto = new ControladorProductos();
        ctrproducto.eliminar(codigo_producto.getText());
        limpiarTabla();
        listaProductos();
        limpiar();
    }

    public void modificar() {

        ControladorProductos ctrproducto = new ControladorProductos();
        Producto1 producto = new Producto1();
        producto.setcategoria_idcategoteria(Integer.parseInt(categoria_idcategoria.getText()));
        producto.setcodigo_producto(Integer.parseInt(codigo_producto.getText()));
        producto.setdescuento(Float.parseFloat(descuento.getText()));
        producto.setgarantia(garantia.getText());
        producto.setmarca_nombre_comercial(marca_nombre_comercial.getText());
        producto.setoferta(oferta.getText());
        producto.setnombre_producto(nombre_producto.getText());
        producto.setpromociones(promociones.getText());
        producto.setproveedor_nit(Integer.parseInt(proveedor_nit.getText()));
        producto.setprecio(Float.parseFloat(precio.getText()));
        producto.setestado(1);
        producto.setdescripcion(descripcion.getText());
//        producto.setimagen(destino.toString());
        ctrproducto.modificar(producto);

        limpiarTabla();
        listaProductos();
        limpiar();
    }

    public void limpiar() {
        codigo_producto.setText("");
        nombre_producto.setText("");
        garantia.setText("");
        oferta.setText("");
        promociones.setText("");
        marca_nombre_comercial.setText("");
        proveedor_nit.setText("");
        precio.setText("");
        descuento.setText("");
        categoria_idcategoria.setText("");
        txt_nombre.setText("");
        lbl_rutadestino.setText("");
        imagen.setText("");
        imagen.setIcon(null);
    }

    public void limpiarTabla() {

        for (int posicion = 0; posicion < 100; posicion++) {
            tblproductos.setValueAt("", posicion, 0);
            tblproductos.setValueAt("", posicion, 1);
            tblproductos.setValueAt("", posicion, 2);
            tblproductos.setValueAt("", posicion, 3);
            tblproductos.setValueAt("", posicion, 4);
            tblproductos.setValueAt("", posicion, 5);
            tblproductos.setValueAt("", posicion, 6);
            tblproductos.setValueAt("", posicion, 7);
            tblproductos.setValueAt("", posicion, 8);
            tblproductos.setValueAt("", posicion, 9);
            tblproductos.setValueAt("", posicion, 10);
            tblproductos.setValueAt("", posicion, 11);
        }

    }

    public void mostrarDatos() {
        try {
            
        
        for (int posicion = 0; posicion < listaproductos.size(); posicion++) {
            if (tblproductos.getSelectedRow() == posicion) {
                producto = listaproductos.get(posicion);

            }
        }
        nombre_producto.setText(producto.getnombre_producto());
        garantia.setText(producto.getgarantia());
        oferta.setText(producto.getoferta());
        promociones.setText(producto.getpromociones());
        marca_nombre_comercial.setText(producto.getmarca_nombre_comercial());
        proveedor_nit.setText(String.valueOf(producto.getproveedor_nit()));
        precio.setText(String.valueOf(producto.getprecio()));
        descuento.setText(String.valueOf(producto.getdescuento()));
        categoria_idcategoria.setText(String.valueOf(producto.getcategoria_idcategoria()));
        codigo_producto.setText(String.valueOf(producto.getcodigo_producto()));
        lbl_rutadestino.setText(producto.getimagen());
        txt_nombre.setText(producto.getimagen());
        File fileName = new File(producto.getimagen());
        ImageIcon icon = new ImageIcon(fileName.getAbsolutePath());
            System.out.println("Estoy en mostrar datos: "+fileName.getAbsolutePath());
        Icon icono = new ImageIcon(icon.getImage().
                getScaledInstance(imagen.getWidth(), imagen.getHeight(),
                        Image.SCALE_DEFAULT));
        imagen.setText(null);
        imagen.setIcon(icono);
//        imagen.setIcon(new ImageIcon(producto.getimagen()));
//        imagen.setIcon(new ImageIcon("C:\\NetBeansProjects\\ProyectoAdsi\\src\\imagenes\\img5.png"));
          } catch (Exception e) {
              System.out.println("error en el metodo mostrar datos"+e);
        }
        
       
    }

    public void rutaImagen() {
//        String ruta;
        String rutadestino = null, rutaorigen = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("JPG & GIF Images & PNG", "jpg", "gif", "png");
        fileChooser.setFileFilter(imgFilter);
        int result = fileChooser.showOpenDialog(this);
        if (result != JFileChooser.CANCEL_OPTION) {
             
//                    
           File fileName = fileChooser.getSelectedFile() ;
           
//            System.out.println("ruta de archivo seleccionado: " + );
//            System.out.println("nombre de archivo seleccionado: " + fileName.getName());
            try {
                txt_nombre.setText(fileChooser.getSelectedFile().toString());
                //definimos el destino del archivo, que seá en la carpeta imágenes

//                rutadestino = System.getProperty("user.dir") + "/src/img/" + txt_nombre.getText() + ".jpg";
                rutadestino = "C:\\imagenes\\" + fileName.getName();
//                rutadestino = System.getProperty("user.dir") + "\\src\\imagenes\\" + fileName.getName();

//                OutputStream out = new FileOutputStream(rutadestino);
                lbl_rutadestino.setText(rutadestino);
                destino = Paths.get(rutadestino);
                
//                System.out.println("rutadestino:" + destino);
//                System.setProperty(destino.toString(), destino.toString());
                //definimos el origen, el cual sera seleccionado
//                ruta = "C:\\Users\\L340 RYZEN3\\Desktop\\img.jpg";
//                ruta = txt_nombre.getText();
//                rutaorigen = ruta;
//                System.out.println("esta es la ruta origen: " + fileName.getPath());
//                rutaorigen = fileName.getPath();
//                origen = Paths.get(rutaorigen);
                System.out.println("ruta salida: " + destino.toAbsolutePath());

//                ImageIcon icon = new ImageIcon("C:\\imagenes\\img5.png");
                ImageIcon icon = new ImageIcon(fileName.getAbsolutePath());

                System.out.println("ruta salida: " + fileName.getAbsolutePath());
                Icon icono = new ImageIcon(icon.getImage().
                        getScaledInstance(imagen.getWidth(), imagen.getHeight(),
                                Image.SCALE_DEFAULT));
                imagen.setText(null);
                imagen.setIcon(icono);
                System.out.println("lugar donde queda la imagen seleccionada: " + destino);
            } catch (Exception e) {
                System.out.println("error en imagen " + e);
            }
        }
    }

    public void listaProductos() {
        ControladorProductos ctrlp = new ControladorProductos();

        listaproductos = ctrlp.consulta();
        for (int posicion = 0; posicion < listaproductos.size(); posicion++) {
            tblproductos.setValueAt(listaproductos.get(posicion).getnombre_producto(), posicion, 0);
            tblproductos.setValueAt(listaproductos.get(posicion).getcodigo_producto(), posicion, 1);
            tblproductos.setValueAt(listaproductos.get(posicion).getimagen(), posicion, 2);
            tblproductos.setValueAt(listaproductos.get(posicion).getmarca_nombre_comercial(), posicion, 3);
            tblproductos.setValueAt(listaproductos.get(posicion).getoferta(), posicion, 4);
            tblproductos.setValueAt(listaproductos.get(posicion).getproveedor_nit(), posicion, 5);
            tblproductos.setValueAt(listaproductos.get(posicion).getgarantia(), posicion, 6);
            tblproductos.setValueAt(listaproductos.get(posicion).getestado(), posicion, 7);
            tblproductos.setValueAt(listaproductos.get(posicion).getpromociones(), posicion, 8);
            tblproductos.setValueAt(listaproductos.get(posicion).getcategoria_idcategoria(), posicion, 9);
            tblproductos.setValueAt(listaproductos.get(posicion).getdescuento(), posicion, 10);
            tblproductos.setValueAt(listaproductos.get(posicion).getprecio(), posicion, 11);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblproductos = new javax.swing.JTable();
        crear = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombre_producto = new javax.swing.JTextField();
        codigo_producto = new javax.swing.JTextField();
        marca_nombre_comercial = new javax.swing.JTextField();
        proveedor_nit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        garantia = new javax.swing.JTextField();
        oferta = new javax.swing.JTextField();
        promociones = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        categoria_idcategoria = new javax.swing.JTextField();
        descuento = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        descripcion = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        lbl_rutadestino = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        modificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Poducto", "Codigo", "Imagen", "Marca", "Estado", "Proveedor", "Garantia", "Oferta", "Promociones", "Categoria", "Descuento", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblproductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblproductosMouseClicked(evt);
            }
        });
        tblproductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblproductosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblproductos);
        if (tblproductos.getColumnModel().getColumnCount() > 0) {
            tblproductos.getColumnModel().getColumn(0).setResizable(false);
            tblproductos.getColumnModel().getColumn(1).setResizable(false);
            tblproductos.getColumnModel().getColumn(2).setResizable(false);
            tblproductos.getColumnModel().getColumn(3).setResizable(false);
            tblproductos.getColumnModel().getColumn(4).setResizable(false);
            tblproductos.getColumnModel().getColumn(5).setResizable(false);
            tblproductos.getColumnModel().getColumn(6).setResizable(false);
            tblproductos.getColumnModel().getColumn(7).setResizable(false);
            tblproductos.getColumnModel().getColumn(8).setResizable(false);
            tblproductos.getColumnModel().getColumn(9).setResizable(false);
            tblproductos.getColumnModel().getColumn(10).setResizable(false);
            tblproductos.getColumnModel().getColumn(11).setResizable(false);
        }

        crear.setText("Crear");
        crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearActionPerformed(evt);
            }
        });

        limpiar.setText("limpiar");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Codigo");

        jLabel3.setText("Marca");

        jLabel5.setText("Proveedor");

        jLabel6.setText("Garantia");

        jLabel7.setText("Oferta");

        jLabel8.setText("Promociones");

        jLabel9.setText("Categoria");

        jLabel10.setText("Descuento");

        jLabel11.setText("Precio");

        precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioActionPerformed(evt);
            }
        });

        jLabel12.setText("Imagen");

        imagen.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setText("descripcion");

        buscar.setText("buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        lbl_rutadestino.setText(" ");

        txt_nombre.setText(" ");

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nombre_producto, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(codigo_producto)
                            .addComponent(marca_nombre_comercial)
                            .addComponent(promociones)))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(garantia, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(proveedor_nit)
                    .addComponent(oferta)
                    .addComponent(descripcion))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel10)))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(descuento)
                            .addComponent(precio)
                            .addComponent(categoria_idcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(crear)
                                    .addComponent(eliminar)
                                    .addComponent(limpiar)
                                    .addComponent(modificar)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscar)))
                        .addContainerGap(239, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_rutadestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(96, 96, 96))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buscar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))
                            .addComponent(crear, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(codigo_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel6)
                                            .addComponent(garantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10)
                                            .addComponent(descuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel7)
                                                    .addComponent(oferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel11)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(marca_nombre_comercial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel3)))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(eliminar)
                                .addGap(18, 18, 18)
                                .addComponent(limpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(modificar))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(proveedor_nit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(categoria_idcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nombre)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(promociones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_rutadestino, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioActionPerformed

    private void tblproductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblproductosKeyPressed
        mostrarDatos();
    }//GEN-LAST:event_tblproductosKeyPressed

    private void tblproductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblproductosMouseClicked
      mostrarDatos();
    }//GEN-LAST:event_tblproductosMouseClicked

    private void crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_crearActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        rutaImagen();
    }//GEN-LAST:event_buscarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
        eliminar();

    }//GEN-LAST:event_eliminarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        // TODO add your handling code here:
        modificar();
    }//GEN-LAST:event_modificarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_limpiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JTextField categoria_idcategoria;
    private javax.swing.JTextField codigo_producto;
    private javax.swing.JButton crear;
    private javax.swing.JTextField descripcion;
    private javax.swing.JTextField descuento;
    private javax.swing.JButton eliminar;
    private javax.swing.JTextField garantia;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_rutadestino;
    private javax.swing.JButton limpiar;
    private javax.swing.JTextField marca_nombre_comercial;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField nombre_producto;
    private javax.swing.JTextField oferta;
    private javax.swing.JTextField precio;
    private javax.swing.JTextField promociones;
    private javax.swing.JTextField proveedor_nit;
    private javax.swing.JTable tblproductos;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables

   
}
