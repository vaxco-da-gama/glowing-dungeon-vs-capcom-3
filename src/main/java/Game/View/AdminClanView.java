package Game.View;

import Game.Config.Screen;
import Game.Controllers.AttackController;
import Game.Controllers.ClanController;
import Game.Models.Domain.Attack;
import Game.Models.Domain.Clan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AdminClanView extends JFrame {
	private JPanel container;
	private JPanel form;
	private JTextField nameField;
	private JTextArea descriptionField;
	private JPanel submitContainer;
	private JTable clanTable;

	private JButton submitButton;
	private JButton removeButton;
	private JButton backButton;

	private JPanel Waves;
	private JTextField constituitonField;
	private JTextField strengthField;
	private JTextField dexterityField;
	private JTextField intelligenceField;
	private JPanel checkBoxContainer;

	private List<Clan> clans;

	public void render() {
		setupListeners();

		setContentPane(container);
		setTitle("Cadastro de Zona");
		setSize(Screen.getWidth(), Screen.getHeight());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		fillTable();

		setVisible(true);
	}

	private void fillTable() {
		String[] columns = {
				"Nome",
				"Descrição",
				"Constituição",
				"Inteligência",
				"Força",
				"Destreza"
		};
		DefaultTableModel tableModel = getTableModel();

		tableModel.setColumnIdentifiers(columns);
		clanTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		clans = ClanController.findAll();

		for (Clan clan : clans) {
			tableModel.addRow(new Object[] {
					clan.getName(),
					clan.getDescription(),
					clan.getConstitutionMultiplier(),
					clan.getIntelligenceMultiplier(),
					clan.getStrengthMultiplier(),
					clan.getDexterityMultiplier()
			});
		}
	}

	private void fillAttacks() {
		List<Attack> attacks = AttackController.findAll();
		for (Attack attack : attacks) {
			checkBoxContainer.add(new JCheckBox(attack.getName()));
		}
	}

	private void setupListeners() throws HeadlessException {
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				redirectToAdminView();
			}
		});

		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addClan();
			}
		});

		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeClan();
			}
		});
	}

	private void addClan() {
		try {
			String name = nameField.getText();
			String description = descriptionField.getText();
			int constitutionMultiplier = Integer.parseInt(constituitonField.getText());
			int strengthMultiplier = Integer.parseInt(strengthField.getText());
			int intelligenceMultiplier = Integer.parseInt(intelligenceField.getText());
			int dexterityMultiplier = Integer.parseInt(dexterityField.getText());
			List<Attack> attacks = new ArrayList<>();

			ClanController.create(
					name,
					description,
					attacks,
					constitutionMultiplier,
					strengthMultiplier,
					intelligenceMultiplier,
					dexterityMultiplier);

			String[] data = new String[6];
			data[0] = name;
			data[1] = description;
			data[2] = Integer.toString(constitutionMultiplier);
			data[3] = Integer.toString(strengthMultiplier);
			data[4] = Integer.toString(intelligenceMultiplier);
			data[5] = Integer.toString(dexterityMultiplier);

			DefaultTableModel tableModel = getTableModel();
			tableModel.addRow(data);
			tableModel.fireTableDataChanged();
			clearFields();
		} catch (NumberFormatException e) {
			showDialogMessage("Informe os multiplicadores corretamente!");
		} catch (Exception e) {
			showDialogMessage(e.getMessage());
		}
	}

	private void removeClan() {
		DefaultTableModel tableModel = getTableModel();

		if (clanTable.getRowCount() == 0) {
			showDialogMessage("Não existem clans cadastrados!");
			return;
		}

		if (clanTable.getSelectedRowCount() == 0) {
			showDialogMessage("Selecione um clan para ser removido!");
			return;
		}

		int row = clanTable.getSelectedRow();
		Clan clan = clans.get(row);

		if (clan != null) {
			ClanController.delete(clan.getId());
			tableModel.removeRow(row);
		} else {
			showDialogMessage("Erro ao remover clan!");
		}
	}

	private void redirectToAdminView() {
		try {
			AdminView adminView = new AdminView();
			adminView.render();
			dispose();
		} catch (Exception e) {
			showDialogMessage("Erro ao redirecionar para a tela de admin!");
		}
	}

	private DefaultTableModel getTableModel() {
		return (DefaultTableModel) clanTable.getModel();
	}

	private void showDialogMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	private void clearFields() {
		nameField.setText("");
		descriptionField.setText("");
		constituitonField.setText("1");
		strengthField.setText("1");
		intelligenceField.setText("1");
		dexterityField.setText("1");
	}
}
