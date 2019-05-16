
package soft.java.interfaces;

import java.awt.MouseInfo;
import java.awt.Point;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import soft.java.conection.MySQLConnection;




public class RegistryProducts extends javax.swing.JFrame {

    int x, y;
    
    // conector a la Base de datos
    MySQLConnection conex = new MySQLConnection();
    Connection con = conex.getConnectionBD();
        
   
    public RegistryProducts() {
        this.setUndecorated(true);
        initComponents();
        setTitle("Registro Productos");
        setIconImage(new ImageIcon(getClass().getResource("/soft/java/files/logo-fifasm.png")).getImage());
        this.setLocationRelativeTo(null);
        bloquear();
        ShowTable();
    }

    // Metodo para obtener la fecha del sistema
    void getFecha(){
       Date currentDate = new Date();
        String dateFormat = "dd-MM-yyyy";
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
            txt_date_produc.setText(String.format(format.format(currentDate), format));
    }
    
    // Metodo para bloquear campos de texto y botones
    void bloquear(){
        txt_name_produc.setEditable(false);
        txt_category_produc.setEditable(false);
        txt_type_produc.setEditable(false);
        txt_tamaño_produc.setEditable(false);
        txt_style_produc.setEditable(false);
        txt_date_produc.setEditable(false);
        txt_price_produc.setEditable(false);
        txt_cantidad_produc.setEditable(false);
            btn_enable.setEnabled(true);
            btn_disable.setEnabled(false);
            btn_add.setEnabled(false);
            btn_modified.setEnabled(false);
            btn_update.setEnabled(false);
            btn_delete.setEnabled(false);
    }
    
    // Metodo para desbloquear campos de texto y botones
    void desbloquear(){
        txt_name_produc.setEditable(true);
        txt_category_produc.setEditable(true);
        txt_type_produc.setEditable(true);
        txt_tamaño_produc.setEditable(true);
        txt_style_produc.setEditable(true);
        txt_price_produc.setEditable(true);
        txt_cantidad_produc.setEditable(true);
            btn_enable.setEnabled(false);
            btn_disable.setEnabled(true);
            btn_add.setEnabled(true);
            btn_modified.setEnabled(true);
            btn_update.setEnabled(true);
            btn_delete.setEnabled(true);
    }
    
