package Game.Models.Users;

import java.util.ArrayList;
import java.util.List;

import Game.Models.Creatures.Character;

public class Player extends User {
	private List<Character> characters = new ArrayList<>();

	public Player(String id, String name, String email, String password) throws Exception {
		super(id, name, email, password);
	}

	public List<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}
}
