package Game.Controllers;

import Game.Database.Database;
import Game.Models.Users.User;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UserController implements Controller {
	private static final String FILE_NAME = "users.json";
	private static final String FILE_PATH = Database.PATH_FOLDER + FILE_NAME;

	private static ArrayList<User> users = new ArrayList<>();

	public static List<User> findAll() {
		return users;
	}

	public static User findById(String id) {
		for (User user : users) {
			if (user.getId().equalsIgnoreCase(id)) {
				return user;
			}
		}

		return null;
	}

	public static User create(String name, String email, String password, int level) {
		String userId = UUID.randomUUID().toString();

		User user = new User(userId, name, email, password, level);
		users.add(user);

		return user;
	}

	public static User update(String id, User newUser) {
		User user = findById(id);

		if (user == null) {
			return null;
		}

		user.setEmail(newUser.getEmail());
		user.setName(newUser.getName());
		user.setPassword(newUser.getPassword());
		user.setLevel(newUser.getLevel());

		return user;
	}

	public static void delete(String id) {
		for (User user : users) {
			if (user.getId().equalsIgnoreCase(id)) {
				users.remove(user);
				break;
			}
		}
	}

	public void save() {
		Gson gson = new Gson();
		File file = new File(FILE_PATH);

		String json = gson.toJson(users);

		Database.write(file, json);
	}

	public void load() {
		Gson gson = new Gson();

		String stringFile = Database.read(FILE_PATH);

		Type type = new TypeToken<ArrayList<User>>() {
		}.getType();

		ArrayList<User> userArray = gson.fromJson(stringFile, type);

		users = userArray;
	}

	public User login(String email, String password) {
		for (User user : users) {
			if (user.getEmail() == email && user.getPassword() == password) {
				return user;
			}
		}

		return null;
	}
}
