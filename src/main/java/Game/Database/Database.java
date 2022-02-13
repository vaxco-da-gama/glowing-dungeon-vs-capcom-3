package Game.Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import Game.Controllers.AdminController;
import Game.Controllers.AttackController;
import Game.Controllers.CharacterController;
import Game.Controllers.ClanController;
import Game.Controllers.EnemyController;
import Game.Controllers.PlayerController;
import Game.Controllers.UserController;
import Game.Controllers.WaveController;
import Game.Controllers.ZoneController;

public final class Database {
	public static final String PATH_FOLDER = "src/main/java/Game/Database/Saves/";
	public static AdminController adminController = new AdminController();
	public static AttackController attackController = new AttackController();
	public static CharacterController characterController = new CharacterController();
	public static ClanController clanController = new ClanController();
	public static EnemyController enemyController = new EnemyController();
	public static PlayerController playerController = new PlayerController();
	public static UserController userController = new UserController();
	public static WaveController waveController = new WaveController();
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

			return buffer.readLine();
		} catch (Exception e) {
			return "";
		}
	}

	public static void load() {
		userController.load();
		adminController.load();
		attackController.load();
		characterController.load();
		clanController.load();
		enemyController.load();
		playerController.load();
		waveController.load();
		zoneController.load();
	}
}
