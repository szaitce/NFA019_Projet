package Hopital;

import java.io.IOException;
import java.util.*;

public class gereBD {
	private static int r;
	private static int z;

    /**
     * Default constructor
     */
    public gereBD(ArrayList<String> al) {
        r=Integer.parseInt(al.get(0));
        z=al.size();
    }
    
 //   gereBD.chargerBD(pat1,pat2,medcin,consult1,consult2,consult3,appareil,log);
    
    public static void chargerBD (
    		ArrayList<String []>pat1,
    		ArrayList<String []>pat2,
    		ArrayList<String []>medcin,
    		ArrayList<String []>consult1,
    		ArrayList<String []>consult2,
    		ArrayList<String []>consult3,
    		ArrayList<String []>tecnicien,
    		ArrayList<String []>appareil,
    		ArrayList<String>log)  throws IOException { 
	pat1=	 ioBD.readALTabFromFile (pat1, "patients1.hpt");
	pat2=	 ioBD.readALTabFromFile (pat2, "patients2.hpt");
	medcin=	 ioBD.readALTabFromFile (medcin, "medecins.hpt");
	consult1=ioBD.readALTabFromFile (consult1, "consultation1.hpt");
	consult2=ioBD.readALTabFromFile (consult2, "consultation2.hpt");
	consult3=ioBD.readALTabFromFile (consult3, "consultation3.hpt");
	tecnicien=ioBD.readALTabFromFile (tecnicien, "tecnicien.hpt");
	appareil=ioBD.readALTabFromFile (appareil, "appareilles.hpt");
	log = 	 ioBD.readALfromFile (log, "login.hpt");
	
//	afficherAL(log, 20);
//	gereBD.afficherAL(pat1, 15);
//	gereBD.afficherAL(pat2, 15);
//	gereBD.afficherAL(medcin, 15);
//	gereBD.afficherAL(consult1, 15);
//	gereBD.afficherAL(consult2, 15);
//	gereBD.afficherAL(consult3, 25);
//	gereBD.afficherAL(appareil, 20);
    }
    
    public static ArrayList <String []> convertirALtoAlTab (ArrayList <String> al){
    	int r=Integer.parseInt(al.get(0));
    	int z=al.size();
    	ArrayList <String []> alRes = new ArrayList <String []> ();
    	for (int i=1; i<z; i=i+r) {
    		String [] tab = new String [r];
    		for (int j=0; j<r; j++) {
    			tab[j]=al.get(i+j);
    		}
    		alRes.add(tab);
    	}
    	return alRes;
    }
    
    public static ArrayList <String> convertirAlTabToAL (ArrayList <String []> al){
    	int r=al.get(0).length;
    	int z=al.size();
    	ArrayList <String> alRes = new ArrayList <String> ();
    	alRes.add(Integer.toString(r));
    	for (int i=0; i<z; i++) {
    		for (String str : al.get(i)) {
    			alRes.add(str);
    		}
    	}
    	return alRes;
    }
    
    
    
    public static void afficherTabDD (String [][] tab, int maxSymboles) {
    	int lines=tab.length;
    	int cols=tab[0].length;
    	String str;
    	for (int i=0; i<cols; i++) {
    		for (int j=0; j<lines; j++) {
    			str = tab[i][j];
    			System.out.print(str+espaces(str.length(), maxSymboles));
        	}
        System.out.println();
      	}
    }
    
