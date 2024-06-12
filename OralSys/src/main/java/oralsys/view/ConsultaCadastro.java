/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package oralsys.view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import oralsys.controller.ConsultaController;
import oralsys.controller.FuncionarioController;
import oralsys.view.listagem.ListagemConsulta;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author kelvy
 */
public class ConsultaCadastro extends javax.swing.JPanel {
    ListagemConsulta listagemConsulta;
    int id = 0;
    String modo = "";
    /**
     * Creates new form ConsultaCadastrar
     */
    public ConsultaCadastro() {
        initComponents();
        inicio();
    }
    
    public ConsultaCadastro(ListagemConsulta listagemConsulta) {
        this.listagemConsulta = listagemConsulta;
        initComponents();
        inicio();
    }
    
    public void setPaciente(String cpf) {
        this.tCPF.setText(cpf);
    }
    
    public void setDentista(String dentista) {
        if (((DefaultComboBoxModel) sDentista.getModel()).getIndexOf(dentista) == -1) {
            sDentista.addItem(dentista);
        }
        sDentista.setSelectedItem(dentista);
    }
    
    public void setStatus(String status) {
        if (((DefaultComboBoxModel) sStatus.getModel()).getIndexOf(status) == -1) {
            sStatus.addItem(status);
        }
        sStatus.setSelectedItem(status);
    }
    
    public void setFormaPagamento(String formaPagamento) {
        if (((DefaultComboBoxModel) sFormaPagamento.getModel()).getIndexOf(formaPagamento) == -1) {
            sStatus.addItem(formaPagamento);
        }
        sStatus.setSelectedItem(formaPagamento);
    }
    
    public void setObservacoes(String observacoes) {
        this.textAreaObservacao.setText(observacoes);
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setModo(String modo) {
        this.modo = modo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lFuncionario = new javax.swing.JLabel();
        lFormaPagamento = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lArquivos = new javax.swing.JLabel();
        lStatus = new javax.swing.JLabel();
        lObservacao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaObservacao = new javax.swing.JTextArea();
        tCPF = new javax.swing.JTextField();
        sFormaPagamento = new javax.swing.JComboBox<>();
        sStatus = new javax.swing.JComboBox<>();
        lNomeFuncionario = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        sDentista = new javax.swing.JComboBox<>();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lFuncionario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lFuncionario.setText("Funcionario");
        jPanel1.add(lFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 565, -1, -1));

        lFormaPagamento.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lFormaPagamento.setText("Forma de Pagamento");
        jPanel1.add(lFormaPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 271, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("CPF Paciente");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 79, -1, 32));

        lArquivos.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lArquivos.setText("Arquivos");
        jPanel1.add(lArquivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 178, -1, -1));

        lStatus.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lStatus.setText("Status");
        jPanel1.add(lStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 225, -1, -1));

        lObservacao.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lObservacao.setText("Observação");
        jPanel1.add(lObservacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 314, -1, -1));

        textAreaObservacao.setColumns(20);
        textAreaObservacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        textAreaObservacao.setRows(5);
        jScrollPane1.setViewportView(textAreaObservacao);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 314, 409, 106));

        tCPF.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel1.add(tCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 81, 300, -1));

        sFormaPagamento.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        sFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A vista", "Pix", "Credito" }));
        jPanel1.add(sFormaPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 268, -1, -1));

        sStatus.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        sStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aguardando Confirmação", "Aguardando Horario", "Confirmado", "Cancelado", "Bloqueado" }));
        sStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sStatusActionPerformed(evt);
            }
        });
        jPanel1.add(sStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 222, 300, -1));

        lNomeFuncionario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lNomeFuncionario.setText("Recebe o valor do nome do login");
        jPanel1.add(lNomeFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 565, -1, -1));

        btnSalvar.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnSalvar.setText("Salvar");
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 482, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnCancelar.setText("Cancelar");
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 482, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Dentista");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 132, -1, -1));

        jButton1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton1.setText("Anexar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 175, -1, -1));

        sDentista.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        sDentista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "..." }));
        sDentista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sDentistaActionPerformed(evt);
            }
        });
        jPanel1.add(sDentista, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 129, 300, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        /*JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(this, "Arquivo Selecionado: " + selectedFile.getAbsolutePath());
        }*/
    }//GEN-LAST:event_jButton1MouseClicked

    private void sStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sStatusActionPerformed

    private void sDentistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sDentistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sDentistaActionPerformed

    public String salvar() {
        String cpfPaciente = tCPF.getText();
        Object dentista = sDentista.getSelectedItem();
        String status = sStatus.getSelectedItem().toString();
        Object formaPagamento = sFormaPagamento.getSelectedItem();
        String observacao = textAreaObservacao.getText();
        System.out.println(cpfPaciente);
        System.out.println(dentista);
        System.out.println(status);
        System.out.println(formaPagamento);
        System.out.println(observacao);
        
        JSONObject json = new JSONObject();
        json.put("cpf", cpfPaciente);
        json.put("dentista", dentista);
        json.put("status", status);
        json.put("formaPagamento", formaPagamento);
        json.put("observacao", observacao);
        json.put("id", this.id);
        ConsultaController consultaController = new ConsultaController();
        String retorno = "";
        if (this.modo.equals("cadastro")) {
            retorno = consultaController.marcarConsulta(json);
        } else {
            retorno = consultaController.confirmarConsulta(this.id);
        }
        return retorno;
    }
    
    public void inicio() {
        FuncionarioController funcionarioController = new FuncionarioController();
        JSONArray array = funcionarioController.listarFuncionario("funcao_id='1'");
        for (int i = 0; i < array.length(); i ++) {
            JSONObject registro = array.getJSONObject(i);
            sDentista.addItem(registro.getString("nome"));
        }
        System.out.println(array);
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lArquivos;
    private javax.swing.JLabel lFormaPagamento;
    private javax.swing.JLabel lFuncionario;
    private javax.swing.JLabel lNomeFuncionario;
    private javax.swing.JLabel lObservacao;
    private javax.swing.JLabel lStatus;
    private javax.swing.JComboBox<String> sDentista;
    private javax.swing.JComboBox<String> sFormaPagamento;
    private javax.swing.JComboBox<String> sStatus;
    private javax.swing.JTextField tCPF;
    private javax.swing.JTextArea textAreaObservacao;
    // End of variables declaration//GEN-END:variables
}