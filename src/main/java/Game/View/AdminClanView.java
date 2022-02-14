package Game.View;

import Game.Config.Screen;
import Game.Controllers.ZoneController;
import Game.Models.Domain.Zone;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminClanView extends JFrame {
	private JPanel container;
	private JPanel form;
	private JPanel submitContainer;
	private JTable zoneTable;
	private JTextField nameField;
	private JTextArea descriptionField;

	private JButton submitButton;
	private JButton removeButton;
	private JButton backButton;

	private JPanel Waves;
	private List<Zone> zones;

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
		String[] columns = { "Nome", "Descrição" };
		DefaultTableModel tableModel = getTableModel();

		tableModel.setColumnIdentifiers(columns);
		zoneTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		zones = ZoneController.findAll();

		for (Zone zone : zones) {
			tableModel.addRow(new Object[] {
					zone.getName(),
					zone.getDescription()
			});
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
				addZone();
			}
		});

		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeZone();
			}
		});
	}

	private void addZone() {
		try {
			String name = nameField.getText();
			String description = descriptionField.getText();
			ZoneController.create(name, description);

			String[] data = new String[2];
			data[0] = name;
			data[1] = description;

			DefaultTableModel tableModel = getTableModel();
			tableModel.addRow(data);
			tableModel.fireTableDataChanged();
			clearFields();
		} catch (Exception e) {
			showDialogMessage(e.getMessage());
		}
	}

	private void removeZone() {
		DefaultTableModel tableModel = getTableModel();

		if (zoneTable.getRowCount() == 0) {
			showDialogMessage("Não existem zonas cadastradas!");
			return;
		}

		if (zoneTable.getSelectedRowCount() == 0) {
			showDialogMessage("Selecione uma zona para ser removida!");
			return;
		}

		int row = zoneTable.getSelectedRow();
		Zone zone = zones.get(row);

		if (zone != null) {
			ZoneController.delete(zone.getId());
			tableModel.removeRow(row);
		} else {
			showDialogMessage("Erro ao remover zona!");
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
		return (DefaultTableModel) zoneTable.getModel();
	}

	private void showDialogMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	private void clearFields() {
		nameField.setText("");
		descriptionField.setText("");
	}
}
