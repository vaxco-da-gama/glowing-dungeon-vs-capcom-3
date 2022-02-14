package Game.View;

import Game.Config.Screen;

import javax.swing.*;

public class AdminCreateView extends JFrame {
	private JPanel container;

	public void render() {
		setContentPane(container);
		setTitle("Stock Control | Products");
		setSize(Screen.getWidth(), Screen.getHeight());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);

		setupListeners();
	}
	
	private void setupListeners(){}
}
