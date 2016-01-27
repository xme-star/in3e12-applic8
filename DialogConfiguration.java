import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

// JDialog permettant de fixer le taux de conversion
public class DialogConfiguration extends JDialog implements ActionListener{
	private Convertisseur conv; // l'objet convertisseur auquel est associé ce Dialog
	private JTextField taux; // le TextField pour la saisie du taux
	private JButton btV; // le bouton pour la validation du taux
	private JButton btA; // le bouton pour annulation

	// constructeur du Dialog pour fixer le taux
	public DialogConfiguration(Convertisseur c){
		super(c,"TAUX DE CONVERSION ",true);// modal centrée sur le convertisseur c
		conv=c;
		// mise en place des composants graphiques du dialogue
		Container contentPane=this.getContentPane();
		contentPane.setLayout(new FlowLayout());

		JLabel b1=new JLabel("Taux de change");
		taux=new JTextField(10);
		btV=new JButton("Valider");
		btA=new JButton("Annuler");
		// Placement des objets
		this.add(b1);
		this.add(taux);
		this.add(btV);
		this.add(btA);
		// Placement des Listener
		btV.addActionListener(this);
		btA.addActionListener(this);

		this.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btV){ // Lors de la validation
			try{ // Si le taux est bien un nombre, cela permet d'éviter un crash
				double val=Double.parseDouble(taux.getText());
				conv.setTaux(val);
				this.setVisible(false); // fenêtre invisible
			}catch(Exception ex){// Affichage d'un message d'erreur
				JOptionPane.showMessageDialog(this,"Entrez un nombre","alert",JOptionPane.ERROR_MESSAGE);
			}
		}else{
			this.setVisible(false); // Fermeture de la fenetre si l'on appuie sur le bouton annuler
		}
	}
}