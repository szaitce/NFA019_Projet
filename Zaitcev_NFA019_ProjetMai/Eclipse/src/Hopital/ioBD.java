package Hopital;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ioBD {
    public ioBD() {
    }


    public static String pathBD;


    public static String chercherPathBD () {
//    	String workingDIR = System.getProperty("user.dir");
//    	String separatorSYS = System.getProperty("file.separator");
    	String workingDIR = System.getProperty("user.dir");
    	pathBD = workingDIR;
    	return pathBD;
    }
    
    /**
     * @param alToFile
     */
    public static boolean saveALtoFile(ArrayList<String> arl, String file) throws IOException{
    	FileWriter lines = null;
		try {
			lines = new java.io.FileWriter (file, true);
			for (int i=0; i<arl.size(); i++) {
				lines.write(arl.get(i)+"\n");
			}
		}catch(Exception E) {
			return false;
		}
		lines.close();
	return true;
	}

    /**
     * delete all info from ArrayList
     * extract info from file to Array List
     * 
     */
    public static ArrayList<String> readALfromFile(ArrayList<String> arl, String file) throws IOException{
    	
    	java.io.BufferedReader lines;
    	try {
    		lines = new java.io.BufferedReader(new java.io.FileReader (file));
    		while (lines.ready()){
    			arl.add(lines.readLine());
    		}
    	}catch(Exception E) {
    		System.out.println("can't find the file "+file);
    	}
    	gereBD.afficherAL(arl, 18);
    	return arl;
    }
    public static ArrayList<String[]> readALTabFromFile(ArrayList<String []> arl, String file) throws IOException{
    	ArrayList <String> al = new ArrayList <String> (); 
    	al = readALfromFile (al, file);
    	arl = gereBD.convertirALtoAlTab(al);
    	gereBD.afficherALTab(arl, 25);
    	return arl;
    }
}