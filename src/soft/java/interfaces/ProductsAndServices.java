
package soft.java.interfaces;

import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.JOptionPane;


public class ProductsAndServices extends javax.swing.JFrame {

    int x, y;
    
    public ProductsAndServices() {
        this.setUndecorated(true);
        initComponents();
        setTitle("Productos y Servicios");
        this.setLocationRelativeTo(null);
        
    }

 
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_placa = new javax.swing.JTextField();
        txt_placa1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jcb_vehiculo = new javax.swing.JComboBox<>();
        jcb_vehiculo1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jcb_vehiculo2 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jcb_vehiculo3 = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        txt_placa2 = new javax.swing.JTextField();
        txt_placa3 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btn_ingreso = new javax.swing.JButton();
        btn_ingreso1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jcb_vehiculo4 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jcb_vehiculo5 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        txt_placa4 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_placa5 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txt_placa6 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txt_placa8 = new javax.swing.JTextField();
        txt_placa7 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btn_liquidacion = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_venta = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

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

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(239, 243, 246));
        jLabel25.setText("Producto y Servicio");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 864, Short.MAX_VALUE)
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
                    .addComponent(jLabel25)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

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

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/soft/java/files/search32px.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel5.setText("Estado del");

        jLabel8.setText("Producto");

        txt_placa.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_placa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_placaActionPerformed(evt);
            }
        });
        txt_placa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_placaKeyTyped(evt);
            }
        });

        txt_placa1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_placa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_placa1ActionPerformed(evt);
            }
        });
        txt_placa1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_placa1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(txt_placa, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel4)
                .addGap(96, 96, 96)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_placa1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(317, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_placa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_placa1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel4)))
                        .addGap(3, 3, 3)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 1190, 80));

        jPanel1.setBackground(new java.awt.Color(239, 243, 246));

        jLabel9.setText("Tipo de");

        jLabel10.setText("Producto");

        jcb_vehiculo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jcb_vehiculo.setPreferredSize(new java.awt.Dimension(33, 35));

        jcb_vehiculo1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jcb_vehiculo1.setPreferredSize(new java.awt.Dimension(33, 35));

        jLabel11.setText("Tamaño");

        jcb_vehiculo2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jcb_vehiculo2.setPreferredSize(new java.awt.Dimension(33, 35));

        jLabel12.setText("Categoria");

        jLabel13.setText("Estilo");

        jcb_vehiculo3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jcb_vehiculo3.setPreferredSize(new java.awt.Dimension(33, 35));

        jLabel14.setText("Cantidad a comprar");

        txt_placa2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_placa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_placa2ActionPerformed(evt);
            }
        });
        txt_placa2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_placa2KeyTyped(evt);
            }
        });

        txt_placa3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_placa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_placa3ActionPerformed(evt);
            }
        });
        txt_placa3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_placa3KeyTyped(evt);
            }
        });

        jLabel15.setText("Valor");

        jLabel16.setText("Unitario");

        jPanel8.setBackground(new java.awt.Color(239, 243, 246));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(112, 112, 112)));

        btn_ingreso.setBackground(new java.awt.Color(255, 255, 255));
        btn_ingreso.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btn_ingreso.setForeground(new java.awt.Color(112, 112, 112));
        btn_ingreso.setText("Añadir servicio");
        btn_ingreso.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(112, 112, 112), null));
        btn_ingreso.setBorderPainted(false);
        btn_ingreso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ingreso.setFocusPainted(false);
        btn_ingreso.setPreferredSize(new java.awt.Dimension(170, 28));
        btn_ingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresoActionPerformed(evt);
            }
        });

        btn_ingreso1.setBackground(new java.awt.Color(255, 255, 255));
        btn_ingreso1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btn_ingreso1.setForeground(new java.awt.Color(112, 112, 112));
        btn_ingreso1.setText("Cancelar");
        btn_ingreso1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(112, 112, 112), null));
        btn_ingreso1.setBorderPainted(false);
        btn_ingreso1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ingreso1.setFocusPainted(false);
        btn_ingreso1.setPreferredSize(new java.awt.Dimension(170, 28));
        btn_ingreso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingreso1ActionPerformed(evt);
            }
        });

        jLabel17.setText("Servicio");

        jcb_vehiculo4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jcb_vehiculo4.setPreferredSize(new java.awt.Dimension(33, 35));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcb_vehiculo4, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ingreso1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ingreso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcb_vehiculo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap())
        );

        jLabel18.setText("Modo de pago");

        jcb_vehiculo5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jcb_vehiculo5.setPreferredSize(new java.awt.Dimension(33, 35));

        jLabel19.setText("Total pago");

        txt_placa4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_placa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_placa4ActionPerformed(evt);
            }
        });
        txt_placa4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_placa4KeyTyped(evt);
            }
        });

        jLabel20.setText("Efectivo");

        txt_placa5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_placa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_placa5ActionPerformed(evt);
            }
        });
        txt_placa5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_placa5KeyTyped(evt);
            }
        });

        jLabel21.setText("Valor por");

        jLabel22.setText("Servicio");

        txt_placa6.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_placa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_placa6ActionPerformed(evt);
            }
        });
        txt_placa6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_placa6KeyTyped(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(239, 243, 246));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(112, 112, 112)));

        jLabel23.setText("Cantidad restante");

        jLabel24.setText("Cambio devolución");

        txt_placa8.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_placa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_placa8ActionPerformed(evt);
            }
        });
        txt_placa8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_placa8KeyTyped(evt);
            }
        });

        txt_placa7.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_placa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_placa7ActionPerformed(evt);
            }
        });
        txt_placa7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_placa7KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addGap(32, 32, 32)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_placa7, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(txt_placa8))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_placa7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_placa8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcb_vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcb_vehiculo1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(152, 152, 152)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcb_vehiculo3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcb_vehiculo2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addGap(18, 18, 18)
                                    .addComponent(txt_placa2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jcb_vehiculo5, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel19)
                                        .addComponent(jLabel20))
                                    .addGap(32, 32, 32)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_placa4)
                                        .addComponent(txt_placa5)))))
                        .addGap(154, 154, 154)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel21))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_placa6)
                                    .addComponent(txt_placa3, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1025, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 79, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcb_vehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcb_vehiculo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcb_vehiculo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jcb_vehiculo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_placa2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16))
                    .addComponent(txt_placa3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_placa6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jcb_vehiculo5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_placa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_placa5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(54, 54, 54))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 1190, 480));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(112, 112, 112)));

        btn_liquidacion.setBackground(new java.awt.Color(255, 255, 255));
        btn_liquidacion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_liquidacion.setForeground(new java.awt.Color(49, 56, 62));
        btn_liquidacion.setText("Generar liquidación");
        btn_liquidacion.setBorderPainted(false);
        btn_liquidacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_liquidacion.setPreferredSize(new java.awt.Dimension(189, 50));
        btn_liquidacion.setRequestFocusEnabled(false);
        btn_liquidacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_liquidacionActionPerformed(evt);
            }
        });

        btn_cancelar.setBackground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(49, 56, 62));
        btn_cancelar.setText("Cancelar");
        btn_cancelar.setBorderPainted(false);
        btn_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelar.setPreferredSize(new java.awt.Dimension(189, 50));
        btn_cancelar.setRequestFocusEnabled(false);
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_venta.setBackground(new java.awt.Color(255, 255, 255));
        btn_venta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_venta.setForeground(new java.awt.Color(49, 56, 62));
        btn_venta.setText("Nueva venta");
        btn_venta.setBorderPainted(false);
        btn_venta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_venta.setPreferredSize(new java.awt.Dimension(189, 50));
        btn_venta.setRequestFocusEnabled(false);
        btn_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ventaActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(btn_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btn_liquidacion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_liquidacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(517, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 614, 1190, 100));

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

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
       // Mouse Pressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // Mouse Dragged
        Point p = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(p.x - x, p.y - y);
    }//GEN-LAST:event_formMouseDragged

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
         // Boton volver
        MainMenu mainmenu = new MainMenu();
        mainmenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btn_liquidacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_liquidacionActionPerformed

    }//GEN-LAST:event_btn_liquidacionActionPerformed

    private void btn_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ventaActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void txt_placaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_placaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_placaActionPerformed

    private void txt_placaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placaKeyTyped

    }//GEN-LAST:event_txt_placaKeyTyped

    private void txt_placa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_placa1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_placa1ActionPerformed

    private void txt_placa1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placa1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_placa1KeyTyped

    private void txt_placa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_placa2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_placa2ActionPerformed

    private void txt_placa2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placa2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_placa2KeyTyped

    private void txt_placa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_placa3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_placa3ActionPerformed

    private void txt_placa3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placa3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_placa3KeyTyped

    private void btn_ingresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresoActionPerformed
        // Boton Dar ingreso
        
    }//GEN-LAST:event_btn_ingresoActionPerformed

    private void btn_ingreso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingreso1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ingreso1ActionPerformed

    private void txt_placa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_placa4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_placa4ActionPerformed

    private void txt_placa4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placa4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_placa4KeyTyped

    private void txt_placa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_placa5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_placa5ActionPerformed

    private void txt_placa5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placa5KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_placa5KeyTyped

    private void txt_placa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_placa6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_placa6ActionPerformed

    private void txt_placa6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placa6KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_placa6KeyTyped

    private void txt_placa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_placa7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_placa7ActionPerformed

    private void txt_placa7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placa7KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_placa7KeyTyped

    private void txt_placa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_placa8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_placa8ActionPerformed

    private void txt_placa8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placa8KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_placa8KeyTyped

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
            java.util.logging.Logger.getLogger(ProductsAndServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductsAndServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductsAndServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductsAndServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductsAndServices().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_ingreso;
    private javax.swing.JButton btn_ingreso1;
    private javax.swing.JButton btn_liquidacion;
    private javax.swing.JButton btn_venta;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
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
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> jcb_vehiculo;
    private javax.swing.JComboBox<String> jcb_vehiculo1;
    private javax.swing.JComboBox<String> jcb_vehiculo2;
    private javax.swing.JComboBox<String> jcb_vehiculo3;
    private javax.swing.JComboBox<String> jcb_vehiculo4;
    private javax.swing.JComboBox<String> jcb_vehiculo5;
    public static javax.swing.JTextField txt_placa;
    public static javax.swing.JTextField txt_placa1;
    public static javax.swing.JTextField txt_placa2;
    public static javax.swing.JTextField txt_placa3;
    public static javax.swing.JTextField txt_placa4;
    public static javax.swing.JTextField txt_placa5;
    public static javax.swing.JTextField txt_placa6;
    public static javax.swing.JTextField txt_placa7;
    public static javax.swing.JTextField txt_placa8;
    // End of variables declaration//GEN-END:variables
}
