package Hopital;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interface {

    static ArrayList<String []> pat1 = new ArrayList<String []> ();
    static ArrayList<String []> pat2 = new ArrayList<String []> ();
    static ArrayList<String []> medcin = new ArrayList<String []> ();
    static ArrayList<String []> consult1 = new ArrayList<String []> ();
    static ArrayList<String []> consult2 = new ArrayList<String []> ();
    static ArrayList<String []> consult3 = new ArrayList<String []> ();
    static ArrayList<String []> tecnicien = new ArrayList<String []> ();
    static ArrayList<String []> appareil = new ArrayList<String []> ();
    static ArrayList<String> log = new ArrayList<String> ();
    static String login;
    static char [] pass;
    /*
     * statusLog=-1 system log Off
     * statusLog= 0 login superAdmin
     * statusLog= 1 login agent admin
     * statusLog= 2 login medecin
     * statusLog= 3 login technicnien
     * statusLog= 4 login patient
     */
    public static int statusLog;
	public static String dateNaissPat ="jj/mm/aaaa";
	public static String [] choixAction = {
			"modifier patient",
			"ajouter une consultation",
			"supprimer patient"};
	
	static JFrame frame;
	private final JTextField textField;
	private final JPasswordField passwordField;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		statusLog = -1;
		System.out.println( ioBD.chercherPathBD() );
		gereBD.chargerBD(pat1,pat2,medcin,consult1,consult2,consult3,tecnicien,appareil,log);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public Interface() throws IOException {
		this.textField = new JTextField();
		this.passwordField = new JPasswordField();
		initialize();
		
	}

	protected void Listener(
			JLabel lblFonImage,
			JTextField tfLogin,
			JPasswordField passField
//			,JButton btnLogInOut
			){
		if (statusLog==-1) {
//			Button "Log" is in state "Log In"
			pass  = passField.getPassword();
			login = tfLogin.getText();
			boolean passTrue=false;
			if (login.length()>0 && pass.length>0) {
	//			System.out.println(login+"  "+pass);
				int logInt = Recherche.indexInAL (login, log);
				if (logInt!=0) {
					// login is correct
					char [] passBD=(log.get(logInt+1)).toCharArray();
					if (pass.length==passBD.length) {
						passTrue=true;
						for (int i=0; i<passBD.length; i++) {
							if (passBD[i]!=pass[i]) {
								passTrue=false;
							}
						}
					}
					if (passTrue) {
						//Pass is correct
						// Operations de supprimer les traces de password 
						lblFonImage.setVisible(false);
						tfLogin.setText("");
						passField.setText("");
		//				btnLogInOut.setText("Logout");
						statusLog = Integer.parseInt(log.get(logInt+2));
						if (statusLog ==0) {
							System.out.println("SuperAdmin");
						}
						if (statusLog ==1) {
							System.out.println("Agent Admin");
						}
						if (statusLog ==2) {
							int idMedcin = Integer.parseInt(medcin.get(Recherche.indexInALTab(log.get(logInt+3), medcin, 0))[0]);
							System.out.println("Medecin"+medcin.get(idMedcin+2));
						}
						if (statusLog ==3) {
							System.out.println("Technicien");
						}
						if (statusLog ==4) {
							int idPat = Integer.parseInt(log.get(logInt+3));
							System.out.println("id Patient ="+idPat);
							gereBD.afficherALTab(consult2, 18);
							InFacePatient.afficherPlaning(idPat,pat1,pat2,medcin,consult1,consult2,consult3,tecnicien,appareil);
						}
					}else {
						passIncorDialog ();
					}
				}else {
					passIncorDialog ();
				}
			}else {
				passIncorDialog ();
			}
		}else {
//			Button "Log" is in state "Log out"
			System.out.println(statusLog);
			if (statusLog>=0 && statusLog<=4) {
				statusLog=-1;
				lblFonImage.setVisible(true);
				tfLogin.setText("");
				passField.setText("");
//				btnLogInOut.setText("Login");
			}
		}
	}

	
	private void passIncorDialog () {
	//Pass is incorrect
	
	// JOptionPane
	
	JOptionPane.showMessageDialog (
			frame, 
			"Login et mot de pass sont incorrects",
			"error",						
			JOptionPane.ERROR_MESSAGE);
	}
	
	// JDialog
//	JDialog passIncor = new JDialog (frame, "error", true);
//	passIncor.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//	passIncor.setBounds(500, 350, 600, 400);
//	passIncor.setVisible(true);
//	
//	JLabel lblPassIncor = new JLabel ("Login et mot de pass sont incorrects");
//	lblPassIncor.setBounds(530,330,570,350);
//	passIncor.add(lblPassIncor);
//	
//	JButton btnPassIncor = new JButton ();
//	btnPassIncor.setBounds(530, 370, 570, 390);
//	btnPassIncor.setText("Ok");
//	passIncor.add(btnPassIncor);
//	btnPassIncor.setVisible (true);
//	btnPassIncor.addActionListener(new ActionListener() {
//		@SuppressWarnings("deprecation")
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
//			passIncor.disable();
//		}
//	});

	
	
	
	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(1200,800);
		
		ImageIcon fonImage = createImageIcon("photo.jpg");
		JLabel lblFonImage = new JLabel("FonImage", fonImage, JLabel.CENTER);
		lblFonImage.setBounds(0, 81, 1184, 680);
		frame.getContentPane().add(lblFonImage);
		
		JLabel labelLogin = new JLabel("Login:");
		labelLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelLogin.setBounds(60, 11, 33, 14);
		frame.getContentPane().add(labelLogin);
		
		JTextField tfLogin = new JTextField();
		tfLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfLogin.setBounds(103, 9, 86, 20);
		frame.getContentPane().add(tfLogin);
		tfLogin.setColumns(10);
		
		JLabel lblPass = new JLabel("Mot de pass:");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPass.setBounds(25, 36, 80, 14);
		frame.getContentPane().add(lblPass);
		
		JPasswordField passField = new JPasswordField();
//		passField.setActionCommand(Listener (tfLogin, passField, btnLogInOut));
		passField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passField.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent arg0) {
				Listener (lblFonImage, tfLogin, passField);
			}
		});
		passField.setBounds(103, 34, 86, 20);
		frame.getContentPane().add(passField);
		
		JButton btnLogInOut = new JButton("Login");
		btnLogInOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Listener (lblFonImage, tfLogin, passField);
			}
		});
		btnLogInOut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogInOut.setBounds(199, 33, 89, 23);
		frame.getContentPane().add(btnLogInOut);
	}
//khlbgliuhn
// ,gkjglhgjkjlk
	private ImageIcon createImageIcon(String path) throws IOException {
		java.net.URL img = getClass().getResource(path);
		if (img != null) {
			return new ImageIcon (img);
		}else {
			System.out.println ("can't find image file on path: "+ path);
			return null;
		}
	}
	
}
