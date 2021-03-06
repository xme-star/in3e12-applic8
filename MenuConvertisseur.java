import javax.swing.*;

import java.awt.event.*;

// La barre du menu convertisseur
public class MenuConvertisseur extends JMenuBar implements ActionListener{
	private Convertisseur conv; // Le convertisseur
	private JMenuItem itemConfig; // item du menu
	private JMenuItem itemQuitter; // item du menu
	private JMenuItem itemApropos; // item du menu
	private DialogConfiguration dialTaux; // configuration du taux

	public MenuConvertisseur(Convertisseur c){
		conv=c;
		JMenu menuFichier=new JMenu("Fichier");
		itemConfig=new JMenuItem("Configurer");
		itemQuitter=new JMenuItem("Quitter");
		menuFichier.add(itemConfig);
		menuFichier.add(itemQuitter);
		JMenu menuAide=new JMenu("Aide");
		itemApropos=new JMenuItem("A propos");
		menuAide.add(itemApropos);

		itemConfig.addActionListener(this);
		itemQuitter.addActionListener(this);
		itemApropos.addActionListener(this);

		this.add(menuFichier);
		this.add(menuAide);

		// intégration DialogConfig pour configurer le taux
		dialTaux=new DialogConfiguration(c);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==itemConfig){
			System.out.println("Configuration ...");
			dialTaux.setVisible(true);
		}else if(e.getSource()==itemQuitter){
			System.exit(0);
		}else if(e.getSource()==itemApropos){
			JOptionPane.showMessageDialog(conv,"<HTML><BODY><h1>Want to chat with me ? :)</h1>Auteur : xme-star <BR><I>https://tlk.io/xme-star</I></BODY></HTML>");
		}
	}
}