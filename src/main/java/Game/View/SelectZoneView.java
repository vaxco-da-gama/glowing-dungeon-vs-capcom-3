package Game.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Game.Config.Screen;
import Game.Controllers.ZoneController;
import Game.Models.Domain.Zone;
import Game.Utils.Session;

import java.awt.*;
import java.util.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectZoneView extends JFrame {
	private JPanel container;
	private JTable table;
	private JButton selecionarButton;

	private List<Zone> zones;

	private void render() {
		setContentPane(container);
		setTitle("Selecionar Zona");
		setSize(Screen.getWidth(), Screen.getHeight());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);

		fillTableZoneTable();
		setupListeners();
	}

	private void setupListeners() {
		selecionarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();

				if (table.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Selecione uma zona para continuar");
					return;
				}

				if (table.getSelectedRowCount() > 0) {
					JOptionPane.showMessageDialog(null, "Selecione somente uma zona para continuar");
					return;
				}

				Zone zone = zones.get(selectedRow);
				Session.setZone(zone);
				// dispose();
			}
		});
	}

	private void fillTableZoneTable() {
		String[] columns = { "Nome", "Descrição" };
		DefaultTableModel tableModel = getTableModel();

		tableModel.setColumnIdentifiers(columns);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		zones = ZoneController.findAll();

		for (Zone zone : zones) {
			tableModel.addRow(new Object[] {
					zone.getName(),
					zone.getDescription()
			});
		}
	}

	private DefaultTableModel getTableModel() {
		return (DefaultTableModel) table.getModel();
	}
}
