package Hopital;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class InFaceAdmin extends Interface {


	public InFaceAdmin() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}




	/**
	 * @wbp.nonvisual location=-30,-31
	 */
	private final JPanel panel = new JPanel();

	


	/**
	 * Create the application.
	 */

	
	public void initialize() {


//		JList <String> listPatients = new JList <String> (gereBD.qqsColsOfAlToTab(pat1, 1, 3));
//    	String [] tab = new String [((pat1.size()-1)/Integer.parseInt(pat1.get(0)))-1];
////		JList <String> listPatients = new JList <String> ();
//    	listPatients.addListSelectionListener(new ListSelectionListener() {
//    		public void valueChanged(ListSelectionEvent arg0) {
//    			int choixPatient = listPatients.getSelectedIndex();
//    			int iDchoixPatientAL =  1+(choixPatient+1)*Integer.parseInt(pat1.get(0));
//    			int idChoixPatient = Integer.parseInt(pat1.get(iDchoixPatientAL));
//    			dateNaissPat = pat1.get(4+(choixPatient+1)*Integer.parseInt(pat1.get(0)));
//    			System.out.println (dateNaissPat );
////    			labelIndDateNaissPat.setText(dateNaissPat);
////			    labelIndDateNaissPat.paintImmediately(labelIndDateNaissPat.getVisibleRect());
//    			
//    		}
//		}
//    	);
		
		JLabel labelDateNaissPat = new JLabel("Date de naissance:");
		labelDateNaissPat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelDateNaissPat.setBounds(449, 112, 118, 23);
		Interface.frame.getContentPane().add(labelDateNaissPat);

		JLabel labelIndDateNaissPat = new JLabel();
		labelIndDateNaissPat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelIndDateNaissPat.setBounds(577, 116, 134, 14);
		Interface.frame.getContentPane().add(labelIndDateNaissPat);
//		labelIndDateNaissPat.setText(dateNaissPat);
		
    	
    	
//		listPatients.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		listPatients.setLayoutOrientation(JList.VERTICAL);
//		listPatients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		listPatients.setBounds(71, 111, 339, 214);
//		Interface.frame.getContentPane().add(listPatients);
		
		JButton newPatient = new JButton("Patient nouveau");
		newPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String [] patNew = dialogPat.noveau ("Patient nouveau", true);
//				framePatNew.setVisible (true);
//			}
//			String [] dialogPat.New (String string, boolean b) {
//				// TODO Auto-generated method stub
//				return null;
			}
		});
		newPatient.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newPatient.setBounds(449, 66, 134, 23);
		Interface.frame.getContentPane().add(newPatient);
		
//		JList<String> listMedecins = new JList <String> (gereBD.qqsColsOfAlToTab(medcin, 1, 3));
//		listMedecins.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		listMedecins.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		listMedecins.setBounds(71, 401, 339, 294);
//		Interface.frame.getContentPane().add(listMedecins);
		
//		JList <String> listProfMedecin = new JList <String> (gereBD.qqsColsOfAlToTab(medcin, 3, 1));
//		listProfMedecin.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		listProfMedecin.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		listProfMedecin.setBounds(449, 401, 134, 294);
//		Interface.frame.getContentPane().add(listProfMedecin);
		
		JList <String> listCreneauDispo = new JList <String> ();
		listCreneauDispo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		listCreneauDispo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCreneauDispo.setBounds(635, 401, 134, 294);
		Interface.frame.getContentPane().add(listCreneauDispo);
		

		
		JTextField textChercher = new JTextField();
		textChercher.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textChercher.setBounds(660, 28, 194, 20);
		Interface.frame.getContentPane().add(textChercher);
		textChercher.setColumns(10);
		
		JButton buttonChercher = new JButton("recherche");
		buttonChercher.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonChercher.setBounds(862, 27, 89, 23);
		Interface.frame.getContentPane().add(buttonChercher);
		
		JButton confChoix = new JButton("Confirmer");
		confChoix.setFont(new Font("Tahoma", Font.PLAIN, 12));
		confChoix.setBounds(817, 402, 144, 23);
		Interface.frame.getContentPane().add(confChoix);
		
		JLabel lblPatient = new JLabel("Patient");
		lblPatient.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPatient.setBounds(71, 86, 46, 14);
		Interface.frame.getContentPane().add(lblPatient);
		
		JLabel lblMedecin = new JLabel("Medecin");
		lblMedecin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMedecin.setBounds(71, 376, 46, 14);
		Interface.frame.getContentPane().add(lblMedecin);
		
		JLabel lblSpecialisation = new JLabel("Specialisation");
		lblSpecialisation.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSpecialisation.setBounds(449, 376, 86, 14);
		Interface.frame.getContentPane().add(lblSpecialisation);
		
		JLabel lblCreanaux = new JLabel("Creanaux");
		lblCreanaux.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCreanaux.setBounds(635, 377, 89, 14);
		Interface.frame.getContentPane().add(lblCreanaux);
	}
}
