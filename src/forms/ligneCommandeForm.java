/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import entities.Client;
import entities.Commande;
import entities.Produit;
import entities.LigneCommande;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.CommandeService;
import services.LigneCommandeService;
import services.ProduitService;

/**
 *
 * @author samih
 */
public class ligneCommandeForm extends javax.swing.JInternalFrame {
    static Commande commande;
    static Produit produit;
    private ProduitService ps;
    private CommandeService cms;
    private LigneCommandeService lcs; 
    private DefaultTableModel model;
    /**
     * Creates new form ligneCommandeForm
     */
    public ligneCommandeForm() {
        initComponents();
           cms = new CommandeService();
           loadCommande();
            ps = new ProduitService();
            loadProduit();
     model = (DefaultTableModel) listeLigneCommandes.getModel();
        load();
    }
       private void loadCommande() {
        for (Commande c : cms.findAll()) {
           commandeList.addItem(c);
       }
     }
        private void loadProduit() {
        for (Produit p : ps.findAll()) {
           produitList.addItem(p);
       }
    }

    public void load (){
        model.setRowCount(0);
        for(LigneCommande lc : lcs.findAll()){
            model.addRow(new Object[]{
                lc.getCommande().getCode(),
                lc.getProduit().getId(),
                lc.getQuantite(),
                lc.getPrixVente()
            });
        }
            
    
   

    }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAjouter = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnSupprimer = new javax.swing.JButton();
        produitList = new javax.swing.JComboBox<Produit>();
        txtQuantite = new javax.swing.JTextField();
        commandeList = new javax.swing.JComboBox<Commande>();
        txtPrixVente = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listeLigneCommandes = new javax.swing.JTable();
        btnModifier = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel1.setText("Commande:");

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel2.setText("Produit:");

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel3.setText("Quantité:");

        btnAjouter.setBackground(new java.awt.Color(0, 51, 255));
        btnAjouter.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        btnAjouter.setText("Ajouter");
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel4.setText("Prix de Vente:");

        btnSupprimer.setBackground(new java.awt.Color(255, 0, 51));
        btnSupprimer.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        btnSupprimer.setText("Supprimer");
        btnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
        });

        txtQuantite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantiteActionPerformed(evt);
            }
        });

        commandeList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commandeListActionPerformed(evt);
            }
        });

        txtPrixVente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrixVenteActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Les informations de la ligne de commande", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tempus Sans ITC", 1, 13))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N

        listeLigneCommandes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Demande", "Produit", "Quantité", "Prix d'Achat"
            }
        ));
        listeLigneCommandes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listeLigneCommandesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listeLigneCommandes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(192, 192, 192))
        );

        btnModifier.setBackground(new java.awt.Color(0, 153, 0));
        btnModifier.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        btnModifier.setText("Modifier");
        btnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(commandeList, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(produitList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtQuantite, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtPrixVente, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnAjouter)
                        .addGap(44, 44, 44)
                        .addComponent(btnSupprimer)
                        .addGap(47, 47, 47)
                        .addComponent(btnModifier))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(commandeList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(produitList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtQuantite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrixVente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAjouter)
                            .addComponent(btnSupprimer)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnModifier)))
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtQuantiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantiteActionPerformed

    private void commandeListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commandeListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commandeListActionPerformed

    private void txtPrixVenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrixVenteActionPerformed
        // TODO add your handling code here:
            Commande commande = (Commande) commandeList.getSelectedItem();
          Produit produit = (Produit) produitList.getSelectedItem();
          int quantite  = Integer.parseInt(txtQuantite.getText());
            double prixAchat  = Double.parseDouble(txtPrixVente.getText());
       if (lcs.update(new LigneCommande(commande,produit,quantite,prixAchat))) {
            JOptionPane.showMessageDialog(this, "Bien modifié");
            loadCommande();
        } 
    }//GEN-LAST:event_txtPrixVenteActionPerformed

    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterActionPerformed
        // TODO add your handling code here:
        Commande commande = (Commande) commandeList.getSelectedItem();
        Produit produit = (Produit) produitList.getSelectedItem();
        double prixVente = Double.parseDouble(txtPrixVente.getText());
        int quantite=Integer.parseInt(txtQuantite.getText());
        if (lcs.create(new LigneCommande(commande, produit,quantite, prixVente))) {
            JOptionPane.showMessageDialog(this, "Bien ajouté");
            load();
        
        }
    }//GEN-LAST:event_btnAjouterActionPerformed

    private void btnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierActionPerformed
        // TODO add your handling code here:
  Commande demande = (Commande) commandeList.getSelectedItem();
          Produit produit = (Produit) produitList.getSelectedItem();
          int quantite  = Integer.parseInt(txtQuantite.getText());
            double prixAchat  = Double.parseDouble(txtPrixVente.getText());
       if (lcs.update(new LigneCommande(demande,produit,quantite,prixAchat))) {
            JOptionPane.showMessageDialog(this, "Bien modifié");
            loadCommande();
        }    
        
    }//GEN-LAST:event_btnModifierActionPerformed

    private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerActionPerformed
        // TODO add your handling code here:
          int reponse = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer cette ligne de commande ? ");
            if(reponse == 0){
                lcs.delete(lcs.findById(commande,produit));
                loadCommande();
                JOptionPane.showMessageDialog(this, "Bien supprimé");
            }
          
      
    }//GEN-LAST:event_btnSupprimerActionPerformed

    private void listeLigneCommandesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeLigneCommandesMouseClicked
        // TODO add your handling code here:
commande= (Commande)model.getValueAt(listeLigneCommandes.getSelectedRow(),0);
       produit= (Produit)model.getValueAt(listeLigneCommandes.getSelectedRow(),1);
        int quantite=Integer.parseInt( model.getValueAt(listeLigneCommandes.getSelectedRow(),2).toString());
        double prixAchat=Double.parseDouble( model.getValueAt(listeLigneCommandes.getSelectedRow(),3).toString());
    }//GEN-LAST:event_listeLigneCommandesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjouter;
    private javax.swing.JButton btnModifier;
    private javax.swing.JButton btnSupprimer;
    private javax.swing.JComboBox<Commande> commandeList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listeLigneCommandes;
    private javax.swing.JComboBox<Produit> produitList;
    private javax.swing.JTextField txtPrixVente;
    private javax.swing.JTextField txtQuantite;
    // End of variables declaration//GEN-END:variables
}
