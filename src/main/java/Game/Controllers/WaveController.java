package Game.Controllers;

import Game.Database.Database;
import Game.Models.Creatures.Enemy;
import Game.Models.Domain.Wave;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WaveController implements Controller {
	private static final String FILE_NAME = "waves.json";
	private static final String FILE_PATH = Database.PATH_FOLDER + FILE_NAME;

	private static ArrayList<Wave> waves = new ArrayList<>();

	public static List<Wave> findAll() {
		return waves;
	}

	public static Wave findById(String id) {
		for (Wave wave : waves) {
			if (wave.getId().equalsIgnoreCase(id)) {
				return wave;
			}
		}

		return null;
	}

	public static Wave create(List<Enemy> enemies, int status, boolean boss) {

		String waveId = UUID.randomUUID().toString();

		Wave wave = new Wave(waveId, enemies, status, boss);

		waves.add(wave);

		return wave;
	}

	public static Wave update(String id, Wave newWave) {
		Wave wave = findById(id);

		if (wave == null) {
			return null;
		}

		wave.setEnemies(newWave.getEnemies());
		wave.setStatus(newWave.getStatus());
		wave.setBoss(newWave.isBoss());

		return wave;
	}

	public static void delete(String id) {
		for (Wave wave : waves) {
			if (wave.getId().equalsIgnoreCase(id)) {
				waves.remove(wave);
				break;
			}
		}
	}

	public void save() {
		Gson gson = new Gson();
		File file = new File(FILE_PATH);

		String json = gson.toJson(waves);

		Database.write(file, json);
	}

	public void load() {
		Gson gson = new Gson();

		String stringFile = Database.read(FILE_PATH);

		Type type = new TypeToken<ArrayList<Wave>>() {
		}.getType();

		ArrayList<Wave> waveArray = gson.fromJson(stringFile, type);

		if (waveArray != null) {
			waves = waveArray;
		}
	}
}
