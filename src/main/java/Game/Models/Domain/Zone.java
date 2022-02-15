package Game.Models.Domain;

import Game.Models.Creatures.Enemy;
import Game.Models.Users.Admin;
import Game.Models.Users.User;

import java.util.ArrayList;
import java.util.List;

public class Zone {
	private String id;
	private String name;
	private String description;
	private Admin creator;
	private List<User> bannedUsers;
	private List<Enemy> enemies;

	public Zone(String id, String name, String description, Admin creator) throws Exception {
		if (id.length() == 0) {
			throw new Exception("ID Inválido!");
		}

		if (name.length() == 0) {
			throw new Exception("Nome Inválido!");
		}

		if (description.length() == 0) {
			throw new Exception("Descrição Inválida!");
		}
		
		if (creator == null) {
		 	throw new Exception("Admin Inválido!");
		}

		this.id = id;
		this.name = name;
		this.description = description;
		this.creator = creator;
		this.bannedUsers = new ArrayList<>();
		this.enemies = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Admin getCreator() {
		return creator;
	}

	public void setCreator(Admin creator) {
		this.creator = creator;
	}

	public List<User> getBannedUsers() {
		return bannedUsers;
	}

	public void setBannedUsers(List<User> bannedUsers) {
		this.bannedUsers = bannedUsers;
	}

	public List<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(List<Enemy> waves) {
		this.enemies = waves;
	}
}
