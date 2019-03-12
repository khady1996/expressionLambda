package fr.ensup.gestionEtablissementScolaire.presentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TooManyListenersException;
import java.util.stream.*;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

import fr.ensup.gestionEtablissementScolaire.domaine.Personne;
import fr.ensup.gestionEtablissementScolaire.domaine.ComparePersonneParNom;
import fr.ensup.gestionEtablissementScolaire.domaine.Etudiant;
import fr.ensup.gestionEtablissementScolaire.service.ConnexionLogiciel;
import fr.ensup.gestionEtablissementScolaire.service.EtudiantService;

public class Test {

	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(System.in);
		boolean conf = false;
		int choix = 6;

		ConnexionLogiciel session = new ConnexionLogiciel();

		List<Personne> personnes = creerPersonnes(); // jeu de donn�es

		System.out.println(personnes);

//		do {
//
//			// Ouverture de session
//
//			while (conf == false) {
//
//				System.out.println("Veuillez-vous connecter SVP :\n");
//				System.out.println("Login :");
//				String log = scan.nextLine();
//				System.out.println("\nPassword :");
//				String pwd = scan.nextLine();
//
//				conf = session.ouvrirsession(log, pwd);
//
//			}
//
//			EtudiantService etusv = new EtudiantService();
//
//			System.out.println("Que souhaiteriez vous faire :\n" + "1 : Créer un étudiant\n"
//					+ "2 : Lire les informations d'un étudiant\n" + "3 : Modifier une des informations sur l'étudiant\n"
//					+ "4 : Supprimer un étudiant\n" + "5 : Lister l'ensemble des étudiants de l'école\n"
//					+ "6 : Quitter\n");
//
//			choix = scan.nextInt();
//
//			switch (choix) {
//			case 1:
//				etusv.ajouterEtudiant(etu1); 
//				etusv.ajouterEtudiant(etu2);
//				break;
//			case 2:
//				etusv.recupererEtudiant(1);
//				break;
//			case 3:
//				etusv.modifierEtudiant(2, "versailles");
//				break;
//			case 4:
//				etusv.supprimerEtudiant(2);
//				break;
//			case 5:
//				etusv.recupererTout();
//				break;
//			}
//
//		} while (choix != 6);

		// Collections.sort(personnes, new ComparePersonneParNom()); // avant java 8

//		Collections.sort(personnes, (Personne p1, Personne p2) -> {
//			return p1.getNom().compareTo(p2.getNom());
//			}
//	);

//		Collections.sort(personnes, (p1, p2) -> {return p1.getNom().compareTo(p2.getNom());}
//personnes.sort(Comparator.comparing(p->p.getNom())
		personnes.sort(Comparator.comparing(Personne::getNom)

		);
//		System.out.println(personnes);

		List<String> listePersonnes = new ArrayList<>();
		for (Personne personne : personnes) {
			if (personne.getNom() == "NDIAYE" && personne.getId() > 2) {
				listePersonnes.add(personne.getPrenom().toUpperCase());
			}
		}
		System.out.println(listePersonnes);

//		List<String> listePersonnes2;
//		listePersonnes2 = personnes.stream().filter(person -> person.getNom() == "NDIAYE")
//				.filter(person -> person.getId() > 1).map(person -> person.getPrenom().toUpperCase()).collect(toList());
//		System.out.println(listePersonnes2);

	}

	public static List<Personne> creerPersonnes() {
		return Arrays.asList(new Personne(1, "NDIAYE", "KHADY", "knd@ensup.fr", "bagneux", "07.56.79.38.22"),
				new Personne(2, "FALL", "COUMBA", "cfll@ensup.fr", "nanterre", "06.76.00.54.98"),
				new Personne(3, "BA", "BOUBA", "bbouba@ensup.fr", "medina", "05.77.28.52.04"),
				new Personne(4, "NDIAYE", "HAMATH", "ahmeth@ensup.fr", "poissy", "01.77.40.41.18"),
				new Personne(5, "BALDE", "AZIZ", "zizb@ensup.fr", "defense", "02.89.98.15.27"),
				new Personne(6, "DUPONT", "MAXIME", "maximou@ensup.fr", "guyancourt", "06.16.64.24.41"));
	}

}
