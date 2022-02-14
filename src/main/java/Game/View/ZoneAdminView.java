package Game.View;

import Game.Controllers.ZoneController;
import Game.Models.Domain.Zone;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ZoneAdminView extends JFrame {
	private JPanel container;
	private JPanel form;
	private JPanel submitContainer;
	private JTable zoneTable;
	private JTextField nameField;
	private JTextArea descriptionField;
	private JButton submitButton;
	private JButton removeButton;
	private JButton voltarButton;
	private JPanel Waves;

	public void render() {
		setupListeners();

		setContentPane(container);
		setTitle("Cadastro de Zona");
		setSize(400, 800);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		fillTable();

		setVisible(true);
	}

	private void fillTable() {
		String[] columns = { "Nome", "Descrição" };
		DefaultTableModel tableModel = getTableModel();

		tableModel.setColumnIdentifiers(columns);
		zoneTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		List<Zone> zones = ZoneController.findAll();

		for (int i = 0; i < zones.size(); i++) {
			tableModel.addRow(new Object[] {
					zones.get(i).getName(),
					zones.get(i).getDescription()
			});
		}
	}

	private void setupListeners() throws HeadlessException {
		voltarButton.addActionListener(new ActionListener() {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void removeZone() {
		DefaultTableModel tableModel = getTableModel();
		if (zoneTable.getSelectedRowCount() == 0) {
			return;
		}

		if (zoneTable.getRowCount() == 0) {
			return;
		}

		int row = zoneTable.getSelectedRow();

		tableModel.removeRow(row);
	}

	private void redirectToAdminView() {
		try {
			AdminView adminView = new AdminView();
			adminView.render();
			dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private DefaultTableModel getTableModel() {
		return (DefaultTableModel) zoneTable.getModel();
	}

}
