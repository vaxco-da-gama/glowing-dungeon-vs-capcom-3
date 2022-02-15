package Game.View;

import Game.Config.Screen;
import Game.Controllers.AttackController;
import Game.Controllers.CharacterController;
import Game.Controllers.ClanController;
import Game.Models.Creatures.Character;
import Game.Models.Domain.Attack;
import Game.Models.Domain.Clan;
import Game.Utils.Session;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class CreateCharacterView extends JFrame {
	private JPanel container;
	private JPanel navbar;
	private JButton voltarButton;
	private JPanel form;
	private JPanel habilities;
	private JComboBox habilidade1Box;
	private JComboBox habilidade2Box;
	private JComboBox habilidade3Box;
	private JButton criarButton;
	private JTextField nameInput;
	private JComboBox clanBox;

	private List<Attack> attacks = new ArrayList<>();

	public void render() {
		setContentPane(container);
		setTitle("Criar Personagem");
		setSize(Screen.getWidth(), Screen.getHeight());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);

		setupListeners();
		setupContent();
	}

	private void setupContent() {
		List<Clan> clans = ClanController.findAll();
		for (Clan clan : clans) {
			clanBox.addItem(clan.getName());
		}
	}

	private void setupListeners() {
		voltarButton.addActionListener(e -> {
			dispose();
			new PlayerView().render();
		});

		criarButton.addActionListener(e -> {
			createPlayer();
			returnToPlayerView();
		});

		clanBox.addActionListener(e -> {
			getAttacks();
		});
	}

	private void createPlayer() {
		try {
			Attack attack1 = AttackController.findByName(habilidade1Box.getSelectedItem().toString());
			Attack attack2 = AttackController.findByName(habilidade2Box.getSelectedItem().toString());
			Attack attack3 = AttackController.findByName(habilidade3Box.getSelectedItem().toString());

			if (attack1 == null || attack2 == null || attack3 == null) {
				JOptionPane.showMessageDialog(null, "Todas as habilidades devem ser preenchidas");
				return;
			}

			String name = nameInput.getText();
			String clan = clanBox.getSelectedItem().toString();

			Character character = CharacterController.create(Session.getPlayer(), name, ClanController.findByName(clan));
			Session.setCharacter(character);

			List<Attack> attacks = new ArrayList<>();
			attacks.add(attack1);
			attacks.add(attack2);
			attacks.add(attack3);

			character.setAttacks(attacks);

			CharacterController.update(Session.getPlayer().getId(), character);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private void getAttacks() {
		String clan = clanBox.getSelectedItem().toString();

		attacks = ClanController.findByName(clan).getAttacks();

		habilidade1Box.removeAllItems();
		habilidade2Box.removeAllItems();
		habilidade3Box.removeAllItems();

		for (Attack attack : attacks) {
			habilidade1Box.addItem(attack.getName());
			habilidade2Box.addItem(attack.getName());
			habilidade3Box.addItem(attack.getName());
		}
	}

	private void returnToPlayerView() {
		new CharacterController().save();

		dispose();
		new PlayerView().render();
	}
}
