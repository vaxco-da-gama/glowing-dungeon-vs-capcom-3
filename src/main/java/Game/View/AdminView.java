package Game.View;

import javax.swing.*;
import javax.swing.text.ZoneView;

import Game.Config.Screen;
import Game.Controllers.UserController;
import Game.Database.Database;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminView extends JFrame {
	private JPanel container;
	private JButton saveButton;
	private JPanel nav;
	private JPanel navbar;
	private JLabel nameLabel;
	private JButton signOutButton;
	private JPanel data;
	private JButton usuariosAdminsButton;
	private JButton clansButton1;
	private JButton attacksButton;
	private JButton inimigosButton1;
	private JButton zonasButton;
	private JPanel submitContainer;
	private JButton submitButton;
	private JButton removeButton;
	private JTable zoneTable;

	public void render() {
		setContentPane(container);
		setTitle("Stock Control | Products");
		setSize(Screen.getWidth(), Screen.getHeight());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);

		setupListeners();
	}

	private void setupListeners() {
		signOutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				signOut();
			}
		});

		zonasButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				redirectToZoneView();
			}
		});

		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					Database.save();
					JOptionPane.showMessageDialog(null, "Dados salvos no banco de dados");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void redirectToZoneView() {
		try {
			ZoneAdminView zoneAdminView = new ZoneAdminView();
			zoneAdminView.render();
			dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
