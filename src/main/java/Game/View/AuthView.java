package Game.View;

import javax.swing.*;

import Game.Controllers.PlayerController;
import Game.Controllers.UserController;
import Game.Models.Users.Player;
import Game.Models.Users.User;
import Game.Utils.Session;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AuthView extends JFrame {
	private JPanel container;
	private JPanel SignIn;
	private JPanel SignUp;
	private JLabel siEmailLabel;
	private JTextField siEmailField;
	private JLabel siPassLabel;
	private JButton siButton;
	private JLabel suNameLabel;
	private JTextField suNameField;
	private JLabel suEmailLabel;
	private JTextField suEmailField;
	private JLabel suPassLabel;
	private JPasswordField suPasswordField;
	private JPasswordField siPasswordField;
	private JLabel suConfirmPassLabel;
	private JPasswordField suConfirmPasswordField;
	private JButton suButton;

	public AuthView() throws HeadlessException {
		setupListeners();
		render();
	}

	private void render() {
		setContentPane(container);
		setTitle("Stock Control | Products");
		setSize(400, 800);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void setupListeners() {
		suButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					signUp();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		siButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					signIn();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void signUp() {
		String name = suNameField.getText();
		String email = suEmailField.getText();
		String password = new String(suPasswordField.getPassword());
		String confirmPassword = new String(suConfirmPasswordField.getPassword());

		if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			return;
		}

		if (!password.equals(confirmPassword)) {
			JOptionPane.showMessageDialog(null, "As senhas não são iguais!");
			return;
		}

		User newUser = UserController.signUp(name, email, password);

		if (newUser == null) {
			JOptionPane.showMessageDialog(null, "Email já cadastrado!");
			return;
		}

		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");

		// this.dispose();
	}

	private void signIn() {
		String email = siEmailField.getText();
		String password = new String(siPasswordField.getPassword());

		if (email.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			return;
		}

		User user = UserController.signIn(email, password);

		if (user == null) {
			JOptionPane.showMessageDialog(null, "Email ou senha incorretos!");
			return;
		}

		JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");

		if (Session.getAdmin() != null) {
			this.dispose();
			// new AdminView();
		}

		if (Session.getPlayer() != null) {
			this.dispose();
			// new PlayerView();
		}

		// this.dispose();
	}
}
