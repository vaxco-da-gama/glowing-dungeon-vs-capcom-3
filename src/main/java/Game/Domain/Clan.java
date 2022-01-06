package Game.Domain;

import java.util.ArrayList;
import java.util.List;

public class Clan {
	private String name;
	private String description;
	private List<Attack> attacks = new ArrayList<>();
	private int constitutionMultiplier;
	private int strengthMultiplier;
	private int intelligenceMultiplier;
	private int dexterityMultiplier;

	public Clan(String name, String description, List<Attack> attacks, int constitutionMultiplier, int strengthMultiplier,
			int intelligenceMultiplier, int dexterityMultiplier) {
		this.name = name;
		this.description = description;
		this.attacks = attacks;
		this.constitutionMultiplier = constitutionMultiplier;
		this.strengthMultiplier = strengthMultiplier;
		this.intelligenceMultiplier = intelligenceMultiplier;
		this.dexterityMultiplier = dexterityMultiplier;
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

	public List<Attack> getAttacks() {
		return attacks;
	}

	public void setAttacks(List<Attack> attacks) {
		this.attacks = attacks;
	}

	public int getConstitutionMultiplier() {
		return constitutionMultiplier;
	}

	public void setConstitutionMultiplier(int constitutionMultiplier) {
		this.constitutionMultiplier = constitutionMultiplier;
	}

	public int getStrengthMultiplier() {
		return strengthMultiplier;
	}

	public void setStrengthMultiplier(int strengthMultiplier) {
		this.strengthMultiplier = strengthMultiplier;
	}

	public int getIntelligenceMultiplier() {
		return intelligenceMultiplier;
	}

	public void setIntelligenceMultiplier(int intelligenceMultiplier) {
		this.intelligenceMultiplier = intelligenceMultiplier;
	}

	public int getDexterityMultiplier() {
		return dexterityMultiplier;
	}

	public void setDexterityMultiplier(int dexterityMultiplier) {
		this.dexterityMultiplier = dexterityMultiplier;
	}
}
