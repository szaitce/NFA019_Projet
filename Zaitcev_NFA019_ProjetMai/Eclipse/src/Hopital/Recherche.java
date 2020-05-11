package Hopital;

import java.util.*;

/**
 * 
 */
public class Recherche {

    /**
     * Default constructor
     */
    public Recherche() {
    	
    }
    

    
    /**
     * chercher un mot sur une seule ArrayList
     * return = ArrayList <String>
     * return = une liste des iDs, dans les lignes ou il y a le 'mot'
     * return 'null' s'il n'y a pas. 
     */
    public static ArrayList<String> idInAL (String mot, ArrayList<String> al) {
        ArrayList<String> res = new ArrayList<String> ();
        int r=Integer.parseInt(al.get(0));
        int z=al.size();
        int line=0;
        //chercher le mot dans AL
        for (int i=r+1; i<z; i++) {
          if (mot.equals(al.get(i))) {
              line=(int) (Math.floor((i-1)/r));
              res.add(al.get(line*r+1));
          }
        }
        return res;
    }
 
    
    
    /**
     * chercher un mot sur une seule ArrayList
     * return = ArrayList
     * return = une liste des la meme "mot" (type 'String')
     * return 'null' s'il n'y a pas. 
     */
    public static ArrayList<String> unMotInAL (String mot, ArrayList<String> al) {
    	ArrayList<String> res = new ArrayList<String> ();
    	for (String str : al) {
    		if (str.equals(mot)) {
    			res.add(str);
    		}
    	}
		return res;    	
    }
    
    
    
    /**
    * chercher un <String> sur une seule ArrayList
    * return = int
    * return = le number de mot <String> 
    * return '0' s'il n'y a pas
    * !!!!
    * !!!! net proverki na mnozhestvennost'!!!
    * !!!! vydaet pervyj index ot nachala ArrayList
    */
    public static int indexInAL (String mot, ArrayList<String> al) {
    	int res =0, compt=0;
    	String str;
    	do{
    		str=al.get(compt);
    		if (str.equals(mot)) {
    			res=al.indexOf(str);
    		}
    		compt++;
    	} while  (compt<al.size() && res==0);
    	return res;
    }
    
    /**
    * chercher un <String> sur une seule ArrayList
    * return = int
    * return = le numero de ligne <String> []
    * return '-1' s'il n'y a pas
    * !!!!
    * !!!! net proverki na mnozhestvennost'!!!
    * !!!! vydaet pervyj index ot nachala ArrayList
    */
    public static int indexInALTab (String mot, ArrayList<String[]> al, int col) {
    	int res =-1, compt=0;
    	String str;
    	do{
    		str=al.get(compt)[col];
    		if (str.equals(mot)) {
    			res=compt;
    		}
    		compt++;
    	} while  (compt<al.size() && res==-1);
    	return res;
    }
    
    /**
     * chercher un 'mot' <String> dans la 'colonne' de ArrayList
     * return = int
     * return = le number de line de ArrayList 
     * return '0' s'il n'y a pas
     * !!!!
     * !!!! net proverki na mnozhestvennost'!!!
     * !!!! vydaet pervyj index ot nachala ArrayList
     */
    public static int tulpeInTabInAL (String mot, ArrayList<String []> al, int colonne) {
    	int res =0, compt=0;
    	if (al.size()>0) {
	    	String [] str = new String [(al.get(0)).length];
	    	do{
	    		str=al.get(compt);
	    		if (str[colonne].equals(mot)) {
	    			res=compt;
	    		}
	    		compt++;
	    	} while  (compt<al.size() && res==0);
    	}else {
    		System.out.println ("recherche.tulpeInTabInAl: Error of ArrayList");
    	}
    return res;
    }
}