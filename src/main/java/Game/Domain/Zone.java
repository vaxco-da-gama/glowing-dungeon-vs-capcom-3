package Game.Domain;

import Game.Creatures.Character;
import Game.Creatures.Enemy;
import Game.Users.Admin;
import Game.Users.User;

import java.util.ArrayList;
import java.util.List;

public class Zone {
	private String name;
	private String description;
	private Admin creator;
	private List<Enemy> enemies = new ArrayList<>();
	private List<User> bannedUsers = new ArrayList<>();
	private List<Wave> waves = new ArrayList<>();

	public Zone(String name, String description, Admin creator, List<Enemy> enemies, List<User> bannedUsers, List<Wave> waves) {
		this.name = name;
		this.description = description;
		this.creator = creator;
		this.enemies = enemies;
		this.bannedUsers = bannedUsers;
		this.waves = waves;
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

	public List<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(List<Enemy> enemies) {
		this.enemies = enemies;
	}

	public List<User> getBannedUsers() {
		return bannedUsers;
	}

	public void setBannedUsers(List<User> bannedUsers) {
		this.bannedUsers = bannedUsers;
	}

	public List<Wave> getWaves() {
		return waves;
	}

	public void setWaves(List<Wave> waves) {
		this.waves = waves;
	}
}
