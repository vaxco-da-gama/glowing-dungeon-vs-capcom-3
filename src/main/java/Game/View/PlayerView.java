package Game.View;

import Game.Config.Screen;
import Game.Controllers.CharacterController;
import Game.Controllers.PlayerController;
import Game.Controllers.UserController;
import Game.Controllers.ZoneController;
import Game.Database.Database;
import Game.Models.Creatures.Character;
import Game.Models.Domain.Zone;
import Game.Utils.Session;

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
		setupContent();
	}

	private void setupContent() {
		fillTableCharacterTable();
		fillTableZoneTable();
	}

	private void setupListeners() {
		sairButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				signOut();
			}
		});

		escolherZonaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				selectZone();
			}
		});

		escolherPersonagemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				selectCharacter();
			}
		});

		salvarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Database.save();
			}
		});

		criarPersonagemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				dispose();
				new CreateCharacterView().render();
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

	private void fillTableCharacterTable() {
		String[] characterColums = { "Nome", "Clan", "Level" };

		DefaultTableModel tableModel = (DefaultTableModel) personagensTable.getModel();

		tableModel.setColumnIdentifiers(characterColums);
		personagensTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		for (Character character : Session.getPlayer().getCharacters()) {
			tableModel.addRow(new Object[] {
					character.getName(),
					character.getClan().getName(),
					character.getLevel()
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

	private void selectZone() {
		int selectedRow = zonasTable.getSelectedRow();

		if (selectedRow < 0) {
			JOptionPane.showMessageDialog(null, "Selecione uma zona");
			return;
		}

		Zone zone = zones.get(selectedRow);

		try {
			Session.setZone(zone);
			JOptionPane.showMessageDialog(null, "Você entrou na zona " + zone.getName());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}

	}

	private void selectCharacter() {
		int selectedRow = personagensTable.getSelectedRow();

		if (selectedRow < 0) {
			JOptionPane.showMessageDialog(null, "Selecione um personagem");
			return;
		}

		Character character = characters.get(selectedRow);

		Session.setCharacter(character);
		JOptionPane.showMessageDialog(null, "Você selecionou o personagem " + character.getName());
	}
}
