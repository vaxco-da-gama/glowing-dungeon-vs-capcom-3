package Game.Creatures;

import Game.Domain.Clan;
import Game.Users.Admin;

public class Enemy extends Creature {
	private Admin creator;
	private boolean alive = false;
	private boolean boss;

	public Enemy(String name, Clan clan, String level, Admin creator, boolean boss) {
		super(name, clan, level);
		this.creator = creator;
		this.boss = boss;
	}

	public Admin getCreator() {
		return creator;
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
