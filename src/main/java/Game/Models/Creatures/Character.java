package Game.Models.Creatures;

import Game.Models.Domain.Clan;
import Game.Models.Domain.Attack;
import Game.Models.Users.Player;

import java.util.ArrayList;
import java.util.List;

public class Character extends Creature {
	private Player creator;
	private int experience;
	private int mana;
	private int maxMana;
	private int constitution;
	private int strength;
	private int intelligence;
	private int dexterity;
	private List<Attack> attacks = new ArrayList<>();
	private List<String> completedZones = new ArrayList<>();

	public Character(String id, String name, Clan clan, Player creator) {
		super(id, name, clan);		
		this.level = 1;
		this.experience = 0;
		this.maxMana = 10;
		this.creator = creator;

		this.constitution = this.clan.getConstitutionMultiplier();
		this.strength = this.clan.getStrengthMultiplier();
		this.intelligence = this.clan.getIntelligenceMultiplier();
		this.dexterity = this.clan.getDexterityMultiplier();
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

	public int getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
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

	public List<Attack> getAttacks() {
		return attacks;
	}

	public void setAttacks(List<Attack> attacks) {
		this.attacks = attacks;
	}

	public List<String> getCompletedZones() {
		return completedZones;
	}

	public void setCompletedZones(List<String> completedZones) {
		this.completedZones = completedZones;
	}
}
