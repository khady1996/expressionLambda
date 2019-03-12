package fr.ensup.gestionEtablissementScolaire.domaine;

import java.util.Comparator;

public class ComparePersonneParNom implements Comparator<Personne> {

	@Override
	public int compare(Personne p1, Personne p2) {
		// TODO Auto-generated method stub
		return p1.getNom().compareTo(p2.getNom());
	}

}
