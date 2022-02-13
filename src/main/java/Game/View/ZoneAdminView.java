package Game.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZoneAdminView extends JFrame {
	private JPanel container;
	private JTable zoneTable;
	private JTextField nameField;
	private JTextArea descriptionField;
	private JButton submitButton;
	private JButton removeButton;

	public ZoneAdminView() throws HeadlessException {
		setupListeners();
		render();
	}

	private void render() {
		setContentPane(container);
		setTitle("Cadastro de Zona");
		setSize(400, 800);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		String[] columns = {"Nome", "Descrição"};
		DefaultTableModel tableModel = getTableModel();
		
		tableModel.setColumnIdentifiers(columns);
		zoneTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addZone();
		addZone();
		setVisible(true);
	}

	private void setupListeners() throws	HeadlessException {
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
	
	private void addZone () {
				String[] data = new String[2];
				data[0] = nameField.getText();
				data[1] = descriptionField.getText();
				DefaultTableModel tableModel = getTableModel();
				tableModel.addRow(data);
				tableModel.fireTableDataChanged();
	}
	
	private void removeZone () {
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
	
	private DefaultTableModel getTableModel () {
		return (DefaultTableModel) zoneTable.getModel();		
	}	
}