    public static void afficherAL(ArrayList<String> al, int maxSymboles) {
    	int r=Integer.parseInt(al.get(0));
// output tete de tableau
    	for (int i=1; i<=r; i++) {     
    		System.out.print(al.get(i)+espaces(al.get(i).length(), maxSymboles));
    	}
    	System.out.println();
    	int z=al.size();
// output corps de tableau 
    	for (int n=r+1; n<z; n=n+r) {    
    		for (int j=n; j<n+r; j++) {      
        		System.out.print(al.get(j) + espaces(al.get(j).length(), maxSymboles) );
        	}
        	System.out.println();
    	}

    }
    public static void afficherALTab(ArrayList<String []> al, int maxSymboles) {
    	String [] str=al.get(0);
    	int r=str.length;
// output tete de tableau
    	for (int i=0; i<r; i++) {     
    		System.out.print(al.get(0)[i]+espaces(al.get(0)[i].length(), maxSymboles));
    	}
    	System.out.println();
    	int z=al.size();
// output corps de tableau 
    	for (int n=1; n<z; n++) {
    		for (int i=0; i<r; i++) {      
        		System.out.print(al.get(n)[i] + espaces(al.get(n)[i].length(), maxSymboles) );
        	}
        	System.out.println();
    	}

    }
    public static String espaces (int n, int max) {
    	String res="";
    	if (max>n) {
    		for (int i=max; i>n; i--) {
    			res=res+" ";
    		}
    	}
    	return res;
    }
    
    public static String [] alToTab (ArrayList<String> al) {
    	int r=Integer.parseInt(al.get(0));
    	int z=al.size();
    	String [] tab = new String [z-r-1];
    	for (int i=r+1, j=0; i<z; i=i+1, j++) {    // 	output corps de tableau 
    		tab [j] = al.get(i);
    	}
    	return tab;
    }

