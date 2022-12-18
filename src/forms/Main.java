/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import com.formdev.flatlaf.FlatLightLaf;
/**
 *
 * @author samih
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
         this.setTitle("Gestion des machines");
        this.setExtendedState(MAXIMIZED_BOTH);
       FlatLightLaf.setup();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        ClientForm = new javax.swing.JMenuItem();
        commandeForm = new javax.swing.JMenuItem();
        ligneCommandeForm = new javax.swing.JMenuItem();
        fournisseurForm = new javax.swing.JMenuItem();
        demandeForm = new javax.swing.JMenuItem();
        ligneDemandeForm = new javax.swing.JMenuItem();
        produitForm = new javax.swing.JMenuItem();
        rayonForm = new javax.swing.JMenuItem();
        categorieForm = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        produitParCategorie = new javax.swing.JMenuItem();
        produitsParRayon = new javax.swing.JMenuItem();
        produitRuptureStock = new javax.swing.JMenuItem();
        produitsEntreDeuxDates = new javax.swing.JMenuItem();
        commandesParClient = new javax.swing.JMenuItem();
        demandesParFournisseur = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuBar.setFont(new java.awt.Font("Franklin Gothic Book", 1, 15)); // NOI18N
        menuBar.setName("Gestion du stock"); // NOI18N

        fileMenu.setMnemonic('f');
        fileMenu.setText("Gestion");

        ClientForm.setMnemonic('o');
        ClientForm.setText("Client");
        ClientForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientFormActionPerformed(evt);
            }
        });
        fileMenu.add(ClientForm);

        commandeForm.setMnemonic('s');
        commandeForm.setText("Commande");
        commandeForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commandeFormActionPerformed(evt);
            }
        });
        fileMenu.add(commandeForm);

        ligneCommandeForm.setMnemonic('a');
        ligneCommandeForm.setText("Ligne de Commandes");
        ligneCommandeForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ligneCommandeFormActionPerformed(evt);
            }
        });
        fileMenu.add(ligneCommandeForm);

        fournisseurForm.setMnemonic('a');
        fournisseurForm.setText("Fournisseur");
        fournisseurForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fournisseurFormActionPerformed(evt);
            }
        });
        fileMenu.add(fournisseurForm);

        demandeForm.setMnemonic('a');
        demandeForm.setText("Demande");
        demandeForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demandeFormActionPerformed(evt);
            }
        });
        fileMenu.add(demandeForm);

        ligneDemandeForm.setMnemonic('a');
        ligneDemandeForm.setText("Ligne de Demandes");
        ligneDemandeForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ligneDemandeFormActionPerformed(evt);
            }
        });
        fileMenu.add(ligneDemandeForm);

        produitForm.setMnemonic('a');
        produitForm.setText("Produit");
        produitForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produitFormActionPerformed(evt);
            }
        });
        fileMenu.add(produitForm);

        rayonForm.setMnemonic('a');
        rayonForm.setText("Rayon");
        rayonForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rayonFormActionPerformed(evt);
            }
        });
        fileMenu.add(rayonForm);

        categorieForm.setMnemonic('a');
        categorieForm.setText("Catégorie");
        categorieForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categorieFormActionPerformed(evt);
            }
        });
        fileMenu.add(categorieForm);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Recherche");

        produitParCategorie.setMnemonic('t');
        produitParCategorie.setText("Produits par catégorie");
        produitParCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produitParCategorieActionPerformed(evt);
            }
        });
        editMenu.add(produitParCategorie);

        produitsParRayon.setMnemonic('d');
        produitsParRayon.setText("Produits par rayon");
        produitsParRayon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produitsParRayonActionPerformed(evt);
            }
        });
        editMenu.add(produitsParRayon);

        produitRuptureStock.setMnemonic('y');
        produitRuptureStock.setText("Produits en rupture de stock");
        produitRuptureStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produitRuptureStockActionPerformed(evt);
            }
        });
        editMenu.add(produitRuptureStock);

        produitsEntreDeuxDates.setMnemonic('p');
        produitsEntreDeuxDates.setText("Produits les plus vendus entre 2 dates");
        produitsEntreDeuxDates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produitsEntreDeuxDatesActionPerformed(evt);
            }
        });
        editMenu.add(produitsEntreDeuxDates);

        commandesParClient.setMnemonic('d');
        commandesParClient.setText("Commandes par client");
        commandesParClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commandesParClientActionPerformed(evt);
            }
        });
        editMenu.add(commandesParClient);

        demandesParFournisseur.setMnemonic('d');
        demandesParFournisseur.setText("Demandes par fournisseur");
        demandesParFournisseur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demandesParFournisseurActionPerformed(evt);
            }
        });
        editMenu.add(demandesParFournisseur);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contents");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void ClientFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientFormActionPerformed
        // TODO add your handling code here:
        clientForm cf = new clientForm();
        desktopPane.add(cf);
        cf.setVisible(true);
        
    }//GEN-LAST:event_ClientFormActionPerformed

    private void ligneCommandeFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ligneCommandeFormActionPerformed
        // TODO add your handling code here:
        ligneCommandeForm lcf=new ligneCommandeForm();
        desktopPane.add(lcf);
        lcf.setVisible(true);
    }//GEN-LAST:event_ligneCommandeFormActionPerformed

    private void fournisseurFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fournisseurFormActionPerformed
        // TODO add your handling code here:
        fournisseurForm ff=new fournisseurForm();
         desktopPane.add(ff);
        ff.setVisible(true);
    }//GEN-LAST:event_fournisseurFormActionPerformed

    private void demandeFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demandeFormActionPerformed
        // TODO add your handling code here:
        demandeForm df=new demandeForm();
         desktopPane.add(df);
        df.setVisible(true);
    }//GEN-LAST:event_demandeFormActionPerformed

    private void ligneDemandeFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ligneDemandeFormActionPerformed
        // TODO add your handling code here:
        ligneDemandeForm ldf=new ligneDemandeForm();
         desktopPane.add(ldf);
        ldf.setVisible(true);
    }//GEN-LAST:event_ligneDemandeFormActionPerformed

    private void rayonFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rayonFormActionPerformed
        // TODO add your handling code here:
        rayonForm rf=new rayonForm();
         desktopPane.add(rf);
        rf.setVisible(true);
    }//GEN-LAST:event_rayonFormActionPerformed

    private void categorieFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categorieFormActionPerformed
        // TODO add your handling code here:
        categorieForm cf=new categorieForm();
         desktopPane.add(cf);
        cf.setVisible(true);
    }//GEN-LAST:event_categorieFormActionPerformed

    private void produitFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produitFormActionPerformed
        // TODO add your handling code here:
        ProduitForm pf=new ProduitForm();
         desktopPane.add(pf);
        pf.setVisible(true);
    }//GEN-LAST:event_produitFormActionPerformed

    private void produitParCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produitParCategorieActionPerformed
        // TODO add your handling code here:
         produitsParCategorieForm pcf = new produitsParCategorieForm();
        desktopPane.add(pcf);
        pcf.setVisible(true);
    }//GEN-LAST:event_produitParCategorieActionPerformed

    private void commandeFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commandeFormActionPerformed
        // TODO add your handling code here:
        commandeForm  cf = new commandeForm();
        desktopPane.add(cf);
        cf.setVisible(true);
    }//GEN-LAST:event_commandeFormActionPerformed

    private void commandesParClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commandesParClientActionPerformed
        // TODO add your handling code here:
         commandesParClientForm ccf = new commandesParClientForm();
        desktopPane.add(ccf);
        ccf.setVisible(true);
    }//GEN-LAST:event_commandesParClientActionPerformed

    private void demandesParFournisseurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demandesParFournisseurActionPerformed
        // TODO add your handling code here:
        demandesParFournisseurForm dff = new demandesParFournisseurForm();
        desktopPane.add(dff);
        dff.setVisible(true);
    }//GEN-LAST:event_demandesParFournisseurActionPerformed

    private void produitsParRayonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produitsParRayonActionPerformed
        // TODO add your handling code here:
         produitsParRayonForm prf = new produitsParRayonForm();
        desktopPane.add(prf);
        prf.setVisible(true);
    }//GEN-LAST:event_produitsParRayonActionPerformed

    private void produitRuptureStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produitRuptureStockActionPerformed
        // TODO add your handling code here:
          produitRuptureStockForm prsf = new produitRuptureStockForm();
        desktopPane.add(prsf);
        prsf.setVisible(true);
    }//GEN-LAST:event_produitRuptureStockActionPerformed

    private void produitsEntreDeuxDatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produitsEntreDeuxDatesActionPerformed
        // TODO add your handling code here:
         produitsEntreDeuxDatesForm pddf = new produitsEntreDeuxDatesForm();
        desktopPane.add(pddf);
        pddf.setVisible(true);
    }//GEN-LAST:event_produitsEntreDeuxDatesActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ClientForm;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem categorieForm;
    private javax.swing.JMenuItem commandeForm;
    private javax.swing.JMenuItem commandesParClient;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem demandeForm;
    private javax.swing.JMenuItem demandesParFournisseur;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem fournisseurForm;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem ligneCommandeForm;
    private javax.swing.JMenuItem ligneDemandeForm;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem produitForm;
    private javax.swing.JMenuItem produitParCategorie;
    private javax.swing.JMenuItem produitRuptureStock;
    private javax.swing.JMenuItem produitsEntreDeuxDates;
    private javax.swing.JMenuItem produitsParRayon;
    private javax.swing.JMenuItem rayonForm;
    // End of variables declaration//GEN-END:variables

}
