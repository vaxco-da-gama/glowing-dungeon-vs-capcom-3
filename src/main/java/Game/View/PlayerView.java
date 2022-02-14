package Game.View;

import Game.Config.Screen;
import Game.Controllers.UserController;
import Game.Controllers.ZoneController;
import Game.Database.Database;
import Game.Models.Domain.Zone;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PlayerView extends JFrame {
	private JPanel container;
	private JPanel navbar;
	private JButton sairButton;
	private JButton criarPersonagemButton;
	private JButton escolherZonaButton;
	private JButton escolherPersonagemButton;
	private JScrollPane Personagens;
	private JTable personagensTable;
	private JScrollPane zonas;
	private JTable zonasTable;
	private JButton salvarButton;

	private List<Zone> zones = new ArrayList<>();
	private List<Character> characters = new ArrayList<>();

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

	private void fillTableZoneTable() {
		String[] columns = { "Nome", "Descrição" };
		DefaultTableModel tableModel = (DefaultTableModel) zonasTable.getModel();

		tableModel.setColumnIdentifiers(columns);
		zonasTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		zones = ZoneController.findAll();

		for (Zone zone : zones) {
			tableModel.addRow(new Object[] {
					zone.getName(),
					zone.getDescription()
			});
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
