package Game.Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import Game.Controllers.AttackController;
import Game.Controllers.CharacterController;
import Game.Controllers.ClanController;
import Game.Controllers.EnemyController;
import Game.Controllers.UserController;
import Game.Controllers.ZoneController;

public final class Database {
	public static final String PATH_FOLDER = "src/main/java/Game/Database/Saves/";
	public static AttackController attackController = new AttackController();
	public static CharacterController characterController = new CharacterController();
	public static ClanController clanController = new ClanController();
	public static EnemyController enemyController = new EnemyController();
	public static UserController userController = new UserController();
	public static ZoneController zoneController = new ZoneController();

	public static void write(File file, String json) {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(json);
			fileWriter.flush();
			fileWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String read(String pathname) {
		try {
			FileReader fileReader = new FileReader(pathname);
			BufferedReader buffer = new BufferedReader(fileReader);

			String value = buffer.readLine();
			buffer.close();

			return value;

		} catch (Exception e) {
			return "";
		}
	}

	public static void load() {
		userController.load();
		attackController.load();
		characterController.load();
		clanController.load();
		enemyController.load();
		zoneController.load();
	}

	public static void save() {
		userController.save();
		attackController.save();
		characterController.save();
		clanController.save();
		enemyController.save();
		zoneController.save();
	}
}
