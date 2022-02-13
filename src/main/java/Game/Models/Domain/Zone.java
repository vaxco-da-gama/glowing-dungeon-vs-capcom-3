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
	private List<User> bannedUsers = new ArrayList<>();
	private List<Wave> waves = new ArrayList<>();

	public Zone(String id, String name, String description, Admin creator, List<User> bannedUsers,
			List<Wave> waves) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.creator = creator;
		this.bannedUsers = bannedUsers;
		this.waves = waves;
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

	public List<Wave> getWaves() {
		return waves;
	}

	public void setWaves(List<Wave> waves) {
		this.waves = waves;
	}
}
