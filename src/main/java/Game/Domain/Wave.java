package Game.Domain;

import Game.Creatures.Enemy;

import java.util.ArrayList;
import java.util.List;

public class Wave {
	private List<Enemy> enemies = new ArrayList<>();
	private int status;
	private boolean boss;

	public Wave(List<Enemy> enemies, int status, boolean boss) {
		this.enemies = enemies;
		this.status = status;
		this.boss = boss;
	}

	public List<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(List<Enemy> enemies) {
		this.enemies = enemies;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isBoss() {
		return boss;
	}
}
