package puzzle_lab2;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FramePrincipale extends JFrame implements Runnable{

	//Constante
	private final Dimension DIMENSION = new Dimension(600, 700);
	
	//Attribut
	private JPanel panneauPrincipal;  //pointera sur getContentPane()
	private JButton bSolve;
	private JButton bLoad;
	private PegSolitaire gamePannel;
	
	public void run() {
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		
		//initialisation du panneau           
		panneauPrincipal = (JPanel)getContentPane();
		panneauPrincipal.setLayout(new BoxLayout(panneauPrincipal, BoxLayout.Y_AXIS));
		
		gamePannel = new PegSolitaire();
		bSolve = new JButton("R�soudre le puzzle");
		bLoad = new JButton("Charger un puzzle");
		
		gamePannel.setAlignmentX(CENTER_ALIGNMENT);
		bSolve.setAlignmentX(CENTER_ALIGNMENT);
		bLoad.setAlignmentX(CENTER_ALIGNMENT);
		
		panneauPrincipal.add(Box.createRigidArea(new Dimension(0,20)));
		panneauPrincipal.add(gamePannel);
		panneauPrincipal.add(bSolve);
		panneauPrincipal.add(bLoad);
		
		bSolve.addActionListener(new EcouteurBoutton());
		bLoad.addActionListener(new EcouteurBoutton());
		
        this.setSize(DIMENSION);
        setResizable(false);
        this.setLocation(screenDimension.width/2-this.getSize().width/2, screenDimension.height/2-this.getSize().height/2);
        setTitle("Peg Solitaire");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
	
	public class EcouteurBoutton implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == bSolve){
				gamePannel.solveAlgo();
			}

			if (e.getSource() == bLoad){
				gamePannel.loadPuzzle();
			}
		}
		
	}	
}
