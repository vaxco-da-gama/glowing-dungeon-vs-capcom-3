package Game.View;

import javax.swing.*;
import java.awt.*;

public class SelectZoneView extends JFrame {
	private JPanel container;
	private JTable table;
	private JButton selecionarButton;

	public SelectZoneView() throws HeadlessException {
		setupListeners();
		render();
	}

	private void render() {
		setContentPane(container);
		setTitle("Glowing Dungeon VS Capcom | Products");
		setSize(400, 800);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void setupListeners() {

	}

	private void setupContent() {

	}

	private void setupTable() {
		String[] columns = { "Name", "Value", "Quantity", "Description" };
	}
}
