package Game.Screens;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import javax.swing.*;


public class ScreenBase extends JPanel implements MouseListener
{

		JTextArea textArea;
		ScreenAvatar blankArea;


    public ScreenBase ()
    {
				super(new GridLayout(0,1));
				this.addMouseListener(this);


				JPanel avatarsPanel = new JPanel();
				avatarsPanel.setSize(600,600);


				GridLayout horizontalLayout = new GridLayout(1,0);
				
				avatarsPanel.setLayout(horizontalLayout);  


				avatarsPanel.add(new ScreenAvatar("images/wizard.png", 0, 0));
        avatarsPanel.add(new BlankArea(null));
        avatarsPanel.add(new ScreenAvatar("images/ranger.png", 0, 0));

				add(avatarsPanel);
				
				JPanel buttonsPanel = new JPanel();
				buttonsPanel.setBackground(Color.darkGray);
				buttonsPanel.setSize(200,200);

				GridLayout layout = new GridLayout(0,4);
				layout.setHgap(10);
				layout.setVgap(10);
				
				buttonsPanel.setLayout(layout);        
				buttonsPanel.add(new BlankArea(Color.RED));
        buttonsPanel.add(new BlankArea(Color.BLUE));
        buttonsPanel.add(new BlankArea(Color.YELLOW));
        buttonsPanel.add(new BlankArea(Color.GREEN));

				add(buttonsPanel);
    }

		public void mousePressed(MouseEvent e) {
			System.out.println("Event listener");
		}

		public void mouseReleased(MouseEvent e) {
			System.out.println("Event listener");
		}

		public void mouseEntered(MouseEvent e) {
			System.out.println("Event listener");
		}

		public void mouseClicked(MouseEvent e) {
			System.out.println("Event listener");
		}

		public void mouseExited(MouseEvent e) {
			System.out.println("Event listener");
		}
		
}
