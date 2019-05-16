
package soft.java.interfaces;

import java.awt.MouseInfo;
import java.awt.Point;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import soft.java.conection.MySQLConnection;


public class ProductsAndServices extends javax.swing.JFrame {

    int x, y, valuedPay = 0, cashPay = 0, totalPago = 0;
    String currentOutDate = "", selectedPay, selectedService = "", cantidad_disponible;
    
      
    // conector a la Base de datos
    MySQLConnection conex = new MySQLConnection();
    Connection con = conex.getConnectionBD();
        
    
    public ProductsAndServices() {
        this.setUndecorated(true);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/soft/java/files/logo-fifasm.png")).getImage());
        setTitle("Productos y Servicios");
        this.setLocationRelativeTo(null);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
        bloquear();
    }
        
 
    // Metodo para bloquear campos de texto y botones
    void bloquear(){
        txt_nombre_prod.setEditable(false);
        txt_estado_prod.setEditable(false);
        jcb_tipo_prod.setEditable(false);
        jcb_categoria_prod.setEditable(false);
        jcb_tamaño_prod.setEditable(false);
        jcb_estilo_prod.setEditable(false);        
        txt_cantidad_prod.setEditable(false);
        txt_product_dispo.setEditable(false);        
        txt_valor_prod.setEditable(false);
        txt_valor_serv.setEditable(false);
        jcb_servicio.setEditable(false);
        jcb_servicio.setEnabled(false);
        jcb_modo_pago.setEditable(false);
        txt_total_pago.setEditable(false);
        txt_efectivo_pago.setEditable(false);
        txt_cantidad_restant.setEditable(false);
        txt_cambio.setEditable(false);
        jcb_modo_pago.setEditable(false);
            btn_venta.setEnabled(true);
            btn_cancelar.setEnabled(false);
            btn_liquidacion.setEnabled(false); 
            btn_habilited.setEnabled(false);
            btn_añadir_serv.setEnabled(false); 
            btn_cancelar_serv.setEnabled(false); 
    }

     // Metodo para desbloquear campos de texto y botones
    void desbloquear(){
        txt_nombre_prod.setEditable(true);
        txt_estado_prod.setEditable(false);
        jcb_tipo_prod.setEditable(false);
        jcb_categoria_prod.setEditable(false);
        jcb_tamaño_prod.setEditable(false);
        jcb_estilo_prod.setEditable(false);        
        txt_cantidad_prod.setEditable(true);        
        txt_valor_prod.setEditable(false);
        txt_valor_serv.setEditable(false);
        jcb_servicio.setEditable(false);
        jcb_modo_pago.setEditable(true);
        txt_total_pago.setEditable(false);
        txt_efectivo_pago.setEditable(true);
        txt_cantidad_restant.setEditable(false);
        txt_cambio.setEditable(false);
        jcb_modo_pago.setEditable(false);
            btn_venta.setEnabled(false);
            btn_cancelar.setEnabled(true);
            btn_liquidacion.setEnabled(true); 
            btn_habilited.setEnabled(true);
            btn_cancelar_serv.setEnabled(false); 
    }
 
    void limpiar(){
        txt_nombre_prod.setText("");
        txt_estado_prod.setText("");
        txt_cantidad_prod.setText("");
        jcb_tipo_prod.setText("");
        jcb_categoria_prod.setText("");
        jcb_tamaño_prod.setText("");
        jcb_estilo_prod.setText("");
        txt_valor_prod.setText("");
        txt_valor_serv.setText("");
        txt_total_pago.setText("");
        txt_cantidad_restant.setText("");
        txt_cambio.setText("");
        txt_efectivo_pago.setText("");
        txt_product_dispo.setText("");
        jcb_modo_pago.removeAllItems();
        jcb_servicio.removeAllItems();
    }
    
    // Metodo para obtener la fecha del sistema
    void getFecha(){
        Date currentDate = new Date();        
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            this.currentOutDate = dateFormat.format(currentDate);
    }
    
