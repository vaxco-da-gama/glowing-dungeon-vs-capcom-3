package Game.Controllers;

import Game.Database.Database;
import Game.Models.Domain.Attack;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AttackController implements Controller {
	private static final String FILE_NAME = "attacks.json";
	private static final String FILE_PATH = Database.PATH_FOLDER + FILE_NAME;

	private static ArrayList<Attack> attacks = new ArrayList<>();

	public static List<Attack> findAll() {
		return attacks;
	}

	public static Attack findById(String id) {
		for (Attack attack : attacks) {
			if (attack.getId().equalsIgnoreCase(id)) {
				return attack;
			}
		}

		return null;
	}

	public static Attack create(String name, String description, int minimumLevel, int manaCost, int damage, int heal,
			boolean random,
			boolean onlyBoss) {

		String attackId = UUID.randomUUID().toString();
		Attack attack = new Attack(attackId, name, description, minimumLevel, manaCost, damage, heal,
				random,
				onlyBoss);
		attacks.add(attack);

		return attack;
	}

	public static Attack update(String id, Attack newAttack) {
		Attack attack = findById(id);

		if (attack == null) {
			return null;
		}

		attack.setName(newAttack.getName());
		attack.setDescription(newAttack.getDescription());
		attack.setMinimumLevel(newAttack.getMinimumLevel());
		attack.setManaCost(newAttack.getManaCost());
		attack.setDamage(newAttack.getDamage());
		attack.setHeal(newAttack.getHeal());
		attack.setRandom(newAttack.isRandom());
		attack.setOnlyBoss(newAttack.isOnlyBoss());

		return attack;
	}

	public static void delete(String id) {
		for (Attack attack : attacks) {
			if (attack.getId().equalsIgnoreCase(id)) {
				attacks.remove(attack);
				break;
			}
		}
	}

	public void save() {
		Gson gson = new Gson();
		File file = new File(FILE_PATH);

		String json = gson.toJson(attacks);

		Database.write(file, json);
	}

	public void load() {
		Gson gson = new Gson();

		String stringFile = Database.read(FILE_PATH);

		Type type = new TypeToken<ArrayList<Attack>>() {
		}.getType();

		ArrayList<Attack> attackArray = gson.fromJson(stringFile, type);

		attacks = attackArray;
	}
}
