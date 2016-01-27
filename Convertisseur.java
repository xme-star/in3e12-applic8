import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Convertisseur extends JFrame implements ActionListener{
	// le taux de conversion
	protected double taux=1.3563; // 1 euro = 1.3563 dollars
	protected JLabel tauxL; // permet l'affichage du taux de conversion
	protected JTextField euro; // contient la valeur à convertir
	protected JTextField dollar; // contient la valeur convertie
	
	public Convertisseur(){
		super("convertisseur 1.0");

		Container contentPane=this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JPanel pNord=new JPanel();
		JPanel pEuro=new JPanel(new BorderLayout());
		pEuro.add(new JLabel("Euro"),BorderLayout.NORTH); // Ajout d'un label pour écrire euro
		pEuro.add(euro=new JTextField(10),BorderLayout.SOUTH);
		pNord.add(pEuro);

		JPanel pDollar=new JPanel(new BorderLayout());
		pDollar.add(new JLabel("Dollars"),BorderLayout.NORTH);
		pDollar.add(dollar=new JTextField(10),BorderLayout.SOUTH);
		dollar.setEditable(false);
		pNord.add(pDollar);

		JPanel pTaux=new JPanel();
		pTaux.add(tauxL=new JLabel("taux de conversion : 1 euro = 1.35$"));
		contentPane.add(pTaux,BorderLayout.CENTER);

		this.pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]){
		// création de la fenêtre
		Convertisseur c=new Convertisseur();
		// affichage de la fenêtre
		c.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println(e);
	}
}