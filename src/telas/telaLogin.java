package telas;
//imports
import dal.ModuloConexao;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.getString;

public class telaLogin extends javax.swing.JFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    /*
        è usado para executar a mesma instrução repetidamemente em alta eficiência. 
        Ela consiste em preparar e excutar
    */
    ResultSet rs = null;
    
    public telaLogin() {
        initComponents();
        conexao = ModuloConexao.conector();
        if (conexao != null){
            status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/KnobValidGreen.png")));
        }
        else {
            status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/knobCancel.png")));
        }
    }
    
    public void logar(){
        String sql = "SELECT * FROM tbl_usuarios WHERE email=? AND senha=?";
        try {
            //capturar oque o usuario digitar na caixa de usuario e senha
            pst = conexao.prepareStatement(sql);
            pst.setString(1,usuarioNome.getText());
            pst.setString(2,usuarioSenha.getText());
            
            //a linha abaixo executa a consulta
            rs = pst.executeQuery();
            
            if (rs.next()){
                //Se existir usuario e senha correspodente abriará um novo formulário
                TelaPrincipal principal = new TelaPrincipal();
                principal.setVisible(true);
                TelaPrincipal.lblUsuario.setText(rs.getString(2));
                this.dispose();
                /*
                    é um método que implementa o código necessário para finalizar
                    o objeto e liberar a memória.
                */
                conexao.close();
                
            }
            else {
                JOptionPane.showMessageDialog(null,"Usuario e/ou senha inválido");
            }
        }
        catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuario = new javax.swing.JLabel();
        senha = new javax.swing.JLabel();
        buttonLogin = new javax.swing.JButton();
        usuarioNome = new javax.swing.JTextField();
        usuarioSenha = new javax.swing.JTextField();
        status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de Login");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        setForeground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(500, 300));
        setResizable(false);

        usuario.setText("Usuario:");

        senha.setText("Senha:");

        buttonLogin.setText("Login");
        buttonLogin.setAlignmentY(0.0F);
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        usuarioNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioNomeActionPerformed(evt);
            }
        });

        usuarioSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioSenhaActionPerformed(evt);
            }
        });

        status.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.black, null, null));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(senha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuarioSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(usuarioNome))
                        .addGap(99, 99, 99))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        //chamando o metodo logar
        logar();
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void usuarioNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioNomeActionPerformed
        
    }//GEN-LAST:event_usuarioNomeActionPerformed

    private void usuarioSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioSenhaActionPerformed
        
    }//GEN-LAST:event_usuarioSenhaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogin;
    private javax.swing.JLabel senha;
    private javax.swing.JLabel status;
    private javax.swing.JLabel usuario;
    private javax.swing.JTextField usuarioNome;
    private javax.swing.JTextField usuarioSenha;
    // End of variables declaration//GEN-END:variables

}