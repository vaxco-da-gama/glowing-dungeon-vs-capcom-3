package Game.Models.Creatures;

import Game.Models.Domain.Clan;
import Game.Models.Users.Admin;

public class Enemy implements Creature {
	private String id;
	private String name;
	private Clan clan;
	private int level;
	private Admin creator;
	private boolean alive = false;
	private boolean boss;

	public Enemy(String id, String name, Clan clan, int level, Admin creator, boolean alive, boolean boss) {
		this.id = id;
		this.name = name;
		this.clan = clan;
		this.level = level;
		this.creator = creator;
		this.alive = alive;
		this.boss = boss;
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

	public Clan getClan() {
		return clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Admin getCreator() {
		return creator;
	}

	public void setCreator(Admin creator) {
		this.creator = creator;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public boolean isBoss() {
		return boss;
	}

	public void setBoss(boolean boss) {
		this.boss = boss;
	}
}