    /**
     * chercher les lignes qui inclus le mot sur une ArrayListIn2
     * 'col' = number de colonne (0=first)
     * return = ArrayList
     * return = ligne de 'alIn1' + ligne de 'alIn2' avec 'element clé 'colIn1'='colIn2' (Tab1 et Tab2)
     * return = une liste des lignes structures par la meme facon que ArrayList entree (avec Chapeau)
     * return = les ligne qui contient le 'mot'
     * return 'null' s'il n'y a pas. 
     */
    public static ArrayList<String> ajouterLignesInAL 
    (int colIn1, int colIn2, ArrayList<String> alIn1, ArrayList<String> alIn2) {
    	String elementCle;
    	int indexLineCleIn2;
    	ArrayList<String> res = new ArrayList<String> ();
    	int r1=Integer.parseInt(alIn1.get(0));
    	int z1=alIn1.size();
    	int r2=Integer.parseInt(alIn2.get(0));    	
    	//longueur de ligne res sera la somme des longueurs des Tab1 et Tab2
    	res.add(0, Integer.toString(Integer.parseInt(alIn1.get(0))+Integer.parseInt(alIn2.get(0))));
    	
    	//probegaem po strokam tablicy, i1=pervyj element
    	for (int i1=r1+1; i1<z1; i1=i1+r1) {
    	
    		//copie alIn1 -> res
    		for (int j1=i1; j1<i1+r1; j1++) {
    			res.add(alIn1.get(j1));
    		}
    		
    		//chercher dans alIn2 un element suivant de col de alIn1 et ajouter cette ligne dans 'res'
    		// najti sleduyuschij element kolonki iz 'alIn1' i dobavit' vsyu liniyu v 'res'
    		// si element n'est pas unique l'algo ne marche pas correctement!!!
    		elementCle=alIn1.get(i1+colIn1-1); 
    		indexLineCleIn2=alIn2.indexOf(elementCle)-colIn2+1;
    		for (int j2=indexLineCleIn2; j2<indexLineCleIn2+r2; j2++) {
    			res.add(alIn2.get(j2));
    		}
    	}
    	
    	ajouterChapeauShift(alIn2, res, 1);
    	ajouterChapeauShift(alIn1, res, 1);
    	return res;
    }
    /**
     * chercher les lignes qui inclus le mot sur une ArrayListIn2
     * 'col' = number de colonne (0=first)
     * return = ArrayList
     * return = ligne de 'alIn1' + ligne de 'alIn2' avec 'element clé 'colIn1'='colIn2' (Tab1 et Tab2)
     * return = une liste des lignes structures par la meme facon que ArrayList entree (avec Chapeau)
     * return = les ligne qui contient le 'mot'
     * return 'null' s'il n'y a pas. 
     */
    public static ArrayList<String []> ajouterLignesInALTab (
    		int colIn1, 
    		int colIn2, 
    		ArrayList<String []> alIn1, 
    		ArrayList<String []> alIn2) {
    	ArrayList <String []> res = new ArrayList <String []> ();
    	
    	String elementCle;
    	int r1=(alIn1.get(0)).length;
    	int z1=alIn1.size();
    	int r2=(alIn2.get(0)).length;
    	int lineAlIn2;
    	//longueur de ligne 'res' sera la somme des longueurs des Tab1 et Tab2
    	//probegaem po strokam tablicy, i=pervyj element
    	for (int i=0; i<z1; i=i+1) {
			String [] str=alIn1.get(i);
    		String [] tab = new String [r1+r2];
    		//copie alIn1 -> res
    		tab=copieLineTabToTab (str, tab, 0, str.length,0);
    		
    		//chercher dans alIn2 un element suivant de col de alIn1 et ajouter cette ligne dans 'res'
    		// najti sleduyuschij element kolonki iz 'alIn1' i dobavit' vsyu liniyu v 'res'
    		// si element n'est pas unique l'algo ne marche pas correctement!!!
    		elementCle=str [colIn1];
    		lineAlIn2 = Recherche.indexInALTab(elementCle, alIn2, colIn2);		// number of line of AlIn2 with elementCle
    		tab=copieLineTabToTab (alIn2.get(lineAlIn2), tab, 0, alIn2.get(lineAlIn2).length, str.length);
    			res.add(tab);
    	}
    	return res;
    }   
    
    
    //
    //      copy elements of 'tbaIn' to 'tabOut'
    //		
    //
    public static String [] copieLineTabToTab (
    		String [] tabIn, 						// tab source
    		String [] tabOut,						// tab return
    		int tulpeFirstOfTabIn, 					// first element of Tab source
    		int longueurTulpesTabIn,				// quantite des elements pour copier
    		int tulpeFirstOfTabOut) {				// first tulpe for record
    	int rIn = tabIn.length;
    	int rOut = tabIn.length;
    	if (	rIn > tulpeFirstOfTabIn +longueurTulpesTabIn &&
    			rOut> tulpeFirstOfTabOut+longueurTulpesTabIn) {
    		for (int i=tulpeFirstOfTabIn, j=tulpeFirstOfTabOut;
    				i<longueurTulpesTabIn; i++, j++) {
    			tabOut [j]= tabIn[i];
    		}
    	}else {
    		System.out.println("Methode 'copieLineTabToTab': Errore de longueur dans tableau(x)");
    	}
    	return tabOut;
    }
    
    
    
    /**
     * 
     * chercher les lignes qui inclus le mot sur une seule colonne d'ArrayList
     * return = ArrayList
     * return = une liste des lignes structures par la meme facon que ArrayList entree (avec Chapeau)
     * return = les ligne qui contient le 'mot'
     * return 'null' s'il n'y a pas. 
     */
    public static ArrayList<String> linesInAL (int colAl, String mot, ArrayList<String> al) {
        ArrayList<String> res = new ArrayList<String> ();
        int r=Integer.parseInt(al.get(0));
        int z=al.size();
        int line=0, j=0;
        //chercher le mot dans AL
        for (int i=r+colAl; i<z; i=i+r) {
          if (mot.equals(al.get(i))) {
            line=(int) (Math.floor((i-1)/r));
            for(j=line*r+1; j<line*r+1+r; j++) {
              res.add(al.get(j));
            }
 //           i=j; //pour eviter d'ajouter deux fois la-meme ligne
          }
        }
        res=ajouterChapeau(al,res);
        afficherAL(res,20);
        return res;
    }

