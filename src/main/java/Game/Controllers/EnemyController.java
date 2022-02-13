package Game.Controllers;

import Game.Database.Database;
import Game.Models.Creatures.Enemy;
import Game.Models.Domain.Clan;
import Game.Models.Users.Admin;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EnemyController implements Controller {
	private static final String FILE_NAME = "enemies.json";
	private static final String FILE_PATH = Database.PATH_FOLDER + FILE_NAME;

	private static ArrayList<Enemy> enemies = new ArrayList<>();

	public static List<Enemy> findAll() {
		return enemies;
	}

	public static Enemy findById(String id) {
		for (Enemy enemy : enemies) {
			if (enemy.getId().equalsIgnoreCase(id)) {
				return enemy;
			}
		}

		return null;
	}

	public static Enemy create(String id, String name, Clan clan, int level, Admin creator, boolean alive, boolean boss) {

		String enemyId = UUID.randomUUID().toString();

		Enemy enemy = new Enemy(enemyId, name, clan, level, creator, alive, boss);

		enemies.add(enemy);

		return enemy;
	}

	public static Enemy update(String id, Enemy newEnemy) {
		Enemy enemy = findById(id);

		if (enemy == null) {
			return null;
		}

		enemy.setName(newEnemy.getName());
		enemy.setClan(newEnemy.getClan());
		enemy.setLevel(newEnemy.getLevel());
		enemy.setAlive(newEnemy.isAlive());
		enemy.setBoss(newEnemy.isBoss());

		return enemy;
	}

	public static void delete(String id) {
		for (Enemy enemy : enemies) {
			if (enemy.getId().equalsIgnoreCase(id)) {
				enemies.remove(enemy);
				break;
			}
		}
	}

	public void save() {
		Gson gson = new Gson();
		File file = new File(FILE_PATH);

		String json = gson.toJson(enemies);

		Database.write(file, json);
	}

	public void load() {
		Gson gson = new Gson();

		String stringFile = Database.read(FILE_PATH);

		Type type = new TypeToken<ArrayList<Enemy>>() {
		}.getType();

		ArrayList<Enemy> enemyArray = gson.fromJson(stringFile, type);

		enemies = enemyArray;
	}
}
