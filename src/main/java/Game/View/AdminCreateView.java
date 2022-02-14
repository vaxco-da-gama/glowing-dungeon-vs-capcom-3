package Game.View;

import Game.Config.Screen;
import Game.Controllers.AdminController;
import Game.Database.Database;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminCreateView extends JFrame {
	private JPanel container;
	private JButton voltarButton;
	private JPanel form;
	private JPanel navbar;
	private JTextField nameInput;
	private JTextField emailInput;
	private JButton submitButton;
	private JPasswordField passwordInput;

	public void render() {
		setContentPane(container);
		setTitle("Stock Control | Products");
		setSize(Screen.getWidth(), Screen.getHeight());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);

		setupListeners();
	}

	private void setupListeners() {
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					createAdmin();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void createAdmin() {
		try {
			AdminController.create(nameInput.getText(), emailInput.getText(), passwordInput.getText());
			JOptionPane.showMessageDialog(null, "Admin Criado com sucesso");
			Database.save();
			resetForm();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	private void resetForm() {
		nameInput.setText("");
		emailInput.setText("");
		passwordInput.setText("");
	}
}
