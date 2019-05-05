
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import soft.java.conection.MySQLConnection;


public class RegistryDifunto extends javax.swing.JFrame {
    
    int x, y;
    
    // conector a la Base de datos
    MySQLConnection conex = new MySQLConnection();
    Connection con = conex.getConnectionBD();
        
    
    public RegistryDifunto() {
        this.setUndecorated(true);
        initComponents();
        setTitle("Matricula Difunto");
        this.setLocationRelativeTo(null);
        bloquear();
        ShowTable();
    }
    
    // Metodo para bloquear campos de texto y botones
    void bloquear(){
        txt_name_clien.setEditable(false);
        txt_apellido_clien.setEditable(false);
        txt_typedocu_clien.setEditable(false);
        txt_num_clien.setEditable(false);
        txt_name_difun.setEditable(false);
        txt_apellido_difun.setEditable(false);
        txt_nacimiento_difun.setEditable(false);
        txt_kill_difun.setEditable(false);
        txt_msm_difun.setEditable(false);
            btn_enable.setEnabled(true);
            btn_disable.setEnabled(false);
            btn_add.setEnabled(false);
            btn_modified.setEnabled(false);
            btn_update.setEnabled(false);
            btn_delete.setEnabled(false);
    }
    
    // Metodo para desbloquear campos de texto y botones
    void desbloquear(){
       txt_name_clien.setEditable(true);
       txt_apellido_clien.setEditable(true);
       txt_typedocu_clien.setEditable(true);
       txt_num_clien.setEditable(true);
       txt_name_difun.setEditable(true);
       txt_apellido_difun.setEditable(true);
       txt_nacimiento_difun.setEditable(true);
       txt_kill_difun.setEditable(true);
       txt_msm_difun.setEditable(true);
           btn_enable.setEnabled(false);
           btn_disable.setEnabled(true);
           btn_add.setEnabled(true);
           btn_modified.setEnabled(true);
           btn_update.setEnabled(true);
           btn_delete.setEnabled(true);
   }
    
    // Metodo para limpiar los campos de textos
    void limpiar(){
        txt_name_clien.setText("");
        txt_apellido_clien.setText("");
        txt_typedocu_clien.setText("");
        txt_num_clien.setText("");
        txt_name_difun.setText("");
        txt_apellido_difun.setText("");
        txt_nacimiento_difun.setText("");
        txt_kill_difun.setText("");
        txt_msm_difun.setText("");
        txt_buscar.setText("");
    }
    

    // Metodo para mostrar la tabla de la Base Datos 
    void ShowTable(){
        DefaultTableModel modelo = new DefaultTableModel(); 
            modelo.addColumn("Id cliente");
            modelo.addColumn("Nombre cliente");
            modelo.addColumn("Apellido cliente");
            modelo.addColumn("Tipo documento");
            modelo.addColumn("Número documento");
            modelo.addColumn("Nombre difunto");
            modelo.addColumn("Apellido difunto");
            modelo.addColumn("Fecha nacimiento");
            modelo.addColumn("Fecha Fallecimiento");
            modelo.addColumn("Mensaje");
                table_client_difun.setModel(modelo);         
            String sql = "SELECT id_cliente, nombre_cliente, apellido_cliente, tipo_documento, numero_documento, nombre_difunto, apellido_difunto, fecha_nacimiento, fecha_fallecimiento, msm_recordatorio, estado_cliente FROM cliente_solicitante;";
            String datos[] = new String[10];
            Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
                while (rs.next()){
                    datos[0] = rs.getString(1); /*ID Cliente*/
                    datos[1] = rs.getString(2); /*Nombre cliente*/
                    datos[2] = rs.getString(3); /*Apellido Cliente*/
                    datos[3] = rs.getString(4); /*Tipo documento*/
                    datos[4] = rs.getString(5); /*Numero documento*/
                    datos[5] = rs.getString(6); /*Nombre difunto*/
                    datos[6] = rs.getString(7); /*Apellido difunto*/
                    datos[7] = rs.getString(8); /*Fecha nacimiento*/
                    datos[8] = rs.getString(9); /*Fecha fallecimiento*/
                    datos[9] = rs.getString(10); /*Mensaje*/
                        modelo.addRow(datos);
                }
                 table_client_difun.setModel(modelo);  
                
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_client_difun = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_name_clien = new javax.swing.JTextField();
        txt_apellido_clien = new javax.swing.JTextField();
        txt_typedocu_clien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_num_clien = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btn_add = new javax.swing.JButton();
        btn_modified = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btn_enable = new javax.swing.JButton();
        btn_disable = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_name_difun = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_apellido_difun = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_nacimiento_difun = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_kill_difun = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_msm_difun = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();

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
        jLabel22.setText("Matricula Difunto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 891, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        table_client_difun.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        table_client_difun.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_client_difun.setGridColor(new java.awt.Color(255, 255, 255));
        table_client_difun.setRowHeight(25);
        jScrollPane1.setViewportView(table_client_difun);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1178, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 1190, 220));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Nombre del");

