package Game.Controllers;

import Game.Database.Database;
import Game.Models.Users.Player;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PlayerController implements Controller {
	private static final String FILE_NAME = "players.json";
	private static final String FILE_PATH = Database.PATH_FOLDER + FILE_NAME;

	private static ArrayList<Player> players = new ArrayList<>();

	public static List<Player> findAll() {
		return players;
	}

	public static Player findByEmail(String email) {
		for (Player player : players) {
			if (player.getEmail().equalsIgnoreCase(email)) {
				return player;
			}
		}

		return null;
	}

	public static Player findById(String id) {
		for (Player player : players) {
			if (player.getId().equalsIgnoreCase(id)) {
				return player;
			}
		}

		return null;
	}

	public static Player create(String name, String email, String password) throws Exception {
		String playerId = UUID.randomUUID().toString();

		Player player = new Player(playerId, name, email, password);
		players.add(player);

		return player;
	}

	public static Player update(String id, Player newPlayer) {
		Player player = findById(id);

		if (player == null) {
			return null;
		}

		player.setEmail(newPlayer.getEmail());
		player.setName(newPlayer.getName());
		player.setPassword(newPlayer.getPassword());

		return player;
	}

	public static void delete(String id) {
		for (Player player : players) {
			if (player.getId().equalsIgnoreCase(id)) {
				players.remove(player);
				break;
			}
		}
	}

	public void save() {
		Gson gson = new Gson();
		File file = new File(FILE_PATH);

		String json = gson.toJson(players);

		Database.write(file, json);
	}

	public void load() {
		Gson gson = new Gson();

		String stringFile = Database.read(FILE_PATH);

		Type type = new TypeToken<ArrayList<Player>>() {
		}.getType();

		ArrayList<Player> playerArray = gson.fromJson(stringFile, type);

		if (playerArray != null) {
			players = playerArray;
		}
	}
}
