import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Convertisseur extends JFrame implements ActionListener, KeyListener{
	protected double taux=1.3563; // 1 euro = 1.3563 dollars
	protected JLabel tauxL; // permet l'affichage du taux de conversion
	protected JTextField euro; // contient la valeur à convertir
	protected JTextField dollar; // contient la valeur convertie
	protected JButton convertir; // bouton pour lancer la conversion

	public Convertisseur(){
		super("convertisseur 1.0");

		Container contentPane=this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		JPanel pNord=new JPanel();
		JPanel pEuro=new JPanel(new BorderLayout());
		JPanel pDollar=new JPanel(new BorderLayout());
		JPanel pCentre=new JPanel();
		JPanel pSud=new JPanel();

		contentPane.add(pNord,BorderLayout.NORTH);
		contentPane.add(pCentre,BorderLayout.CENTER);
		contentPane.add(pSud,BorderLayout.SOUTH);

		pEuro.add(new JLabel("Euro"),BorderLayout.NORTH); // Ajout d'un label pour écrire euro
		pEuro.add(euro=new JTextField(10),BorderLayout.SOUTH);
		pNord.add(pEuro);

		pDollar.add(new JLabel("Dollars"),BorderLayout.NORTH);
		pDollar.add(dollar=new JTextField(10),BorderLayout.SOUTH);
		dollar.setEditable(false);
		pNord.add(pDollar);

		JPanel pTaux=new JPanel();
		pTaux.add(tauxL=new JLabel("taux de conversion : 1 euro = 1.35$"));
		contentPane.add(pTaux,BorderLayout.CENTER);

		convertir=new JButton("Convertir"); // Ajout bouton convertir
		pSud.add(convertir);
		convertir.addActionListener(this); // Suivi actions sur bouton convertir
		
		euro.addKeyListener(this); // Suivi touches sur TextField euro

		// intégration d'un menu en utilisant la classe MenuConvertisseur
		this.setJMenuBar(new MenuConvertisseur(this));

		this.pack();
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setTaux(double x){
		taux=x;
		tauxL.setText("Le taux de converssion est de :  1€ = "+taux+"$");
	}

	public static void main(String args[]){
		// création de la fenêtre
		Convertisseur c=new Convertisseur();
		// affichage de la fenêtre
		c.setVisible(true);
	}

	private void convertir(){
		try{
			double deuros=Double.parseDouble(euro.getText().replace(',','.'));
			double x=deuros*taux;
			dollar.setText(((int)(x*100))/100.+"");
		}catch(Exception f){
			JOptionPane.showMessageDialog(null,"Entrez un nombre !","alert",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==convertir){
			convertir();
		}
	}

	@Override
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){ // détecte l'appui sur ENTREE pour lancer la conversion
			convertir();
		}else if(e.getKeyCode()==KeyEvent.VK_DELETE){ // détecte l'appui sur SUPPR pour effacer les champs
			euro.setText("");
			dollar.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent e){
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e){
		// TODO Auto-generated method stub
	}
}