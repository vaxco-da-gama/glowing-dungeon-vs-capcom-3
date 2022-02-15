package Game.Models.Domain;

public class Attack {
	private String id;
	private String name;
	private String description;
	private int minimumLevel;
	private int manaCost;
	private int damage;
	private int heal;
	private boolean random;
	private boolean onlyBoss;

	public Attack(String id, String name, String description, int minimumLevel, int manaCost, int damage, int heal,
			boolean random,
			boolean onlyBoss) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.minimumLevel = minimumLevel;
		this.manaCost = manaCost;
		this.damage = damage;
		this.heal = heal;
		this.random = random;
		this.onlyBoss = onlyBoss;
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

	public int getMinimumLevel() {
		return minimumLevel;
	}

	public void setMinimumLevel(int level) {
		this.minimumLevel = level;
	}

	public int getManaCost() {
		return manaCost;
	}

	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHeal() {
		return heal;
	}

	public void setHeal(int heal) {
		this.heal = heal;
	}

	public boolean isRandom() {
		return random;
	}

	public void setRandom(boolean random) {
		this.random = random;
	}

	public boolean isOnlyBoss() {
		return onlyBoss;
	}

	public void setOnlyBoss(boolean onlyBoss) {
		this.onlyBoss = onlyBoss;
	}
}
