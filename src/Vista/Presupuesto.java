/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo
 */
public class Presupuesto extends javax.swing.JFrame {
    private static SimpleDateFormat simpleDateFormat;
    private static ElegirCliente elegirClientev;
    private static ElegirTienda elegirTiendav;
    private static String clientev;
    private static DefaultTableModel defaultTableModel = new DefaultTableModel();
    private static int selectproductotienda;
    private static DefaultTableModel defaultTableModel1 = new DefaultTableModel();
    private static int selectproductocompra;
    /**
     * Creates new form Presupuesto
     */
    public Presupuesto() {
        initComponents();
    }
    
    public Presupuesto(ElegirCliente elegirCliente,String cliente) {
        initComponents();
        
        ArrayList<String> tiendas = Controlador.ControladorElegirTienda.ConsultarTiendas();
        for(String tienda:tiendas)
        {
            jComboBoxTiendas.addItem(tienda);
        }
        
        jButton2.setEnabled(false);
        simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        jTable1.removeAll();
        jTable2.removeAll();
        defaultTableModel = new DefaultTableModel();
        defaultTableModel1 = new DefaultTableModel();
        getContentPane().setBackground(java.awt.Color.white);
        elegirClientev=elegirCliente;
        clientev=cliente;
        ArrayList<String> clienteDatos = Controlador.ControladorPresupuesto.ConsultarDatosClienteJuridico(cliente);
        jLabel_NombreCliente.setText(clienteDatos.get(0));
        jLabel_UsuarioCliente.setText(clienteDatos.get(1));
        String [] carnetSplit=clienteDatos.get(2).split("-");
        String carnet = carnetSplit[1];
        while(carnet.length()<8)
        {
            carnet="0"+carnet;
        }
        carnet=carnetSplit[0]+"-"+carnet;
        jLabel_NroCarnetCliente.setText(carnet);
        defaultTableModel.addColumn("Nombre");
        defaultTableModel.addColumn("Cantidad Disponible");
        defaultTableModel.addColumn("Precio");
        jTable1.setModel(defaultTableModel);
        selectproductotienda=0;
        defaultTableModel1.addColumn("Nombre");
        defaultTableModel1.addColumn("Cantidad Disponible");
        defaultTableModel1.addColumn("Precio");
        jTable2.setModel(defaultTableModel1);
        selectproductocompra=0;
        
        
    }
    
    private static DecimalFormat decimalFormat= new DecimalFormat("0.00");
    
    private static double ObtenerPrecio(String producto)
    {
        String nombre="";
        int i;
        
        for(i=0;i<defaultTableModel.getRowCount();i++)
        {
            nombre=(String) defaultTableModel.getValueAt(i,0);
            if(producto.equals(nombre))
            {
                break;
            }
            
        }
        
        String precio = String.valueOf(defaultTableModel.getValueAt(i, 2));
        return Double.parseDouble(precio);
    }
    