    public static ArrayList<String []> linesInALTab (int colAl, String mot, ArrayList<String []> al) {
        ArrayList<String []> res = new ArrayList<String []> ();
        if (al.size()>1) {
	        for (int i=1; i<al.size(); i++) {
	        	if (mot.equals(al.get(i)[colAl])) {
	        		res.add(al.get(i));
	        	}
	        }
        }else {
        	System.out.println ("linesInALTab error: ArrayList is empty");
        }
        res.add(0, al.get(0));
        afficherALTab(res,20);
        return res;
    }

    
    
    /**
     * ajouter chapeau de alBase dans alRes
     * return = ArrayList<String>
     * return = alRes avec Chapeau 
     */
    public static ArrayList<String> ajouterChapeauShift (ArrayList<String> alBase, ArrayList<String> alRes, int shift){
        r=Integer.parseInt(alBase.get(0));
    	if (alRes.size()>0){
            for (int i=shift; i<r+1; i++){
              alRes.add(i, alBase.get(i));
            }
          }
    	return alRes;
    }
    public static ArrayList<String> ajouterChapeau (ArrayList<String> alBase, ArrayList<String> alRes){
    	alRes=ajouterChapeauShift(alBase, alRes, 0);
    	return alRes;
    }
    
    /**
     * chercher les lignes qui inclus le id sur une seule ArrayList
     * return = ArrayList
     * return = copy "line by line"
     * return = une liste des lignes structures par la meme facon que ArrayList entree 'alBase' (avec Chapeau)
     * return = les ligne qui correspodants les 'id' dans une autre liste 'alBase'
     * return 'null' s'il n'y a pas.
     *  
     */
    public static ArrayList<String> idInAL (int id, ArrayList<String> alBase, ArrayList<String> alx) {
    	
		ArrayList <String> alRes = new ArrayList <String>();
        int r=Integer.parseInt(alBase.get(0));
        int z=alBase.size();
        int r2=Integer.parseInt(alx.get(0));
        int z2=alx.size();
        
        //chercher le mot dans AL
        for (int i=r+1; i<z; i=i+r) {
        	for (int k=r2+1; k<z2; k=k+r2) {
	        	if (id==Integer.parseInt(alx.get(i))) {
		        	for (int j=k; j<k+r2; j++) {
		        		alRes.add(alx.get(j));
		        	}
	        	}
        	}
        }
        alRes=ajouterChapeau(alx, alRes);
    	return alRes;
    }
    
    
    // Create TAB from every first or 'x' (shift) element of ArrayList
    // Entree: 
    // al=ArrayList, 
    // shift= shift from first tuple, 
    
    public static String [] unColOfAlToTab (ArrayList<String> al, int shift) {
    	int r=Integer.parseInt(al.get(0));  			// nombre of colonnes dans ArrayList
    	int z=al.size();								// nombre d'elements dans ArrayList
    	int lignes =((z-1)/r)-1;						// nombre d'lignes dans ArrayList sans chapeau 													
    	String [] tab = new String [lignes];			// longueur de tableau
    	for (int i=r+1+shift, j=0; i<z; i=i+r, j++) {	// 	output corps de tableau 
    		tab [j] = al.get(i);
    	}
    	return tab;
    }
    
    // Create TAB from 'qqs' element (with 'shift' from first) of ArrayList
    // tab[i] = al.get[j]+ ", " +al.get[j+1]+ ", " +al.get[j]+ ", " + ... + al.get[j+qqs]
    // Entree: 
    // al=ArrayList, 
    // shift= shift from first tuple, 
    // qqs= quantité les tuple pour les coler

