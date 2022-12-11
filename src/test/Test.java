
package test;

import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Commande;
import entities.LigneCommande;
import entities.Produit;
import services.ClientService;
import services.CommandeService;
import services.ProduitService;

public class Test {

	public static void main(String[] args) {
		ClientService cs = new ClientService();
		ProduitService ps = new ProduitService();
		CommandeService cms = new CommandeService();
		Scanner sc = new Scanner(System.in);
		int id = 0;
		String nom;
		String telephone;
		String email;
		String designation;
		String Ndesignation;
		int NPrixAchat;
		int prixAchat;
		int code;
		int Ncode;
		int idProduit;
		int qte;
		int prixVente;
		int nbrLignes;
		int Nid;
		int choix = -1;
		while (choix != 0) {
			System.out.println("*****************Menu******************");
			System.out.println("---------Gestion des clients-----------");
			System.out.println("1.Cliquez 1 pour ajouter un client");
			System.out.println("2.Cliquez 2 pour modifier un client");
			System.out.println("3.Cliquez 3 pour supprimer un client");
			System.out.println("4.Cliquez 4 pour afficher un client avec son ID");
			System.out.println("5.Cliquez 5 pour afiicher tous les clients");

			System.out.println("---------Gestion des produits-----------");
			System.out.println("6.Cliquez 6 pour ajouter un produit");
			System.out.println("7.Cliquez 7 pour modifier un produit");
			System.out.println("8.Cliquez 8 pour supprimer un produit");
			System.out.println("9.Cliquez 9 pour afficher un produit avec son ID");
			System.out.println("10.Cliquez 10 pour afiicher tous les produits");

			System.out.println("---------Gestion des commandes----------");
			System.out.println("11.Cliquez 11 pour ajouter une commande");
			System.out.println("12.Cliquez 12 pour modifier une commande");
			System.out.println("13.Cliquez 13 pour supprimer une commande");
			System.out.println("14.Cliquez 14 pour afficher une commande avec son ID");
			System.out.println("15.Cliquez 15 pour afiicher toutes les commandes");

			System.out.println("------Au revoir------");
			System.out.println("0.Cliquez 0 pour Quitter");

			System.out.println("-------Donnez votre choix--------");
			choix = sc.nextInt();

			switch (choix) {
			case 0:
				break;
			case 1:
				System.out.println("***L'ajout d'un client***");
				System.out.println("Donner le nom du client :");
				nom = sc.next();
				System.out.println("Donner le N° de téléphone du client :");
				telephone = sc.next();
				System.out.println("Donner l'email du client :");
				email = sc.next();

				cs.create(new Client(nom, telephone, email));
				break;
			case 2:
				System.out.println("***La modification d'un client***");
				System.out.println("Donner l'id du client à modifier:");
				id = sc.nextInt();
				System.out.println("Donner le nouveau nom du client :");
				nom = sc.next();
				System.out.println("Donner le nouveau N° de téléphone du client :");
				telephone = sc.next();
				System.out.println("Donner le nouveau email du client :");
				email = sc.next();

				Client client = cs.findById(id);
				client.setNom(nom);
				client.setTelephone(telephone);
				client.setEmail(email);
				cs.update(client);
				break;
			case 3:
				System.out.println("***La suppression d'un client***");
				System.out.println("Donner l'id du client à supprimer:");
				id = sc.nextInt();

				cs.delete(cs.findById(id));
				break;
			case 4:
				System.out.println("***Affichage d'un client***");
				System.out.println("Donner l'id du client à afficher:");
				id = sc.nextInt();
				cs.findById(id);

			case 5:
				System.out.println("***La liste des clients***");
				for (Client c : cs.findAll()) {
					System.out.println(c);
				}
				break;
			case 6:
				System.out.println("***L'ajout d'un produit***");
				System.out.println("Donner la designation du produit :");
				designation = sc.next();
				System.out.println("Donner le prix d'achat :");
				prixAchat = sc.nextInt();

				ps.create(new Produit(designation, prixAchat));
				break;
			case 7:
				System.out.println("***La modification d'un produit***");
				System.out.println("Donner l'id du produit à modifier:");
				id = sc.nextInt();
				System.out.println("Donner le nouvelle designation du produit :");
				Ndesignation = sc.next();
				System.out.println("Donner le nouveau N° de téléphone du client :");
				NPrixAchat = sc.nextInt();

				Produit produit = ps.findById(id);
				produit.setDesignation(Ndesignation);
				produit.setPrixAchat(NPrixAchat);
				ps.update(produit);
				break;
			case 8:
				System.out.println("***La suppression d'un produit***");
				System.out.println("Donner l'id du produit à supprimer:");
				id = sc.nextInt();

				ps.delete(ps.findById(id));
				break;
			case 9:
				System.out.println("***Affichage d'un produit***");
				System.out.println("Donner l'id du produit à afficher:");
				id = sc.nextInt();
				ps.findById(id);

			case 10:
				System.out.println("***La liste des produits***");
				for (Produit p : ps.findAll()) {
					System.out.println(p);
				}
				break;
			case 11:
				System.out.println("***L'ajout d'une commande***");
				System.out.println("Donner le code de la commande :");
				code = sc.nextInt();
				System.out.println("Donner l'id du client :");
				id = sc.nextInt();
				cms.create(new Commande(code, new Date(), cs.findById(id)));
				System.out.println("Donner le nombre de lignes de la commande");
				nbrLignes = sc.nextInt();
				for (int i = 0; i < nbrLignes; i++) {
					System.out.println("Donner l'id du produit :");
					idProduit = sc.nextInt();
					System.out.println("Donner la quantité :");
					qte = sc.nextInt();
					System.out.println("Donner le prixde vente :");
					prixVente = sc.nextInt();
					cms.findById(code).getLigneCommandes()
							.add(new LigneCommande(cms.findById(code), ps.findById(idProduit), qte, prixVente));
				}

				break;
			case 12:
				System.out.println("***La modification d'une commande***");
				System.out.println("Donner l'id de la commande à modifier:");
				 id = sc.nextInt();
				System.out.println("Donner le nouveau code :");
				Ncode = sc.nextInt();
				System.out.println("Donner le nouveau id du client :");
				Nid = sc.nextInt();
				
				Commande cmd=cms.findById(Ncode);
				cmd.setCode(Ncode);
				cmd.setDate(new Date());
				cmd.setClient(cs.findById(Nid));
				cms.update(cmd);
				break;
			case 13:
				System.out.println("***La suppression d'une commande***");
				System.out.println("Donner l'id de la commande à supprimer:");
				id= sc.nextInt();
				cms.delete(cms.findById(id));
				break;
			case 14:
				System.out.println("***Affichage d'une commande***");
				System.out.println("Donner l'id du client à afficher:");
				id=sc.nextInt();
				cs.findById(id);
				
			case 15:
				System.out.println("***La liste des commandes***");
				for (Commande c : cms.findAll()) {
					System.out.println(c);
				}
				break;

			}

		}
	}
}

