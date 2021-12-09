package Game.Creatures;

import Game.Domain.Clan;

public class Creature {
	private String name;
	private Clan clan;
	private String level;

	public Creature(String name, Clan clan, String level) {
		this.name = name;
		this.clan = clan;
		this.level = level;
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
}
