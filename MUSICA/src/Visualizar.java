
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER1
 */
public class Visualizar extends javax.swing.JFrame {
public static int idcancion, idgenero, idartista, idTGC;
    /**
     * Creates new form Visualizar
     */
    public static String nombreCancion;
    public Visualizar() {
        initComponents();         
    }

    
    public static void consultaVisualizar ()
    {
        String nombrei="";
         String calificacioni="";
         String linki="";
         String Generoi="";
         String tipoi="";
         String artistai="";
         int anioi=0;
         String imgi="";
         
         
         
     try{
              
           Connection con = Conection.getConexion();
            String query = "SELECT c.Nombre as nombreCancion, c.Calificacion, c.link, gc.Nombre as nombreGenero, t.Nombre_tipo, t.año, t.imagen, a.Nombre as nombreArtista FROM cancion c JOIN generocancion gc ON c.fkidGeneroCancion = gc.idGeneroCancion JOIN tipogrupocanciones t ON c.fkidtipoGrupoCanciones = t.idtipoGrupoCanciones JOIN artista a ON a.idArtista = t.fkidArtista WHERE c.Nombre ='"+ nombreCancion + "'";
            PreparedStatement psmt = con.prepareStatement(query);
            ResultSet rs;
            rs = psmt.executeQuery();
            
            if(rs.next())
            {
            nombrei= rs.getString("nombreCancion");
             calificacioni= rs.getString("c.Calificacion");
             linki= rs.getString("c.Link");
             Generoi= rs.getString("nombreGenero");
             tipoi= rs.getString("t.Nombre_tipo");
             artistai= rs.getString("nombreArtista");
             anioi=rs.getInt("t.año");
             imgi=rs.getString("t.imagen");
             
            
            cancion.setText(nombrei);
            Visualizar.artista.setText(artistai);
            genero.setText(Generoi);
            calif.setText(calificacioni);
            link.setText(linki);
            anio.setText(String.valueOf(anioi));
            img.setText(imgi);
            tipo.setText(tipoi);
            
            
            
            }
        }
     catch (SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("No existen valores");
        } 
     
        try{
              
           Connection con = Conection.getConexion();
            String query = "SELECT c.idCancion FROM cancion c WHERE c.Nombre ='"+ nombrei + "'";
            PreparedStatement psmt = con.prepareStatement(query);
            ResultSet rs;
            rs = psmt.executeQuery();
            
            if(rs.next())
            {
            idcancion= rs.getInt("c.idCancion");
            }
        }
     catch (SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("No existen valores cancion");
        } 
        
        
        try{
              
           Connection con = Conection.getConexion();
            String query = "SELECT idArtista FROM artista WHERE Nombre ='"+ artistai + "'";
            PreparedStatement psmt = con.prepareStatement(query);
            ResultSet rs;
            rs = psmt.executeQuery();
            
            if(rs.next())
            {
            idartista= rs.getInt("idArtista");
            }
        }
     catch (SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("No existen valores artista");
        } 
        
        try{
              
           Connection con = Conection.getConexion();
            String query = "SELECT idTipoGrupoCanciones FROM TipoGrupoCanciones WHERE Nombre_tipo ='"+ tipoi + "'";
            PreparedStatement psmt = con.prepareStatement(query);
            ResultSet rs;
            rs = psmt.executeQuery();
            
            if(rs.next())
            {
            idTGC= rs.getInt("idTipoGrupoCanciones");
            }
        }
     catch (SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("No existen valores artista");
        } 
        
        try{
              
           Connection con = Conection.getConexion();
            String query = "SELECT idGeneroCancion FROM TipoGrupoCanciones WHERE Nombre ='"+ Generoi + "'";
            PreparedStatement psmt = con.prepareStatement(query);
            ResultSet rs;
            rs = psmt.executeQuery();
            
            if(rs.next())
            {
            idgenero= rs.getInt("idGeneroCancion");
            }
        }
     catch (SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("No existen valores artista");
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

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cancion = new javax.swing.JLabel();
        artista = new javax.swing.JLabel();
        genero = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        calif = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        LinkLabel = new javax.swing.JLabel();
        AnioLable = new javax.swing.JLabel();
        TipoLabel = new javax.swing.JLabel();
        link = new javax.swing.JLabel();
        anio = new javax.swing.JLabel();
        tipo = new javax.swing.JLabel();
        img = new javax.swing.JLabel();
        ImgLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Visualizar canciónes");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 153));
        jLabel3.setText("Detalles ");

        jButton1.setText("Menú");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cancion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cancion.setText("-");

        artista.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        artista.setText("-");
        artista.setToolTipText("");

        genero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        genero.setText("-");

        calif.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        calif.setText("-");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Nombre:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Artista:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Genero:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Calificación:");

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dislike_masmaspequeño.png"))); // NOI18N
        jButton15.setBorderPainted(false);
        jButton15.setContentAreaFilled(false);
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton15.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/dislike_maspequeño.png"))); // NOI18N
        jButton15.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/dislike.png"))); // NOI18N
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/like_masmaspequeña.png"))); // NOI18N
        jButton12.setBorderPainted(false);
        jButton12.setContentAreaFilled(false);
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/like_maspequeña.png"))); // NOI18N
        jButton12.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/like.png"))); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        LinkLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LinkLabel.setText("Link:");

        AnioLable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AnioLable.setText("Año");

        TipoLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TipoLabel.setText("Tipo");

        link.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        link.setText("-");
        link.setToolTipText("");

        anio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        anio.setText("-");

        tipo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tipo.setText("-");

        img.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        img.setText("-");

        ImgLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ImgLabel.setText("Imagen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addContainerGap(123, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(76, 76, 76)
                                        .addComponent(jLabel7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(genero, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(cancion, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(calif, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(18, 18, 18)
                                    .addComponent(artista, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AnioLable)
                                .addGap(18, 18, 18)
                                .addComponent(anio, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(TipoLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(LinkLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(link, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(ImgLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(39, 39, 39)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)))))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addComponent(jLabel3)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancion, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(artista, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(genero, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(calif))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LinkLabel)
                    .addComponent(link, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AnioLable)
                    .addComponent(anio, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TipoLabel)
                    .addComponent(tipo))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ImgLabel)
                            .addComponent(img))
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        Principal newFrame = new Principal();
            newFrame.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        try{              
            Connection con = Conection.getConexion();
            
            String query ="SELECT  l.fkidCancion as idCancion, l.fkidUsuario as idUsuario FROM likes l , cancion c WHERE l.fkidCancion=c.idCancion AND c.Nombre='" + nombreCancion + "'";
            String sentenciaInsert= "Insert into likes values(?,?,?,?)";
            String queryMax="SELECT Max(idLikes) as MaxLikes FROM likes";
            
            PreparedStatement psmt = con.prepareStatement(query); 
            PreparedStatement psmtMax= con.prepareStatement(queryMax);            
            PreparedStatement psmtInsert= con.prepareStatement(sentenciaInsert);
   
            ResultSet rs;               
            ResultSet rsMax;
            
            rs = psmt.executeQuery();  
            rsMax= psmtMax.executeQuery();
            
            if(rs.next() && rsMax.next())
            {
                 int val1 = rsMax.getInt("MaxLikes");
                 System.out.println(val1);
                 int val2 = rs.getInt("idCancion");
                 System.out.println(val2);
                 int val3 = rs.getInt("idUsuario");
                 System.out.println(val3);

                 System.out.println("User ID" +  InicioSesion.pidU);
                 int idLikes= val1+1;                 
                
                 psmtInsert.setInt(1,idLikes);
                 psmtInsert.setInt(2,val2);
                 psmtInsert.setInt(3,InicioSesion.pidU);
                 psmtInsert.setInt(4, -1);
                 psmtInsert.executeUpdate();
        
            }
        }
     catch (SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("No se puede");
        } 
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        try{              
            Connection con = Conection.getConexion();
            
            String query ="SELECT  l.fkidCancion as idCancion, l.fkidUsuario as idUsuario FROM likes l , cancion c WHERE l.fkidCancion=c.idCancion AND c.Nombre='" + nombreCancion + "'";
            String sentenciaInsert= "Insert into likes values(?,?,?,?)";
            String queryMax="SELECT Max(idLikes) as MaxLikes FROM likes";
            
            PreparedStatement psmt = con.prepareStatement(query); 
            PreparedStatement psmtMax= con.prepareStatement(queryMax);            
            PreparedStatement psmtInsert= con.prepareStatement(sentenciaInsert);
   
            ResultSet rs;               
            ResultSet rsMax;
            
            rs = psmt.executeQuery();  
            rsMax= psmtMax.executeQuery();
            
            if(rs.next() && rsMax.next())
            {
                 int val1 = rsMax.getInt("MaxLikes");
                 System.out.println(val1);
                 int val2 = rs.getInt("idCancion");
                 System.out.println(val2);
                 int val3 = rs.getInt("idUsuario");
                 System.out.println(val3);
                 
                 System.out.println("User Id" +  InicioSesion.pidU);

                 int idLikes= val1+1;                 
                
                 psmtInsert.setInt(1,idLikes);
                 psmtInsert.setInt(2,val2);
                 psmtInsert.setInt(3,InicioSesion.pidU);
                 psmtInsert.setInt(4,1);
                 psmtInsert.executeUpdate();
        
            }
        }
     catch (SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("No se puede");
        } 
        
                       
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       if(!InicioSesion.isAdmin){
           javax.swing.JOptionPane. showMessageDialog (this, "Su usuario no cuenta con permisos de administrador");
           
       }
       else {Actualizar newFrame = new Actualizar();
            newFrame.setVisible(true);
            this.dispose();}
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
            java.util.logging.Logger.getLogger(Visualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Visualizar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnioLable;
    private javax.swing.JLabel ImgLabel;
    private javax.swing.JLabel LinkLabel;
    private javax.swing.JLabel TipoLabel;
    public static javax.swing.JLabel anio;
    public static javax.swing.JLabel artista;
    public static javax.swing.JLabel calif;
    public static javax.swing.JLabel cancion;
    public static javax.swing.JLabel genero;
    public static javax.swing.JLabel img;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JLabel link;
    public static javax.swing.JLabel tipo;
    // End of variables declaration//GEN-END:variables
}
