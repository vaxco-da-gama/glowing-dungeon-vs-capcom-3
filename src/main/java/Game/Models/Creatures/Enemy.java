package Game.Models.Creatures;

import Game.Models.Domain.Clan;
import Game.Models.Users.Admin;

public class Enemy extends Creature {

	private Admin creator;
	private boolean alive = false;
	private boolean boss;

	public Enemy(String id, String name, Clan clan, Admin creator, boolean alive, boolean boss) {
		super(id, name, clan);
		this.creator = creator;
		this.alive = alive;
		this.boss = boss;
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
