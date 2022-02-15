package Game.Controllers;

import Game.Database.Database;
import Game.Models.Creatures.Character;
import Game.Models.Domain.Clan;
import Game.Models.Users.Player;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CharacterController implements Controller {
	private static final String FILE_NAME = "characters.json";
	private static final String FILE_PATH = Database.PATH_FOLDER + FILE_NAME;

	private static ArrayList<Character> characters = new ArrayList<>();

	public static List<Character> findAll() {
		return characters;
	}

	public static Character findById(String id) {
		for (Character character : characters) {
			if (character.getId().equalsIgnoreCase(id)) {
				return character;
			}
		}

		return null;
	}

	public static Character findByName(String name) {
		for (Character character : characters) {
			if (character.getName().equalsIgnoreCase(name)) {
				return character;
			}
		}

		return null;
	}

	public static Character create(Player creator, String name, Clan clan) throws Exception {

		if (creator == null || name == null || clan == null) {
			throw new Exception("Nenhum dos parâmetros pode ser nulo.");

		}

		if (findByName(name) != null) {
			throw new Exception("Personagem com o nome " + name + " já existe.");
		}

		String characterId = UUID.randomUUID().toString();

		Character character = new Character(characterId, creator, name, clan);

		characters.add(character);

		return character;
	}

	public static Character update(String id, Character newCharacter) {
		Character character = findById(id);

		if (character == null) {
			return null;
		}

		character.setName(newCharacter.getName());
		character.setClan(newCharacter.getClan());

		return character;
	}

	public static void delete(String id) {
		for (Character character : characters) {
			if (character.getId().equalsIgnoreCase(id)) {
				characters.remove(character);
				break;
			}
		}
	}

	public void save() {
		Gson gson = new Gson();
		File file = new File(FILE_PATH);

		String json = gson.toJson(characters);

		Database.write(file, json);
	}

	public void load() {
		Gson gson = new Gson();

		String stringFile = Database.read(FILE_PATH);

		Type type = new TypeToken<ArrayList<Character>>() {
		}.getType();

		ArrayList<Character> characterArray = gson.fromJson(stringFile, type);

		if (characterArray != null) {
			characters = characterArray;
		}
	}
}