    public void SetearCantidad (int cantidad)
    {
        defaultTableModel1.setValueAt(cantidad, selectproductocompra, 1);
        defaultTableModel1.setValueAt((cantidad*ObtenerPrecio((String)defaultTableModel1.getValueAt(selectproductocompra, 0))), selectproductocompra, 2);
        Double montototal=0.0;
        for(int i=0;i<jTable2.getRowCount();i++)
        {
            montototal=montototal+Double.valueOf(String.valueOf(defaultTableModel1.getValueAt(i, 2)));
        }
        
        jLabel_MontoTotal.setText(String.valueOf(montototal));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Tienda = new javax.swing.JLabel();
        jLabel_Foto = new javax.swing.JLabel();
        jLabel_Producto = new javax.swing.JLabel();
        jLabel_Agregar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel_Cliente = new javax.swing.JLabel();
        jLabel_NombreCliente = new javax.swing.JLabel();
        jLabel_Usuario = new javax.swing.JLabel();
        jLabel_UsuarioCliente = new javax.swing.JLabel();
        jLabel_NroCarnet = new javax.swing.JLabel();
        jLabel_NroCarnetCliente = new javax.swing.JLabel();
        jLabel_Productos = new javax.swing.JLabel();
        jLabel_Eliminar = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabelPVP = new javax.swing.JLabel();
        jLabel_MontoTotal = new javax.swing.JLabel();
        jButton_Confirmar = new javax.swing.JButton();
        jComboBoxTiendas = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Presupuesto");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel_Tienda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Tienda.setText("Tienda :");

        jLabel_Foto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Foto.setText("FOTO NO DISPONIBLE");

        jLabel_Producto.setText("Productos");

        jLabel_Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar.jpeg"))); // NOI18N
        jLabel_Agregar.setText("jLabel12");
        jLabel_Agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_AgregarMouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel_Cliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Cliente.setText("Cliente :");

        jLabel_NombreCliente.setText("jLabel6");

        jLabel_Usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Usuario.setText("Usuario :");

        jLabel_UsuarioCliente.setText("jLabel8");

        jLabel_NroCarnet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_NroCarnet.setText("Nro. Carnet :");

        jLabel_NroCarnetCliente.setText("jLabel11");

        jLabel_Productos.setText("Productos");

        jLabel_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Eliminar.jpg"))); // NOI18N
        jLabel_Eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_EliminarMouseClicked(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable2KeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabelPVP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPVP.setText("P.V.P");

        jLabel_MontoTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_MontoTotal.setText("0");

        jButton_Confirmar.setText("Presupuestar");
        jButton_Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ConfirmarActionPerformed(evt);
            }
        });

        jComboBoxTiendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTiendasActionPerformed(evt);
            }
        });

        jButton2.setText("Comprar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_Tienda, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jComboBoxTiendas, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addGap(17, 17, 17)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelPVP, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel_MontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_Eliminar))
                                .addGap(60, 60, 60))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_Cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel_Usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel_NroCarnet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel_Productos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_UsuarioCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel_NombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel_NroCarnetCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(162, 162, 162))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Confirmar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(59, 59, 59))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_NombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_Usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_UsuarioCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_NroCarnet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_NroCarnetCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_Productos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_Eliminar)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_MontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPVP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_Confirmar)
                            .addComponent(jButton2))
                        .addGap(1, 1, 1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_Tienda, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(jComboBoxTiendas))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jButton1))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_AgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_AgregarMouseClicked
        // TODO add your handling code here:

        defaultTableModel1.addRow(new Object[] {defaultTableModel.getValueAt(selectproductotienda, 0),1,defaultTableModel.getValueAt(selectproductotienda, 2)});
        Double pvp = Double.parseDouble(jLabel_MontoTotal.getText());

        pvp = pvp+ Double.valueOf((String)defaultTableModel.getValueAt(selectproductotienda, 2));

        jLabel_MontoTotal.setText(String.valueOf(pvp));
    }//GEN-LAST:event_jLabel_AgregarMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        selectproductotienda = jTable1.getSelectedRow();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ElegirCliente elegirCliente = new ElegirCliente(elegirTiendav, jComboBoxTiendas.getSelectedItem().toString());
        this.dispose();
        elegirCliente.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel_EliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EliminarMouseClicked
        // TODO add your handling code here:
        defaultTableModel1.removeRow(selectproductocompra);
        Double montototal=0.0;
        Double monto =0.0;
        for(int i=0;i<jTable2.getRowCount();i++)
        {
            montototal=montototal+Double.valueOf(String.valueOf(defaultTableModel1.getValueAt(i, 2)));
        }
        jLabel_MontoTotal.setText(String.valueOf(montototal));
    }//GEN-LAST:event_jLabel_EliminarMouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        selectproductocompra=jTable2.getSelectedRow();
        CantidadProductos cantidadProductos = new CantidadProductos(this);
        this.setEnabled(false);
        cantidadProductos.setVisible(true);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTable2KeyPressed

    private void jTable2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyReleased
        // TODO add your handling code here:

        //defaultTableModel1.setValueAt((cantidad*ObtenerPrecio((String)defaultTableModel1.getValueAt(selectproductocompra, 0))), selectproductocompra, 2);

    }//GEN-LAST:event_jTable2KeyReleased

    private void jTable2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2KeyTyped

    private void jButton_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ConfirmarActionPerformed
        // TODO add your handling code here:
        
            if(Controlador.ControladorPresupuesto.RealizarPresupuestoReservando(jComboBoxTiendas.getSelectedItem().toString(), jLabel_UsuarioCliente.getText(), jLabel_MontoTotal.getText()))
            {
                ArrayList<String> productos= new ArrayList<>();
                ArrayList<String> cantidad= new ArrayList<>();
                for(int i=0;i<defaultTableModel1.getRowCount();i++)
                {
                    cantidad.add(String.valueOf(defaultTableModel1.getValueAt(i, 1)));
                    productos.add(String.valueOf(defaultTableModel1.getValueAt(i, 0)));
                }

                ArrayList<String> presupuesto = Controlador.ControladorPresupuesto.ObtenerCodigoPresupuesto();
                System.out.println("Presupuesto: "+presupuesto.get(0));
                for(int i=0;i<productos.size();i++)
                {
                    System.out.println("Producto: "+productos.get(i));
                    ArrayList<String> ejemplares = Controlador.ControladorCompra.ObtenerEjemplares(productos.get(i), cantidad.get(i), jComboBoxTiendas.getSelectedItem().toString());
                    for(int j=0;j<ejemplares.size();j++)
                    {
                        System.out.println("Ejemplar : "+ejemplares.get(j));
                        Controlador.ControladorCompra.ReservarEjemplares(ejemplares.get(j), presupuesto.get(0));
                    }
                }
                JOptionPane.showMessageDialog(rootPane, "Presupuesto Registrado Exitosamente", "Presupuesto", JOptionPane.INFORMATION_MESSAGE);
                jButton2.setEnabled(true);
                jButton_Confirmar.setEnabled(false);
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Error al Registrar Presupuesto", "Presupuesto", JOptionPane.ERROR_MESSAGE);
            }
        
            
            
        
    }//GEN-LAST:event_jButton_ConfirmarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        ElegirCliente elegirCliente = new ElegirCliente();
        elegirCliente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing
    private static ArrayList<String> productosdisponibles;
    private void jComboBoxTiendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTiendasActionPerformed
        // TODO add your handling code here:
        jTable1.removeAll();
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Nombre");
        defaultTableModel.addColumn("Cantidad Disponible");
        defaultTableModel.addColumn("Precio");
        jTable1.setModel(defaultTableModel);
        productosdisponibles = Controlador.ControladorCompra.ConsultarProductosDisponibles(jComboBoxTiendas.getSelectedItem().toString());
        
        int i=0;
        while (i<productosdisponibles.size())
        {
            defaultTableModel.addRow(new Object[] {productosdisponibles.get(i),productosdisponibles.get(i+1),productosdisponibles.get(i+2)});
            i=i+3;
        }
    }//GEN-LAST:event_jComboBoxTiendasActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ArrayList<String> presupuesto = Controlador.ControladorPresupuesto.ObtenerCodigoPresupuesto();
        if(Controlador.ControladorPresupuesto.RealizarCompraPresupuesto(presupuesto.get(0),jComboBoxTiendas.getSelectedItem().toString()))
            {
                
                JOptionPane.showMessageDialog(rootPane, "Compra de Presupuesto Registrada Exitosamente", "Compra Presupuesto", JOptionPane.INFORMATION_MESSAGE);

                //Redirigir A Pago

            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Error al Registrar Compra de Presupuesto", "Presupuesto", JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Presupuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Presupuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Presupuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Presupuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Presupuesto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_Confirmar;
    private javax.swing.JComboBox jComboBoxTiendas;
    private javax.swing.JLabel jLabelPVP;
    private javax.swing.JLabel jLabel_Agregar;
    private javax.swing.JLabel jLabel_Cliente;
    private javax.swing.JLabel jLabel_Eliminar;
    private javax.swing.JLabel jLabel_Foto;
    private javax.swing.JLabel jLabel_MontoTotal;
    private javax.swing.JLabel jLabel_NombreCliente;
    private javax.swing.JLabel jLabel_NroCarnet;
    private javax.swing.JLabel jLabel_NroCarnetCliente;
    private javax.swing.JLabel jLabel_Producto;
    private javax.swing.JLabel jLabel_Productos;
    private javax.swing.JLabel jLabel_Tienda;
    private javax.swing.JLabel jLabel_Usuario;
    private javax.swing.JLabel jLabel_UsuarioCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}