package Game;

import javax.swing.JFrame;

import Game.Screens.*;

/**
 *
 * @author caique
 */
public class Application extends JFrame
{
    
    public Application ()
    {
			
				add(new ScreenBase());

        setTitle("Glowing Dungeon Vs Capcom 3");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Application();
    }
    
}