    public static String [] qqsColsOfAlToTab (ArrayList<String> al, int shift, int qqs) {
    	int r=Integer.parseInt(al.get(0));  			// nombre of colonnes dans ArrayList
    	int z=al.size();								// nombre d'elements dans ArrayList
    	int lignes =((z-1)/r)-1;						// nombre d'lignes dans ArrayList sans chapeau 													
    	String [] tab = new String [lignes];		// longueur de tableau
    	for (int i=r+1+shift, j=0; i<z; i=i+r, j++) {   // 	i=compteur de ArrayList, j = compteur de Tab 
    		tab [j] = "";
    		for (int k=i; k<i+qqs; k++) {
    			tab [j] = tab [j] + al.get(k)+ ", "; 
    		}
    	}
    	return tab;
    }
    
    
    // Create TAB from 'qqs' colons of ArrayList (in order of indexTab[]) 
    // tab[i] = al.get[indexTab[i1]]+ ", " +al.get[indexTab[i2]]+ ", " +al.get[indexTab[i3]+ ", " + ... + al.get[indexTab[i+n]]
    // Entree: 
    // al=ArrayList, 
    // 

    public static String [][] listColsOfAlToTabDD (ArrayList<String> al, int [] cols) {
    	int r=Integer.parseInt(al.get(0));  			
    	int z=al.size();								
    	int lignes =((z-1)/(r-cols.length));   									//lignes avec les chapeau
    	String [][] tab = new String [lignes][cols.length];
    	for (int c=0; c<cols.length; c++) {										// c = num de colonne de Tab
// copier les elements de colonne 'c'
// i = num d'element de AL
// j = num d'element de Tab[j][]
	    	for (int i=r+1+cols[c], j=0; i<z; i=i+r, j++) {
	    		tab [j][c]=al.get(i);
	    	}
	    }
    	return tab;
    }
    public static String [][] listColsOfAlTabToTabDD (ArrayList<String []> al, int [] cols) {
    	int r=(al.get(0)).length;
    	int z=al.size();
    	int lignes =r;   														//lignes avec les chapeau
    	String [][] tab = new String [lignes][cols.length];
    	for (int ligne=1; ligne<z; ligne++) {
    		for (int col : cols) {												// c = num de colonne de Tab
    			tab [ligne][col]=al.get(ligne)[cols[col]];
    		}
    	}
    	return tab;
    }
    
    //
    // Determination le quantite des lignes dans BD de AL
    //
    public static int xLine (ArrayList<String> al) {
    	int r=Integer.parseInt(al.get(0));
    	int z=al.size();
    	int res =(int) ((z-1)/r-1);
    	return res;
    }
    
    /**
     * @param al
     * @throws IOException 
     */
	public static void ajouterElem( ArrayList<String> al, String [] addElement, String file) throws IOException {
		//
		// comparer les longeurs des lists
		if (Integer.parseInt(al.get(0))==(addElement.length-1)) {
			//
			//lire lastId de list
			int lastId=Integer.parseInt(al.get(al.size()-Integer.parseInt(al.get(0))));
			al.add(Integer.toString(lastId+1)+"/n");
			//
			// ajouter les autres elements
			for (int i=0; i<addElement.length; i++) {
				al.add(addElement[i]+"/n");
			}
			boolean saveGood=ioBD.saveALtoFile (al, file);
			if (saveGood) {
				System.out.println ("BD est renové");
			}else {
				System.out.println ("Error de renover BD");
			}
		}else {
			System.out.println("les taille de ArrayList ne convient de taille d'elements ajoutes");
		}
		return;
    }

    /**
     * @param al
     * @throws IOException 
     */
    public void modifierElem(ArrayList<String> al, String [] modElement, int nId, String file) throws IOException {
		if (Integer.parseInt(al.get(0))==modElement.length) {
			for (int i=0; i<modElement.length; i++) {
				al.set(nId+i,modElement[i]);
			}
			boolean saveGood=ioBD.saveALtoFile (al, file);
			if (saveGood) {
				System.out.println ("BD est renové");
			}else {
				System.out.println ("Error de renover BD");
			}
		}else {
			System.out.println("les taille de ArrayList ne convient de taille d'elements ajoutes");
		}
		return;
    }

    /**
     * @param al
     */
    public void supprimerElem(ArrayList<String> al, int idElem, String file) {

    	
    	
    	
        
    }

}