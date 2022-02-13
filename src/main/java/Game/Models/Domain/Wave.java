package Game.Models.Domain;

import Game.Models.Creatures.Enemy;

import java.util.ArrayList;
import java.util.List;

public class Wave {
	private String id;
	private List<Enemy> enemies = new ArrayList<>();
	private int status;
	private boolean boss;

	public Wave(String id, List<Enemy> enemies, int status, boolean boss) {
		this.id = id;
		this.enemies = enemies;
		this.status = status;
		this.boss = boss;
	}

	public String getId() {
		return id;
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

	public void setBoss(boolean boss) {
		this.boss = boss;
	}
}
