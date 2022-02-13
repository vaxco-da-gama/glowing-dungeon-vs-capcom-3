package Game.Controllers;

import Game.Database.Database;
import Game.Models.Users.Admin;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AdminController implements Controller {
	private static final String FILE_NAME = "admins.json";
	private static final String FILE_PATH = Database.PATH_FOLDER + FILE_NAME;

	private static ArrayList<Admin> admins = new ArrayList<>();

	public static List<Admin> findAll() {
		return admins;
	}

	public static Admin findById(String id) {
		for (Admin admin : admins) {
			if (admin.getId().equalsIgnoreCase(id)) {
				return admin;
			}
		}

		return null;
	}

	public static Admin create(String name, String email, String password, int level) {
		String adminId = UUID.randomUUID().toString();

		Admin admin = new Admin(adminId, name, email, password, level);
		admins.add(admin);

		return admin;
	}

	public static Admin update(String id, Admin newAdmin) {
		Admin admin = findById(id);

		if (admin == null) {
			return null;
		}

		admin.setEmail(newAdmin.getEmail());
		admin.setName(newAdmin.getName());
		admin.setPassword(newAdmin.getPassword());
		admin.setLevel(newAdmin.getLevel());

		return admin;
	}

	public static void delete(String id) {
		for (Admin admin : admins) {
			if (admin.getId().equalsIgnoreCase(id)) {
				admins.remove(admin);
				break;
			}
		}
	}

	public void save() {
		Gson gson = new Gson();
		File file = new File(FILE_PATH);

		String json = gson.toJson(admins);

		Database.write(file, json);
	}

	public void load() {
		Gson gson = new Gson();

		String stringFile = Database.read(FILE_PATH);

		Type type = new TypeToken<ArrayList<Admin>>() {
		}.getType();

		ArrayList<Admin> adminArray = gson.fromJson(stringFile, type);

		admins = adminArray;
	}
}
