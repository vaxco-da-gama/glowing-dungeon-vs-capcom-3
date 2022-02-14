package Game.View;

import javax.swing.*;

import Game.Config.Screen;

import java.awt.*;

public class WaveView extends JFrame {
	private JPanel container;
	private JPanel MyCharacter;
	private JPanel Logs;
	private JPanel Enemies;
	private JPanel Habilities;
	private JLabel Life;
	private JProgressBar LifeBar;
	private JProgressBar ManaBar;
	private JLabel Mana;
	private JList LogsList;
	private JLabel Enemy1;
	private JProgressBar Enemie1Life;
	private JLabel Enemy2;
	private JProgressBar Enemie2Life;
	private JProgressBar Enemie3Life;
	private JLabel Enemy3;
	private JButton habilidade1Button;
	private JButton habilidade2Button;
	private JButton habilidade3Button;
	private JButton habilidade4Button;
	private JButton habilidade5Button;

	public WaveView() throws HeadlessException {
		setupListeners();
		setupContent();
		render();
	}

	private void render() {
		setContentPane(container);
		setTitle("Stock Control | Products");
		setSize(Screen.getWidth(), Screen.getHeight());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void setupListeners() {

	}

	private void setupContent() {
		setupEnemies();
	}

	private void setupEnemies() {

	}
}
