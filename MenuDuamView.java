//-------------------------------------------------------------------------------------------------------------------------------------------//
// Projeto Megasoft 1 Versão 2.0 do Sistema de Tributos Municipais com Banco de Dados: IPTU. ITBI e ISS, com implementação básica do REFIS;
// Autor: Daniel Guedes Fukuyoshi Garcia;
//-------------------------------------------------------------------------------------------------------------------------------------------//
// Pacote View;
package View;
//-------------------------------------------------------------------------------------------------------------------------------------------//

// Classe MenuDuamView;
public class MenuDuamView extends javax.swing.JFrame {
    //---------------------------------------------------------------------------------------------------------------------------------------//
    // Métodos Especiais
    // Construtor da Classe MenuDuamView
    /**
     * Creates new form MenuDuam
     */
    public MenuDuamView() {
        initComponents();
    }
    
    //---------------------------------------------------------------------------------------------------------------------------------------//
    // Métodos
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IconImage = new javax.swing.JLabel();
        TitleMunicipalTaxSystem = new javax.swing.JTextField();
        BotaoMenuCadastrar = new javax.swing.JButton();
        BotaoMenuConsultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);

        IconImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IconImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/image/index.jpeg"))); // NOI18N

        TitleMunicipalTaxSystem.setEditable(false);
        TitleMunicipalTaxSystem.setBackground(new java.awt.Color(51, 51, 51));
        TitleMunicipalTaxSystem.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        TitleMunicipalTaxSystem.setForeground(new java.awt.Color(255, 255, 255));
        TitleMunicipalTaxSystem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TitleMunicipalTaxSystem.setText("Sistema Tributário Municipal");
        TitleMunicipalTaxSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TitleMunicipalTaxSystemActionPerformed(evt);
            }
        });

        BotaoMenuCadastrar.setBackground(new java.awt.Color(51, 51, 51));
        BotaoMenuCadastrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BotaoMenuCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoMenuCadastrar.setText("Cadastrar DUAM");
        BotaoMenuCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoMenuCadastrarActionPerformed(evt);
            }
        });

        BotaoMenuConsultar.setBackground(new java.awt.Color(51, 51, 51));
        BotaoMenuConsultar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BotaoMenuConsultar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoMenuConsultar.setText("Consultar DUAM");
        BotaoMenuConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoMenuConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(IconImage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TitleMunicipalTaxSystem, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
                    .addComponent(BotaoMenuConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotaoMenuCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(IconImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TitleMunicipalTaxSystem))
                .addGap(18, 18, 18)
                .addComponent(BotaoMenuCadastrar)
                .addGap(18, 18, 18)
                .addComponent(BotaoMenuConsultar)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void TitleMunicipalTaxSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TitleMunicipalTaxSystemActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_TitleMunicipalTaxSystemActionPerformed

    private void BotaoMenuCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoMenuCadastrarActionPerformed
        // TODO add your handling code here:
        MenuCadastroView menuCadas = new MenuCadastroView();
        menuCadas.setVisible(true);
    }//GEN-LAST:event_BotaoMenuCadastrarActionPerformed

    private void BotaoMenuConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoMenuConsultarActionPerformed
        // TODO add your handling code here:
        MenuConsultaView menuCons = new MenuConsultaView();
        menuCons.setVisible(true);
    }//GEN-LAST:event_BotaoMenuConsultarActionPerformed

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
            java.util.logging.Logger.getLogger(MenuDuamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuDuamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuDuamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuDuamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuDuamView().setVisible(true);
            }
        });
    }
    
    //---------------------------------------------------------------------------------------------------------------------------------------//
    // Atributos
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoMenuCadastrar;
    private javax.swing.JButton BotaoMenuConsultar;
    private javax.swing.JLabel IconImage;
    private javax.swing.JTextField TitleMunicipalTaxSystem;
    // End of variables declaration//GEN-END:variables
    //---------------------------------------------------------------------------------------------------------------------------------------//
    // Fim da Classe MenuDuamView;
}
//-------------------------------------------------------------------------------------------------------------------------------------------//