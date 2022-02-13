package Game.Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import Game.Controllers.UserController;

public final class Database {
	public static final String PATH_FOLDER = "src/main/java/Game/Database/Saves/";

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
		UserController.load();
	}
}
