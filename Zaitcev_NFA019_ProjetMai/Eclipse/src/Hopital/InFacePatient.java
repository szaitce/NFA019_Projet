package Hopital;

import java.io.IOException;
import java.util.ArrayList;

public class InFacePatient extends Interface {

	public InFacePatient() throws IOException {
	}
	
	public static void afficherPlaning (
			int idPat,
    		ArrayList<String []>pat1,
    		ArrayList<String []>pat2,
    		ArrayList<String []>medcin,
    		ArrayList<String []>consult1,
    		ArrayList<String []>consult2,
    		ArrayList<String []>consult3,
    		ArrayList<String []>tecnicien,
    		ArrayList<String []>appareil) {
		
		// recevoir le liste des consultations avec le patient "id"
		ArrayList <String[]> tableIdPat = new ArrayList <String[]>();
		gereBD.afficherALTab(consult2, 18);
		tableIdPat = gereBD.linesInALTab (2, Integer.toString(idPat), consult2);
		gereBD.afficherALTab(tableIdPat, 12);
		

		//recevoir le liste des dates et des heures des consultations 
		if (tableIdPat==null) {
			System.out.println ("Liste est vide");
		}else {
			tableIdPat=gereBD.ajouterLignesInALTab(1,1,tableIdPat, consult1); // dates et l'heures de consultations
			tableIdPat=gereBD.ajouterLignesInALTab(3,1,tableIdPat, medcin); // coordonets des medcins
			gereBD.afficherALTab(tableIdPat, 12);
			// tb est Array d'ordre de colonnes pour le Tab future
			// donc il sera sortirai premier colonne =1; deuxieme =5, etc
			int [] tb = {1,5,6,10,9,8,12};    
			String [][] planingPat;
			planingPat = new String [1+tableIdPat.size()][7]; // [line][column]
			planingPat = gereBD.listColsOfAlTabToTabDD(tableIdPat, tb);
//			planingPat[0][0] = "num";
//			planingPat[0][1] = "date";
//			planingPat[0][2] = "l'heure";
//			planingPat[0][3] = "chez (prof)";
//			planingPat[0][4] = "Medecin, Nom";
//			planingPat[0][5] = "Prenom";
//			planingPat[0][6] = "Bureau";
		gereBD.afficherTabDD(planingPat, 20);
		
		}
	}


}
