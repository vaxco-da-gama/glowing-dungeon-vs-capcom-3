package Game.Controllers;

import Game.Database.Database;
import Game.Models.Domain.Zone;

import Game.Models.Users.Admin;
import Game.Utils.Session;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ZoneController implements Controller {
	private static final String FILE_NAME = "zones.json";
	private static final String FILE_PATH = Database.PATH_FOLDER + FILE_NAME;

	private static ArrayList<Zone> zones = new ArrayList<>();

	public static List<Zone> findAll() {
		return zones;
	}

	public static Zone findById(String id) {
		for (Zone zone : zones) {
			if (zone.getId().equalsIgnoreCase(id)) {
				return zone;
			}
		}

		return null;
	}

	public static Zone create(String name, String description) throws Exception {
		String zoneId = UUID.randomUUID().toString();
		Admin admin = Session.getAdmin();

		Zone zone = new Zone(zoneId, name, description, admin);

		zones.add(zone);

		return zone;
	}

	public static Zone update(String id, Zone newZone) {
		Zone zone = findById(id);

		if (zone == null) {
			return null;
		}

		zone.setName(newZone.getName());
		zone.setDescription(newZone.getDescription());
		zone.setCreator(newZone.getCreator());
		zone.setBannedUsers(newZone.getBannedUsers());
		zone.setEnemies(newZone.getEnemies());

		return zone;
	}

	public static void delete(String id) {
		for (Zone zone : zones) {
			if (zone.getId().equalsIgnoreCase(id)) {
				zones.remove(zone);
				break;
			}
		}
	}

	public void save() {
		Gson gson = new Gson();
		File file = new File(FILE_PATH);

		String json = gson.toJson(zones);

		Database.write(file, json);
	}

	public void load() {
		Gson gson = new Gson();

		String stringFile = Database.read(FILE_PATH);

		Type type = new TypeToken<ArrayList<Zone>>() {
		}.getType();

		ArrayList<Zone> zoneArray = gson.fromJson(stringFile, type);

		if (zoneArray != null) {
			zones = zoneArray;
		}
	}
}
