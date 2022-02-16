package Game.Models.Creatures;

import Game.Models.Domain.Clan;

abstract class Creature {
	 protected String id;
	 protected String name;
	 protected Clan clan;
	protected int level;

	public Creature(String id, String name, Clan clan) {
		this.id = id;
		this.name = name;
		this.clan = clan;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
}