    // Metodo para limpiar los campos de textos
    void limpiar(){
        txt_name_produc.setText("");
        txt_category_produc.setText("");
        txt_type_produc.setText("");
        txt_tamaño_produc.setText("");
        txt_style_produc.setText("");
        txt_date_produc.setText("");
        txt_price_produc.setText("");
        txt_cantidad_produc.setText("");
        txt_buscar.setText("");
    }
    
    
    // Metodo para mostrar la tabla de la Base Datos 
    void ShowTable(){
        DefaultTableModel modelo = new DefaultTableModel(); 
            modelo.addColumn("Id producto");
            modelo.addColumn("Nombre producto");
            modelo.addColumn("Categoria");
            modelo.addColumn("Tipo");
            modelo.addColumn("Tamaño");
            modelo.addColumn("Estilo");
            modelo.addColumn("Fecha ingreso");
            modelo.addColumn("Precio unitario");
            modelo.addColumn("Cantidad disponible");
            modelo.addColumn("Estado");
                table_product.setModel(modelo);         
            String sql = "SELECT id_inventario, nombre_producto, tipo_producto, categoria, tamaño_producto, estilo_producto, fecha_ingreso, precio_unitario, cantidad_disponible, estado FROM inventario;";
            String datos[] = new String[10];
            Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
                while (rs.next()){
                    datos[0] = rs.getString(1); /*ID producto*/
                    datos[1] = rs.getString(2); /*Nombre producto*/
                    datos[2] = rs.getString(3); /*Categoria*/
                    datos[3] = rs.getString(4); /*Tipo*/
                    datos[4] = rs.getString(5); /*Tamaño*/
                    datos[5] = rs.getString(6); /*Estilo*/
                    datos[6] = rs.getString(7); /*Fecha ingreso*/
                    datos[7] = rs.getString(8); /*Precio unitario*/
                    datos[8] = rs.getString(9); /*Cantidad disponible*/
                    datos[9] = rs.getString(10); /*Estado*/
                        modelo.addRow(datos);
                }
                 table_product.setModel(modelo);  
                
        } catch (SQLException ex) {
            Logger.getLogger(RegistryDifunto.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_name_produc = new javax.swing.JTextField();
        txt_category_produc = new javax.swing.JTextField();
        txt_type_produc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_tamaño_produc = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_date_produc = new javax.swing.JTextField();
        txt_style_produc = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_price_produc = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_cantidad_produc = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btn_add = new javax.swing.JButton();
        btn_modified = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btn_enable = new javax.swing.JButton();
        btn_disable = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_product = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(33, 52, 67));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/soft/java/files/close24px.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/soft/java/files/minimizar24px.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(239, 243, 246));
        jLabel22.setText("Registro Productos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 866, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 60));

        jPanel3.setBackground(new java.awt.Color(44, 57, 74));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/soft/java/files/regresar64px.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(571, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(25, 25, 25))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 90, 660));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Nombre del");

        jLabel3.setText("Producto");

        jLabel5.setText("Categoria");

        jLabel8.setText("Producto");

        txt_name_produc.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_name_produc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_name_producActionPerformed(evt);
            }
        });
        txt_name_produc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_name_producKeyTyped(evt);
            }
        });

        txt_category_produc.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_category_produc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_category_producActionPerformed(evt);
            }
        });
        txt_category_produc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_category_producKeyTyped(evt);
            }
        });

        txt_type_produc.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_type_produc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_type_producActionPerformed(evt);
            }
        });
        txt_type_produc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_type_producKeyTyped(evt);
            }
        });

        jLabel4.setText("Tipo de");

        jLabel9.setText("Producto");

        txt_tamaño_produc.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_tamaño_produc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tamaño_producActionPerformed(evt);
            }
        });
        txt_tamaño_produc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_tamaño_producKeyTyped(evt);
            }
        });

        jLabel10.setText("Tamaño");

        jLabel11.setText("Producto");

        jLabel12.setText("Estilo de");

        jLabel13.setText("Producto");

        txt_date_produc.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_date_produc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_date_producActionPerformed(evt);
            }
        });
        txt_date_produc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_date_producKeyTyped(evt);
            }
        });

        txt_style_produc.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_style_produc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_style_producActionPerformed(evt);
            }
        });
        txt_style_produc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_style_producKeyTyped(evt);
            }
        });

        jLabel14.setText("Fecha");

        jLabel15.setText("Ingreso");

        jLabel16.setText("Precio");

        jLabel17.setText("Unitario");

        txt_price_produc.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_price_produc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_price_producActionPerformed(evt);
            }
        });
        txt_price_produc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_price_producKeyTyped(evt);
            }
        });

        jLabel18.setText("Cantidad");

        jLabel19.setText("Disponible");

        txt_cantidad_produc.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_cantidad_produc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cantidad_producActionPerformed(evt);
            }
        });
        txt_cantidad_produc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cantidad_producKeyTyped(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(239, 243, 246));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_add.setBackground(new java.awt.Color(255, 255, 255));
        btn_add.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        btn_add.setForeground(new java.awt.Color(49, 56, 62));
        btn_add.setText("Agregar");
        btn_add.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_add.setBorderPainted(false);
        btn_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_add.setFocusable(false);
        btn_add.setMargin(new java.awt.Insets(48, 16, 16, 48));
        btn_add.setPreferredSize(new java.awt.Dimension(160, 40));
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel5.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        btn_modified.setBackground(new java.awt.Color(255, 255, 255));
        btn_modified.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        btn_modified.setForeground(new java.awt.Color(49, 56, 62));
        btn_modified.setText("Modificar");
        btn_modified.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_modified.setBorderPainted(false);
        btn_modified.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_modified.setFocusable(false);
        btn_modified.setMargin(new java.awt.Insets(48, 16, 16, 48));
        btn_modified.setPreferredSize(new java.awt.Dimension(160, 40));
        btn_modified.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifiedActionPerformed(evt);
            }
        });
        jPanel5.add(btn_modified, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));

        btn_update.setBackground(new java.awt.Color(255, 255, 255));
        btn_update.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        btn_update.setForeground(new java.awt.Color(49, 56, 62));
        btn_update.setText("Actualizar");
        btn_update.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_update.setBorderPainted(false);
        btn_update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_update.setFocusable(false);
        btn_update.setMargin(new java.awt.Insets(48, 16, 16, 48));
        btn_update.setPreferredSize(new java.awt.Dimension(160, 40));
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel5.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, -1));

        btn_delete.setBackground(new java.awt.Color(255, 255, 255));
        btn_delete.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(49, 56, 62));
        btn_delete.setText("Eliminar");
        btn_delete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btn_delete.setBorderPainted(false);
        btn_delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_delete.setFocusable(false);
        btn_delete.setMargin(new java.awt.Insets(48, 16, 16, 48));
        btn_delete.setPreferredSize(new java.awt.Dimension(160, 40));
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel5.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, -1, -1));

        txt_buscar.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txt_buscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_buscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_buscar.setEnabled(false);
        txt_buscar.setFocusable(false);
        jPanel5.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 50, -1));

        jLabel20.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel20.setText("ID");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, -1, -1));

        btn_enable.setBackground(new java.awt.Color(255, 255, 255));
        btn_enable.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        btn_enable.setForeground(new java.awt.Color(49, 56, 62));
        btn_enable.setText("Nuevo registro");
        btn_enable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btn_enable.setBorderPainted(false);
        btn_enable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_enable.setFocusable(false);
        btn_enable.setMargin(new java.awt.Insets(48, 16, 16, 48));
        btn_enable.setPreferredSize(new java.awt.Dimension(160, 40));
        btn_enable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enableActionPerformed(evt);
            }
        });

        btn_disable.setBackground(new java.awt.Color(255, 255, 255));
        btn_disable.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        btn_disable.setForeground(new java.awt.Color(49, 56, 62));
        btn_disable.setText("Cancelar");
        btn_disable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btn_disable.setBorderPainted(false);
        btn_disable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_disable.setFocusable(false);
        btn_disable.setMargin(new java.awt.Insets(48, 16, 16, 48));
        btn_disable.setPreferredSize(new java.awt.Dimension(160, 40));
        btn_disable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_disableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btn_enable, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_disable, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_enable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_disable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, 60));

        table_product.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        table_product.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_product.setGridColor(new java.awt.Color(255, 255, 255));
        table_product.setRowHeight(25);
        jScrollPane1.setViewportView(table_product);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_price_produc, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13)
                                .addComponent(jLabel12))
                            .addGap(31, 31, 31)
                            .addComponent(txt_style_produc, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addComponent(txt_name_produc, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_type_produc, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(138, 138, 138)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_category_produc, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel10)
                                .addComponent(jLabel15)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel14)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_date_produc, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_tamaño_produc, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addComponent(txt_cantidad_produc, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_name_produc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_category_produc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(3, 3, 3)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_tamaño_produc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_type_produc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_style_produc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_date_produc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_price_produc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_cantidad_produc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 1190, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea salir del sistema?", "Salir", dialog);
        if (result == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // Boton volver
        MainMenu mainmenu = new MainMenu();
        mainmenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // Mouse Dragged
        Point p = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(p.x - x, p.y - y);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // Mouse Pressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void txt_name_producActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_name_producActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_name_producActionPerformed

    private void txt_name_producKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_name_producKeyTyped
        // Limite caracteres placa
        int characterLimit = 15;
        if (txt_name_produc.getText().length() >= characterLimit){
            evt.consume();
        }
    }//GEN-LAST:event_txt_name_producKeyTyped

    private void txt_category_producActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_category_producActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_category_producActionPerformed

    private void txt_category_producKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_category_producKeyTyped
        int characterLimit = 49;
        if (txt_category_produc.getText().length() >= characterLimit){
            evt.consume();
        }
    }//GEN-LAST:event_txt_category_producKeyTyped

    private void txt_type_producActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_type_producActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_type_producActionPerformed

    private void txt_type_producKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_type_producKeyTyped
        int characterLimit = 49;
        if (txt_type_produc.getText().length() >= characterLimit){
            evt.consume();
        }
    }//GEN-LAST:event_txt_type_producKeyTyped

    private void txt_tamaño_producActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tamaño_producActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tamaño_producActionPerformed

    private void txt_tamaño_producKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tamaño_producKeyTyped
        int characterLimit = 15;
        if (txt_tamaño_produc.getText().length() >= characterLimit){
            evt.consume();
        }
    }//GEN-LAST:event_txt_tamaño_producKeyTyped

    private void txt_date_producActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_date_producActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_date_producActionPerformed

    private void txt_date_producKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_date_producKeyTyped
        int characterLimit = 9;
        if (txt_date_produc.getText().length() >= characterLimit){
            evt.consume();
        }
    }//GEN-LAST:event_txt_date_producKeyTyped

    private void txt_style_producActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_style_producActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_style_producActionPerformed

    private void txt_style_producKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_style_producKeyTyped
        int characterLimit = 15;
        if (txt_style_produc.getText().length() >= characterLimit){
            evt.consume();
        }
    }//GEN-LAST:event_txt_style_producKeyTyped

    private void txt_price_producActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_price_producActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_price_producActionPerformed

    private void txt_price_producKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_price_producKeyTyped
        char inputText = evt.getKeyChar();
        int characterLimit = 10;
        if (inputText<'0' || inputText>'9') evt.consume();
        if (txt_price_produc.getText().length() >= characterLimit){
            evt.consume();
        }
    }//GEN-LAST:event_txt_price_producKeyTyped

    private void txt_cantidad_producActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cantidad_producActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cantidad_producActionPerformed

    private void txt_cantidad_producKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidad_producKeyTyped
        char inputText = evt.getKeyChar();
        int characterLimit = 10;
        if (inputText<'0' || inputText>'9') evt.consume();
        if (txt_cantidad_produc.getText().length() >= characterLimit){
            evt.consume();
        }
    }//GEN-LAST:event_txt_cantidad_producKeyTyped

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // Boton Agregar
        String StatedTrue = "Disponible";
        // Registro para Tabla - Inventario
        try {
            PreparedStatement pps = con.prepareStatement("INSERT INTO inventario (nombre_producto, tipo_producto, categoria, tamaño_producto, estilo_producto, fecha_ingreso, precio_unitario, cantidad_disponible, estado) VALUES (?,?,?,?,?,?,?,?,?);");
            pps.setString(1, txt_name_produc.getText());
            pps.setString(2, txt_type_produc.getText());
            pps.setString(3, txt_category_produc.getText());
            pps.setString(4, txt_tamaño_produc.getText());
            pps.setString(5, txt_style_produc.getText());
            pps.setString(6, txt_date_produc.getText());
            pps.setString(7, txt_price_produc.getText());
            pps.setString(8, txt_cantidad_produc.getText());
            pps.setString(9, StatedTrue);
                pps.executeUpdate();
                pps.close();
                JOptionPane.showMessageDialog(null, "Datos Almacenados");
                limpiar();
                bloquear();
                ShowTable();
        } catch (SQLException ex) {
            Logger.getLogger(RegistryProducts.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_modifiedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifiedActionPerformed
        // Boton Modificar
        int fila = table_product.getSelectedRow();
        if(fila>=0){
            txt_buscar.setText(table_product.getValueAt(fila, 0).toString());
            txt_name_produc.setText(table_product.getValueAt(fila, 1).toString());
            txt_type_produc.setText(table_product.getValueAt(fila, 2).toString());
            txt_category_produc.setText(table_product.getValueAt(fila, 3).toString());
            txt_tamaño_produc.setText(table_product.getValueAt(fila, 4).toString());
            txt_style_produc.setText(table_product.getValueAt(fila, 5).toString());
            txt_date_produc.setText(table_product.getValueAt(fila, 6).toString());
            txt_price_produc.setText(table_product.getValueAt(fila, 7).toString());
            txt_cantidad_produc.setText(table_product.getValueAt(fila, 8).toString());
            
            btn_add.setEnabled(false);
            btn_delete.setEnabled(false);
            btn_modified.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }

    }//GEN-LAST:event_btn_modifiedActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // Boton Actualizar
        String StatedTrue = "Disponible";
        try {                                                                   
            PreparedStatement pps = con.prepareStatement("UPDATE inventario SET nombre_producto='"+txt_name_produc.getText()+"',tipo_producto='"+txt_type_produc.getText()
                +"',categoria='"+txt_category_produc.getText()+"',tamaño_producto='"+txt_tamaño_produc.getText()
                +"',estilo_producto='"+txt_style_produc.getText()+"',fecha_ingreso='"+txt_date_produc.getText()
                +"',precio_unitario='"+txt_price_produc.getText()+"',cantidad_disponible='"+txt_cantidad_produc.getText()+"',estado='"+StatedTrue
                +"' WHERE id_inventario ='"+txt_buscar.getText()+"'");
            pps.executeUpdate();
            pps.close();
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            limpiar();
            ShowTable();
            bloquear();
        } catch (SQLException ex) {
            Logger.getLogger(RegistryProducts.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // Boton Eliminar
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar?", "Advertencia", dialog);
        if (result == 0) {
            int fila = table_product.getSelectedRow();
            String valor = table_product.getValueAt(fila, 0).toString();
            if(fila>=0){
                try {
                    PreparedStatement pps = con.prepareStatement("DELETE FROM inventario WHERE id_inventario='"+valor+"'");
                    pps.executeUpdate();
                    pps.close();
                    JOptionPane.showMessageDialog(null, "Dato Eliminado");
                    ShowTable();
                } catch (SQLException ex) {
                    Logger.getLogger(RegistryProducts.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }

    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_enableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enableActionPerformed
        // Boton Enable
        // Captura la fecha
       getFecha();
       desbloquear();
    }//GEN-LAST:event_btn_enableActionPerformed

    private void btn_disableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_disableActionPerformed
        // Boton cancelar
        bloquear();
        limpiar();
    }//GEN-LAST:event_btn_disableActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistryProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistryProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistryProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistryProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistryProducts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_disable;
    private javax.swing.JButton btn_enable;
    private javax.swing.JButton btn_modified;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_product;
    private javax.swing.JTextField txt_buscar;
    public static javax.swing.JTextField txt_cantidad_produc;
    public static javax.swing.JTextField txt_category_produc;
    public static javax.swing.JTextField txt_date_produc;
    public static javax.swing.JTextField txt_name_produc;
    public static javax.swing.JTextField txt_price_produc;
    public static javax.swing.JTextField txt_style_produc;
    public static javax.swing.JTextField txt_tamaño_produc;
    public static javax.swing.JTextField txt_type_produc;
    // End of variables declaration//GEN-END:variables
}
