package telas;

import javax.swing.JOptionPane;
import java.text.*;


public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        initComponents();
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        labelUsuario = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        cadastroMenu = new javax.swing.JMenu();
        clienteSubMenu = new javax.swing.JMenuItem();
        usuariosSubMenu = new javax.swing.JMenuItem();
        ajudaMenu = new javax.swing.JMenu();
        sobreSubMenu = new javax.swing.JMenuItem();
        opcaoMenu = new javax.swing.JMenu();
        sairSubMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktop.setPreferredSize(new java.awt.Dimension(350, 265));
        desktop.setLayout(new javax.swing.BoxLayout(desktop, javax.swing.BoxLayout.LINE_AXIS));

        labelUsuario.setText("Bem-Vindo");
        labelUsuario.setMaximumSize(new java.awt.Dimension(150, 16));

        lblUsuario.setText("jLabel1");

        cadastroMenu.setText("Cadastro");
        cadastroMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroMenuActionPerformed(evt);
            }
        });

        clienteSubMenu.setText("Cliente");
        cadastroMenu.add(clienteSubMenu);

        usuariosSubMenu.setText("Usuarios");
        usuariosSubMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosSubMenuActionPerformed(evt);
            }
        });
        cadastroMenu.add(usuariosSubMenu);

        barraMenu.add(cadastroMenu);

        ajudaMenu.setText("Ajuda");

        sobreSubMenu.setText("Sobre");
        sobreSubMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sobreSubMenuActionPerformed(evt);
            }
        });
        ajudaMenu.add(sobreSubMenu);

        barraMenu.add(ajudaMenu);

        opcaoMenu.setText("Opção");
        opcaoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcaoMenuActionPerformed(evt);
            }
        });

        sairSubMenu.setText("Sair");
        sairSubMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairSubMenuActionPerformed(evt);
            }
        });
        opcaoMenu.add(sairSubMenu);

        barraMenu.add(opcaoMenu);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblUsuario)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairSubMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairSubMenuActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, "Você deseja mesmo sair?", "Atenção", JOptionPane.YES_NO_OPTION);
        
        if (sair == JOptionPane.YES_OPTION){
            System.exit(0);
        }
        
        /*int sair = JOptionPane.showConfirmDialog(null, "Você deseja mesmo sair?", "Atenção", JOptionPane.YES_NO_OPTION);
        
        if (sair == JOptionPane.YES_OPTION){
            //System.exit(0);
            int sair2 = JOptionPane.showConfirmDialog(null, "Tem certeza que você quer mesmo sair?", "Atenção", JOptionPane.YES_NO_OPTION);
            
            if( sair2 == JOptionPane.YES_OPTION){
                int sair3 = JOptionPane.showConfirmDialog(null, "Tem certeza absoluta mesmo que você quer sair?", "Atenção", JOptionPane.YES_NO_OPTION);
            //System.exit(0);
                if( sair3 == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null, "Você não vai sair!");
                }
                else {
                    JOptionPane.showMessageDialog(null,"Não iria deixar você sair mesmo!");
                }
            }    
        } 
        */
    }//GEN-LAST:event_sairSubMenuActionPerformed
        
    private void opcaoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcaoMenuActionPerformed

    }//GEN-LAST:event_opcaoMenuActionPerformed

    private void sobreSubMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sobreSubMenuActionPerformed
        telaSobre sobre = new telaSobre();
        sobre.setVisible(true);
    }//GEN-LAST:event_sobreSubMenuActionPerformed

    private void usuariosSubMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariosSubMenuActionPerformed
        TelaUsuarios usuario = new TelaUsuarios();
        usuario.setVisible(true);
        desktop.add(usuario);
    }//GEN-LAST:event_usuariosSubMenuActionPerformed

    private void cadastroMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastroMenuActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ajudaMenu;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenu cadastroMenu;
    private javax.swing.JMenuItem clienteSubMenu;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JLabel labelUsuario;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu opcaoMenu;
    private javax.swing.JMenuItem sairSubMenu;
    private javax.swing.JMenuItem sobreSubMenu;
    private javax.swing.JMenuItem usuariosSubMenu;
    // End of variables declaration//GEN-END:variables
}
