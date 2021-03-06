
package soft.java.interfaces;

import java.awt.MouseInfo;
import java.awt.Point;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import soft.java.conection.MySQLConnection;



public class RegistryServices extends javax.swing.JFrame {

    int x, y;
    
    // conector a la Base de datos
    MySQLConnection conex = new MySQLConnection();
    Connection con = conex.getConnectionBD();
    
    public RegistryServices() {
        this.setUndecorated(true);
        initComponents();
        setTitle("Registro Servicios");
        setIconImage(new ImageIcon(getClass().getResource("/soft/java/files/logo-fifasm.png")).getImage());
        this.setLocationRelativeTo(null);
        bloquear();
        ShowTable();
    }

    
    // Metodo para bloquear campos de texto y botones
    void bloquear(){
        txt_nombre_serv.setEditable(false);
        txa_descipcion_serv.setEditable(false);
        txt_precio_serv.setEditable(false);
            btn_enable.setEnabled(true);
            btn_disable.setEnabled(false);
            btn_add.setEnabled(false);
            btn_modified.setEnabled(false);
            btn_update.setEnabled(false);
            btn_delete.setEnabled(false);
    }
    
    // Metodo para desbloquear campos de texto y botones
    void desbloquear(){
        txt_nombre_serv.setEditable(true);
        txa_descipcion_serv.setEditable(true);
        txt_precio_serv.setEditable(true);
            btn_enable.setEnabled(false);
            btn_disable.setEnabled(true);
            btn_add.setEnabled(true);
            btn_modified.setEnabled(true);
            btn_update.setEnabled(true);
            btn_delete.setEnabled(true);
    }
    
    // Metodo para limpiar los campos de textos
    void limpiar(){
        txt_nombre_serv.setText("");
        txa_descipcion_serv.setText("");
        txt_precio_serv.setText("");
        txt_buscar.setText("");
    }
    
    
    // Metodo para mostrar la tabla de la Base Datos 
    void ShowTable(){
        DefaultTableModel modelo = new DefaultTableModel(); 
            modelo.addColumn("Id servicio");
            modelo.addColumn("Nombre servicio");
            modelo.addColumn("Descripcion servicio");
            modelo.addColumn("Precio del servicio");
                table_services.setModel(modelo);         
            String sql = "SELECT id_servicio, nombre_servicio, descripcion_servicio, precio_servicio FROM servicios;";
            String datos[] = new String[4];
            Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
                while (rs.next()){
                    datos[0] = rs.getString(1); /*ID Servicio*/
                    datos[1] = rs.getString(2); /*Nombre servicio*/
                    datos[2] = rs.getString(3); /*Descripcion servicio*/
                    datos[3] = rs.getString(4); /*Precio del servicio*/
                        modelo.addRow(datos);
                }
                 table_services.setModel(modelo);
                 TableColumnModel columnModel = table_services.getColumnModel();
                    columnModel.getColumn(0).setPreferredWidth(20);
                    columnModel.getColumn(1).setPreferredWidth(50);
                    columnModel.getColumn(2).setPreferredWidth(50);
                    columnModel.getColumn(3).setPreferredWidth(50);
                
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
        txt_nombre_serv = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_precio_serv = new javax.swing.JTextField();
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
        table_services = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txa_descipcion_serv = new javax.swing.JTextArea();

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
        jLabel22.setText("Registro Servicios");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 879, Short.MAX_VALUE)
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

        jLabel3.setText("Servicio");

