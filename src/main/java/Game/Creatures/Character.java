package Game.Creatures;

import Game.Domain.Clan;
import Game.Users.Player;
import Game.Utilities.Attacks;

public class Character extends Creature {
	private Player creator;
	private int experience;
	private int mana;
	private int constitution;
	private int strength;
	private int intelligence;
	private int dexterity;
	private Attacks[] attacks;

	public Character(String name, Clan clan, String level, Player creator, int experience, int mana, int constitution,
			int strength, int intelligence, int dexterity, Attacks[] attacks) {
		super(name, clan, level);
		this.creator = creator;
		this.experience = experience;
		this.mana = mana;
		this.constitution = constitution;
		this.strength = strength;
		this.intelligence = intelligence;
		this.dexterity = dexterity;
		this.attacks = attacks;
	}

	public Player getCreator() {
		return creator;
	}

	public void setCreator(Player creator) {
		this.creator = creator;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public Attacks[] getAttacks() {
		return attacks;
	}

	public void setAttacks(Attacks[] attacks) {
		this.attacks = attacks;
	}
}