        jLabel3.setText("Cliente");

        jLabel5.setText("Apellido del");

        jLabel8.setText("Cliente");

        txt_name_clien.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_name_clien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_name_clienActionPerformed(evt);
            }
        });
        txt_name_clien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_name_clienKeyTyped(evt);
            }
        });

        txt_apellido_clien.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_apellido_clien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_apellido_clienActionPerformed(evt);
            }
        });
        txt_apellido_clien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apellido_clienKeyTyped(evt);
            }
        });

        txt_typedocu_clien.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_typedocu_clien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_typedocu_clienActionPerformed(evt);
            }
        });
        txt_typedocu_clien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_typedocu_clienKeyTyped(evt);
            }
        });

        jLabel4.setText("Tipo de");

        jLabel9.setText("Documento");

        txt_num_clien.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_num_clien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_num_clienActionPerformed(evt);
            }
        });
        txt_num_clien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_num_clienKeyTyped(evt);
            }
        });

        jLabel10.setText("Numero de");

        jLabel11.setText("Documento");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(txt_name_clien, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(txt_typedocu_clien, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(138, 138, 138)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addComponent(txt_num_clien, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(txt_apellido_clien, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(305, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_name_clien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_apellido_clien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(3, 3, 3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txt_typedocu_clien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_num_clien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 1190, 140));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
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

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel12.setText("ID");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, -1, -1));

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

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 1190, 80));

        jPanel6.setBackground(new java.awt.Color(239, 243, 246));

        jLabel13.setText("Nombre del");

        jLabel14.setText("Difunto");

        txt_name_difun.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_name_difun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_name_difunActionPerformed(evt);
            }
        });
        txt_name_difun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_name_difunKeyTyped(evt);
            }
        });

        jLabel15.setText("Apellido del");

        jLabel16.setText("Difunto");

        txt_apellido_difun.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_apellido_difun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_apellido_difunActionPerformed(evt);
            }
        });
        txt_apellido_difun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apellido_difunKeyTyped(evt);
            }
        });

        jLabel17.setText("Fecha de");

        jLabel18.setText("Nacimiento");

        txt_nacimiento_difun.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_nacimiento_difun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nacimiento_difunActionPerformed(evt);
            }
        });
        txt_nacimiento_difun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nacimiento_difunKeyTyped(evt);
            }
        });

        jLabel19.setText("Fecha de");

        jLabel20.setText("Fallecimiento");

        txt_kill_difun.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_kill_difun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kill_difunActionPerformed(evt);
            }
        });
        txt_kill_difun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_kill_difunKeyTyped(evt);
            }
        });

        txt_msm_difun.setColumns(20);
        txt_msm_difun.setRows(5);
        jScrollPane2.setViewportView(txt_msm_difun);

        jLabel21.setText("Mensaje");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addComponent(txt_name_difun, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(txt_nacimiento_difun, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))))
                .addGap(138, 138, 138)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_apellido_difun, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(txt_kill_difun))
                .addContainerGap(305, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_name_difun, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_apellido_difun, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_nacimiento_difun, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_kill_difun, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel21)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 1190, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // Boton volver
        MainMenu mainmenu = new MainMenu();
        mainmenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

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

    private void txt_name_clienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_name_clienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_name_clienActionPerformed

    private void txt_name_clienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_name_clienKeyTyped
        // Limite caracteres placa
        int characterLimit = 15;
        if (txt_name_clien.getText().length() >= characterLimit){
            evt.consume();
        }
    }//GEN-LAST:event_txt_name_clienKeyTyped

    private void txt_apellido_clienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_apellido_clienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_apellido_clienActionPerformed

    private void txt_apellido_clienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellido_clienKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_apellido_clienKeyTyped

    private void txt_typedocu_clienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_typedocu_clienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_typedocu_clienActionPerformed

    private void txt_typedocu_clienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_typedocu_clienKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_typedocu_clienKeyTyped

    private void txt_num_clienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_num_clienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_num_clienActionPerformed

    private void txt_num_clienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_num_clienKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_num_clienKeyTyped

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // Boton Guardar
        
        // Registro para Tabla - Cliente solicitante
        try {
            PreparedStatement pps = con.prepareStatement("INSERT INTO cliente_solicitante (nombre_cliente, apellido_cliente, tipo_documento, numero_documento, nombre_difunto, apellido_difunto, fecha_nacimiento, fecha_fallecimiento, msm_recordatorio) VALUES (?,?,?,?,?,?,?,?,?)");
            pps.setString(1, txt_name_clien.getText());
            pps.setString(2, txt_apellido_clien.getText());
            pps.setString(3, txt_typedocu_clien.getText());
            pps.setString(4, txt_num_clien.getText());
            pps.setString(5, txt_name_difun.getText());
            pps.setString(6, txt_apellido_difun.getText());
            pps.setString(7, txt_nacimiento_difun.getText());
            pps.setString(8, txt_kill_difun.getText());
            pps.setString(9, txt_msm_difun.getText());
                pps.executeUpdate();
                pps.close();
                JOptionPane.showMessageDialog(null, "Datos Almacenados");
                limpiar();
                bloquear();
                ShowTable();
        } catch (SQLException ex) {
            Logger.getLogger(RegistryDifunto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_modifiedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifiedActionPerformed
        // Boton Modificar
        int fila = table_client_difun.getSelectedRow();
        if(fila>=0){
            txt_buscar.setText(table_client_difun.getValueAt(fila, 0).toString());
            txt_name_clien.setText(table_client_difun.getValueAt(fila, 1).toString());
            txt_apellido_clien.setText(table_client_difun.getValueAt(fila, 2).toString());
            txt_typedocu_clien.setText(table_client_difun.getValueAt(fila, 3).toString());
            txt_num_clien.setText(table_client_difun.getValueAt(fila, 4).toString());
            txt_name_difun.setText(table_client_difun.getValueAt(fila, 5).toString());
            txt_apellido_difun.setText(table_client_difun.getValueAt(fila, 6).toString());
            txt_nacimiento_difun.setText(table_client_difun.getValueAt(fila, 7).toString());
            txt_kill_difun.setText(table_client_difun.getValueAt(fila, 8).toString());
            txt_msm_difun.setText(table_client_difun.getValueAt(fila, 9).toString());
            
            
            btn_add.setEnabled(false);
            btn_delete.setEnabled(false);
            btn_modified.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }
        
    }//GEN-LAST:event_btn_modifiedActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // Boton Actualizar
        try {                                                                   
            PreparedStatement pps = con.prepareStatement("UPDATE cliente_solicitante SET nombre_cliente='"+txt_name_clien.getText()+"',apellido_cliente='"+txt_apellido_clien.getText()
                +"',tipo_documento='"+txt_typedocu_clien.getText()+"',numero_documento='"+txt_num_clien.getText()
                +"',nombre_difunto='"+txt_name_difun.getText()+"',apellido_difunto='"+txt_apellido_difun.getText()
                +"',fecha_nacimiento='"+txt_nacimiento_difun.getText()+"',fecha_fallecimiento='"+txt_kill_difun.getText()
                +"',msm_recordatorio='"+txt_msm_difun.getText()
                +"' WHERE id_cliente ='"+txt_buscar.getText()+"'");
            pps.executeUpdate();
            pps.close();
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            limpiar();
            ShowTable();
            bloquear();
        } catch (SQLException ex) {
            Logger.getLogger(RegistryDifunto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // Boton Eliminar
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar?", "Advertencia", dialog);
        if (result == 0) {
            int fila = table_client_difun.getSelectedRow();
            String valor = table_client_difun.getValueAt(fila, 0).toString();
            if(fila>=0){
                try {
                    PreparedStatement pps = con.prepareStatement("DELETE FROM cliente_solicitante WHERE id_cliente='"+valor+"'");
                    pps.executeUpdate();
                    pps.close();
                    JOptionPane.showMessageDialog(null, "Dato Eliminado");
                    ShowTable();
                } catch (SQLException ex) {
                    Logger.getLogger(RegistryDifunto.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }

    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_enableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enableActionPerformed
        // Boton enable
        desbloquear();
    }//GEN-LAST:event_btn_enableActionPerformed

    private void btn_disableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_disableActionPerformed
        // Boton cancelar
        bloquear();
        limpiar();
    }//GEN-LAST:event_btn_disableActionPerformed

    private void txt_name_difunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_name_difunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_name_difunActionPerformed

    private void txt_name_difunKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_name_difunKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_name_difunKeyTyped

    private void txt_apellido_difunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_apellido_difunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_apellido_difunActionPerformed

    private void txt_apellido_difunKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellido_difunKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_apellido_difunKeyTyped

    private void txt_nacimiento_difunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nacimiento_difunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nacimiento_difunActionPerformed

    private void txt_nacimiento_difunKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nacimiento_difunKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nacimiento_difunKeyTyped

    private void txt_kill_difunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kill_difunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kill_difunActionPerformed

    private void txt_kill_difunKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_kill_difunKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kill_difunKeyTyped

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
            java.util.logging.Logger.getLogger(RegistryDifunto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistryDifunto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistryDifunto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistryDifunto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistryDifunto().setVisible(true);
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
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_client_difun;
    public static javax.swing.JTextField txt_apellido_clien;
    public static javax.swing.JTextField txt_apellido_difun;
    private javax.swing.JTextField txt_buscar;
    public static javax.swing.JTextField txt_kill_difun;
    private javax.swing.JTextArea txt_msm_difun;
    public static javax.swing.JTextField txt_nacimiento_difun;
    public static javax.swing.JTextField txt_name_clien;
    public static javax.swing.JTextField txt_name_difun;
    public static javax.swing.JTextField txt_num_clien;
    public static javax.swing.JTextField txt_typedocu_clien;
    // End of variables declaration//GEN-END:variables
}
