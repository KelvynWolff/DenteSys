package oralsys.view;

import javax.swing.JOptionPane;
import oralsys.controller.CidadeController;
import oralsys.view.listagem.ListagemCidade;
import org.json.JSONObject;


public class CidadeCadastro extends javax.swing.JFrame {
    
    ListagemCidade listagemCidade;
    String modo = "cadastro";
    int id = 0;
    boolean tabelaMontar = true;
   
    public CidadeCadastro() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public CidadeCadastro(ListagemCidade listagemCidade) {
        this.listagemCidade = listagemCidade;
        initComponents();
    }
    
    public void setCidade(String cidade) {
        tCidade.setText(cidade);
    }
    
    public void setTabelaMontar(boolean status) {
        this.tabelaMontar = status;
    }
    
    public void setEstado(String estado) {
        tEstado.setText(estado);
    }
    
    public void setModo(String modo) {
        this.modo = "alterar";
    }
    
    public void setId(int id) {
        this.id = id;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jCidade = new javax.swing.JLabel();
        jEstado = new javax.swing.JLabel();
        tEstado = new javax.swing.JTextField();
        tCidade = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(401, 230));
        setMinimumSize(new java.awt.Dimension(401, 230));
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("Cadastro de Cidade");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCidade.setText("Cidade");

        jEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jEstado.setText("Estado");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jEstado)
                            .addGap(47, 47, 47)
                            .addComponent(tEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(91, 91, 91)
                            .addComponent(tCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(btnSalvar)
                            .addGap(63, 63, 63)
                            .addComponent(btnCancelar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(192, 192, 192)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCidade))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEstado)
                    .addComponent(tEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String retorno = salvar();
        String mensagem = "Cidade Cadastrada com Sucesso!";
        if (this.modo.equals("alterar")) {
            mensagem = "Cidade Alterada com Sucesso!";
        }
        if (retorno.equals("Sucesso!")) {
            JOptionPane.showMessageDialog(rootPane, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            if (this.tabelaMontar) {
                listagemCidade.montarTabela("");   
            }
            dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, retorno, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

   
    public static void main(String args[]) {
        

       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CidadeCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jCidade;
    private javax.swing.JLabel jEstado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tCidade;
    private javax.swing.JTextField tEstado;
    // End of variables declaration//GEN-END:variables

    public String salvar() {
        String cidade = tCidade.getText();
        String estado = tEstado.getText();
        JSONObject json = new JSONObject();
        json.put("nome", cidade);
        json.put("estado", estado);
        json.put("id", this.id);
        CidadeController cidadeController = new CidadeController();
        String retorno = "";
        if (this.modo.equals("cadastro")) {
            retorno = cidadeController.cadastrarCidade(json);
        } else {
            retorno = cidadeController.alterarCidade(json);
        }
        return retorno;
    }
}