    // Metodo para obtener datos 'tipo servicios' de la base datos
    void getServices(){
        try {
            String sql = "SELECT DISTINCT nombre_servicio FROM servicios";
            PreparedStatement pps = con.prepareStatement(sql);
            ResultSet rs = pps.executeQuery(sql);
                jcb_servicio.addItem("Seleccione servicio");
            while(rs.next()){
                jcb_servicio.addItem(rs.getString("nombre_servicio"));
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No hay resultado");
        }
        selectedService = jcb_servicio.getSelectedItem().toString();
    }
    
  
    // Metodo para obtener el precio del servicio
    void getPriceServices(){
        // Obtiene el valor de campo lista
        String selectedService = jcb_servicio.getSelectedItem().toString();
        String priceService = "";

        try {
            // Consulta en la BD
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT precio_servicio FROM servicios WHERE nombre_servicio = '"+selectedService+"'");
            rs.first();
            // Selecciona los atributos deacuerdo a la posicion de la consulta sql
            priceService = rs.getString(1);
            // Parsea el valor String a Entero
            Integer servicePrice = Integer.parseInt(priceService);
            
            if (!selectedService.equals("Seleccione servicio")) {
                // Suma: Precio servicio + Valor total
                int payMoreService = totalPago + servicePrice;
                String serviceMorePay = Integer.toString(payMoreService);
                
                txt_valor_serv.setText(priceService);
                txt_total_pago.setText(serviceMorePay);
                
                rs.close();
            }
    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un servicio");
        } 
    }
    
    // Metodo para modo de pago
    void modePay(){  
        jcb_modo_pago.addItem("Seleccione modo de pago");
        //jcb_modo_pago.addItem("Por cuota");
        jcb_modo_pago.addItem("Venta directa");
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
        txt_nombre_prod = new javax.swing.JTextField();
        txt_estado_prod = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txt_cantidad_prod = new javax.swing.JTextField();
        txt_valor_prod = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btn_habilited = new javax.swing.JButton();
        btn_cancelar_serv = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jcb_servicio = new javax.swing.JComboBox<>();
        btn_añadir_serv = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jcb_modo_pago = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        txt_total_pago = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_efectivo_pago = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txt_valor_serv = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txt_cambio = new javax.swing.JTextField();
        txt_cantidad_restant = new javax.swing.JTextField();
        jcb_tipo_prod = new javax.swing.JTextField();
        jcb_tamaño_prod = new javax.swing.JTextField();
        jcb_categoria_prod = new javax.swing.JTextField();
        jcb_estilo_prod = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txt_product_dispo = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
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
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setText("Estado del");

        jLabel8.setText("Producto");

        txt_nombre_prod.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_nombre_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombre_prodActionPerformed(evt);
            }
        });
        txt_nombre_prod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombre_prodKeyTyped(evt);
            }
        });

        txt_estado_prod.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_estado_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_estado_prodActionPerformed(evt);
            }
        });
        txt_estado_prod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_estado_prodKeyTyped(evt);
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
                .addComponent(txt_nombre_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(87, 87, 87)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_estado_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_estado_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(3, 3, 3))
                    .addComponent(txt_nombre_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 1190, 80));

        jPanel1.setBackground(new java.awt.Color(239, 243, 246));

        jLabel9.setText("Tipo de");

        jLabel10.setText("Producto");

        jLabel11.setText("Tamaño");

        jLabel12.setText("Categoria");

        jLabel13.setText("Estilo");

        txt_cantidad_prod.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_cantidad_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cantidad_prodActionPerformed(evt);
            }
        });
        txt_cantidad_prod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cantidad_prodKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cantidad_prodKeyTyped(evt);
            }
        });

        txt_valor_prod.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_valor_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_valor_prodActionPerformed(evt);
            }
        });
        txt_valor_prod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_valor_prodKeyTyped(evt);
            }
        });

        jLabel15.setText("Valor");

        jLabel16.setText("Unitario");

        jPanel8.setBackground(new java.awt.Color(239, 243, 246));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(112, 112, 112)));

        btn_habilited.setBackground(new java.awt.Color(255, 255, 255));
        btn_habilited.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btn_habilited.setForeground(new java.awt.Color(112, 112, 112));
        btn_habilited.setText("Habilitar");
        btn_habilited.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(112, 112, 112), null));
        btn_habilited.setBorderPainted(false);
        btn_habilited.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_habilited.setFocusPainted(false);
        btn_habilited.setPreferredSize(new java.awt.Dimension(170, 28));
        btn_habilited.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_habilitedActionPerformed(evt);
            }
        });

        btn_cancelar_serv.setBackground(new java.awt.Color(255, 255, 255));
        btn_cancelar_serv.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btn_cancelar_serv.setForeground(new java.awt.Color(112, 112, 112));
        btn_cancelar_serv.setText("Cancelar");
        btn_cancelar_serv.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(112, 112, 112), null));
        btn_cancelar_serv.setBorderPainted(false);
        btn_cancelar_serv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelar_serv.setFocusPainted(false);
        btn_cancelar_serv.setPreferredSize(new java.awt.Dimension(170, 28));
        btn_cancelar_serv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar_servActionPerformed(evt);
            }
        });

        jLabel17.setText("Servicio");

        jcb_servicio.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jcb_servicio.setPreferredSize(new java.awt.Dimension(33, 35));

        btn_añadir_serv.setBackground(new java.awt.Color(255, 255, 255));
        btn_añadir_serv.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btn_añadir_serv.setForeground(new java.awt.Color(112, 112, 112));
        btn_añadir_serv.setText("Añadir servicio");
        btn_añadir_serv.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(112, 112, 112), null));
        btn_añadir_serv.setBorderPainted(false);
        btn_añadir_serv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_añadir_serv.setFocusPainted(false);
        btn_añadir_serv.setPreferredSize(new java.awt.Dimension(170, 28));
        btn_añadir_serv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadir_servActionPerformed(evt);
            }
        });

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
                        .addComponent(jcb_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_habilited, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancelar_serv, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_añadir_serv, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar_serv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_habilited, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcb_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_añadir_serv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jLabel18.setText("Modo de pago");

        jcb_modo_pago.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jcb_modo_pago.setPreferredSize(new java.awt.Dimension(33, 35));

        jLabel19.setText("Total pago");

        txt_total_pago.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_total_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_pagoActionPerformed(evt);
            }
        });
        txt_total_pago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_total_pagoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_total_pagoKeyTyped(evt);
            }
        });

        jLabel20.setText("Efectivo");

        txt_efectivo_pago.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_efectivo_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_efectivo_pagoActionPerformed(evt);
            }
        });
        txt_efectivo_pago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_efectivo_pagoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_efectivo_pagoKeyTyped(evt);
            }
        });

        jLabel21.setText("Valor por");

        jLabel22.setText("Servicio");

        txt_valor_serv.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_valor_serv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_valor_servActionPerformed(evt);
            }
        });
        txt_valor_serv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_valor_servKeyTyped(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(239, 243, 246));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(112, 112, 112)));

        jLabel23.setText("Deuda pendiente");

        jLabel24.setText("Cambio devolución");

        txt_cambio.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_cambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cambioActionPerformed(evt);
            }
        });
        txt_cambio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cambioKeyTyped(evt);
            }
        });

        txt_cantidad_restant.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_cantidad_restant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cantidad_restantActionPerformed(evt);
            }
        });
        txt_cantidad_restant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cantidad_restantKeyTyped(evt);
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
                    .addComponent(txt_cantidad_restant, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(txt_cambio))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cantidad_restant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jcb_tipo_prod.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jcb_tipo_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_tipo_prodActionPerformed(evt);
            }
        });
        jcb_tipo_prod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jcb_tipo_prodKeyTyped(evt);
            }
        });

        jcb_tamaño_prod.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jcb_tamaño_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_tamaño_prodActionPerformed(evt);
            }
        });
        jcb_tamaño_prod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jcb_tamaño_prodKeyTyped(evt);
            }
        });

        jcb_categoria_prod.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jcb_categoria_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_categoria_prodActionPerformed(evt);
            }
        });
        jcb_categoria_prod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jcb_categoria_prodKeyTyped(evt);
            }
        });

        jcb_estilo_prod.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jcb_estilo_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_estilo_prodActionPerformed(evt);
            }
        });
        jcb_estilo_prod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jcb_estilo_prodKeyTyped(evt);
            }
        });

        jLabel26.setText("Cantidad");

        jLabel27.setText("Compra");

        txt_product_dispo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_product_dispo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_product_dispoActionPerformed(evt);
            }
        });
        txt_product_dispo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_product_dispoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_product_dispoKeyTyped(evt);
            }
        });

        jLabel28.setText("Cantidad");

        jLabel29.setText("Disponible");

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
                            .addComponent(jcb_tipo_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcb_tamaño_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(136, 136, 136)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcb_categoria_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcb_estilo_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(326, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_total_pago, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(txt_efectivo_pago)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcb_modo_pago, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel26)
                                        .addComponent(jLabel27))
                                    .addGap(30, 30, 30)
                                    .addComponent(txt_cantidad_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel28)
                                        .addComponent(jLabel29))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_product_dispo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(120, 120, 120)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel21))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_valor_serv)
                                    .addComponent(txt_valor_prod, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
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
                        .addComponent(jLabel12)
                        .addComponent(jcb_tipo_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcb_categoria_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jcb_tamaño_prod)
                    .addComponent(jcb_estilo_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel16))
                        .addComponent(txt_valor_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_cantidad_prod)
                                .addComponent(txt_product_dispo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29)
                        .addGap(8, 8, 8)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_valor_serv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jcb_modo_pago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_total_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_efectivo_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
        
        int dialog = JOptionPane.YES_NO_OPTION;
        int cantidadRestante;

        String emptyCant = "";
        String txt_cant_prod = txt_cantidad_prod.getText();
        
             
        if (!txt_cant_prod.equals(emptyCant)){

            String payCash = txt_efectivo_pago.getText();
            getFecha();
            
            if (!payCash.equals("")) {
                
                /* -- SE CANCELO ESTA PARTE
                // Si el pago es: Por cuota
                if (selectedPay.equals("Por cuota")){
                    SaleFee salefee = new SaleFee();
                    
                    String name_product,
                            tipo_prod,
                            categoria_prod,
                            tamaño_prod,
                            estilo_prod,
                            cantidad_prod,
                            selectedService,
                            selectedPay,
                            total_pago,
                            efectivo_pago,
                            cant_restant;
                    
                    String deuda_pendiente = txt_cantidad_restant.getText();
                    String stateCliente = "Deuda";

                    // Envia la informacion a la interfaz SaleFee
                    SaleFee.txt_estado.setText(stateCliente);
                    SaleFee.txt_cant_restant.setText(deuda_pendiente);
                    
                    name_product = txt_nombre_prod.getText();
                    tipo_prod = jcb_tipo_prod.getText();
                    categoria_prod = jcb_categoria_prod.getText();
                    tamaño_prod = jcb_tamaño_prod.getText();
                    estilo_prod = jcb_estilo_prod.getText();
                    cantidad_prod = txt_cantidad_prod.getText();
                    //selectedService = jcb_servicio.getSelectedItem().toString();
                    total_pago = txt_total_pago.getText();
                    efectivo_pago = txt_efectivo_pago.getText();
                    cant_restant = txt_cantidad_restant.getText();
                    
                    System.out.println(txt_nombre_prod.getText());
                    salefee.setVisible(true);
                }
                */
                // Si el pago es por: Venta directa
                if (selectedPay.equals("Venta directa")){
                    
                    if (cashPay >= valuedPay){

                        int result = JOptionPane.showConfirmDialog(null, "¿Generar salida del producto?", "Venta" ,dialog);  
                        if (result == 0){

                            String selectedPago = jcb_modo_pago.getSelectedItem().toString();
                             this.selectedService = jcb_servicio.getSelectedItem().toString();
                            
                            int cantidadDisponible = Integer.parseInt(cantidad_disponible);
                            int cantidadCompra = Integer.parseInt(txt_cantidad_prod.getText());

                            cantidadRestante = cantidadDisponible - cantidadCompra;
                            
                            if (selectedService.equals("Seleccione servicio")) {
                                // Registro para Tabla - CAJA
                                try {
                                    // Se actualiza la cantidad disponible del producto en INVENTARIO
                                    PreparedStatement ppsu;
                                    ppsu = con.prepareStatement("UPDATE inventario SET cantidad_disponible='"+cantidadRestante+"' WHERE nombre_producto ='"+txt_nombre_prod.getText()+"'");                                                                         
                                    ppsu.executeUpdate();
                                    ppsu.close();

                                    PreparedStatement pps = con.prepareStatement("INSERT INTO caja (nombre_prod_caja, tipo_prod_caja, categoria_prod_caja, tamaño_prod_caja, estilo_prod_caja, cantidad_compra, modo_pago, total_pago, efectivo, cambio, fecha_salida) VALUES (?,?,?,?,?,?,?,?,?,?,?);");
                                    pps.setString(1, txt_nombre_prod.getText());
                                    pps.setString(2, jcb_tipo_prod.getText());
                                    pps.setString(3, jcb_categoria_prod.getText());
                                    pps.setString(4, jcb_tamaño_prod.getText());
                                    pps.setString(5, jcb_estilo_prod.getText());
                                    pps.setString(6, txt_cantidad_prod.getText());
                                    pps.setString(7, selectedPago);
                                    pps.setString(8, txt_total_pago.getText());
                                    pps.setString(9, txt_efectivo_pago.getText());
                                    pps.setString(10, txt_cambio.getText());
                                    pps.setString(11, currentOutDate);
                                        pps.executeUpdate();
                                        pps.close();
                                        JOptionPane.showMessageDialog(null, "Venta realizada");
                                        limpiar();
                                        bloquear();

                                } catch (SQLException ex) {
                                    Logger.getLogger(ProductsAndServices.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }else{
                                // Registro para Tabla - CAJA
                                try {
                                    // Se actualiza la cantidad disponible del producto en INVENTARIO
                                    PreparedStatement ppsu;
                                    ppsu = con.prepareStatement("UPDATE inventario SET cantidad_disponible='"+cantidadRestante+"' WHERE nombre_producto ='"+txt_nombre_prod.getText()+"'");                                                                         
                                    ppsu.executeUpdate();
                                    ppsu.close();

                                    PreparedStatement pps = con.prepareStatement("INSERT INTO caja (nombre_prod_caja, tipo_prod_caja, categoria_prod_caja, tamaño_prod_caja, estilo_prod_caja, cantidad_compra, tipo_servicio, modo_pago, total_pago, efectivo, cambio, fecha_salida) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);");
                                    pps.setString(1, txt_nombre_prod.getText());
                                    pps.setString(2, jcb_tipo_prod.getText());
                                    pps.setString(3, jcb_categoria_prod.getText());
                                    pps.setString(4, jcb_tamaño_prod.getText());
                                    pps.setString(5, jcb_estilo_prod.getText());
                                    pps.setString(6, txt_cantidad_prod.getText());
                                    pps.setString(7, selectedService);
                                    pps.setString(8, selectedPago);
                                    pps.setString(9, txt_total_pago.getText());
                                    pps.setString(10, txt_efectivo_pago.getText());
                                    pps.setString(11, txt_cambio.getText());
                                    pps.setString(12, currentOutDate);
                                        pps.executeUpdate();
                                        pps.close();
                                        JOptionPane.showMessageDialog(null, "Venta realizada");
                                        limpiar();
                                        bloquear();

                                } catch (SQLException ex) {
                                    Logger.getLogger(ProductsAndServices.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        } 
                    }else{
                        JOptionPane.showMessageDialog(null, "El efectivo ingresado no es valido, Por favor verifique");  
                    }
                }
            }else{
               JOptionPane.showMessageDialog(null, "No ha ingresado efectivo"); 
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar cantidad a comprar");
        }
    }//GEN-LAST:event_btn_liquidacionActionPerformed

    private void btn_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ventaActionPerformed
        // Boton Nueva venta
        txt_nombre_prod.setEditable(true);
        btn_cancelar.setEnabled(true);
        limpiar();
    }//GEN-LAST:event_btn_ventaActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // Boton Cancelar
        bloquear();
        limpiar();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void txt_nombre_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombre_prodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombre_prodActionPerformed

    private void txt_nombre_prodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombre_prodKeyTyped
        int characterLimit = 15;
        if (txt_nombre_prod.getText().length() >= characterLimit){
            evt.consume();
        }
    }//GEN-LAST:event_txt_nombre_prodKeyTyped

    private void txt_estado_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_estado_prodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_estado_prodActionPerformed

    private void txt_estado_prodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_estado_prodKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_estado_prodKeyTyped

    private void txt_cantidad_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cantidad_prodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cantidad_prodActionPerformed

    private void txt_cantidad_prodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidad_prodKeyTyped
        char inputText = evt.getKeyChar();
        int characterLimit = 10;
        if (inputText<'0' || inputText>'9') evt.consume();
        if (txt_cantidad_prod.getText().length() >= characterLimit){
            evt.consume();
        }
    }//GEN-LAST:event_txt_cantidad_prodKeyTyped

    private void txt_valor_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_valor_prodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_valor_prodActionPerformed

    private void txt_valor_prodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valor_prodKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_valor_prodKeyTyped

    private void btn_cancelar_servActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar_servActionPerformed
        // Boton Cancelar servicio
        jcb_servicio.setEnabled(false);
        btn_habilited.setEnabled(true);
        btn_añadir_serv.setEnabled(false);
        txt_valor_serv.setText("");
        btn_cancelar_serv.setEnabled(false);
    }//GEN-LAST:event_btn_cancelar_servActionPerformed

    private void txt_total_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_pagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_pagoActionPerformed

    private void txt_total_pagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_total_pagoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_pagoKeyTyped

    private void txt_efectivo_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_efectivo_pagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_efectivo_pagoActionPerformed

    private void txt_efectivo_pagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_efectivo_pagoKeyTyped
       char inputText = evt.getKeyChar();
        int characterLimit = 10;
        if (inputText<'0' || inputText>'9') evt.consume();
        if (txt_efectivo_pago.getText().length() >= characterLimit){
            evt.consume();
        }
    }//GEN-LAST:event_txt_efectivo_pagoKeyTyped

    private void txt_valor_servActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_valor_servActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_valor_servActionPerformed

    private void txt_valor_servKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valor_servKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_valor_servKeyTyped

    private void txt_cantidad_restantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cantidad_restantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cantidad_restantActionPerformed

    private void txt_cantidad_restantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidad_restantKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cantidad_restantKeyTyped

    private void txt_cambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cambioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cambioActionPerformed

    private void txt_cambioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cambioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cambioKeyTyped

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // Boton buscar- Lupa
        int dialog = JOptionPane.YES_NO_OPTION;
        String emptySearch = "";
        String txt_search = txt_nombre_prod.getText();
        
        if (!txt_search.equals(emptySearch)){
            
             try {
                // Consulta en la BD
                Statement stat = con.createStatement();
                ResultSet rs = stat.executeQuery("SELECT nombre_producto, estado, tipo_producto, categoria, tamaño_producto, estilo_producto, precio_unitario, cantidad_disponible FROM inventario WHERE nombre_producto = '"+txt_search+"'");
                rs.first();
                // Selecciona los atributos deacuerdo a la posicion de la consulta sql
                String name_product = rs.getString(1);
                
                    if (txt_search.equals(name_product)) {
                        int result = JOptionPane.showConfirmDialog(null, "Producto encontrado, ¿Proceder con la venta?", "Generar venta" ,dialog);
                        if (result == 0){ 
                            getServices();
                            
                            String state_product = rs.getString(2);
                            String type_product = rs.getString(3);
                            String category_product = rs.getString(4);
                            String width_product = rs.getString(5);
                            String style_product = rs.getString(6);
                            String precio_unitario = rs.getString(7);

                            cantidad_disponible = rs.getString(8);
                            Integer productDisponible = Integer.parseInt(cantidad_disponible);
                            
                            if (productDisponible == 0) {
                                String StatedFalse = "No disponible";
                                try {                                                                  
                                    PreparedStatement pps;
                                    pps = con.prepareStatement("UPDATE inventario SET estado ='"+StatedFalse+"' WHERE nombre_producto ='"+name_product+"'");                                                                         
                                    pps.executeUpdate();
                                    pps.close();
                                } catch (SQLException ex) {
                                    Logger.getLogger(ProductsAndServices.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                JOptionPane.showMessageDialog(null, "Este producto se encuentra agotado, Por favor verifique el inventario");
                                txt_estado_prod.setText(state_product);
                            }else{
                                modePay();
                                desbloquear();
                            
                                // Bloque campo nombre producto
                                txt_nombre_prod.setEditable(false);
                                // Envio de los datos bd a campos de textos
                                txt_estado_prod.setText(state_product);
                                jcb_tipo_prod.setText(type_product);
                                jcb_categoria_prod.setText(category_product);
                                jcb_tamaño_prod.setText(width_product);
                                jcb_estilo_prod.setText(style_product);
                                txt_valor_prod.setText(precio_unitario);
                                txt_product_dispo.setText(cantidad_disponible);  
                            }

                        }
                    }              

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se ha encontrado el producto, por favor verifique su inventario");
            } 

        } else {
            JOptionPane.showMessageDialog(null, "No se ha ingresado ningun producto para buscar");
        }
        
       
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jcb_tipo_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_tipo_prodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_tipo_prodActionPerformed

    private void jcb_tipo_prodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcb_tipo_prodKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_tipo_prodKeyTyped

    private void jcb_tamaño_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_tamaño_prodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_tamaño_prodActionPerformed

    private void jcb_tamaño_prodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcb_tamaño_prodKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_tamaño_prodKeyTyped

    private void jcb_categoria_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_categoria_prodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_categoria_prodActionPerformed

    private void jcb_categoria_prodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcb_categoria_prodKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_categoria_prodKeyTyped

    private void jcb_estilo_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_estilo_prodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_estilo_prodActionPerformed

    private void jcb_estilo_prodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcb_estilo_prodKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_estilo_prodKeyTyped

    private void btn_añadir_servActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadir_servActionPerformed
        // Boton añadir servicio
        getPriceServices();
  
    }//GEN-LAST:event_btn_añadir_servActionPerformed

    private void txt_efectivo_pagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_efectivo_pagoKeyReleased
       // Genera la devolucion del pago 
       
        this.selectedPay = jcb_modo_pago.getSelectedItem().toString();
        String payValued = txt_total_pago.getText();
        String payCash = txt_efectivo_pago.getText();

        if (!selectedPay.equals("Seleccione modo de pago")){
            
            this.valuedPay = Integer.parseInt(payValued);
            this.cashPay = Integer.parseInt(payCash);

            int valor_pagado = cashPay - valuedPay;
            String enteroString = Integer.toString(Math.abs(valor_pagado));
             
            if (selectedPay.equals("Por cuota")) {
                 
                if (!txt_efectivo_pago.getText().equals("")) {

                    if (cashPay <= valuedPay) {
                        
                       txt_cambio.setText("");
                       
                       txt_cantidad_restant.setText(enteroString); 
                    }else{
                        JOptionPane.showMessageDialog(null, "La cantidad ingresada cubre el pago total");
                        txt_cantidad_restant.setText("");
                    }

                }else{
                    txt_cantidad_restant.setText("");
               } 
            }
            
            if (selectedPay.equals("Venta directa")) {

                if (!txt_efectivo_pago.getText().equals("")) {

                    txt_cantidad_restant.setText("");
                    txt_cambio.setText(enteroString); 
                }else{
                 txt_cambio.setText("");
                }  
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un modo de pago");
        }
    }//GEN-LAST:event_txt_efectivo_pagoKeyReleased

    // Campo - txt_total_pago - Pago total
    private void txt_total_pagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_total_pagoKeyReleased
        String valuedService = txt_valor_serv.getText();
        Integer serviceValued = Integer.parseInt(valuedService);
    }//GEN-LAST:event_txt_total_pagoKeyReleased

    // Campo - Cantidad Compra
    private void txt_cantidad_prodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidad_prodKeyReleased
       // Genera la devolucion del pago 
        if (!txt_cantidad_prod.getText().equals("")) {

            String cantidaProduct = txt_cantidad_prod.getText();
            String priceProduct = txt_valor_prod.getText();
            
            Integer productDisponible = Integer.parseInt(cantidad_disponible);
            Integer productCantida = Integer.parseInt(cantidaProduct);
            Integer productPrice = Integer.parseInt(priceProduct);
            
            if (productCantida <= productDisponible) {
                
                this.totalPago = productCantida * productPrice;
                String totalPagoString = Integer.toString(totalPago);
                txt_total_pago.setText(totalPagoString); 
            }else{
                JOptionPane.showMessageDialog(null, "La cantidad ingresada supera la cantidad disponible en el inventario");
            }

        }else{
         txt_total_pago.setText("");
        }   
    }//GEN-LAST:event_txt_cantidad_prodKeyReleased

    private void txt_product_dispoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_product_dispoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_product_dispoActionPerformed

    private void txt_product_dispoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_product_dispoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_product_dispoKeyReleased

    private void txt_product_dispoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_product_dispoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_product_dispoKeyTyped

    private void btn_habilitedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_habilitedActionPerformed
        // Boton Habilitar - servicio
        btn_cancelar_serv.setEnabled(true);
        jcb_servicio.setEnabled(true);
        btn_habilited.setEnabled(false);
        btn_añadir_serv.setEnabled(true);
    }//GEN-LAST:event_btn_habilitedActionPerformed

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
    private javax.swing.JButton btn_añadir_serv;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_cancelar_serv;
    private javax.swing.JButton btn_habilited;
    private javax.swing.JButton btn_liquidacion;
    private javax.swing.JButton btn_venta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
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
    public static javax.swing.JTextField jcb_categoria_prod;
    public static javax.swing.JTextField jcb_estilo_prod;
    public static javax.swing.JComboBox<String> jcb_modo_pago;
    public static javax.swing.JComboBox<String> jcb_servicio;
    public static javax.swing.JTextField jcb_tamaño_prod;
    public static javax.swing.JTextField jcb_tipo_prod;
    public static javax.swing.JTextField txt_cambio;
    public static javax.swing.JTextField txt_cantidad_prod;
    public static javax.swing.JTextField txt_cantidad_restant;
    public static javax.swing.JTextField txt_efectivo_pago;
    public static javax.swing.JTextField txt_estado_prod;
    public static javax.swing.JTextField txt_nombre_prod;
    public static javax.swing.JTextField txt_product_dispo;
    public static javax.swing.JTextField txt_total_pago;
    public static javax.swing.JTextField txt_valor_prod;
    public static javax.swing.JTextField txt_valor_serv;
    // End of variables declaration//GEN-END:variables
}
