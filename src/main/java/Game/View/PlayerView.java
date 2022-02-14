package Game.View;

import javax.swing.*;

public class PlayerView extends JFrame {
	private JPanel container;

	public void render() {
		setContentPane(container);
		setTitle("Página do Jogador");
		setSize(400, 800);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		setVisible(true);
	}
}
