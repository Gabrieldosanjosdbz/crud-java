package telas;

import java.sql.*;
import dal.ModuloConexao;
import javax.swing.JOptionPane;

public class TelaUsuarios extends javax.swing.JInternalFrame {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public TelaUsuarios() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    
private void consultar(){
        String sql = "SELECT * FROM tbl_usuarios WHERE id=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, inputId.getText());
            rs = pst.executeQuery();
            if (rs.next()){
                inputNome.setText(rs.getString(2));
                inputEmail.setText(rs.getString(3));
                inputSenha.setText(rs.getString(4));
            }
            else {
                JOptionPane.showMessageDialog(null,"Esse usuario não existe.");
                inputNome.setText(null);
                inputEmail.setText(null);
                inputSenha.setText(null);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void adicionar(){
        //comando para adicionar dados dentro do banco de dados
        String sql = "INSERT INTO tbl_usuarios(nome, email, senha) VALUES (?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, inputNome.getText());
            pst.setString(2, inputEmail.getText());
            pst.setString(3, inputSenha.getText());
            int adicionado = pst.executeUpdate();
            //retorna 1 se estiver ok 
            if (adicionado > 0){
                JOptionPane.showMessageDialog(null, "USUARIO CADASTRADO!");
                /*
                    Exibe a nensagem e apaga caso inserido com sucesso.
                    As linhas abaixo irá limpar o formulário.
                */
                inputId.setText(null);
                inputNome.setText(null);
                inputEmail.setText(null);
                inputSenha.setText(null);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, closable);
        }
    }
    private void editar() {
        String sql = "UPDATE tbl_usuarios SET nome=?, email=?, senha=? WHERE id=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, inputNome.getText());
            pst.setString(2, inputEmail.getText());
            pst.setString(3, inputSenha.getText());
            pst.setString(4, inputId.getText());
            int adicionado = pst.executeUpdate();
            //retorna 1 se ok
            if(adicionado > 0){
                JOptionPane.showMessageDialog(null, "USUARIO ALTERADO COM SUCESSO");
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }      
    }
    
    private void apagar(){
        //a estrutura abaixo confirma a exclusão do usuario da tabela
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este usuario?", "ATENÇÃO", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION){
            String sql = "DELETE FROM tbl_usuarios WHERE id=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, inputId.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0){
                    JOptionPane.showMessageDialog(null, "Usuário Apagado!");
                    inputNome.setText(null);
                    inputEmail.setText(null);
                    inputSenha.setText(null);
                }
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        inputId = new javax.swing.JTextField();
        inputNome = new javax.swing.JTextField();
        inputEmail = new javax.swing.JTextField();
        inputSenha = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnVisualizar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuários");
        setAutoscrolls(true);

        jLabel5.setText("id");

        jLabel6.setText("Nome");

        jLabel7.setText("E-mail");

        jLabel8.setText("Senha");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("TELA DE CADASTRAR");

        inputId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputIdActionPerformed(evt);
            }
        });

        btnAdicionar.setText("Adicionar");
        btnAdicionar.setPreferredSize(new java.awt.Dimension(90, 25));
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnVisualizar.setText("Visualizar");
        btnVisualizar.setPreferredSize(new java.awt.Dimension(90, 25));
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.setPreferredSize(new java.awt.Dimension(90, 25));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnApagar.setText("Apagar");
        btnApagar.setPreferredSize(new java.awt.Dimension(90, 25));
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(inputSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnVisualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(8, 8, 8)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel9)))
                .addGap(95, 114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        setBounds(0, 0, 450, 300);
    }// </editor-fold>//GEN-END:initComponents

    private void inputIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputIdActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        
        adicionar();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        apagar();
    }//GEN-LAST:event_btnApagarActionPerformed

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
        
        consultar();  
    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       editar();    
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JTextField inputEmail;
    private javax.swing.JTextField inputId;
    private javax.swing.JTextField inputNome;
    private javax.swing.JTextField inputSenha;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
