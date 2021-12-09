package Game.Domain;

import Game.Creatures.Character;
import Game.Creatures.Enemy;
import Game.Users.Admin;
import Game.Users.User;

public class Zone {
	private String name;
	private String description;
	private Admin creator;
	private Enemy[] enemies;
	private Character characters;
	private User[] bannedUsers;

	public Zone(String name, String description, Admin creator, Enemy[] enemies, Character characters,
			User[] bannedUsers) {
		this.name = name;
		this.description = description;
		this.creator = creator;
		this.enemies = enemies;
		this.characters = characters;
		this.bannedUsers = bannedUsers;
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

	public Enemy[] getEnemies() {
		return enemies;
	}

	public void setEnemies(Enemy[] enemies) {
		this.enemies = enemies;
	}

	public Character getCharacters() {
		return characters;
	}

	public void setCharacters(Character characters) {
		this.characters = characters;
	}

	public User[] getBannedUsers() {
		return bannedUsers;
	}

	public void setBannedUsers(User[] bannedUsers) {
		this.bannedUsers = bannedUsers;
	}
}
