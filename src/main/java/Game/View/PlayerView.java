package Game.View;

import Game.Config.Screen;
import Game.Controllers.UserController;
import Game.Database.Database;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerView extends JFrame {
	private JPanel container;
	private JPanel navbar;
	private JButton sairButton;

	public void render() {
		setContentPane(container);
		setTitle("Página do Jogador");
		setSize(Screen.getWidth(), Screen.getHeight());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);

		setupListeners();
	}

	private void setupListeners() {
		sairButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				signOut();
			}
		});
	}

	private void signOut() {
		Database.save();
		JOptionPane.showMessageDialog(null, "Dados salvos no banco de dados");

		UserController.signOut();

		try {
			AuthView authView = new AuthView();
			authView.render();
			dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