        txt_nombre_serv.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_nombre_serv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombre_servActionPerformed(evt);
            }
        });
        txt_nombre_serv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombre_servKeyTyped(evt);
            }
        });

        jLabel4.setText("Descripción del");

        jLabel9.setText("Servicio");

        jLabel16.setText("Precio");

        jLabel17.setText("Unitario");

        txt_precio_serv.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_precio_serv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_precio_servActionPerformed(evt);
            }
        });
        txt_precio_serv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_precio_servKeyTyped(evt);
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

        table_services.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        table_services.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_services.setGridColor(new java.awt.Color(255, 255, 255));
        table_services.setRowHeight(25);
        jScrollPane1.setViewportView(table_services);

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

        txa_descipcion_serv.setColumns(20);
        txa_descipcion_serv.setRows(5);
        txa_descipcion_serv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txa_descipcion_servKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txa_descipcion_serv);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_precio_serv)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addComponent(txt_nombre_serv, javax.swing.GroupLayout.Alignment.TRAILING))
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
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_nombre_serv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_precio_serv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 1190, 660));

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

    private void btn_disableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_disableActionPerformed
        // Boton Cancelar
        bloquear();
        limpiar();
    }//GEN-LAST:event_btn_disableActionPerformed

    private void btn_enableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enableActionPerformed
        // Boton Enable
        desbloquear();
    }//GEN-LAST:event_btn_enableActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // Boton Eliminar
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar?", "Advertencia", dialog);
        if (result == 0) {
            int fila = table_services.getSelectedRow();
            String valor = table_services.getValueAt(fila, 0).toString();
            if(fila>=0){
                try {
                    PreparedStatement pps = con.prepareStatement("DELETE FROM servicios WHERE id_servicio='"+valor+"'");
                    pps.executeUpdate();
                    pps.close();
                    JOptionPane.showMessageDialog(null, "Dato Eliminado");
                    ShowTable();
                } catch (SQLException ex) {
                    Logger.getLogger(RegistryServices.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // Boton Actualizar
         try {                                                                   
            PreparedStatement pps = con.prepareStatement("UPDATE servicios SET nombre_servicio='"+txt_nombre_serv.getText()+"',descripcion_servicio='"+txa_descipcion_serv.getText()
                +"',precio_servicio='"+txt_precio_serv.getText()
                +"' WHERE id_servicio ='"+txt_buscar.getText()+"'");
            pps.executeUpdate();
            pps.close();
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            limpiar();
            ShowTable();
            bloquear();
        } catch (SQLException ex) {
            Logger.getLogger(RegistryServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_modifiedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifiedActionPerformed
        // Boton Modificar
        int fila = table_services.getSelectedRow();
        if(fila>=0){
            txt_buscar.setText(table_services.getValueAt(fila, 0).toString());
            txt_nombre_serv.setText(table_services.getValueAt(fila, 1).toString());
            txa_descipcion_serv.setText(table_services.getValueAt(fila, 2).toString());
            txt_precio_serv.setText(table_services.getValueAt(fila, 3).toString());
            btn_add.setEnabled(false);
            btn_delete.setEnabled(false);
            btn_modified.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }
    }//GEN-LAST:event_btn_modifiedActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // Boton Guardar
        // Registro para Tabla - Servicio
        try {
            PreparedStatement pps = con.prepareStatement("INSERT INTO servicios (nombre_servicio, descripcion_servicio, precio_servicio) VALUES (?,?,?)");
            pps.setString(1, txt_nombre_serv.getText());
            pps.setString(2, txa_descipcion_serv.getText());
            pps.setString(3, txt_precio_serv.getText());
                pps.executeUpdate();
                pps.close();
                JOptionPane.showMessageDialog(null, "Datos Almacenados");
                limpiar();
                bloquear();
                ShowTable();
        } catch (SQLException ex) {
            Logger.getLogger(RegistryServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void txt_precio_servKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_precio_servKeyTyped
        char inputText = evt.getKeyChar();
        int characterLimit = 10;
        if (inputText<'0' || inputText>'9') evt.consume();
        if (txt_precio_serv.getText().length() >= characterLimit){
            evt.consume();
        }
    }//GEN-LAST:event_txt_precio_servKeyTyped

    private void txt_precio_servActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_precio_servActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_precio_servActionPerformed

    private void txt_nombre_servKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombre_servKeyTyped
        // Limite caracteres placa
        int characterLimit = 15;
        if (txt_nombre_serv.getText().length() >= characterLimit){
            evt.consume();
        }
    }//GEN-LAST:event_txt_nombre_servKeyTyped

    private void txt_nombre_servActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombre_servActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombre_servActionPerformed

    private void txa_descipcion_servKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txa_descipcion_servKeyTyped
        int characterLimit = 149;
        if (txa_descipcion_serv.getText().length() >= characterLimit){
            evt.consume();
        }
    }//GEN-LAST:event_txa_descipcion_servKeyTyped

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
            java.util.logging.Logger.getLogger(RegistryServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistryServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistryServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistryServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistryServices().setVisible(true);
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
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_services;
    private javax.swing.JTextArea txa_descipcion_serv;
    private javax.swing.JTextField txt_buscar;
    public static javax.swing.JTextField txt_nombre_serv;
    public static javax.swing.JTextField txt_precio_serv;
    // End of variables declaration//GEN-END:variables

}
