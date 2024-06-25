package ViewsUI;

import Dao.GlobalDao;
import Dtos.TarefaDto;
import Models.Tarefa;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class TarefaView extends javax.swing.JFrame {

    static GlobalDao context = new GlobalDao() {
    };

    int currentRow = 1;
    DefaultTableModel model;

    public TarefaView() {
        initComponents();
    }

    public TarefaView(GlobalDao _context) {
        context = _context;

        initComponents();
        txtUser.setText(context.usuarioLogado.getUserOrEmail());
        model = (DefaultTableModel) tbTarefas.getModel();
        LoadData();

        tbTarefas.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {

            int i = tbTarefas.getSelectedRow();

            if (i != -1) {
                Integer Id = (Integer) tbTarefas.getValueAt(i, 0);
                Tarefa tarefa = context.PegarTarefa(Id);
                txtTitulo.setText(tarefa.getTitle());
                txtDescricao.setText(tarefa.getDescription());
                cbEstado.setSelected(tarefa.getStatus());
                cbEstado.setText(tarefa.getStatus() ? "Completada" : "N/ Completada");
                btnExcluir.setEnabled(true);
                btnNovaTarefa.setText("Atualizar Tarefa");
                btnNovaTarefa.addActionListener((java.awt.event.ActionEvent evt) -> {
                    btnATualizarTarefaActionPerformed(evt, tarefa);
                });
            } else {
                btnExcluir.setEnabled(false);
                btnNovaTarefa.setText("Criar Tarefa");
                btnNovaTarefa.addActionListener((java.awt.event.ActionEvent evt) -> {
                    btnNovaTarefaActionPerformed(evt);
                });
            }
        });

    }

    private void LimparTabela() {
        model.setRowCount(0);
    }

    private void LoadData() {
        LimparTabela();

        for (var tarefa : context.PegarTarefas()) {
            model.addRow(PreecherLinha(tarefa));
        }

    }

    private Object[] PreecherLinha(Tarefa tarefa) {
        return new Object[]{
            tarefa.getId(),
            tarefa.getTitle(),
            tarefa.getDescription(),
            tarefa.getStatus() ? "Completada" : "N/ Completada",
            tarefa.getCreatedAt().toString(),
            tarefa.getUpdatedAt().toString(),
            tarefa.getCreatedBy().getUserOrEmail(),
            tarefa.getUpdatedBy().getUserOrEmail()
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtUser = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextPane();
        cbEstado = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        btnNovaTarefa = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnExcluir1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbTarefas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_task_20px.png"))); // NOI18N
        jLabel12.setText("Gestão de Tarefas");

        txtUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtUser.setText("User");

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_export_20px.png"))); // NOI18N
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 395,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, 34,
                                                Short.MAX_VALUE))
                                .addContainerGap()));

        jLabel1.setText("Titulo");

        jLabel2.setText("Descrição");

        jScrollPane1.setViewportView(txtDescricao);

        cbEstado.setText("N/ Completada");
        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
            }
        });

        jLabel3.setText("Estado");

        btnNovaTarefa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_task_20px.png"))); // NOI18N
        btnNovaTarefa.setText("Criar Tarefa");
        btnNovaTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaTarefaActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_delete_20px.png"))); // NOI18N
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnExcluir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_search_20px.png"))); // NOI18N
        btnExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout
                                                .createSequentialGroup()
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jScrollPane1)
                                                        .addComponent(txtTitulo,
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                jPanel2Layout.createSequentialGroup()
                                                                        .addComponent(jLabel1)
                                                                        .addGap(0, 0, Short.MAX_VALUE)))
                                                .addGap(14, 14, 14))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        false)
                                                                        .addComponent(cbEstado,
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(btnNovaTarefa,
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                140, Short.MAX_VALUE))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(btnExcluir)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(btnExcluir1)))
                                                .addGap(0, 16, Short.MAX_VALUE)))));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(btnNovaTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btnExcluir1, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(47, Short.MAX_VALUE)));

        tbTarefas.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Id", "Título", "Descrição", "Estado", "Data de Criação", "Data Atualização", "Criado Por",
                        "Atualizado Por"
                }));
        jScrollPane2.setViewportView(tbTarefas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 878,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(16, Short.MAX_VALUE)));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
        context.LogOut();

    }// GEN-LAST:event_btnSairActionPerformed

    private void btnNovaTarefaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNovaTarefaActionPerformed

        try {

            if (!txtTitulo.getText().isEmpty() || !txtDescricao.getText().isEmpty()) {
                context.CriarTarefa(new TarefaDto(
                        txtTitulo.getText(),
                        txtDescricao.getText(),
                        cbEstado.isSelected()));

                currentRow++;

                LoadData();
            }

        } catch (Exception ex) {
            context.ShowAlert("Erro ao cadastrar tarefa", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

        txtTitulo.setText("");
        txtDescricao.setText("");
        cbEstado.setSelected(false);
        cbEstado.setText("N/ Completada");
    }// GEN-LAST:event_btnNovaTarefaActionPerformed

    private void btnATualizarTarefaActionPerformed(ActionEvent evt, Tarefa tarefa) {

        try {
            if (!txtTitulo.getText().isEmpty() || !txtDescricao.getText().isEmpty()) {
                tarefa.setTitle(txtTitulo.getText());
                tarefa.setDescription(txtDescricao.getText());
                tarefa.setStatus(cbEstado.isSelected());

                context.EditarTarefa(tarefa);

                LoadData();
            }

        } catch (Exception ex) {
            context.ShowAlert("Erro ao editar tarefa", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

        txtTitulo.setText("");
        txtDescricao.setText("");
        cbEstado.setSelected(false);
        cbEstado.setText("N/ Completada");
        btnExcluir.setEnabled(false);
    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnExcluirActionPerformed
        int i = tbTarefas.getSelectedRow();

        if (i != -1) {
            Integer Id = (Integer) tbTarefas.getValueAt(i, 0);
            context.ExcluirTarefa(Id);
            LoadData();
        } else {
            context.ShowAlert("Exclusão de tarefa", "Por favor, selecione uma linha!!!", JOptionPane.WARNING_MESSAGE);
        }
        btnExcluir.setEnabled(false);
    }// GEN-LAST:event_btnExcluirActionPerformed

    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbEstadoActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_cbEstadoActionPerformed

    private void btnExcluir1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnExcluir1ActionPerformed
        LimparTabela();

        for (var tarefa : context.PegarTarefasPorFiltros(txtTitulo.getText())) {
            model.addRow(PreecherLinha(tarefa));
        }
    }// GEN-LAST:event_btnExcluir1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TarefaView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TarefaView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TarefaView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TarefaView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (context.isAuthenticated()) {
                    new TarefaView(context).setVisible(true);
                } else {
                    new LoginView().setVisible(true);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnExcluir1;
    private javax.swing.JButton btnNovaTarefa;
    private javax.swing.JButton btnSair;
    private javax.swing.JCheckBox cbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbTarefas;
    private javax.swing.JTextPane txtDescricao;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JLabel txtUser;
    // End of variables declaration//GEN-END:variables
}
