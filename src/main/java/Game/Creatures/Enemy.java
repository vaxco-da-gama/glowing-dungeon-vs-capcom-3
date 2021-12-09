package Game.Creatures;

import Game.Domain.Clan;
import Game.Users.Admin;

public class Enemy extends Creature {
	private Admin creator;

	public Enemy(String name, Clan clan, String level, Admin creator) {
		super(name, clan, level);
		this.creator = creator;
	}

	public Admin getCreator() {
		return creator;
	}
}
