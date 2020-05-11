package Hopital;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class dialogPatNew extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nomField;
	private JTextField prenomField;
	private JTextField dateNaissField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialogPatNew dialog = new dialogPatNew();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public dialogPatNew() {
		setBounds(100, 100, 587, 399);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNom = new JLabel("Nom");
			lblNom.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNom.setBounds(49, 23, 42, 14);
			contentPanel.add(lblNom);
		}
		
		nomField = new JTextField();
		nomField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nomField.setBounds(49, 52, 180, 20);
		contentPanel.add(nomField);
		nomField.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrenom.setBounds(264, 23, 56, 14);
		contentPanel.add(lblPrenom);
		
		prenomField = new JTextField();
		prenomField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		prenomField.setColumns(10);
		prenomField.setBounds(264, 52, 180, 20);
		contentPanel.add(prenomField);
		
		JLabel lblDateDeNaissance = new JLabel("date de naissance (jj/mm/aaaa)");
		lblDateDeNaissance.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateDeNaissance.setBounds(49, 105, 180, 14);
		contentPanel.add(lblDateDeNaissance);
		
		dateNaissField = new JTextField();
		dateNaissField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dateNaissField.setColumns(10);
		dateNaissField.setBounds(264, 102, 180, 20);
		contentPanel.add(dateNaissField);
		
		JLabel lblPathologies = new JLabel("Pathologies");
		lblPathologies.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPathologies.setBounds(49, 194, 74, 14);
		contentPanel.add(lblPathologies);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(133, 192, 403, 20);
		contentPanel.add(textField);
		
		JLabel lblallergieProthseEtc = new JLabel("(allergie, proth\u00E8se, e.t.c.)");
		lblallergieProthseEtc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblallergieProthseEtc.setBounds(49, 219, 180, 14);
		contentPanel.add(lblallergieProthseEtc);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
