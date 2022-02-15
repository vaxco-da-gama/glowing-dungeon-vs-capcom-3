package Game.Controllers;

import Game.Database.Database;
import Game.Models.Domain.Attack;
import Game.Models.Domain.Clan;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ClanController implements Controller {
	private static final String FILE_NAME = "clans.json";
	private static final String FILE_PATH = Database.PATH_FOLDER + FILE_NAME;

	private static ArrayList<Clan> clans = new ArrayList<>();

	public static List<Clan> findAll() {
		return clans;
	}

	public static Clan findById(String id) {
		for (Clan clan : clans) {
			if (clan.getId().equalsIgnoreCase(id)) {
				return clan;
			}
		}

		return null;
	}

	public static Clan findByName(String name) {
		for (Clan clan : clans) {
			if (clan.getName().equalsIgnoreCase(name)) {
				return clan;
			}
		}

		return null;
	}

	public static Clan create(
			String name,
			String description,
			List<Attack> attacks,
			int constitutionMultiplier,
			int strengthMultiplier,
			int intelligenceMultiplier,
			int dexterityMultiplier) throws Exception {

		String clanId = UUID.randomUUID().toString();

		Clan clan = new Clan(clanId, name, description, attacks, constitutionMultiplier, strengthMultiplier,
				intelligenceMultiplier, dexterityMultiplier);

		clans.add(clan);

		return clan;
	}

	public static Clan update(String id, Clan newClan) {
		Clan clan = findById(id);

		if (clan == null) {
			return null;
		}

		clan.setName(newClan.getName());
		clan.setDescription(newClan.getDescription());
		clan.setAttacks(newClan.getAttacks());
		clan.setConstitutionMultiplier(newClan.getConstitutionMultiplier());
		clan.setStrengthMultiplier(newClan.getStrengthMultiplier());
		clan.setIntelligenceMultiplier(newClan.getIntelligenceMultiplier());
		clan.setDexterityMultiplier(newClan.getDexterityMultiplier());

		return clan;
	}

	public static void delete(String id) {
		for (Clan clan : clans) {
			if (clan.getId().equalsIgnoreCase(id)) {
				clans.remove(clan);
				break;
			}
		}
	}

	public void save() {
		Gson gson = new Gson();
		File file = new File(FILE_PATH);

		String json = gson.toJson(clans);

		Database.write(file, json);
	}

	public void load() {
		Gson gson = new Gson();

		String stringFile = Database.read(FILE_PATH);

		Type type = new TypeToken<ArrayList<Clan>>() {
		}.getType();

		ArrayList<Clan> clanArray = gson.fromJson(stringFile, type);

		if (clanArray != null) {
			clans = clanArray;
		}

	}
}
