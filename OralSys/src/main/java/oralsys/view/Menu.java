package oralsys.view;

import oralsys.view.listagem.ListagemCidade;
import oralsys.view.listagem.ListagemConsulta;
import oralsys.view.listagem.ListagemFuncionario;
import oralsys.view.listagem.ListagemMaterial;
import oralsys.view.listagem.ListagemPaciente;
import oralsys.view.listagem.ListagemTipoPagamento;
import oralsys.view.relatorios.RelatorioCidades;
import oralsys.view.relatorios.RelatorioConsultas;
import oralsys.view.relatorios.RelatorioFuncionarios;
import oralsys.view.relatorios.RelatorioMateriais;
import oralsys.view.relatorios.RelatorioPacientes;


public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        cadastro = new javax.swing.JMenu();
        btnCidade = new javax.swing.JMenuItem();
        btnConsulta = new javax.swing.JMenuItem();
        btnMaterial = new javax.swing.JMenuItem();
        btnPaciente = new javax.swing.JMenuItem();
        btnFuncionario = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        relatorio = new javax.swing.JMenu();
        funcionario = new javax.swing.JMenuItem();
        paciente = new javax.swing.JMenuItem();
        consulta = new javax.swing.JMenuItem();
        cidade = new javax.swing.JMenuItem();
        material = new javax.swing.JMenuItem();
        logoff = new javax.swing.JMenu();
        jlogoff = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DALLE2_1.png"))); // NOI18N

        cadastro.setText("Cadastro");
        cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroActionPerformed(evt);
            }
        });

        btnCidade.setText("Cidade");
        btnCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCidadeActionPerformed(evt);
            }
        });
        cadastro.add(btnCidade);

        btnConsulta.setText("Consulta");
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });
        cadastro.add(btnConsulta);

        btnMaterial.setText("Material");
        btnMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaterialActionPerformed(evt);
            }
        });
        cadastro.add(btnMaterial);

        btnPaciente.setText("Paciente");
        btnPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacienteActionPerformed(evt);
            }
        });
        cadastro.add(btnPaciente);

        btnFuncionario.setText(" Funcionario");
        btnFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionarioActionPerformed(evt);
            }
        });
        cadastro.add(btnFuncionario);

        jMenuItem1.setText("Tipo de Pagamento");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        cadastro.add(jMenuItem1);

        jMenuBar1.add(cadastro);

        relatorio.setText("Relatorios");

        funcionario.setText("Funcionario");
        funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funcionarioActionPerformed(evt);
            }
        });
        relatorio.add(funcionario);

        paciente.setText("Paciente");
        paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pacienteActionPerformed(evt);
            }
        });
        relatorio.add(paciente);

        consulta.setText("Consultas");
        consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaActionPerformed(evt);
            }
        });
        relatorio.add(consulta);

        cidade.setText("Cidades");
        cidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidadeActionPerformed(evt);
            }
        });
        relatorio.add(cidade);

        material.setText("Materiais");
        material.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialActionPerformed(evt);
            }
        });
        relatorio.add(material);

        jMenuBar1.add(relatorio);

        logoff.setText("Logoff");
        logoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoffActionPerformed(evt);
            }
        });

        jlogoff.setText("Logoff");
        jlogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlogoffActionPerformed(evt);
            }
        });
        logoff.add(jlogoff);

        jMenuBar1.add(logoff);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroActionPerformed
        
    }//GEN-LAST:event_cadastroActionPerformed

    private void btnCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCidadeActionPerformed
        ListagemCidade listagemCidade = new ListagemCidade();
        listagemCidade.setVisible(true);
    }//GEN-LAST:event_btnCidadeActionPerformed

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        new ListagemConsulta().setVisible(true);
    }//GEN-LAST:event_btnConsultaActionPerformed

    private void btnPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacienteActionPerformed
        new ListagemPaciente().setVisible(true);
    }//GEN-LAST:event_btnPacienteActionPerformed

    private void funcionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funcionarioActionPerformed
        new RelatorioFuncionarios().setVisible(true);
    }//GEN-LAST:event_funcionarioActionPerformed

    private void pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pacienteActionPerformed
        new RelatorioPacientes().setVisible(true);
    }//GEN-LAST:event_pacienteActionPerformed

    private void consultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaActionPerformed
        new RelatorioConsultas().setVisible(true);
    }//GEN-LAST:event_consultaActionPerformed

    private void cidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidadeActionPerformed
        new RelatorioCidades().setVisible(true);
    }//GEN-LAST:event_cidadeActionPerformed

    private void materialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialActionPerformed
        new RelatorioMateriais().setVisible(true);
    }//GEN-LAST:event_materialActionPerformed

    private void btnMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaterialActionPerformed
        new ListagemMaterial().setVisible(true);
    }//GEN-LAST:event_btnMaterialActionPerformed

    private void btnFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionarioActionPerformed
        new ListagemFuncionario().setVisible(true);
    }//GEN-LAST:event_btnFuncionarioActionPerformed

    private void jlogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlogoffActionPerformed
        new LoginCadastro().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jlogoffActionPerformed

    private void logoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoffActionPerformed
        dispose();
    }//GEN-LAST:event_logoffActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new ListagemTipoPagamento().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnCidade;
    private javax.swing.JMenuItem btnConsulta;
    private javax.swing.JMenuItem btnFuncionario;
    private javax.swing.JMenuItem btnMaterial;
    private javax.swing.JMenuItem btnPaciente;
    private javax.swing.JMenu cadastro;
    private javax.swing.JMenuItem cidade;
    private javax.swing.JMenuItem consulta;
    private javax.swing.JMenuItem funcionario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenuItem jlogoff;
    private javax.swing.JMenu logoff;
    private javax.swing.JMenuItem material;
    private javax.swing.JMenuItem paciente;
    private javax.swing.JMenu relatorio;
    // End of variables declaration//GEN-END:variables
}
