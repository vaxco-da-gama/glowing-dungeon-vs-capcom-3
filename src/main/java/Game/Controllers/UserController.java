package Game.Controllers;

import Game.Models.Users.Admin;
import Game.Models.Users.Player;
import Game.Models.Users.User;

import java.util.ArrayList;
import java.util.List;

public class UserController implements Controller {
	private static AdminController adminController = new AdminController();
	private static PlayerController playerController = new PlayerController();

	public static User findByEmail(String email) {
		Player player = PlayerController.findByEmail(email);
		Admin admin = AdminController.findByEmail(email);

		if (player != null) {
			return player;
		}

		if (admin != null) {
			return admin;
		}

		return null;
	}

	public void save() {
		AdminController adminController = new AdminController();
		adminController.save();

		PlayerController playerController = new PlayerController();
		playerController.save();
	}

	public void load() {
		adminController.load();
		playerController.load();
	}

	public static List<User> findAll() {
		List<User> users = new ArrayList<>();

		users.addAll(AdminController.findAll());
		users.addAll(PlayerController.findAll());

		return users;
	}

	public static Player signUp(String name, String email, String password) {
		if (findByEmail(email) == null) {
			Player newPlayer = PlayerController.create(name, email, password);
			return newPlayer;
		}

		return null;
	}

	public User login(String email, String password) {
		List<Admin> admins = AdminController.findAll();
		List<Player> players = PlayerController.findAll();

		for (Admin admin : admins) {
			if (admin.getEmail().equalsIgnoreCase(email) && admin.getPassword().equals(password)) {
				return admin;
			}
		}

		for (Player player : players) {
			if (player.getEmail().equalsIgnoreCase(email) && player.getPassword().equals(password)) {
				return player;
			}
		}

		return null;
	}
}
